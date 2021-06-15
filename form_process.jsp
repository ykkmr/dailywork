<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <title></title>
 <!-- bootstrap -->
 <link href="http://localhost/spring_mvc/common/bootstrap-3.3.2/css/bootstrap.min.css" rel="stylesheet">

 <!-- jQuery CDN(Contents Delivery Network) -->
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
 <script src="http://localhost/spring_mvc/common/bootstrap-3.3.2/js/bootstrap.min.js"></script>
<style type="text/css">

</style>
<script type="text/javascript">

</script>
</head>
<body>
<div>
<form action="http://localhost/spring-mvc/day0615/post_req.do" method="post">
<label>닉네임</label> <c:out value="${ param.name }"/><br/>
<label>나이</label> <c:out value="${ param.age }"/><br/>
<label>영화</label>
<c:if test="${ parameterValues.movie }">
선탯하신 영화가 없습니다
</c:if>
<c:forEach var="movie" items="${ paramValues.movie }">
<c:out value="${ movie }"/>
</c:forEach>
<br/>
<input type="submit" value="전송"/>
</form>
</div>
</body>
</html>