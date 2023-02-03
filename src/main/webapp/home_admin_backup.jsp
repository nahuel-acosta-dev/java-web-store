<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1" />
            <meta name="theme-color" content="#000000" />
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
            
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
                <header>
                    <div class="sidebar pe-4 pb-3">
                        <nav class="navbar bg-secondary navbar-dark">
                            <a href="index.html" class="navbar-brand mx-4 mb-3">
                                <h3 class="text-primary"><i class="fa fa-user-edit me-2"></i>DarkPan</h3>
                            </a>
                            <div class="d-flex align-items-center ms-4 mb-4">
                                <div class="position-relative">
                                    <img class="rounded-circle" src="img/user.jpg" alt="" style="width: 40px; 
                                         height: 40px;">
                                    <div class="bg-success rounded-circle border border-2 border-white 
                                         position-absolute end-0 bottom-0 p-1"></div>
                                </div>
                                <div class="ms-3">
                                    <h6 class="mb-0">Jhon Doe</h6>
                                    <span>Admin</span>
                                </div>
                            </div>
                            <div class="navbar-nav w-100">
                                <a href="index.html" class="nav-item nav-link active"><i class="fa fa-tachometer-alt me-2"></i>Dashboard</a>
                                <div class="nav-item dropdown">
                                    <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="fa fa-laptop me-2"></i>Elements</a>
                                    <div class="dropdown-menu bg-transparent border-0">
                                        <a href="button.html" class="dropdown-item">Buttons</a>
                                        <a href="typography.html" class="dropdown-item">Typography</a>
                                        <a href="element.html" class="dropdown-item">Other Elements</a>
                                    </div>
                                </div>
                                <a href="widget.html" class="nav-item nav-link"><i class="fa fa-th me-2"></i>Widgets</a>
                                <a href="form.html" class="nav-item nav-link"><i class="fa fa-keyboard me-2"></i>Forms</a>
                                <a href="table.html" class="nav-item nav-link"><i class="fa fa-table me-2"></i>Tables</a>
                                <a href="chart.html" class="nav-item nav-link"><i class="fa fa-chart-bar me-2"></i>Charts</a>
                                <div class="nav-item dropdown">
                                    <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="far fa-file-alt me-2"></i>Pages</a>
                                    <div class="dropdown-menu bg-transparent border-0">
                                        <a href="signin.html" class="dropdown-item">Sign In</a>
                                        <a href="signup.html" class="dropdown-item">Sign Up</a>
                                        <a href="404.html" class="dropdown-item">404 Error</a>
                                        <a href="blank.html" class="dropdown-item">Blank Page</a>
                                    </div>
                                </div>
                            </div>
                        </nav>
                    </div>
                </header>
              <main>
                      <c:if test="${sessionScope['msje'] != null}">
                        ${sessionScope['msje']}
                      </c:if>
                      
                      <!-- CARDS -->
                        <jsp:include page="WEB-INF/pages/admin/common/cards.jsp"/>
                      <!---------------->
              </main>        
                            
              <jsp:include page="WEB-INF/pages/common/footer.jsp"/> 
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
