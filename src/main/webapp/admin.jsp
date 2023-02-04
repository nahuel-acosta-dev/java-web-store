<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
        <head>
                <jsp:include page="WEB-INF/pages/common/basic.jsp"/> 
                <title>Iniciar sesión</title>
        </head>
        <body>
                <main class="container-fluid position-relative d-flex p-0">
                        
                    <!-- Spinner Start -->
                    <jsp:include page="WEB-INF/pages/common/spinner.jsp"/>
                    <!-- Spinner End -->
                    
                    <span class="text-warning text-uppercase fs-4 fw-normal" role="alert">
                            <c:if test="${sessionScope['msje_err'] != null}">
                                ${sessionScope['msje_err']}
                            </c:if>
                    </span>
                    
                    <!-- Sign In Start -->
                    <div class="container-fluid">
                        <div class="row h-100 align-items-center justify-content-center" style="min-height: 100vh;">
                            <div class="col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4">
                                <form action="${pageContext.request.contextPath}/ServletController?action=login" 
                                      method="POST" class="bg-secondary rounded p-4 p-sm-5 my-4 mx-3">
                                    <div class="d-flex align-items-center justify-content-between mb-3">
                                        <a href="index.html" class="">
                                            <h3 class="text-primary"><i class="fa fa-user-edit me-2"></i>Admin</h3>
                                        </a>
                                        <h3>Iniciar sesión</h3>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input type="email" 
                                                class="form-control" 
                                                id="floatingInput" 
                                                name="email" 
                                                placeholder="Debes ingresar tu email para continuar" 
                                                required>
                                        <label for="floatingInput">Email</label>
                                    </div>
                                    <div class="form-floating mb-4">
                                        <input  type="password" 
                                                class="form-control" 
                                                id="floatingPassword" 
                                                name="password" 
                                                placeholder="Debes ingresar tu contraseña para continuar" 
                                                required>
                                        <label for="floatingPassword">Contraseña</label>
                                    </div>
                                    <button type="submit" class="btn btn-primary py-3 w-100 mb-4">Ingresar</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </main>
                <jsp:include page="WEB-INF/pages/common/bootstrapjs.jsp"/>     
        </body>
</html>
