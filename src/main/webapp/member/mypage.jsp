<%@page import="javax.swing.text.AbstractDocument.Content"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.shop.model.MemberDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<!--  -->
<script src="./js/jquery-latest.js"></script>
<script src="./js/bootstrap.js"></script>
<script src="./js/bootstrap.min.js"></script>
<link rel="stylesheet" href="./css/bootstrap.css">
<link rel="stylesheet" href="./css/bootstrap.min.css">
<link rel="stylesheet" href="./css/common.css">
<!--  -->





<style>
.form {
  position: relative;
  z-index: 1;
  background: #FFFFFF;
  max-width: 360px;
  margin: 0 auto 100px;
  margin-top:100px;
  padding: 45px;
  text-align: center;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}


.form input {
  font-family: "Roboto", sans-serif;
  outline: 0;
  background: #f2f2f2;
  width: 100%;
  border: 0;
  margin: 0 0 15px;
  padding: 15px;
  box-sizing: border-box;
  font-size: 14px;
}
.form button {
  font-family: "Roboto", sans-serif;
  text-transform: uppercase;
  outline: 0;
  background: #343a40;
  width: 100%;
  border: 0;
  padding: 15px;
  color: #FFFFFF;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}
.form button:hover,.form button:active,.form button:focus {
  background: #444a50;
}
.form .message {
  margin: 15px 0 0;
  color: #b3b3b3;
  font-size: 12px;
}

.form .message a {
  color: #343a40;
  text-decoration: none;
}
.form .register-form {
  display: none;
}
</style>
</head>
<body>
<div class="container2">
<header id="hd">
<jsp:include page="../hd.jsp"></jsp:include>
</header>
<div class="ct">
<div class="loginbox">
    <div class="join-page">
  <div class="form">
  	<h2>My Page</h2>
    <form class="join" id="join" action="EditMemberCtrl" method="post">
      <input type="text" placeholder="id" name="my_id" id="my_id" value="${MemberVo.mid }" required readonly/>
      <input type="password" placeholder="password" name="my_pw" id="my_pw" required/>
      <input type="text" placeholder="name" name="my_name" id="my_name" value="${MemberVo.mname }"required readonly/>
      <input type="text" placeholder="nickname" name="my_nick" id="my_nick"value="${MemberVo.mnick }" required/>
      <input type="text" placeholder="tel" name="my_tel" id="my_tel" value="${MemberVo.mtel }" required/>
      <input type="text" placeholder="address" name="my_address" id="my_address" value="${MemberVo.maddress }" required/>
      <input type="text" placeholder="email" name="my_email" id="my_email" value="${MemberVo.memail }" required/>   
      <c:if test="${sid == 'admin' }">
      <!-- admin -->
      <input type="text" name="my_cash" id="my_cash" placeholder="cash" value="${MemberVo.mcash }">
      <input type="text" name="my_point" id="my_point" placeholder="point" value="${MemberVo.mpoint }">
      <input type="text" name="my_grade" id="my_grade" placeholder="grade" value="${MemberVo.mgrade }">
      </c:if>   
      <!-- 기본회원 -->   
      <c:if test="${sid != 'admin' }">
      <input type="text" name="my_cash2" id="my_cash2" placeholder="cash" value="cash : ${MemberVo.mcash }" readonly>
      <input type="text" name="my_point2" id="my_point2" placeholder="point" value="point : ${MemberVo.mpoint }" readonly>
      <input type="text" name="my_grade2" id="my_grade2" placeholder="grade" value="grade : ${MemberVo.mgrade }" readonly>
      <input type="hidden" name="my_cash" id="my_cash" placeholder="cash" value="${MemberVo.mcash }">
      <input type="hidden" name="my_point" id="my_point" placeholder="point" value="${MemberVo.mpoint }">
      <input type="hidden" name="my_grade" id="my_grade" placeholder="grade" value="${MemberVo.mgrade }">
      </c:if> 
      <button type="button" onclick="Edit();">Edit</button>
      <button type="button" onclick="Del();" style="margin-top:5px;">Del</button>
    </form>
    <script type="text/javascript">
    function Edit(){
    var ck1 = document.getElementById("my_id").readOnly;
    var ck2 = document.getElementById("my_pw").value;
    var ck4 = document.getElementById("my_name").value;
    var ck5 = document.getElementById("my_nick").value;
    var ck6 = document.getElementById("my_tel").value;
    var ck7 = document.getElementById("my_address").value;
    var ck8 = document.getElementById("my_email").value;
    var ck9 = document.getElementById("my_cash").value;
    var ck10 = document.getElementById("my_point").value;
    var ck11 = document.getElementById("my_grade").value;
    if(ck1 == false){
    	alert('아이디 중복검사를 해주세요');
    	return;
    }if(ck2 == ""){
    	alert('비밀번호를 입력해주세요');
    	return;
    }if(ck4 == ""){
    	alert('이름을 입력해주세요');
    	return;
    }if(ck5 == ""){
    	alert('닉네임을 입력해주세요');
    	return;
    }if(ck6 == ""){
    	alert('연락처를 입력해주세요');
    	return;
    }if(ck7 == ""){
    	alert('주소를 입력해주세요');
    	return;
    }if(ck8 == ""){
    	alert('이메일을 입력해주세요');
    	return;
    }if(ck9 == ""){
    	alert('운영자님 빈칸이 있어요');
    	return;
    }if(ck10 == ""){
    	alert('운영자님 빈칸이 있어요');
    	return;
    }if(ck11 == ""){
    	alert('운영자님 빈칸이 있어요');
    	return;
    }
    
    
    	document.getElementById("join").submit();
    }
    
    function Del() {
    	   var retVal = confirm("정말 삭제하실껀가요?");
    	   if( retVal == true ){
    		  var uid = document.getElementById("my_id").value;
    	      location.href="DelMemberCtrl?uid="+uid;
    	   }
		
	}
    
    
    </script>
  </div>
</div>
</div>
</div>
<footer id="ft">
<jsp:include page="../ft.jsp"></jsp:include>
</footer>
</div>
</body>
</html>