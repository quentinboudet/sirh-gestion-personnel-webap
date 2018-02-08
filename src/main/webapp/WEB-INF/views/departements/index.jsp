<jsp:include page="../header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<table class="table">
	<thead>
		<tr>
			<th>Id</th>
			<th>Nom</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listDepartement}" var="dep">
			<tr>
				<td>${dep.id}</td>
				<td>${dep.nom}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page="../footer.jsp" />