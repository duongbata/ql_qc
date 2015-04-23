<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript">
	$(document).on('click','#btnJson',function(){
		var link = CONTEXT_PATH+"/user/jsonUser";
		$.ajax({
			type : "GET",
			url : link,
			success : function(result) {
				alert(result.id);
			},
			error : function(e) {
				alert(e);
			}
		});
	});
</script>
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
<sf:form action="user/add" method="POST" commandName="user">
	<table>
		<tr>
			<th>Name</th>
			<td>
				<sf:hidden path="id"/>
				<sf:input path="name"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="OK"/>
			</td>
		</tr>
	</table>
</sf:form>
<input type="button" value="Json" id="btnJson">