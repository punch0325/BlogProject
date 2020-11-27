<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세보기 페이지</title>

</head>
<body>
  <div>
     <table>
           <tr>
              <td>${board.bcontents}</td>
           </tr>
           <c:if test = "${!empty board.bfile}">
              <tr>
                 <td><img src = "BlogImages/${board.bfile}" style = "width : 300px; height : 300px;" ></td>
              </tr>
           </c:if>
      </table><br>
      <button onclick = "location.href='boardupdate?bnumber=${board.bnumber}'">수정</button>
      <button onclick = "location.href='boarddelete?bnumber=${board.bnumber}'">삭제</button>
      
  </div>
</body>
</html>