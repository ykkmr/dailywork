<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <title></title>
 <!-- bootstrap -->
 <link href="http://localhost/jsp_prj/common/bootstrap-3.3.2/css/bootstrap.min.css" rel="stylesheet">

 <!-- jQuery CDN(Contents Delivery Network) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
 <!-- bootstrap -->
<script src="http://localhost/jsp_prj/common/bootstrap-3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">

</style>
<script type="text/javascript">
$(function() {
	//btnGet 버튼이 클릭되면 <form>에서 submit되도록 코딩 
	$("#btnGet").click(function() {
		$("#getFrm").submit();
	});//get
	//btnPost 버튼이 클릭되면 <form>에서 submit되도록 코딩 
	$("#btnPost").click(function() {
		$("#postFrm").submit();
	});//post
});//ready
</script>
</head>
<body>
<div style="width: 960px">
 <div class="alert alert-success" style="width: 450px;float: left">
 	<form action="parameter_process.jsp" name="getFrm" id="getFrm">
 	<label style="font-weight: bold;">GET방식의 Parameter처리</label><br/>
 	<label>이름</label>
 	<input type="text" name="name"  maxlength="15"/><br/>
	<label>나이</label>
	<input type="password" name="age" maxlength="15"/><br/>
	<label>메일수신여부</label>
	<input type="checkbox" name="mail"/><br/>
	<label>성별</label>
	<input type="radio" name="gender" value="M" checked="checked"/>남자<br/>
	<input type="radio" name="gender" value="F"/>여자<br/>
	<label>hidden</label>
	<input type="hidden" name="addr" value="서울시 강남구 역삼동" /><br/>
	<label>select</label>
	<select name="domain">
		<option value = "daum.net">다음</option>
		<option value = "naver.com">네이버</option>
		<option value = "google.com">구글</option>
	</select><br/>
	<textarea style="width: 400px;height: 100px" name="info"></textarea>
	<input type="button" value="전송" id="btnGet"/><br/>
 	</form>
 </div>

<div class="alert alert-warning" style="width: 450px;float: right">
 	<form action="parameter_process.jsp" name="postFrm" id="postFrm">
 	<label style="font-weight: bold;">POST방식의 Parameter처리</label><br/>
 	<label>이름</label>
 	<input type="text" name="name"  maxlength="15"/><br/>
	<label>나이</label>
	<input type="password" name="age" maxlength="15"/><br/>
	<label>메일수신여부</label>
	<input type="checkbox" name="mail"/><br/>
	<label>성별</label>
	<input type="radio" name="gender" value="M" checked="checked"/>남자<br/>
	<input type="radio" name="gender" value="F"/>여자<br/>
	<label>hidden</label>
	<input type="hidden" name="addr" value="서울시 강남구 역삼동" /><br/>
	<label>select</label>
	<select name="domain">
		<option value = "daum.net">다음</option>
		<option value = "naver.com">네이버</option>
		<option value = "google.com">구글</option>
	</select><br/>
	<textarea style="width: 400px;height: 100px" name="info"></textarea>
	<input type="button" value="전송" id="btnPost"/><br/>
 	</form>
 </div>
 요청 객체 : <%= request %><br/>
 응답 객체 : <%= response %><br/>
</div>
</body>
</html>
    