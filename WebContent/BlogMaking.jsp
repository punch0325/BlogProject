<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>블로그 생성 페이지</title>
</head>
<body>
  <div>
    <h2>블로그 이름과 사진을 지정하세요</h2>
  </div>
  <div>
    <form action = "blogmaking" method="post" enctype="multipart/form-data">
      <input type = "hidden" name = "blogid" value = "${sessionScope.loginId}">
      <input type = "text" name = "blogname"><br><br>
      <input type = "file" name = "blogimage"><br><br>
      <input type = "submit" value = "생성">
    </form>
      
  </div>

</body>
</html>