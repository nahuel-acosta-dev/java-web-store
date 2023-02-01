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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
                case "edit":
                    this.editProduct(request, response);
                    break;
                case "add":
                    this.addProduct(request, response);
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
           //request.getRequestDispatcher("pages/products.jsp").forward(request, response);
           response.sendRedirect("pages/products.jsp");
        } else {
            response.sendRedirect("admin.jsp");
        }
        
    }
    
    /*********** REDIRIGIR EDITAR PRODUCTO **************/
    
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
    
    /*********** REDIRIGIR A AGREGAR PRODUCTO **************/
    
    private void addProduct(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{

        try {
            List<Category> categories = new CategoryDaoJDBC().select();
            List<Gender> genders = new GenderDaoJDBC().select();
            
            request.setAttribute("categories", categories);
            request.setAttribute("genders", genders);
            
            String jspEdit = "pages/add_product.jsp";
            request.getRequestDispatcher(jspEdit).forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            String jspEdit = "pages/add_product.jsp";
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
            rows = new ProductDaoJDBC().select_count();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
        return rows;
    }
    
    /*************************/
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        String action = request.getParameter("action");
        
        if (action != null) {
            switch (action) {
                case "modify":
                    this.modifyClient(request, response);
                    break;
                case "add_product":
                    this.insertProduct(request, response);
                    break;
                default:
                    this.actionDefault(request, response);
            }
        } else{
            this.actionDefault(request, response);
        }
    }
    
    
    /*********** MODIFICAR PRODUCTO **************/
    private void modifyClient(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    //obtenemos valores del formulario edit_product
        int idProduct = (int) Integer.parseInt(request.getParameter("idProduct"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Double price = (Double) Double.parseDouble(request.getParameter("price")); 
        Double comparePrice = (Double) Double.parseDouble(request.getParameter("comparePrice"));
        int sold = (int) Integer.parseInt(request.getParameter("sold"));
        int quantity = (int) Integer.parseInt(request.getParameter("quantity"));
        int category = (int) Integer.parseInt(request.getParameter("category"));
        int gender = (int) Integer.parseInt(request.getParameter("gender"));
        
        Product product = new Product(idProduct ,name, description, price, comparePrice, category, 
                quantity, sold, gender);
        
        //Modificamos el objeto en la base de datos
        int modifiedRecords = new ProductDaoJDBC().update(product);
        System.out.println("Registros Modificados: " + modifiedRecords);
        
        //Redirigimos
        this.actionDefault(request, response);
        
    }
    
    /*************************/
    
    
    /*********** INSERTANDO NUEVO PRODUCTO **************/
    
    
    private void insertProduct(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    //obtenemos valores del formulario edit_product
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Double price = (Double) Double.parseDouble(request.getParameter("price")); 
        Double comparePrice = (Double) Double.parseDouble(request.getParameter("comparePrice"));
        int sold = (int) Integer.parseInt(request.getParameter("sold"));
        int quantity = (int) Integer.parseInt(request.getParameter("quantity"));
        int category = (int) Integer.parseInt(request.getParameter("category"));
        int gender = (int) Integer.parseInt(request.getParameter("gender"));
        
        /***OBTENER FECHA Y HORA***/
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss");
        String date = dtf2.format(LocalDateTime.now());
        /********************/
        Product product = new Product(name, description, price, comparePrice, category, 
                quantity, sold, date, gender);
        
        //Modificamos el objeto en la base de datos
        int addProduct = new ProductDaoJDBC().insert(product);
        System.out.println("Registros agregados: " + addProduct);
        
        //Redirigimos
        this.actionDefault(request, response);
        
    }
    
    
    /*************************/
    
}

