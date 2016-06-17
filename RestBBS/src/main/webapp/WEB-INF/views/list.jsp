
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ include file="./include/header.jsp" %>
<h1>
	목록
</h1>
<input type="button" style="float:right" class="btn btn-success" onclick="goWrite()" value="글쓰기">

<table class="table">
	
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>글쓴이</th>
		<th>날짜</th>
		<th>조회수</th>
	</tr>

	<c:forEach items="${list}" var="vo">
		<tr>		
			<td>${vo.getBoard_no()}</td>
			<td><a href="/rest/${vo.getBoard_no()}">${vo.getTitle()} (${vo.getReply_cnt()})</a></td>
			<td>${vo.getUser_name()}</td>
			<td>${vo.getRegdate()}</td>
			<td>${vo.getView_cnt()}</td>
		</tr>	
	</c:forEach>
</table>
<script>
	function goWrite() {
		location.href="/rest/new"
	}
</script>
<%@ include file="./include/footer.jsp" %>