<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info="액션태그를 사용한 객체 생성"%>
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
 <script src="http://localhost/jsp_prj/common/bootstrap-3.3.2/js/bootstrap.min.js"></script>
<style type="text/css">

</style>
<script type="text/javascript">

</script>
</head>
<body>
<div>
<!-- new를 사용한 instance화 없이 객체를 생성할 수 있다 -->
<jsp:useBean id = "lVO" class ="kr.co.sist.vo.LoginVO" scope="page"/>
<!--  setter method 호출 -->
<jsp:setProperty property="id" name="lVO" value="kang"/>
<jsp:setProperty property="pass" name="lVO" value="kang"/>

<!-- getter method 호출 : 리턴되는 값이 브라우저로 출력된다 -->
아이디 : <jsp:getProperty property="id" name="lVO"/><br/>
비밀번호 : <jsp:getProperty property="pass" name="lVO"/>
<%
	//useBean의 id속성은 객체명이므로 자바코드에서 객체로 사용할 수 있다
	lVO.setId("kim");
	lVO.setPass("2222");
%>
<div>
<strong>객체명 사용</strong>
아이디 : <%= lVO.getId() %><br/>
비밀번호 : <%= lVO.getPass() %><br/>
</div>
</div>
</body>
</html>