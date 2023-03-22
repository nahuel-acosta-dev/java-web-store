<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="WEB-INF/pages/common/basic.jsp"/> 
        <title>Productos</title>
    </head>
    <body style="padding-left: 0px">
        <main class="container-fluid position-relative d-flex p-0">
            <!-- Spinner Start -->
            <jsp:include page="WEB-INF/pages/common/spinner.jsp"/>
            <!-- Spinner End -->
            
            <!-- NAVBAR -->
            <jsp:include page="WEB-INF/pages/common/nav_admin.jsp"/> 
            <!-- -------- -->
            
            

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


            <!-- Recent Sales Start -->
                <div class="container-fluid pt-4 px-4">
                    <div class="bg-secondary text-center rounded p-4">
                        <div class="d-flex align-items-center justify-content-between mb-4">
                            <h6 class="mb-0">Recent Salse</h6>
                            <a href="">Show All</a>
                        </div>
                        <div class="table-responsive">
                            <table class="table text-start align-middle table-bordered table-hover mb-0">
                                <thead>
                                    <tr class="text-white">
                                        <th>#</th>
                                        <th>Nombre</th>
                                        <th>Precio</th>
                                        <th>Cantidad</th>
                                        <th>Vendidos</th>
                                        <c:if test="${sessionScope['admin'].superUser == true}">
                                          <th>Accion</th>
                                        </c:if>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="product" 
                                               items="${sessionScope['sessionProducts'].getProducts()}">     
                                    <tr>
                                      <th scope="row">${product.idProduct}</th>
                                      <td>${product.name}</td>
                                      <td>${product.price}</td>
                                      <td>${product.quantity}</td>
                                      <td>${product.sold}</td>
                                      <c:if test="${sessionScope['admin'].superUser == true}">
                                        <td>
                                          <div class="row">
                                            <div class="col">
                                              <a class="btn btn-primary btn-sm" href="${
                                                      pageContext.request.contextPath}/ProductsServletController?action=edit&idProduct=${
                                                          product.idProduct}"
                                                      >Editar</a>
                                            </div>
                                            <div class="col">
                                              <a class="btn btn-danger btn-sm" href="${
                                                      pageContext.request.contextPath}/ProductsServletController?action=delete&idProduct=${
                                                          product.idProduct}">Eliminar</a>
                                            </div>
                                          </div>
                                        </td>
                                      </c:if>
                                    </tr>
                                   </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            <!-- Recent Sales End -->
            
            <!-- pagination -->
            <div class="container-fluid pt-4 px-4">
                <div class="row justify-content-center">
                    <div class="col"></div>
                    <div class="col d-flex justify-content-center">
                        <jsp:include page="WEB-INF/pages/common/pagination.jsp"/> 
                    </div>
                    <div class="col"></div>
                </div>
            </div>
            <!-- -------- -->
        </main>        

        <jsp:include page="WEB-INF/pages/admin/common/add_admin.jsp"/> 
        <jsp:include page="WEB-INF/pages/common/bootstrapjs.jsp"/>
</html>
