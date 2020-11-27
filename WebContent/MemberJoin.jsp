<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<title>회원 가입 페이지</title>
<link href="https://fonts.googleapis.com/css2?family=Gothic+A1&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Julius+Sans+One&display=swap" rel="stylesheet">
<script>
  function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            var addr = ''; 
            var extraAddr = ''; 
            if (data.userSelectedType === 'R') { 
                addr = data.roadAddress;
            } else { 
                addr = data.jibunAddress;
            }
            if(data.userSelectedType === 'R'){
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                document.getElementById("sample6_extraAddress").value = extraAddr;          
            } else {
                document.getElementById("sample6_extraAddress").value = '';
            }
            document.getElementById('sample6_postcode').value = data.zonecode;
            document.getElementById("sample6_address").value = addr;
            document.getElementById("sample6_detailAddress").focus();
        }
    }).open();
  }

  
  function memberJoin(){
	  joinform.submit();
  }
  
  
  function pwCheck(){
	  var exp = /^(?=.*[a-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,15}$/;
  	  var pw = document.getElementById("mpw").value;
	  var pwCh = document.getElementById("pwCh");

	  if (pw.match(exp)){
		pwCh.innerHTML = "입력되었습니다.";
		pwCh.style.color = "green";
		pwCh.style.fontSize = "15px";
		
	  }else {
		pwCh.innerHTML = "형식이 틀렸습니다."
	    pwCh.style.color = "red";
		pwCh.style.fontSize = "15px";
	  }
  }
  
  function pwSame(){
	  var pw = document.getElementById("mpw").value;
	  var pwd = document.getElementById("pwd").value;
	  var pwSa = document.getElementById("pwSa");
	  
	  if(pw == pwd){
		  pwSa.style.color="green";
		  pwSa.style.fontSize="15px";
		  pwSa.innerHTML="비밀번호 일치";
	  }else{
		  pwSa.style.color="red";
		  pwSa.style.fontSize="15px";
		  pwSa.innerHTML="비밀번호 불일치";
	  }
  }
  
  function mailSel(url){
	  console.log(url);
	  document.getElementById("email").value = url;
  }
  
  function disappear_1(){
	  document.getElementById("pwCh").innerHTML = "";
  }
  
  function disappear_2(){
	  document.getElementById("pwSa").innerHTML = "";
  }
  
  function idCheck(){
	  location.href="memberidcheck";
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
  table{
    margin-left: auto;
    margin-right: auto;
    padding : 50px;
  }
  td{
    padding : 10px;
  }
  .joinTable{
    border : 5px rgb(255, 244, 97) solid;
    margin : 50px;
    background-color : rgb(245, 245, 245);
    background-image : url('Images/노란물감.jpg');
    background-repeat: no-repeat;
    background-position : center;
    background-size : 30cm;
  }
  .button{
    text-align : center;
    margin-top : -20px;
    margin-bottom : 50px;
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
  
  <div class = "joinTable">
    <form action = "memberjoin" method = "post" name = "joinform" enctype="multipart/form-data">
      <table>
         <tr>
           <td>아이디</td>
           <td>
             <input type = "text" name = "mid" id = "mid" style = "width : 450px;" placeholder = "아이디를 입력하세요">
             <button type = "button" id = "button" onclick = "idCheck()" >중복 확인</button>                                   
           </td>
         </tr>
         <tr>
           <td>비밀번호</td>
           <td>
             <input type = "password" name = "mpw" id = "mpw" style = "width : 450px;" placeholder = "비밀번호를 입력하세요"
                    onkeyup = "pwCheck()" onblur = "disappear_1()">
             <span id = "pwCh"></span>
           </td>
         </tr>
         <tr>
           <td>비밀번호 확인</td>
           <td>
             <input type = "password" id = "pwd" style = "width : 450px;" onkeyup="pwSame()" onblur="disappear_2()">
             <span id = "pwSa"></span>
           </td>
         </tr>
         <tr>
           <td>이름</td>
           <td><input type = "text" name = "mname" id = "mname" style = "width : 450px;" placeholder = "이름을 입력하세요"></td>
         </tr>
         <tr>
           <td>생년월일</td>
           <td><input type = "date" name = "mbirth" id = "mbirth" style = "width : 450px;"></td>
         </tr>
         <tr>
           <td>전화번호</td>
           <td><input type = "text" name = "mphone" id = "mphone" style = "width : 450px;" placeholder = "전화번호를 입력하세요"></td>
         </tr>
         <tr>
           <td>이메일</td>
           <td>
             <input type = "text" name = "memail" id = "memail" style = "width : 200px;">
             @ <input type = "text" id = "email" style = "width : 200px;">
             <select id = "Sel" onchange="mailSel(this.value)">
               <option value = "">직접입력</option>
               <option value = "naver.com">naver.com</option>
               <option value = "daum.net">daum.net</option>
               <option value = "gmail.com">gmail.com</option>
               <option value = "hanmail.com">hanmail.com</option>
             </select>
           </td>
         </tr>
         <tr>
           <td>주소</td>
           <td>
             <input type="text"  id="sample6_postcode" placeholder="우편번호">
             <input type="button" id = "button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
             <input type="text"  name = "maddress" id="sample6_address" placeholder="주소"><br>
             <input type="text"   id="sample6_detailAddress" placeholder="상세주소">
             <input type="text" id="sample6_extraAddress" placeholder="참고항목">
           </td>
         </tr>
         <tr>
           <td>프로필사진</td>
           <td><input type = "file" name = "mprofile" id = "mprofile"></td>
         </tr>
      </table>
    </form>
  </div>
  
  <div class = "button">  
    <button id = "button" style = "width : 100px; height : 40px;" onclick = "memberJoin()">회원 가입</button>
  </div>
  
  <div class = "footer">
    <span>이용약관|개인정보처리방침 |책임의 한계와 법적고지|고객센터</span><br>
    <span>© EUNBI BLOG Corp</span>
  </div>
</body>
</html>