<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Sidebar Start -->
        <div class="sidebar pe-4 pb-3">
            <nav class="navbar bg-secondary navbar-dark">
                <a href="${pageContext.request.contextPath}/ServletController" class="navbar-brand mx-4 mb-3">
                    <h3 class="text-primary"><i class="fa fa-user-edit me-2"></i>Administrador</h3>
                </a>
                <div class="d-flex align-items-center ms-4 mb-4">
                    <div class="position-relative">
                            <img class="rounded-circle" 
                                 src="img/user.jpg" 
                                 alt="" 
                                 style="width: 40px; height: 40px;">
                        <div class="bg-success rounded-circle border border-2 border-white 
                             position-absolute end-0 bottom-0 p-1"></div>
                    </div>
                    <div class="ms-3">
                        <h6 class="mb-0">${admin.name.toUpperCase()} ${admin.lastName.toUpperCase()}</h6>
                        <span>Admin</span>
                    </div>
                </div>
                <form action="${pageContext.request.contextPath}/ServletController?action=logout" 
                            method="POST" class="navbar-nav w-100">
                    <a href="${pageContext.request.contextPath}/ServletController" class="nav-item nav-link">
                            <i class="fa fa-tachometer-alt me-2"></i>Dashboard</a>
                    <a href="ProductsServletController" class="nav-item nav-link">
                            <i class="fa fa-th me-2"></i>Productos</a>
                    <a href="SoldsServletController" class="nav-item nav-link">
                            <i class="fa-sharp fa-solid fa-cart-shopping me-2"></i>Ventas
                    </a>
                    <button type="submit" class="btn btn-link nav-item nav-link text-start" style="
                            border-top: 0 !important;border-right: 0 !important;border-bottom: 0 !important;">
                            <i class="fa-sharp fa-solid fa-arrow-right-from-bracket me-2"></i>Salir
                    </button>
                </form>
            </nav>
        </div>
        <!-- Sidebar End -->


        <!-- Content Start -->
        <div class="content">
            <!-- Navbar Start -->
            <nav class="navbar navbar-expand bg-secondary navbar-dark sticky-top px-4 py-0">
                <a href="index.html" class="navbar-brand d-flex d-lg-none me-4">
                    <h2 class="text-primary mb-0"><i class="fa fa-user-edit"></i></h2>
                </a>
                <a href="#" class="sidebar-toggler flex-shrink-0">
                    <i class="fa fa-bars"></i>
                </a>
                <form class="d-none d-md-flex ms-4">
                    <input class="form-control bg-dark border-0" type="search" placeholder="Search">
                </form>
                <div class="navbar-nav align-items-center ms-auto">
                    <div class="nav-item">
                        <a href="#" class="nav-link" data-bs-toggle="dropdown">
                            <i class="fa fa-envelope me-lg-2"></i>
                            ${admin.email}
                        </a>  
                    </div>
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                            <img class="rounded-circle me-lg-2" src="img/user.jpg" alt="" style="width: 40px; height: 40px;">
                            <span class="d-none d-lg-inline-flex">${admin.name.toUpperCase()}
                                    ${admin.lastName.toUpperCase()}
                            </span>
                        </a>
                        <div class="dropdown-menu dropdown-menu-end bg-secondary border-0 rounded-0 
                             rounded-bottom m-0">
                            <c:if test="${admin.superUser == true}">
                                <button type="button" class="dropdown-item" 
                                    data-bs-toggle="modal" data-bs-target="#exampleModal" 
                                    data-bs-whatever="@mdo">
                                    Agregar Admin
                                </button>
                            </c:if>
                            
                            <form action="${pageContext.request.contextPath}/ServletController?action=logout" 
                                method="POST">
                                    <button type="submit" class="dropdown-item">Salir</button>
                            </form>
                        </div>
                    </div>
                </div>
            </nav>
            <!-- Navbar End -->
