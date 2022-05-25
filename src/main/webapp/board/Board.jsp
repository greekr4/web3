<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--  -->
<script src="./js/jquery-latest.js"></script>
<script src="./js/bootstrap.js"></script>
<script src="./js/bootstrap.min.js"></script>
<link rel="stylesheet" href="./css/bootstrap.css">
<link rel="stylesheet" href="./css/bootstrap.min.css">
<link rel="stylesheet" href="./css/common.css">
<!--  -->
<style>

button {
display: inline-block;
padding: 3px 6px;
background: rgb(220, 220, 220);
font-weight: bold;
color: rgb(120, 120, 120);
border: none;
outline: none;
border-radius: 3px;
cursor: pointer;
transition: ease .3s;
}

button:hover {
background: #8BC34A;
color: #ffffff;
}
.board_wrap{
width: 1200px;
overflow: hidden;
margin: 0 auto;
border-top: 2px solid #000;
}
.board_wrap h4{
font-size: 24px;
line-height: 55px;
margin-left: 1em;
}
.board_ul{
	padding: 10px 20px 5px 20px;
    font-size: 1em;
    background: #f8f8f8;
    height: 25px;
    border-top: 1px solid #bbb;
    border-bottom: 1px solid #bbb;
    padding-bottom: 30px;
}
.board_ul li{
	position: relative;
    float: left;
    margin: 0 20px 5px 0;
}
.board_wrap strong{
margin-right: 1em;
}
.detailbox{
margin-top: 10px;
margin-bottom: 10px;
border-bottom: 1px solid #bbb;
min-height: 200px;
}
.detailbox p {
margin-left: 1em;
}

</style>
</head>
<body>
<div class="container2">
<header id="hd">
<jsp:include page="../hd.jsp"></jsp:include>
</header>
<div class="ct">
<!-- 회원 -->
<c:if test="${sid != 'admin' }">
<div class="board_wrap" style="margin-top:20px;">
<h4>${BoardVo.tit }</h4>
	<ul class="board_ul">
		<li>
		
			<strong>작성자</strong><span class="user">${BoardVo.writer }</span>
		</li>
		<li>
			<strong>작성일</strong><span class="cdate">${BoardVo.regdate }</span>
		</li>
	</ul>
	<div class="detailbox">
	<p>${BoardVo.con }</p>
	
	</div>
<button type="button" onclick="location.href='./GetBoardListCtrl';">목록</button>
</div>
</c:if>

<!-- 관리자 -->
<c:if test="${sid == 'admin' }">
<br>
<h3 style="text-align: center;">-----관리자-----</h3>


<form action="EditBoardCtrl" method="post">
<div class="board_wrap" style="margin-top:20px;">
<h4><input type="text" value="${BoardVo.tit }" name="tit"  ></h4>
	<ul class="board_ul">
		<li>
			<strong>작성자</strong><span class="user"><input type="text" value="${BoardVo.writer }" name="writer"></span>
		</li>
		<li>
			<strong>작성일</strong><span class="cdate">${BoardVo.regdate }</span>
		</li>
		<li>
			<strong>공개/비공개</strong><span class="lock_span">
			<select name="lock_post" id="lock_post">
			<option value="1">공개</option>
			<option value="2">비공개</option>
			</select>
			
			<script>
			var lpv = ${BoardVo.lock_post };
			if (lpv == 1){
			$("#lock_post").val("1").prop("select", true);
			}else{
			$("#lock_post").val("2").prop("select", true);
			}
			
			
			</script>
			</span>
		</li>
	</ul>
	<div class="detailbox">
	<p>
	<textarea name="con" id="" cols="150" rows="10">${BoardVo.con }</textarea>
	
	
	
	</p>
	
	</div>
	<input type="hidden" value="${BoardVo.no }" name="no">
	<button type="submit">수정</button>
	<button type="button" onclick="location.href='DelBoardCtrl?no=${BoardVo.no }';">삭제</button>
	<button type="button" onclick="location.href='./GetBoardListCtrl';">목록</button>
</div>

</form>
</c:if>


</div>
<footer id="ft">
<jsp:include page="../ft.jsp"></jsp:include>
</footer>
</div>


</body>
</html>