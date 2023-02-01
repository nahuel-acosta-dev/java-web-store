<section id="actions" class="mt-5 mb-5">
    <div class="container">
        <div class="row">
            <div class="col-4">
              <a class="btn btn-link text-dark btn-sm text-decoration-none" 
                 href="ProductsServletController?pagination=${sessionScope['currentPage']}"> 
                      <i class="fa-solid fa-arrow-left"></i> Regresar
              </a>
            </div>
            <div class="col-4">
                <button type="submit" class="btn btn-success btn-sm"> 
                        <i class="fa-sharp fa-solid fa-check"></i> Guardar Producto
                </button>
            </div>
        </div>
    </div>
</section>