<%@page import="com.ads.bean.InfoValue"%>
<%@page import="java.util.Enumeration"%>

<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%
	Enumeration<String> enumeration = request.getAttributeNames();
	while (enumeration.hasMoreElements()) {
		String key = (String)enumeration.nextElement();
		out.println(key + ":" + request.getAttribute(key)+"<br>");
		if ("infoObject".equals(key)) {
			InfoValue info = (InfoValue)request.getAttribute(key);
			out.println("================>" + info.getUserBean().getId() + ":" + info.getUserBean().getName()+"<br>");
		}
	}
	%>
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
