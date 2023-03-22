<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1" />
            <meta name="theme-color" content="#000000" />
            <meta content="" name="keywords">
             <meta content="" name="description">
                <!-- Google Web Fonts -->
            <link rel="preconnect" href="https://fonts.googleapis.com">
            <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
            <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Roboto:wght@500;700&display=swap" rel="stylesheet">
            
            <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" 
                  rel="stylesheet">

            <!-- Icon Font Stylesheet -->
            <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" 
                  rel="stylesheet">
            <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" 
                  rel="stylesheet">

            
            <!-- Libraries Stylesheet -->
            <link href="static/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
            <link href="static/lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

            
            <link href="static/css/bootstrap.min.css" rel="stylesheet">
            <script src="https://kit.fontawesome.com/50f085f1e4.js" crossorigin="anonymous"></script>
            
            <link rel="stylesheet" href="static/css/style.css">
            <link rel="stylesheet" href="static/css/home_admin.css">
            <title>Administrador</title>
        </head>
        <body style="padding-left: 0px">

        <main class="container-fluid position-relative d-flex p-0">
        <!-- Spinner Start -->
        <jsp:include page="WEB-INF/pages/common/spinner.jsp"/>
        <!-- Spinner End -->

        <!-- NAVBAR -->
        <jsp:include page="WEB-INF/pages/common/nav_admin.jsp"/> 
        <!-- NAVBAR End -->
        
        
            <!-- Sale & Revenue Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="row g-4">
                    <div class="col-sm-6 col-xl-3">
                        <div class="bg-secondary rounded d-flex align-items-center justify-content-between p-4">
                            <i class="fa fa-chart-line fa-3x text-primary"></i>
                            <div class="ms-3">
                                <p class="mb-2">Ventas del dia</p>
                                <h6 class="mb-0">${sessionScope['sales'].getSalesOfTheDay()}</h6>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-xl-3">
                        <div class="bg-secondary rounded d-flex align-items-center justify-content-between p-4">
                            <i class="fa fa-chart-bar fa-3x text-primary"></i>
                            <div class="ms-3">
                                <p class="mb-2">Ganancias del dia</p>
                                <h6 class="mb-0">$ ${sessionScope['sales'].getEarningsOfTheDay()}</h6>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-xl-3">
                        <div class="bg-secondary rounded d-flex align-items-center justify-content-between p-4">
                            <i class="fa fa-chart-area fa-3x text-primary"></i>
                            <div class="ms-3">
                                <p class="mb-2">Total ventas</p>
                                <h6 class="mb-0">${sessionScope['sales'].getTotalSales()}</h6>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-xl-3">
                        <div class="bg-secondary rounded d-flex align-items-center justify-content-between p-4">
                            <i class="fa fa-chart-pie fa-3x text-primary"></i>
                            <div class="ms-3">
                                <p class="mb-2">Ganancias Totales</p>
                                <h6 class="mb-0">$ ${sessionScope['sales'].getTotalEarnings()}</h6>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Sale & Revenue End -->

            <!-- Recent Sales Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="bg-secondary text-center rounded p-4">
                    <div class="d-flex align-items-center justify-content-between mb-4">
                        <h6 class="mb-0">Ventas Recientes</h6>
                        <a href="">Mostrar Todo</a>
                    </div>
                    <div class="table-responsive">
                        <table class="table text-start align-middle table-bordered table-hover mb-0">
                            <thead>
                                <tr class="text-white">
                                    <th scope="col"><input class="form-check-input" type="checkbox"></th>
                                    <th scope="col">#</th>
                                    <th scope="col">Producto</th>
                                    <th scope="col">Comprador</th>
                                    <th scope="col">Estado</th>
                                    <th scope="col">Entrega</th>
                                    <th scope="col">Cantidad</th>
                                    <th scope="col">Detalles</th>
                                </tr>
                            </thead>
                            <tbody>
                                    <c:forEach 
                                        var="sales" 
                                        items="${sessionScope['salesRecents']}">
                                        <tr>
                                            <td><input class="form-check-input" type="checkbox"></td>
                                            <td>${sales.idSales}</td>
                                            <td>${sales.product}</td>
                                            <td>${sales.name} ${sales.lastName}</td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${sales.state}">
                                                       Venta activa 
                                                    </c:when>
                                                    <c:otherwise>
                                                       Venta cancelada
                                                    </c:otherwise>
                                                </c:choose>                          
                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${sales.delivery_status}">
                                                       Entregado
                                                    </c:when>
                                                    <c:otherwise>
                                                       Sin entregar
                                                    </c:otherwise>
                                                </c:choose>    
                                            </td>
                                            <td>${sales.quantity}</td>
                                            <td><a class="btn btn-sm btn-primary" href="">Detail</a></td>
                                        </tr>
                                    </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <!-- Recent Sales End -->


            


            <!-- Footer Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="bg-secondary rounded-top p-4">
                    <div class="row">
                        <div class="col-12 col-sm-6 text-center text-sm-start">
                            &copy; <a href="#">Nahuel Acosta</a>, All Right Reserved. 
                        </div>
                        <div class="col-12 col-sm-6 text-center text-sm-end">
                            <!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
                            Designed By <a href="https://htmlcodex.com">Nahuel Acosta</a>
                            
                        </div>
                    </div>
                </div>
            </div>
            <!-- Footer End -->
        </div>
        <!-- Content End -->


        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
    </main>        
                            
              <jsp:include page="WEB-INF/pages/admin/common/add_admin.jsp"/> 
              
              <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
              
              <!-- BOOTSTRAP JAVASCRIPT -->  
                <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" 
                      integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" 
                      crossorigin="anonymous"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" 
                        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" 
                        crossorigin="anonymous"></script>  
                        
                        
              <!-- JavaScript Libraries -->
              <script src="static/lib/chart/chart.min.js"></script>
              <script src="static/lib/easing/easing.min.js"></script>
              <script src="static/lib/waypoints/waypoints.min.js"></script>
              <script src="static/lib/owlcarousel/owl.carousel.min.js"></script>
              <script src="static/lib/tempusdominus/js/moment.min.js"></script>
              <script src="static/lib/tempusdominus/js/moment-timezone.min.js"></script>
              <script src="static/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>          
                        
                <!-- TEMPLATE JAVASCRIPT -->        
                <script src="static/js/index.js"></script>
        </body>
</html>
