package web;

import data.AdminDaoJDBC;
import data.ProductDaoJDBC;
import domain.Admin;
import domain.Product;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        List<Product> products = null;
        if (sesion.getAttribute("admin") != null) {
            System.out.println("el resultado es el siguiente: ");
            System.out.println(sesion.getAttribute("admin"));
            try {
                products = new ProductDaoJDBC().select();
                sesion.setAttribute("products", products);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            } finally {
                System.out.println("products = " + products);
                /*request.setAttribute("products", products);
                request.getRequestDispatcher("home_admin.jsp").forward(request, response);*/
                response.sendRedirect("home_admin.jsp");
            }
        } else {
            //request.getRequestDispatcher("admin.jsp").forward(request, response);
            response.sendRedirect("admin.jsp");
        }
    }

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
                
                sesion.setAttribute("msje",
                        "Error al intentar iniciar sesion, revise sus credenciales.");
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            /*request.setAttribute("msje",
                    "Error al intentar iniciar sesion");*/
            sesion.setAttribute("msje",
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
            Admin admin = new Admin(name, lastName, email, encPassword, valueSuperUser);
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
