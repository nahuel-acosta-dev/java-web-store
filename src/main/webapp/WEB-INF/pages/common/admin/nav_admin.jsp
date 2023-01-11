<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
      <a class="navbar-brand ms-5" href="#">Administrador</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse nav justify-content-end me-5" id="navbarNavDropdown">
        <ul class="navbar-nav me-5">
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle text-white" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Cerrar sesion
            </a>
            <ul class="dropdown-menu text-center px-2 navdropdow_admin" id="navdropdow_admin" aria-labelledby="navbarDropdownMenuLink">
              <li class="mb-2"><span class="nav-item fw-bold mb-5">${admin.name.toUpperCase()} ${admin.lastName.toUpperCase()}</span></li>
              <li class="mb-2"><span class="nav-item fw-bold mb-5">${admin.email}</span></li>
              <li><hr class="dropdown-divider"></li>
              <li>
                <form action="${pageContext.request.contextPath}/ServletController?action=logout" 
          method="POST">
                    <button type="submit" class="dropdown-item">Salir</button>
                </form>  
              </li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
</nav>