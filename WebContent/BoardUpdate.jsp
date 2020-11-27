<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
  function boardUpdate(){
	  writeform.submit();
  }
</script>
</head>
<body>
   <div>
     <form action="boardupdateprocess" method = "post" enctype="multipart/form-data" name = "writeform">
       <table>
         <tr>
           <td><input type="hidden" name = "bnumber" value = "${board.bnumber}"></td>
         </tr>
         <tr>
           <td>
             <select name = "bcategory">
               <option>카테고리</option>
               <c:forEach var = "cList" items="${cList}">
                 <option value="${cList.cname}">${cList.cname}</option>
               </c:forEach>
             </select>
           </td>
         </tr>
         <tr>
           <td><input type ="text" name = "btitle" value = "${requestScope.board.btitle}"></td>
         </tr>
         <tr>
           <td><textarea name = "bcontents" cols = "50px" rows="40px">${requestScope.board.bcontents}</textarea></td>
         </tr>
         <tr>
           <td><input type = "file" name = "bfile"></td>
         </tr>
       </table>
     </form>
   </div>
   
   <div>
     <button onclick = "boardUpdate()">수정 완료</button>
   </div>
</body>
</html>