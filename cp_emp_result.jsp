<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <title></title>
 <!-- bootstrap -->
 <link href="http://localhost/spring_mybatis/common/bootstrap-3.3.2/css/bootstrap.min.css" rel="stylesheet">

 <!-- jQuery CDN(Contents Delivery Network) -->
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
 <script src="http://localhost/spring_mybatis/common/bootstrap-3.3.2/js/bootstrap.min.js"></script>
<style type="text/css">

</style>
<script type="text/javascript">

<c:choose>
	<c:when test="${ cnt eq 1 }">
		alert("${ param.empno }번 사원정보를 삭제하였습니다");
	</c:when>
	<c:otherwise>
	alert("${ param.empno }번 사원정보를 삭제 못하였습니다");
	</c:otherwise>
</c:choose>
	location.href="http://localhost/spring_mybatis/index.html";
	
</script>
</head>
<body>
<div>

</div>
</body>
</html>