<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="index.css" rel="stylesheet" type="Text/css">
<title>로그인 페이지</title>
<link href="https://fonts.googleapis.com/css2?family=Gothic+A1&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Julius+Sans+One&display=swap" rel="stylesheet">
<style>
  body{
    margin : 0px;
  }
  *{
    font-family: 'Gothic A1', sans-serif;
    font-size : 20px;
  }
  .header{
    background-color : rgb(255, 244, 97);
    text-align : right;
  }
  .logo{
    background-color : rgb(255, 244, 97);
    text-align : center;
    margin-top : -10px;
  }
  #join,#login{
    font-family: 'Julius Sans One', sans-serif;
    font-size : 17px;
    text-decoration: none;
    color : black;
    margin : 0px 3px 0px 3px; 
  }
  #join:hover, #login:hover{
    color : white;
  }
  #logo{
    text-decoration : none;
    font-size : 50px; 
    color : green;
    font-family: 'Julius Sans One', sans-serif;
  }
  #loginform{
    height: 300px;
    margin: 25px;
    
    text-align: center;
    line-height: 200px;
    
    border: 4px solid #ffe200;
    background-image: url('Images/노란물감.jpg');
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
  }

  #loginform form{
    min-width: 363px;
    text-align: left;
    line-height: 16px;
    display: inline-block;
  }

  #loginform form div{
    width: 250px;
    display: inline-block;
    vertical-align: middle;
  }

  #loginform form div input{
    width: 100%;
    height: 31px;
    display: inline-block;
  }

  #loginform form div input:first-child{
    margin-bottom: 3px;
  }

  #loginform form > input{
    width: 100px;
    height: 77px;
    
    background-color: white;
    
    font-size: 20px;
    
    outline: 0;
    border: 1px solid black;
    border-radius: 4px;
    
    margin-left: 7px;
    vertical-align: middle;
  }
  .footer{
    position: fixed; 
    bottom: 0; 
    width: 100%;
    text-align : center;
  }
  span{
    font-size : 15px;
    color : gray;
  }
  #button{
    border : 1px black solid;
    background-color : white;
    border-radius: 8px;
  }
  #button:hover{
    background-color : rgb(245, 245, 245);
  }
  
</style>
</head>
<body>
  <div class = "header">
    <strong><a href = "MemberLogin.jsp" id = "login">LOGIN</a></strong>
    <strong><a href = "MemberJoin.jsp" id = "join" >JOIN</a></strong>
  </div>
  
  <div class = "logo">
    <a href = "MainPage.jsp" id ="logo">EUNBI BLOG</a>
  </div>
  
  <div id="loginform">
    <form action = "memberlogin" method = "post">
      <div>
        <input type="Text" name = "mid">
        <input type="password" name = "mpw">
      </div>
      <input type="submit" value="로그인" id ="button">
    </form>
  </div>
  
  <div class = "footer">
    <span>이용약관|개인정보처리방침 |책임의 한계와 법적고지|고객센터</span><br>
    <span>© EUNBI BLOG Corp</span>
  </div>

</body>
</html>