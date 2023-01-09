package web;

import data.AdminDaoJDBC;
import domain.Admin;
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

        if (sesion.getAttribute("admin") != null) {
            System.out.println("el resultado es el siguiente: ");
            System.out.println(sesion.getAttribute("admin"));
            request.getRequestDispatcher("home_admin.jsp").forward(request, response);
        } else {
            List<Admin> admins = null;
            try {
                admins = new AdminDaoJDBC().select();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            } finally {
                System.out.println("admins = " + admins);
                //request.setAttribute("admin", admins);
                request.getRequestDispatcher("admin.jsp").forward(request, response);
            }

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
        try {
            Admin resultAdmin = adminDao.identify(admin);
            if (resultAdmin != null) {
                sesion = request.getSession();
                sesion.setAttribute("admin", resultAdmin);
                System.out.println(sesion.getAttribute("admin"));
                request.setAttribute("msje", "Bienvenido al sistema");
                request.getRequestDispatcher("home_admin.jsp").forward(request, response);
            } else {
                request.setAttribute("msje",
                        "Error al intentar iniciar sesion, revise sus credenciales.");
                this.actionDefault(request, response);
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            request.setAttribute("msje",
                    "Error al intentar iniciar sesion");
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
            throw new RuntimeException(e);
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
     * **************CREATE ADMIN*****************
     */
    private void insertAdmin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * ***************end*************************
     */
    /**
     * *******************END***************************
     */
}
