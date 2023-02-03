<div class="modal fade bg-dark" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <form class="modal-dialog" action="${pageContext.request.contextPath}/ServletController?action=insert"
        method="POST">
    <div class="modal-content bg-secondary">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Agregar Admin</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <div class="row g-3">
            <div class="col-md-6">
              <label for="inputName" class="form-label">Nombre</label>
              <input type="text" class="form-control" id="inputName" name="name">
            </div>
            <div class="col-md-6">
              <label for="inputLastName" class="form-label">Apellido</label>
              <input type="text" class="form-control" id="inputLastName" name="last_name">
            </div>
            <div class="col-md-6">
              <label for="inputEmail4" class="form-label">Email</label>
              <input type="email" class="form-control" id="inputEmail4" name="email">
            </div>
            <div class="col-md-6">
              <label for="inputPassword4" class="form-label">Contraseña</label>
              <input type="password" class="form-control" id="inputPassword4" name="password">
            </div>
          </div>
          <div class="col-12 mt-3">
            <div class="form-check">
              <span class="d-inline-block" tabindex="0" data-bs-toggle="popover" 
                      data-bs-trigger="hover focus" data-bs-content="Disabled popover">
                <input class="form-check-input" type="checkbox" id="gridCheck" name="super_user">
                <label class="form-check-label" for="gridCheck" data-bs-toggle="popover">
                  Permisos Superiores
                </label>
              </span>
            </div>  
          </div>
      </div>
            
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Agregar</button>
      </div>
    </div>
  </form>
</div>