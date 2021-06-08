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
<c:choose>
	<c:when test="${ addMemberFlag }">
	회원가입 성공
	<c:out value="${ param.member_id }"/>로 가입되었습니다<br/>
	회원가입 ㄳ
	비회원과는 차별할거각ㅌ음?
	</c:when>
	<c:otherwise>
	<c:out value="${ param.member_name }"/>님  회원가입이 정상적으로 이뤄지지 않았습니다<br/>
	ㅈㅅ다시시도좀
	</c:otherwise>
</c:choose>
</div>
</body>
</html>