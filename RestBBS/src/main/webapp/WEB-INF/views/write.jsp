
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ include file="./include/header.jsp" %>
<h1>
	게시글 작성
</h1>
	<form action="/rest/" method="post">
	<table class="table">
		<tr>
			<th>제목</th>
			<td><input type="text" name="title"/></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="user_name"/></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content" rows="10" cols="50"></textarea></td>
		</tr>
		
	
	</table>
		<input type="submit" class="btn btn-info" value="등록">
	</form>
	
<%@ include file="./include/footer.jsp" %>