<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <head>
                <jsp:include page="../WEB-INF/pages/common/basic.jsp"/>

                <title>Editar Producto</title>
        </head>
        <header>
                <jsp:include page="../WEB-INF/pages/admin/common/nav_admin.jsp"/>
        </header>
        <body>
                <main>
                    <jsp:include page="../WEB-INF/pages/common/navigation_buttons.jsp"/> 
                    <div class="container mb-5 cont-form-product">
                        <form class="row g-3">
                            <div class="col-md-6">
                                <label for="inputName" class="form-label">Nombre</label>
                                <input type="text" class="form-control" 
                                       id="inputName" value="${product.getName()}"
                                       name="name">
                            </div>
                            <div class="col-md-6">
                                <label for="inputPrice" class="form-label">Precio</label>
                                <input type="number" class="form-control" id="inputPrice" 
                                       min="1" max="900000" value="${product.getPrice()}"
                                       name="price">
                            </div>
                            <div class="col-md-6">
                                <label for="inputComparePrice" class="form-label">Precio Anterior</label>
                                <input type="number" class="form-control" 
                                       id="inputComparePrice" min="1" name="comparePrice"
                                       max="900000" value="${product.getComparePrice()}">
                            </div>
                            <div class="col-md-6">
                                <label for="inputSold" class="form-label">Vendidos</label>
                                <input type="number" class="form-control" 
                                       id="inputSold" min="1" name="sold"
                                       max="900000" value="${product.getSold()}">
                            </div>
                            <div class="col-md-6">
                                <label for="inputQuantity" class="form-label">Stock</label>
                                <input type="number" class="form-control" id="inputQuantity" 
                                       min="0" max="100000" value="${product.getQuantity()}"
                                       name="quantity">
                            </div>
                            <div class="col-md-4">
                                <label for="inputCategory" class="form-label">Categoria</label>
                                <select id="inputCategory" class="form-select" name="category">
                                    <c:forEach var="category" items="${categories}">
                                        <c:choose>
                                            <c:when test="${product.getCategory() == category.getIdCategory()}">
                                                <option value="${category.getIdCategory()}" selected>
                                                    ${
                                                        category.getName().toUpperCase().charAt(0) 
                                                    }${
                                                        category.getName().substring(
                                                            1, category.getName().length()
                                                        ).toLowerCase()
                                                    }
                                                </option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${category.getIdCategory()}">
                                                    ${
                                                        category.getName().toUpperCase().charAt(0) 
                                                    }${
                                                        category.getName().substring(
                                                            1, category.getName().length()
                                                        ).toLowerCase()
                                                    }
                                                </option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-md-2">
                                <label for="inputGender" class="form-label">Genero</label>
                                <select id="inputGender" class="form-select" name="gender">
                                    <c:forEach var="gender" items="${genders}">
                                        <c:choose>
                                            <c:when test="${product.getGender() == gender.getIdGender()}">
                                                <option value="${gender.getIdGender()}" selected>
                                                    ${gender.getName().toUpperCase().charAt(0)
                                                    }${
                                                        gender.getName().substring(
                                                            1, gender.getName().length()
                                                        ).toLowerCase()
                                                    }    
                                                </option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${gender.getIdGender()}">
                                                    ${gender.getName().toUpperCase().charAt(0)
                                                    }${
                                                        gender.getName().substring(
                                                            1, gender.getName().length()
                                                        ).toLowerCase()
                                                    }    
                                                </option>
                                            </c:otherwise>
                                        </c:choose>
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
                                              value="${product.getDescription()}"
                                              >${product.getDescription()}.</textarea>
                            </div>
                            <div class="col-12">
                                    <button type="submit" class="btn btn-primary">Sign in</button>
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
