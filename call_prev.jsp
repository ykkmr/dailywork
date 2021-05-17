<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info="다양한 방법으로 call.jsp를 호출하는 페이지"%>
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
window.onload=function(){
	document.getElementById("btnPost").addEventListener("click",sendPost);
}//onload

function sendPost() {
	var obj = document.frm;
	alert("javascript에서 POST전송");
	obj.submit();
}//sendPost

$(function() {
	$("#useJqueryPost").click(function() {
		alert("jQuery에서 POST전송");
		$("#postFrm").submit();
	});//click

	$("#href").click(function() {
		alert("location.href로 요청");
		window.location.href="call.jsp";
	});//click

	$("#replace").click(function() {
		alert("location.replace로 요청");
		window.location.replace("call.jsp");
	});//click


});//ready
</script>
</head>
<body>
<div>
<div class="alert alert-success" role="alert">
<strong>POST 방식으로 JSP 요청</strong>
	1.submit으로 요청<br/><!-- javascript에서 유효성 검증이 실패하더라도 alert창 뜨고 전송된다 -->
	<form action="call.jsp" method="post">
	 <input type="submit" value="전송" class="btn btn-default">
	</form>
	<br/>
	2. JavaScript에 submit()요청<br/>
	<form action="call.jsp" method="post" name="frm">
	 <input type="button" value="전송" id="btnPost" class="btn btn-default">
	</form>
	3. jQuery에서 submit()요청<br/>
	<form action="call.jsp" method="post" id="postFrm">
	 <input type="button" value="전송" id="useJqueryPost" class="btn btn-default">
	</form>
</div>

<div class="alert alert-danger" role="alert">
	<strong>GET방식으로 JSP요청</strong><br/>
	1. link 사용 <br/>
	<a href="call.jsp"> GET방식요청 </a><br/>
	2. location 객체 사용 <br/>
	<a href="#" id="href"> href </a><br/>
	<button class="btn btn-primary" id="replace" type="button">replace</button>
	3. &lt;form&gt; 태그를 사용한 submit 요청<br/>
	<form action="call.jsp" method="get">
	 <input type="submit" value="GET전송" class="btn btn-default">
	</form>
	
</div>
</div>
</body>
</html>