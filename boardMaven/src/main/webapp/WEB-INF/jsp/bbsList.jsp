<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
    <h2>게시판 만들기</h2>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>SEQ</th>
				<th>TITLE</th>
				<th>USER</th>
			</tr>
		</thead>
		<tbody id="tableBody">
			<c:forEach var="list" items="${list}">		
			<tr>
				<td>${list.seq}</td>
				<td><a href="/detail/${list.seq}">${list.title}</a></td>
				<td>${list.user}</td>
			</tr>
			</c:forEach>
		</tbody>	
	</table>
	
	<div style="width:100%; text-align:center;">
		<ul class="pagination">
		</ul>
	</div>
	
	
	<div class="row" style="width:100%; text-align:right; padding:10px;">
		<div class="col-sm-4"></div>
		<div class="col-sm-4">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Search" name="search" id="searchTxt">
				<div class="input-group-btn">
					<button class="btn btn-default" type="button"  id="btnSearch"><i class="glyphicon glyphicon-search"></i></button>
				</div>
			</div>
		</div>
		<div class="col-sm-4">
			<button id="btnWrite" class="btn btn-primary">글쓰기</button>
		</div>
	</div>
	
	<c:forEach var="list" items= "${list}" varStatus="status" begin="0" end="0">
		<input type="hidden" id = "maxCnt" value="${list.maxCnt}">
	</c:forEach>	
  </article>
</body>
<script>
	$(document).ready(function(){
		$("#btnWrite").click(function(){
			location.href="/add";
		});

		var maxCnt = 1;
		if($("#maxCnt").val()) {
			maxCnt = $("#maxCnt").val();
		}
		
		makePagenation(maxCnt);
		$("#btnSearch").click(function(){
			getSearchList();
		});
	});

	var makePagenation = function(maxCnt) {
		var ppc = 3;
		var maxPage = Math.ceil(maxCnt/ppc);
		var ppcHtml = "";
		for(var i = 1; i < maxPage + 1; i++) {
			ppcHtml += "<li><a href='/" + i +"'>" + i + "</a></i>";
		}
		$(".pagination").html(ppcHtml);
	}
	
	
	function getSearchList() {
		var req = { "title" : $("#searchTxt").val() };
		$.ajax({
			url : "/rest/searchList",
			dataType : "json",
			type : "post",
			data : JSON.stringify(req),
			contentType : "application/json",
			success : function(data) {
				$("#tableBody").html("");
				
				if(!data) return;
				let html = "";
				for(let i = 0; i < data.length; i++) {
					html += "<tr>" ;
					html += "<td>" + data[i].seq + "</td>";
					html += "<td><a href='/detail/"+data[i].seq+"'>" + data[i].title + "</a></td>";
					html += "<td>" + data[i].user + "</td>";
					html += "</tr>" ;	
				}
				$("#tableBody").html(html);
				makePagenation(data[0].maxCnt);
			}, 
			error : function(request, status, error) {
				alert("code : " + request.status + " error : " + error);
			}
			
		});
	}
</script>

</html>