
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ include file="./include/header.jsp" %>
<h1>
	제목 : ${list.getTitle()}
</h1>


<table class="table">
	
	<tr>
		<th>글쓴이</th>
		<td>${list.getUser_name()}</td>
	</tr>
	<tr>
		<th>작성일</th>
		<td>${list.getRegdate()}</td>
	</tr>
	<tr>
		<th>내용</th>		
		<td><c:out value="${list.getContent()}" escapeXml="false"/></td>
	</tr>	
	
</table>
<div style="float:right">
<form action ="/rest/${list.getBoard_no()}" method="post">
	<input type="hidden" id="_method" name="_method" value="delete">
	<input type="button" class="btn btn-success" onclick="goList()" value="목록">
	<input type="submit" class="btn btn-info" value="삭제"/>
</form>
</div>
<h3>댓글</h3>
<div id="reply_list"></div>
<div id="reply_page"></div>

<form id="reply">
	<input type="text" id="content" name="content" size="50">
	,작성자 : <input type="text" id="user_name" name="user_name" size="10"/>
	<input type="button" class="btn btn-info" onclick="insertReply()" value="등록" />
</form>


<script>

	var currentPage = 1;
	
	function setReplyList(data) {
		var result = "<ul>";
		
		$(data).each(function() {
			result += "<li>" + this.user_name + ":" + this.content + "날짜 : " + this.regdate 
					+ "<input type='button' id='btn_del' name='btn_del' value='삭제' class='btn btn-danger'"
					+ "onClick='deleteReply(" + this.reply_no + ")'>"
					+ "</li>";
		})
		
		result += "</ul>";
		document.getElementById("reply_list").innerHTML = result;
	}
	
	function setPagePrint(pm) {
		var str = "<ul class='pagination'>";
		
		if(pm.prev) {
			
			str += "<li><a style='cursor:hand' onClick='getReplyList("+(pm.startPage-1)+")'> &lt; </a></li>"
		}
		
		for(var i = pm.startPage; i <= pm.endPage; i++){
			if(i == pm.criteria.page){
				str += "<li class='active'><a style='cursor:hand'>" + i + "</a></li>";
			}else{
				str += "<li><a onClick='getReplyList("+i+")' style='cursor:hand'>" + i + "</a></li>";
			}
			
		}
		
		
		if(pm.next) {
			str += "<li><a style='cursor:hand' onClick='getReplyList("+(pm.endPage+1)+")'> &gt; </a></li>"
		}
		
		str += "</ul>";
		
		document.getElementById("reply_page").innerHTML = str;
	}
	
	function getReplyList(page) {
		
		if(page == null){
			page = currentPage;
		}
		//alert(page);
		
		var bno = '${list.board_no}';
		
		$.ajax({
			type:'get',
			url:'/reply/'+ bno + '/' + page,
			headers: {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "GET",
			},
			dataType:'json',
			data : '',
			success : function(result){
				setReplyList(result.l);
				setPagePrint(result.p);
			}
		});
		currentPage = page;
	}
	
	getReplyList(1);
	
	function goList() {
		location.href="/rest"
	}
	
	function insertReply() {
		var bno = '${list.board_no}';
		
		var reply_content = $("#content").val();
		var reply_user = $("#user_name").val();
		
		$.ajax({
			type:'post',
			url:'/reply/'+bno,
			headers: {
				"Content-Type" : "application/json",
			},
			dataType:'text',
			data : JSON.stringify({content:reply_content, user_name:reply_user}),
			success : function(result){
				if(result == "SUCCESS"){
					//alert(result);
					getReplyList(1);
				}
			}
		});
	}
	
	function deleteReply(rno) {
		var bno = '${list.board_no}';
		//alert(rno);
		$.ajax({
			type:'delete',
			url:'/reply/'+rno,
			headers: {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "DELETE",
			},
			dataType:'text',
			data : '',
			success : function(result){
				if(result == "SUCCESS"){
					//alert(result);
					getReplyList(currentPage);
				}
			}
		})
		
	}
	
</script>
<%@ include file="./include/footer.jsp" %>
