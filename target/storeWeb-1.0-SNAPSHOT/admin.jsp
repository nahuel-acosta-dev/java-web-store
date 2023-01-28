<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
        <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1" />
                <meta name="theme-color" content="#000000" />
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
                <script src="https://kit.fontawesome.com/50f085f1e4.js" crossorigin="anonymous"></script>
                <link rel="stylesheet" href="static/css/style.css">
                <title>Administrador</title>
        </head>
        <body class="bg-secondary">
                <main class="row main w-100 px-1">
                        <div class="col-sm-2 col-xs-1"></div>
                        <div class="
                             col-sm-8 col-xs-10 text-center mt-5 mb-5 border
                             border-5 border-dark rounded-3 bg-primary
                             pt-5 px-3 pb-5 h-75
                             ">

                                <span class="text-warning text-uppercase fs-4 fw-normal" role="alert">
                                        <c:if test="${sessionScope['msje_err'] != null}">
                                            ${sessionScope['msje_err']}
                                        </c:if>
                                </span>

                                <h1 class="text-white">Iniciar sesión</h1>
                                <form class="mx-5 was-validated" 
                                      action="${pageContext.request.contextPath}/ServletController?action=login" 
                                      method="POST"
                                      >
                                        <div class="mb-3">
                                                <label for="validationEmail" 
                                                       class="form-label text-white">
                                                        Ingresar Email
                                                </label>
                                                <input type="email" class="form-control is-invalid" id="validationEmail" 
                                                       aria-describedby="emailHelp" name="email" 
                                                       placeholder="Debes ingresar tu email para continuar" 
                                                       required>
                                        </div>
                                        <div class="mb-3">
                                                <label for="validationPassword" class="form-label text-white">
                                                        Contraseña
                                                </label>
                                                <input type="password" class="form-control" 
                                                       id="validationPassword" name="password" 
                                                       placeholder="Debes ingresar tu contraseña para continuar" 
                                                       required>
                                        </div>
                                        <button type="submit" class="btn btn-warning btn-lg">Ingresar</button>
                                </form>
                        </div>
                        <div class="col-sm-2 col-xs-1"></div>
                </main>
                <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>        
        </body>
</html>
