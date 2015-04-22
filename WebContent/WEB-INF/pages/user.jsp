<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<sf:form method="POST" modelAttribute="user">
	<fieldset>
		<table>
			<tr>
				<th>ID</th>
				<td>
					<sf:input path="id"/>
				</td>
			</tr>
			<tr>
				<th>Name</th>
				<td>
					<sf:input path="name"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="OK"/>
				</td>
			</tr>
		</table>
	</fieldset>
</sf:form>