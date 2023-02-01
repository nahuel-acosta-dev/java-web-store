<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <head>
                <jsp:include page="../WEB-INF/pages/common/basic.jsp"/>

                <title>Agregar Producto</title>
        </head>
        <header>
                <jsp:include page="../WEB-INF/pages/admin/common/nav_admin.jsp"/>
        </header>
        <body>
                <main>
                    <div class="container mb-5 cont-form-product">
                        <form class="row g-3" method="POST" action="${
                              pageContext.request.contextPath
                                  }/ProductsServletController?action=add_product">
                            <jsp:include page="../WEB-INF/pages/common/navigation_buttons.jsp"/> 
                            <div class="col-md-6">
                                <label for="inputName" class="form-label">Nombre</label>
                                <input type="text" class="form-control" maxlength="200"
                                       id="inputName" value="${product.getName()}"
                                       name="name" required>
                            </div>
                            <div class="col-md-6">
                                <label for="inputPrice" class="form-label">Precio</label>
                                <input type="number" class="form-control" id="inputPrice" 
                                       min="1" max="900000" value=""
                                       name="price" required step="any">
                            </div>
                            <div class="col-md-6">
                                <label for="inputComparePrice" class="form-label">Precio Anterior</label>
                                <input type="number" class="form-control" id="inputComparePrice"
                                       min="1" name="comparePrice"max="900000" required step="any"
                                       value="">
                            </div>
                            <div class="col-md-6">
                                <label for="inputSold" class="form-label">Vendidos</label>
                                <input type="number" class="form-control" 
                                       id="inputSold" min="0" name="sold" required
                                       max="900000" value="">
                            </div>
                            <div class="col-md-6">
                                <label for="inputQuantity" class="form-label">Stock</label>
                                <input type="number" class="form-control" id="inputQuantity" 
                                       min="0" max="100000" value="" required
                                       name="quantity">
                            </div>
                            <div class="col-md-4">
                                <label for="inputCategory" class="form-label">Categoria</label>
                                <select id="inputCategory" class="form-select" name="category" required>
                                    <option selected>
                                        Elegir Categoria
                                    </option>
                                    <c:forEach var="category" items="${categories}">
                                        <option value="${category.getIdCategory()}">
                                            ${
                                                category.getName().toUpperCase().charAt(0) 
                                            }${
                                                category.getName().substring(
                                                    1, category.getName().length()
                                                ).toLowerCase()
                                            }
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-md-2">
                                <label for="inputGender" class="form-label">Genero</label>
                                <select id="inputGender" class="form-select" name="gender" required>
                                        <option selected>
                                            Elegir Genero
                                        </option>
                                    <c:forEach var="gender" items="${genders}">
                                        <option value="${gender.getIdGender()}">
                                            ${gender.getName().toUpperCase().charAt(0)
                                            }${
                                                gender.getName().substring(
                                                    1, gender.getName().length()
                                                ).toLowerCase()
                                            }    
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="mb-3">
                                <label for="exampleFormControlTextarea1" class="form-label">
                                        Descripcion
                                </label>
                                    <textarea class="form-control text-start" 
                                        id="exampleFormControlTextarea1" 
                                        rows="3"
                                        name="description" 
                                        maxlength="500"
                                        required
                                        ></textarea>
                            </div>
                        </form>  
                    </div>
                </main>
                

                <jsp:include page="../WEB-INF/pages/common/footer.jsp"/> 
                <jsp:include page="../WEB-INF/pages/admin/common/add_admin.jsp"/> 
                <script src="https://kit.fontawesome.com/50f085f1e4.js" crossorigin="anonymous"></script>
                <jsp:include page="../WEB-INF/pages/common/bootstrapjs.jsp"/>
        </body>
</html>
