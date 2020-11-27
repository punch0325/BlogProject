<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<script src="https://kit.fontawesome.com/6d0f499767.js" crossorigin="anonymous"></script>
<link href="https://fonts.googleapis.com/css2?family=Gothic+A1&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Julius+Sans+One&display=swap" rel="stylesheet">
<script>
  function goBlog(){
	  var id = '${sessionScope.blogLogin}'
	  if (id == null){
		  location.href="GoBlogFail.jsp";
	  }else {
		  location.href="blogview?blogid=${sessionScope.loginId}";
	  }
  }
</script>
<style>
  body{
    margin : 0px;
  }
  *{
    font-family: 'Gothic A1', sans-serif;
    font-size : 20px;
  }
  .mainpage{
    background-color : gray;
/*     padding-bottom :25px;
    padding-top :20px;  */
  }
  #category{
    height : 43px;
    font-size : 15px;
  }
  .header{
    text-align : right;
  }
  .logo{
    text-align : center;
    margin-top : -10px;
    margin-bottom : 40px;
  }
  span{
    font-family: 'Julius Sans One', sans-serif;
  }
  #join,#login,#logout{
    font-family: 'Julius Sans One', sans-serif;
    font-size : 17px;
    text-decoration: none;
    color : black;
    margin : 0px 3px 0px 3px; 
  }
  #join:hover, #login:hover , #logout:hover{
    color : rgb(255, 244, 97);
  }
   .search{
    margin-top : 20px;
    float : right;
  }
  .bl{
    width : 200px; 
    height : 270px;
    background-color : rgb(255, 244, 97);
    position : relative;
    border : 2px rgb(255, 244, 97) solid;
  }
  .bl a {
    background-color : rgb(255, 244, 97);
    margin-top : 60px; 
    position : absolute;
    top : 55px;
    left : 33px;
    text-decoration : none;
    color : black;
    font-size : 35px;
  }
  .blogmake {
    width : 200px;
    height : 50px;
    position : relative;
    border : 2px rgb(255, 244, 97) solid;
    margin-bottom : 10px;
  }
  .blogmake a {
    font-size : 35px;
    text-decoration : none;
    position : absolute;
    top : 12px;
    left : 34px;
    color : black;
  }
  .blogmake a:hover {
    color : rgb(255, 244, 97);
  }
  #cate a{
    text-decoration : none;
    font-size : 40px;
    color : black;
  }
  #cate a:hover {
    color : rgb(255, 244, 97);
  }
  #button{
    border : 1px gray solid;
    background-color : white;
    border-radius: 8px;
  }
  .left{
    float : left;
    margin-left: 30px;
  }
  .right{
    float : right;
  }
  .footer{
    position: fixed; 
    bottom: 0; 
    width: 100%;
    text-align : center;
  }
  #footer{
    font-size : 15px;
    color : gray;
  }
</style>
</head>
<body>
  

  <div class = "header">
    <strong><a href = "MemberJoin.jsp" id = "join" >JOIN</a></strong>
    <strong><a href = "MemberLogin.jsp" id = "login">LOGIN</a></strong>
    <strong><a href = "memberlogout" id = "logout" >LOGOUT</a></strong>
  </div>
  
  <div class = "logo">
    <span style = "font-size : 50px; color : rgb(255, 244, 97);">EUNBI BLOG</span>
  </div>
  
  <hr size ="1" color ="gray">
  
  
  <div class = "mainpage">
  
  <div class = "left">
  <div style="margin-top:30px;">
    <button onclick = "location.href='bloghot'" id = "button">인기 블로그</button>
  </div>
  <div style="margin-top:10px;">
    <c:forEach var = "b" items = "${blogList}">
      <c:if test = "${!empty b.blogimage}">    
        <a href = "blogview?blogid=${b.blogid}"><img src ="BlogImages/${b.blogimage}" width = "300px"; height = "300px"; > </a> 
      </c:if>
      <c:if test ="${empty b.blogimage}">
        <a href = "blogview?blogid=${b.blogid}"><img src = "Images/기본프로필.png" width = "300px" height = "auto"> </a> 
      </c:if>
    </c:forEach>
  </div>
  
  <div>
    <button onclick = "location.href='boardhot'" id ="button">인기 글</button>
  </div>
  <div style="margin-top:10px;">
    <c:forEach var = "b" items = "${bList}">
      <span id = "cate"><a href = "blogview?blogid=${b.bwriter}">- ${b.btitle}</a></span> <br>
    </c:forEach>
  </div>
  </div>
  
  <div class = "right">
  <div class = blogmake>
    <a href="BlogMaking.jsp" style = "font-size : 25px; ">블로그 생성</a>
  </div>
  
  <div>
    <c:if test ="${!empty sessionScope.loginId}">
      <div class = "bl">
        <a href = "#" onclick = "goBlog();">My Blog</a>
      </div>
    </c:if>
    <c:if test ="${empty sessionScope.loginId}">
      <div class = "bl">
        <a href = "BlogViewFail.jsp">My Blog</a>
      </div>
    </c:if>
  </div>
  </div>
  
  </div>
  
  <div class = "footer">
    <span id = "footer">이용약관|개인정보처리방침 |책임의 한계와 법적고지|고객센터</span><br>
    <span id = "footer">© EUNBI BLOG Corp</span>
  </div>
</body>
</html>