<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="WEB-INF/pages/common/basic.jsp"/> 
        <title>Ventas</title>
    </head>
    <body style="padding-left: 0px">
        <main class="container-fluid position-relative d-flex p-0">
            <!-- Spinner Start -->
            <jsp:include page="WEB-INF/pages/common/spinner.jsp"/>
            <!-- Spinner End -->
            
            <!-- NAVBAR -->
            <jsp:include page="WEB-INF/pages/common/nav_admin.jsp"/> 
            <!-- -------- -->
            
            
       


            <!-- Recent Sales Start -->
                <div class="container-fluid pt-4 px-4">
                    <div class="bg-secondary text-center rounded p-4">
                        <div class="d-flex align-items-center justify-content-between mb-4">
                            <h6 class="mb-0">Ventas</h6>
                        </div>
                        <div class="table-responsive">
                            <table class="table text-start align-middle table-bordered table-hover mb-0">
                                <thead>
                                    <tr class="text-white">
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
                                        items="${sessionScope['sessionProducts'].getProducts()}">
                                        <tr>

                                            <td>${sales.idSales}</td>
                                            <td>${sales.product}</td>
                                            <td>${sales.user} ${sales.firstName} ${sales.lastName}</td>
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
            
            <!-- pagination -->
            <div class="container-fluid pt-4 px-4">
                <div class="row justify-content-center">
                    <div class="col"></div>
                    <div class="col d-flex justify-content-center">
                        <jsp:include page="WEB-INF/pages/common/sales_pagination.jsp"/> 
                    </div>
                    <div class="col"></div>
                </div>
            </div>
            <!-- -------- -->
        </main>        

        <jsp:include page="WEB-INF/pages/admin/common/add_admin.jsp"/> 
        <jsp:include page="WEB-INF/pages/common/bootstrapjs.jsp"/>
</html>