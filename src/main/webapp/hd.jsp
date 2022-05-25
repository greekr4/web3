<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }" />
    
    
    
    
    
    

 
 
 
 
 
 
 <!--  -->

 <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="${path }">Logo</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor02" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarColor02" style="justify-content: space-around;">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link active" href="${path }">Home
            <span class="visually-hidden"></span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${path }/GetBoardListCtrl">게시판</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">미구현</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">미구현</a>
        </li>
      <!-- 운영자게시판 -->
      <c:if test="${sid == 'admin' }">
        <li class="nav-item">
          <a class="nav-link" href="${path }/GetMemberListCtrl" style="color:pink;">멤버리스트(admin)</a>
        </li>
      </c:if>
	  <!-- 운영자게시판 -->
      </ul>

      <c:if test="${sid == null }">
      		<ul class="navbar-nav me-auto" style="float: right;">
        <li class="nav-item">
          <a class="nav-link active" href="${path }/member/login.jsp">로그인
            <span class="visually-hidden"></span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="${path }/member/agreement.jsp">회원가입
            <span class="visually-hidden"></span>
          </a>
        </li>
      </ul>
      </c:if>
      
      <c:if test="${sid != null }">
            		<ul class="navbar-nav me-auto" style="float: right;">
        <li class="nav-item">
          <a class="nav-link active" href="${path }/GetMyPageCtrl?uid=${sid }">${sname } (${sid })
            <span class="visually-hidden"></span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="${path }/LogoutMemberCtrl">로그아웃
            <span class="visually-hidden"></span>
          </a>
        </li>
      </ul>
      </c:if>

    </div>
  </div>
</nav>

