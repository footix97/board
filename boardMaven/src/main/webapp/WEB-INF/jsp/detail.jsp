<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>게시판</title>
<style>
	article { padding : 10px; }
</style>
</head>
<body>
	<article>
	<h2>글쓰기</h2>
	<br>
		<div class="form-group">
			<label for="inputlg">제목</label>
			<input class="form-control  input-lg" name="title" id="title" type="text" disabled>
		</div>

		<div class="form-group">
			<label for="inputlg">작성자</label>
			<input class="form-control  input-lg" name="user" id="user" type="text" disabled>
		</div>

		<div class="form-group">
			<label for="inputlg">본문</label>
			<textarea class="form-control" rows="5"  name="detl" id="detl"  disabled></textarea>
		</div>

		<div class="form-group">
			<label for="comment">첨부파일</label>
			<span id="attach"></span>
		</div>
		
		<div class="row" style="width:100%; text-align:right; padding:10px;">
			<button type="button" class="btn btn-primary" id="btnList">목록</button>
			<button type="button" class="btn btn-primary" id="btnRev">수정</button>
		</div>

	</article>
</body>
<script>
$(document).ready(function(){
	$("#btnRev").click(function(){
		location.href="/rev?seq=${seq}";
	});
	
	$("#btnList").click(function(){
		location.href="/";
	});
	
	getDetail();
});

function getDetail() {
	var req = { "title" : $("#searchTxt").val() };
	$.ajax({
		url : "/rest/detail/${seq}",
		dataType : "json",
		type : "get",
		data : "",
		contentType : "application/json",
		success : function(data) {
			$("#attach").html("<a href='/filedown/${seq}/" + data.fileuuid + "'>" + data.filename + "</a>" );
			$("#title").val(data.title);
			$("#user").val(data.user);
			$("#detl").val(data.detl);
		}, 
		error : function(request, status, error) {
			alert("code : " + request.status + " error : " + error);
		}
		
	});
}
</script>
</html>