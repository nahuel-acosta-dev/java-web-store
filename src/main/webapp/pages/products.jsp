<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta name="theme-color" content="#000000" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/50f085f1e4.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="static/css/home_admin.css">
        <title>Products</title>
    </head>
    <body>
            <header>
                <jsp:include page="../WEB-INF/pages/admin/common/nav_admin.jsp"/>
            </header>
          <main>
                  <p class="text-center">MIS PRODUCTOS</p>
                  
                <div class="container mt-3 mb-5">
                  <div class="row">
                        <div>
                            <a class="btn btn-primary" href="${
                        pageContext.request.contextPath}/ProductsServletController?action=add">
                                <i class="fa-thin fa-plus"></i> Agregar Producto
                            </a>
                        </div>
                  </div>
                </div>
                    
                  
                  <!-- table -->
                    <jsp:include page="../WEB-INF/pages/admin/common/table.jsp"/> 
                  <!-- -------- -->
                  <!-- pagination -->
                 <div class="container mt-3">
                    
                    <div class="row justify-content-center">
                        <div class="col"></div>
                        <div class="col d-flex justify-content-center">
                            <jsp:include page="../WEB-INF/pages/admin/common/pagination.jsp"/> 
                        </div>
                        <div class="col"></div>
                    </div>
                  </div>
                  <!-- -------- -->
          </main>        

            <jsp:include page="../WEB-INF/pages/common/footer.jsp"/> 
            <jsp:include page="../WEB-INF/pages/admin/common/add_admin.jsp"/> 
          <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" 
                  integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" 
                  crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" 
                    integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" 
                    crossorigin="anonymous"></script>   
    </body>
</html>
