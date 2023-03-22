package web;

import data.AdminDaoJDBC;
import data.SalesDaoJDBC;
import domain.Admin;
import domain.SalesExtends;
import domain.SessionSales;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletController")
public class ServletController extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws SQLException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.actionDefault(request, response);
    }

    /*Obtenemos los datos necesarios y los enviamos al jsp a la vez que Redirigimos*/
    private void actionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion;
        sesion = request.getSession();
        List<SalesExtends> salesRecents = null;
        if (sesion.getAttribute("admin") != null) {
            
            try{
             salesRecents = new SalesDaoJDBC().select_max_limit(5);
            }
            catch (SQLException ex){
               ex.printStackTrace(System.out);
            }
            
            SessionSales sessionSales = new SessionSales(
                    this.countSalesOfDay(), this.getEntriesOfTheDay(),
                    this.countSales(), this.getAllEntries()
            );
            sesion.setAttribute("sales", sessionSales);
            
            sesion.setAttribute("salesRecents", salesRecents);
            
            System.out.println("TODAS LAS VENTAS RECIENTES: " + salesRecents);
            
            response.sendRedirect("home_admin.jsp");
        } else {
            //request.getRequestDispatcher("admin.jsp").forward(request, response);
            response.sendRedirect("admin.jsp");
        }
    }
    
    /*********** CONTAR VENTAS TOTALES **************/
    private int countSales() {
        //response.sendRedirect("products.jsp");
        
        int rows = 0;
        
        try {
            rows = new SalesDaoJDBC().select_count();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
        return rows;
    }
    
    /*************************/
    
    /*********** CONTAR VENTAS del dia **************/
    private int countSalesOfDay() {
        //response.sendRedirect("products.jsp");
        
        int rows = 0;
        try{
            rows = new SalesDaoJDBC().select_count_of_day();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return rows;
    }
    
    /*************************/
    
    /*********** OBTENER TODAS LAS GANANCIAS DE LAS VENTAS **************/
    private double getAllEntries() {
        //response.sendRedirect("products.jsp");
        
        double entries = 0;
        try{
            entries = new SalesDaoJDBC().select_all_entries();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return entries;
    }
    
    /*************************/
    
    /*********** OBTENER LAS GANANCIAS DEL DIA **************/
    private double getEntriesOfTheDay() {
        //response.sendRedirect("products.jsp");
        
        double entries = 0;
        try{
            entries = new SalesDaoJDBC().select_entries_of_the_day();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return entries;
    }
    
    /*************************/
    

    /**
     * ********************************POST*****************************
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "login":
                    login(request, response);
                    break;
                case "logout":
                    logOut(request, response);
                    break;
                case "insert":
                    insertAdmin(request, response);
                    break;
                default:
                    this.actionDefault(request, response);
            }
        } else {
            this.actionDefault(request, response);
        }

    }

    /**
     * ************************Login*****************************
     */
    private void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*obtenemos campos input*/
        HttpSession sesion;
        AdminDaoJDBC adminDao = new AdminDaoJDBC();
        Admin admin = new Admin();
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String encPassword = encryptPassword(password);

        admin.setEmail(email);
        admin.setPassword(encPassword);
        sesion = request.getSession();
        try {
            Admin resultAdmin = adminDao.identify(admin);
            if (resultAdmin != null) {
                sesion.setAttribute("admin", resultAdmin);
                System.out.println(sesion.getAttribute("admin"));
                //request.setAttribute("msje", "Bienvenido al sistema");
                sesion.setAttribute("msje", "Bienvenido al sistema");
            } else {
                /*request.setAttribute("msje",
                        "Error al intentar iniciar sesion, revise sus credenciales.");*/
                
                sesion.setAttribute("msje_err",
                        "Error al intentar iniciar sesion, revise sus credenciales.");
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            /*request.setAttribute("msje",
                    "Error al intentar iniciar sesion");*/
            sesion.setAttribute("msje_err",
                    "Error al intentar iniciar sesion");
        }
        finally{
            this.actionDefault(request, response);
        }
    }

    private String encryptPassword(String password) {

        String encString = null;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] encBytes = md.digest(password.getBytes());
            BigInteger number = new BigInteger(1, encBytes);
            encString = number.toString(16);
            while (encString.length() < 32) {
                encString = "0" + encString;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        return encString;
    }

    /**
     * ***************end*************************
     */
    /**
     * **************lOGOUT**********************
     */
    private void logOut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        sesion.setAttribute("admin", null);
        sesion.invalidate();
        this.actionDefault(request, response);
    }

    /**
     * ***************end*************************
     */
    /**
     * 
     * 
     * **************CREATE ADMIN*****************
     */
    private void insertAdmin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String lastName = request.getParameter("last_name");
        String email = request.getParameter("email");
        int phone = Integer.parseInt(request.getParameter("phone"));
        String password = request.getParameter("password");
        String superUser = request.getParameter("super_user");
        boolean valueSuperUser = false;
        String encPassword = encryptPassword(password);
        HttpSession sesion = request.getSession();
        
        if(superUser != null){
            valueSuperUser = true;
        }
        
        //creamos el nuevo admin
        
        
        try {
            Admin admin = new Admin(name, lastName, email, phone, encPassword, valueSuperUser);
            System.out.println("el siguiente es el admin");
            System.out.println(admin);
            //insertamos el nuevo objeto en la base de datos
            int modifiedRecords = new AdminDaoJDBC().insert(admin);
            System.out.println("registros modificados " + modifiedRecords);
            sesion.setAttribute("msje_admin","Administrador agregado con exito");
        } catch (SQLException ex) {
            sesion.setAttribute("msje_admin","Error al intentar agregar un administrador");
            ex.printStackTrace(System.out);
        }
        finally{
            this.actionDefault(request, response);
        }
    }

    /**
     * ***************end*************************
     */
    
    
    
    /**
     * *******************END***************************
     */
}
