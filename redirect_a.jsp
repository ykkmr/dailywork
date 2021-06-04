<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
   	boolean flag= new Random().nextBoolean();
   request.setAttribute("flag", flag);
   %>
   <c:if test="${ flag }"><!-- 로그인 후에만 존재하는 세션이 있는가? -->
   <!--  없다면 인증페이지로 이동 -->
   		<c:redirect url="redirect_b.jsp"/>
   		</c:if>
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

</div>
</body>
</html>