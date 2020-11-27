<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>나의 블로그</title>
<link href="https://fonts.googleapis.com/css2?family=Gothic+A1&display=swap" rel="stylesheet">
<script src="https://kit.fontawesome.com/6d0f499767.js" crossorigin="anonymous"></script>
<script>
  function category(){
	  var cname = prompt("카테고리명을 입력하세요");
	  if (cname == null){
		  return true;
	  }else {
	      location.href="categorymaking?cwriter=${sessionScope.loginId}&cname="+cname;
	  }
  }
  

</script>
<style>
  *{
    font-family: 'Gothic A1', sans-serif;
  }
  .setting {
    width : 200px;
    margin-top : 30px;
  }
  #write {
    position : absolute;
    top : 6px;
    left : 80px;
  }
  .setting a {
    text-decoration : none;
    color : black;
    font-size : 20px;
  }
  .setting a:hover{
    color : rgb(255, 230, 97);
  }
  .left{
    float : left;
    margin-right: -50px;
  }
  .right{
    float : right;
    margin-left: -50px; 
  }
</style>
</head>
<body>
  <p>방문자 수 : ${requestScope.blog.bloghits}</p>

  <h1 style = "text-align:center;">${requestScope.blog.blogname}</h1>
  
  <div style = "width : 800px; background-color : red; margin-left:600px;">
  <div class = "left"> 
  <div id ="profile" style="width: 200px; height: 200px; overflow: hidden; background-color : rgba(230, 230, 230, 0.877)">
    <c:if test = "${!empty requestScope.blog.blogimage}">    
      <img src = "BlogImages/${requestScope.blog.blogimage}" width = "200px" height = "100%">
    </c:if>
    
    <c:if test ="${empty requestScope.blog.blogimage}">
      <img src = "Images/기본프로필.png" width = "200px" height = "auto">
    </c:if>
  </div>
    <div>
    <a href="#">- 전체 카테고리 </a><br>
    <c:forEach var = "cList" items="${cList}">
      <a href="boardcategory?bcategory=${cList.cname}">- ${cList.cname}</a><br>
    </c:forEach>
  </div>
  
  <div class ="setting">
    <a href="boardwrite"><i class="far fa-edit" style = "font-size : 20px;"></i> 글 쓰기</a>
  </div>
  <div class ="setting">  
    <a href="#" onclick = "category()"><i class="fas fa-cog" style = "font-size : 20px;"></i> 카테고리 만들기</a>
  </div>
  <div class ="setting">
    <a href ="MainPage.jsp"><i class="fas fa-undo-alt" style = "font-size : 20px;"></i> MianPage</a>
  </div>
  </div>
  
  <div class = "right">
  <div id = "all">
    <h2>전체보기</h2>
    <table>
      <tr>
        <th>제목</th>
        <th>날짜</th>
        <th>조회수</th>
      </tr>
        <c:forEach var = "bList" items = "${bList}">
        <c:if test = "${bList.bwriter eq sessionScope.loginId}">
          <tr>
            <td><a href ="boardview?bnumber=${bList.bnumber}&page=${paging.page}&=bwriter${bList.bwriter}" target = "boardView">${bList.btitle}</a></td>
            <td>${bList.bdate}</td>
            <td>${bList.bhits}</td>
          </tr>
        </c:if>
       </c:forEach>
     </table>
      
     <c:if test="${paging.page<=1}">
	   ◁이전&nbsp; 
	 </c:if>
	 <c:if test="${paging.page>1}">
	   <a href="boardlist?page=${paging.page-1}">◁이전</a>&nbsp;
	 </c:if>
	 <c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i" step="1">
		<c:choose>                                                                                             
		  <c:when test="${i eq paging.page}">
			${i}
		  </c:when>
			<c:otherwise>
				<a href="boardlist?page=${i}">${i}</a>
			</c:otherwise>
		</c:choose>
	  </c:forEach>

	 <c:if test="${paging.page>=paging.maxPage}">
		다음▷
	 </c:if>
	 <c:if test="${paging.page<paging.maxPage}">
		 <a href="boardlist?page=${paging.page+1}">다음▷</a>
	 </c:if>
  </div>
  
  
  <div id = "category">
    <h2>${requestScope.cname}<span style ="font-size : 17px; color:gray;"> 의 글 보기</span></h2>
    <table>
      <tr>
        <th>제목</th>
        <th>날짜</th>
        <th>조회수</th>
      </tr>
        <c:forEach var = "bcList" items = "${bcList}">
        <c:if test = "${bcList.bwriter eq sessionScope.loginId}">
          <tr>
            <td><a href ="boardview?bnumber=${bcList.bnumber}&page=${paging.page}&=bwriter${bcList.bwriter}" target = "boardView">${bcList.btitle}</a></td>
            <td>${bcList.bdate}</td>
            <td>${bcList.bhits}</td>
          </tr>
        </c:if>
       </c:forEach>
     </table>
      
     <c:if test="${paging.page<=1}">
	   ◁이전&nbsp; 
	 </c:if>
	 <c:if test="${paging.page>1}">
	   <a href="boardlist?page=${paging.page-1}">◁이전</a>&nbsp;
	 </c:if>
	 <c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i" step="1">
		<c:choose>                                                                                             
		  <c:when test="${i eq paging.page}">
			${i}
		  </c:when>
			<c:otherwise>
				<a href="boardlist?page=${i}">${i}</a>
			</c:otherwise>
		</c:choose>
	  </c:forEach>

	 <c:if test="${paging.page>=paging.maxPage}">
		다음▷
	 </c:if>
	 <c:if test="${paging.page<paging.maxPage}">
		 <a href="boardlist?page=${paging.page+1}">다음▷</a>
	 </c:if>
  </div>
  
  <div>
    <iframe width ="500px" height = "800px" name = "boardView" frameborder = "1"></iframe>
  </div>
  </div>
  
  </div>
  
  



</body>
</html>