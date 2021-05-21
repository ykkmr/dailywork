<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<%
	// <a> 태그에 존재하는 parameter 받기
	String name=request.getParameter("name");
	String age=request.getParameter("age");
	String addr=request.getParameter("addr");
	// 입력받은 한글이 깨지면 URLDecoder로 처리한다 
	// (Apache Tomcat이 7.0이상에서 부터는 get방식의 한글처리가 된다) -URLEndoce나 URLDecode가 여러번 되면 한글이 깨진다
%>
parameter 값 : <br/>
이름 : <strong><%= name %></strong><br/>
나이 : <strong><%= age %></strong><br/>
주소 : <strong><%= addr %></strong><br/>
변환 <%= URLDecoder.decode(name, "UTF-8") %>
</div>
</body>
</html>