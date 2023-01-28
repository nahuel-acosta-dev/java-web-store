/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import data.CategoryDaoJDBC;
import data.GenderDaoJDBC;
import data.ProductDaoJDBC;
import domain.Category;
import domain.Gender;
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
        String action = request.getParameter("action");
        
        if (action != null) {
            switch (action) {
                case "editar":
                this.editProduct(request, response);
                break;
                default:
                    this.actionDefault(request, response);
            }
        } else{
            this.actionDefault(request, response);
        }
    }
    
    
    private void actionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion;
        sesion = request.getSession();
        
        if (sesion.getAttribute("admin") != null) {
            
           boolean resultPagination = this.pagination(request, response);
           
           if(resultPagination == false){
               sesion.setAttribute("msje_err_products", "Error al cargar productos");
           }
           else{
               sesion.setAttribute("msje_err_products", null);
           }
           //response.sendRedirect("pages/products.jsp");
           request.getRequestDispatcher("pages/products.jsp").forward(request, response);
        } else {
            response.sendRedirect("admin.jsp");
        }
        
    }
    
    /*********** EDITAR PRODUCTO **************/
    
    private void editProduct(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{

        
        
        try {
            int idProduct = Integer.parseInt(request.getParameter("idProduct"));
            Product product = new ProductDaoJDBC().select_by_id(new Product(idProduct));
            List<Category> categories = new CategoryDaoJDBC().select();
            List<Gender> genders = new GenderDaoJDBC().select();
            System.out.println("ESTAS SON MIS CATEGORIAS: " + categories);
            
            request.setAttribute("categories", categories);
            request.setAttribute("genders", genders);
            request.setAttribute("product", product);
            
            String jspEdit = "pages/edit_product.jsp";
            request.getRequestDispatcher(jspEdit).forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            String jspEdit = "pages/edit_product.jsp";
            request.getRequestDispatcher(jspEdit).forward(request, response);
        }
    }
    
    /*************************/
    
    /*********** PAGINATION PRODUCTOS **************/
    
    private boolean pagination (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        
        HttpSession sesion;
        sesion = request.getSession();
        List<Product> products = null;

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
            
            /*Obtenemos la cantidad de productos a mostrar el numero de productos que tenemos por
            la cantidad de productos que queremos mostrar*/
            int paginationSections = (int) Math.ceil((double) (countProducts()) / recordsPerPage);
            
            products = new ProductDaoJDBC().select_limit(offsett, count);
            
            SessionProducts sessionProducts = new SessionProducts(products, paginationSections);
            
            sesion.setAttribute("sessionProducts", sessionProducts);
            
            sesion.setAttribute("currentPage", currentPage);
            
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            sesion.setAttribute("sessionProducts", null);
            sesion.setAttribute("currentPage", null);
            return false;
        }
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

