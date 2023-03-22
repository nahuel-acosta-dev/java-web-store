/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import data.CategoryDaoJDBC;
import data.GenderDaoJDBC;
import data.ProductDaoJDBC;
import data.SalesDaoJDBC;
import domain.Category;
import domain.Gender;
import domain.Product;
import domain.SalesExtends;
import domain.SessionProducts;
import domain.SessionSales;
import domain.SessionSalesPagination;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
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


@WebServlet("/SoldsServletController")
public class SoldsServletController extends HttpServlet {
    
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
        
        if (sesion.getAttribute("admin") != null) {
            
           boolean resultPagination = this.pagination(request, response);
           
           if(resultPagination == false){
               sesion.setAttribute("msje_err_products", "Error al cargar productos");
           }
           else{
               sesion.setAttribute("msje_err_products", null);
           }
           //request.getRequestDispatcher("products.jsp").forward(request, response);
           response.sendRedirect("solds.jsp");
        } else {
            response.sendRedirect("admin.jsp");
        }
        
    }
    
    
    
    /*********** PAGINATION VENTAS **************/
    
    private boolean pagination (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        
        HttpSession sesion;
        sesion = request.getSession();
        List<SalesExtends> sales = null;

        try {
            
            
            int offsett = 0; //posicion del primer registro de products a mostrar
            int count = 5; //posicion del ultimo registro de products a mostrar
            
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
            
            sales = new SalesDaoJDBC().select_limit(offsett, count);
            
            SessionSalesPagination sessionSalesPag = new SessionSalesPagination(sales, paginationSections);
            
            sesion.setAttribute("sessionProducts", sessionSalesPag);
            //request.setAttribute("sessionProducts", sessionProducts);
            
            sesion.setAttribute("currentPage", currentPage);
            //request.setAttribute("currentPage", currentPage);
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
            rows = new SalesDaoJDBC().select_count();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
        return rows;
    }

}
