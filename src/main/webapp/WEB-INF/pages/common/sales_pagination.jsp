<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid">
<nav aria-label="Page navigation example" class="table-responsive">
    <ul class="pagination">
        <c:if test="${sessionScope['currentPage'] > 1}">
            <li class="page-item">
                <a 
                    class="page-link" 
                    href="${pageContext.request.contextPath}/SoldsServletController?pagination=${
                            sessionScope['currentPage'] - 1}"
                    aria-label="Previous"
                    >
                        <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
        </c:if>    
        <c:if test="${sessionScope['currentPage'] > 10}">
            <li class="page-item">
                <a class="page-link" 
                href="${
                pageContext.request.contextPath}/SoldsServletController?pagination=${1}">
                   <c:out value = "..."/>
                </a>
            </li>   
        </c:if>  
        <c:forEach var="i" begin="1" end="${sessionScope['sessionProducts'].getSections()}">
            <c:choose>
                <c:when test="${sessionScope['currentPage'] == i}">
                        <li class="page-item active">
                            <a class="page-link" 
                            href="${
                            pageContext.request.contextPath}/SoldsServletController?pagination=${i}">
                                 <c:out value = "${i}"/>
                            </a>
                        </li>     
                </c:when>
                <c:otherwise>
                    <c:if test="${i > (sessionScope['currentPage'] - 10) && i < 11 || 
                                  sessionScope['currentPage'] < 11 && i < 11 ||
                                  sessionScope['currentPage'] > 9 && i == (sessionScope['currentPage'] + 1) ||
                                  sessionScope['currentPage'] > 10 && 
                                  i < sessionScope['currentPage'] && i > (sessionScope['currentPage'] - 10)
                          }">
                        <li class="page-item">
                            <a class="page-link" 
                            href="${
                            pageContext.request.contextPath}/SoldsServletController?pagination=${i}">
                               <c:out value = "${i}"/>
                            </a>
                        </li>    
                    </c:if>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:if test="${sessionScope['sessionProducts'].getSections() > 10 && 
                      (sessionScope['currentPage'] + 1) < sessionScope['sessionProducts'].getSections()}">
            <li class="page-item">
                <a class="page-link" 
                href="${
                pageContext.request.contextPath}/SoldsServletController?pagination=${
                    sessionScope['sessionProducts'].getSections()}">
                   <c:out value = "..."/>
                </a>
            </li>   
        </c:if>
        <c:if test="${sessionScope['currentPage'] < sessionScope['sessionProducts'].getSections()}">
            <li class="page-item">
                <a class="page-link" 
                   href="${pageContext.request.contextPath}/SoldsServletController?pagination=${
                                sessionScope['currentPage'] + 1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </c:if>
    </ul>
</nav>
</div>