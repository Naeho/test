
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>멤버목록</title>
</head>
<body>
<h1>
	멤버목록
</h1>

<input type="hidden" id="uid" name="uid" value="" />	
<table>
	
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>비밀번호</th>
		<th>이메일</th>
	</tr>

	<c:forEach items="${list}" var="vo">
		<tr>
			
			<td>${vo.getUser_id()}</td>
			<td>${vo.getUser_name()}</td>
			<td>${vo.getPw()}</td>
			<td>${vo.getEmail()}</td>
					
			<td><input type="button" onclick="goUpdate(${vo.getUser_id()})" value="수정"></td>
			<td>
				<form id="frm" name="frm" action="/spring/memberDelete" method="post">
				<input type="hidden" id="user_id" name="user_id" value="${vo.getUser_id()}">
				<input type="submit" value="삭제" />
			</td>
		</tr>	
	</c:forEach>
</table>
</form>
</body>
<script>
	function goUpdate(index) {
		location.href="/spring/memberUpdate/"+index;
	}
</script>
</html>
