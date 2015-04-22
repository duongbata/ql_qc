<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<h1>${message}</h1>
	<c:if test="${not empty listUser}">
		<table>
			<c:forEach items="${listUser}" var="user">
				<tr>
					<td>
						<c:out value="${user.id}"></c:out>
					</td>
					<td>
						<c:out value="${user.name}"></c:out>
					</td>
				</tr>
			</c:forEach>	
		</table>
	</c:if>
