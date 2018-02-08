<jsp:include page="./header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<table class="table">
	<thead>
		<tr>
			<th>Id</th>
			<th>Champ 1</th>
			<th>Champ 2</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listeExemples}" var="ex">
			<tr>
				<td>${ex.id}</td>
				<td>${ex.champ1}</td>
				<td>${ex.champ2}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page="./footer.jsp" />