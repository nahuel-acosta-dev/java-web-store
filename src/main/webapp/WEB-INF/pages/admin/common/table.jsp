<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="table-responsive" style="max-height: 50vh">
    <table class="table table-hover">
      <thead;>
        <tr>
          <th>#</th>
          <th>Nombre</th>
          <th>Precio</th>
          <th>Cantidad</th>
          <th>Vendidos</th>
          <th> </th>
        </tr>
      </thead>
      <tbody style="max-height: 30vh">
      <c:forEach var="product" items="${sessionScope['sessionProducts'].getProducts()}">     
        <tr>
          <th scope="row">${product.idProduct}</th>
          <td>${product.name}</td>
          <td>${product.price}</td>
          <td>${product.quantity}</td>
          <td>${product.sold}</td>
          <td>
            <div class="row">
              <div class="col">
                <a class="btn btn-primary btn-sm" href="${
                        pageContext.request.contextPath}/ProductsServletController?action=editar&idProduct=${
                            product.idProduct}"
                        >Editar</a>
              </div>
              <div class="col">
                <a class="btn btn-danger btn-sm" href="${
                        pageContext.request.contextPath}/ProductsServletController?action=eliminar&idProduct=${
                            product.idProduct}">Eliminar</a>
              </div>
            </div>
          </td>
        </tr>
       </c:forEach>
      </tbody>
    </table>
</div>