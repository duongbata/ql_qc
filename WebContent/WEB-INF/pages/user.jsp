<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.ads.bean.InfoValue"%>
<%@page import="java.util.Enumeration"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	$(document).on('click','#btnJson',function(){
		var link = CONTEXT_PATH+"/user/jsonUser";
		$.ajax({
			type : "GET",
			url : link,
			contentType: 'application/json',
			dataType : 'json',
			success : function(result) {
				alert(result.id+":"+result.name);
			},
			error : function(e) {
				alert ('Lỗi trong quá trình sửa');
			}
		});
	});
	$(document).on('click','#btnPostJson',function(){
		var link = CONTEXT_PATH + "/user/jsonPostUser";
		var obj = new Object();
		obj.id = 1;
		obj.name = 'trung';
		$.ajax({
			type : 'POST',
			url : link,
			data : JSON.stringify(obj),
			contentType : 'application/json',
			dataType : 'json',
			success : function(result){
				alert(result.id);
			},
			error : function(e) {
				alert('Error result');
			}
		});
	});
	$(document).on('click','#btnPostJson2',function(){
		var link = CONTEXT_PATH + "/user/jsonPostUser2";

		$.ajax({
			type : 'POST',
			url : link,
			data : {'id':'1','name':'trung'},
			contentType : 'application/json',
			dataType : 'json',
			success : function(result){
				alert(result);
			},
			error : function(e) {
				alert('Error result');
			}
		});
	});
</script>
<%-- 
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
	out.println("=======================================================================================================<br>");
	Enumeration<String> eSession = session.getAttributeNames();
	while (eSession.hasMoreElements()) {
		String key = (String)eSession.nextElement();
		out.println(key + ":" + request.getAttribute(key)+"<br>");
		if ("infoObject".equals(key)) {
			InfoValue info = (InfoValue)request.getAttribute(key);
			out.println("================>" + info.getUserBean().getId() + ":" + info.getUserBean().getName()+"<br>");
		}
	}
%> --%>
<sf:form method="POST" modelAttribute="infoObject">
<%-- 	<a href="${pageContext.request.contextPath}/welcome/1/trung">welcome</a> --%>
	<fieldset>
		<table>
			<tr>
				<th>ID</th>
				<td>
					<sf:input path="userBean.id"/>
				</td>
			</tr>
			<tr>
				<th>Name</th>
				<td>
<%-- 					<sf:input path="userBean.name"/> --%>
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
<%-- <sf:form action="user/add" method="POST" commandName="user">
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
</sf:form> --%>
<input type="button" value="Json" id="btnJson">
<input type="button" value="PostJson" id="btnPostJson">
<input type="button" value="PostJson2" id="btnPostJson2">