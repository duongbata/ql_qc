<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<sf:form action="${pageContext.request.contextPath}/logon" method="POST" modelAttribute="user">
			<table>
				<tr>
					<td>Id</td>
					<td>
						<sf:input path="id"/>
					</td>
				</tr>
				<tr>
					<td>Name</td>
					<td>
						<sf:input path="name"/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="Logon">
					</td>
				</tr>
			</table>			
		</sf:form>
	</center>
</body>
</html>