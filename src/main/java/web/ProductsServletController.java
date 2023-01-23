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
                
                int offsett = 0; //posicion del primer registro de products a mostrar
                int count = 2; //posicion del ultimo registro de products a mostrar
                
                int currentPage = 1; //pagina actual de la paginacion
                int recordsPerPage = count; //cantidad de registros a mostrar
                
                
                //obtenemos la pagina de paginacion a mostrar
                String pagination = request.getParameter("pagination");
                
                if (pagination != null && Integer.parseInt(pagination) > 1) {
                    
                    System.out.println("LA PAGINA ES: " + pagination);
                    int productsPage = (Integer.parseInt(pagination) * recordsPerPage);
                    offsett = productsPage - recordsPerPage;
                    
                } 
                
                if(offsett > 1){
                    currentPage = Integer.parseInt(pagination);
                }
                
                System.out.println(sesion.getAttribute("admin"));
                
                int paginationSections = (int) Math.ceil((double) (countProducts()) / recordsPerPage);
                
                System.out.println("MINIMO DE PRODUCTOS: " + offsett);
                System.out.println("LIMITE DE PRODUCTOS: " + count);

                products = new ProductDaoJDBC().select_limit(offsett, count);
                
                SessionProducts sessionProducts = new SessionProducts(products, paginationSections);
                
                sesion.setAttribute("sessionProducts", sessionProducts);
                
                sesion.setAttribute("currentPage", currentPage);
                
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
    
    
    /*********** PAGINATION PRODUCTOS **************/
    
    private void pagination (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        
    }
    
    /*************************/
    
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

