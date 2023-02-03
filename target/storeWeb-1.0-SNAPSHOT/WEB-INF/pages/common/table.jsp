<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Recent Sales Start -->
<div class="container-fluid pt-4 px-4">
    <div class="bg-secondary text-center rounded p-4">
        <div class="d-flex align-items-center justify-content-between mb-4">
            <h6 class="mb-0">Recent Salse</h6>
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
                              <a class="btn btn-success btn-sm" href="${
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