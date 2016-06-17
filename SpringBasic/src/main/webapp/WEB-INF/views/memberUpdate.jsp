
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>멤버수정</title>
</head>
<body>
<h1>
	멤버수정
</h1>
	<form action="/spring/member1" method="post">
	<table>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="user_id"/></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="user_name"/></td>
		</tr>
		<tr>
			<th>비번</th>
			<td><input type="text" name="pw"/></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="text" name="email"/></td>
		</tr>
	
	</table>
		<input type="submit" value="등록">
	</form>
	
</body>
</html>
