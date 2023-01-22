/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import data.ProductDaoJDBC;
import domain.Product;
import domain.SessionProducts;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nahuel
 */
@WebServlet("/ProductsServletController")
public class ProductsServletController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.sendRedirect("products.jsp");
        this.actionDefault(request, response);
    }
    
    
    private void actionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion;
        sesion = request.getSession();
        List<Product> products = null;
        
        if (sesion.getAttribute("admin") != null) {
            
            try {
                System.out.println(sesion.getAttribute("admin"));
                
                int newRows = (int) Math.ceil((double) (countProducts()) / 10);

                products = new ProductDaoJDBC().select_limit(0, 10);
                
                SessionProducts sessionProducts = new SessionProducts(products, newRows);
                
                sesion.setAttribute("sessionProducts", sessionProducts);
                
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            } finally {
                System.out.println("products = " + products);
                response.sendRedirect("pages/products.jsp");
            }
        } else {
            response.sendRedirect("admin.jsp");
        }
        
    }
    
    
    /*********** CONTAR PRODUCTOS **************/
    
    private int countProducts() throws IOException {
        //response.sendRedirect("products.jsp");
        
        int rows = 0;
        
        try {
            rows = new ProductDaoJDBC().select_count();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
        return rows;
    }
    
    /*************************/
    
    
}

