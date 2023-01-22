<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav aria-label="Page navigation example">
    <ul class="pagination">
      <li class="page-item">
        <a class="page-link" href="#" aria-label="Previous">
          <span aria-hidden="true">&laquo;</span>
        </a>
      </li>
      <c:forEach var = "i" begin = "1" end = "${sessionScope['sessionProducts'].getSections()}">
        <li class="page-item"><a class="page-link" href="#"><c:out value = "${i}"/></a></li>
      </c:forEach>
      <li class="page-item">
        <a class="page-link" href="#" aria-label="Next">
          <span aria-hidden="true">&raquo;</span>
        </a>
      </li>
    </ul>
</nav>