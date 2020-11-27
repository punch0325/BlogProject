<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 페이지</title>
<script>
  function boardWrite(){
	  writeform.submit();
  }
</script>
</head>
<body>        
   

   <div>
     <form action="boardwriteprocess" method = "post" enctype="multipart/form-data" name = "writeform">
       <table>
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
           <td><input type ="text" name = "btitle"></td>
         </tr>
         <tr>
           <td><textarea name = "bcontents" cols = "50px" rows="40px"></textarea></td>
         </tr>
         <tr>
           <td><input type = "file" name = "bfile"></td>
         </tr>
       </table>
     </form>
   </div>
   
   <div>
     <button onclick = "boardWrite()">작성 완료</button>
   </div>
</body>
</html>