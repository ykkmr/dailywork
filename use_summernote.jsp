<%@page import="java.sql.SQLException"%>
<%@page import="kr.co.sist.vo.InterestVO"%>
<%@page import="kr.co.sist.dao.SummerNoteDAO"%>
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
request.setCharacterEncoding("UTF-8");
String name=request.getParameter("name");
String interest=request.getParameter("interest");

InterestVO iVO = new InterestVO(name, interest);
//DB 사용
SummerNoteDAO snDAO = new SummerNoteDAO();
try{
	snDAO.insertFile(iVO);
	%>
	작성된 글이 저장되었습니다.
	<% 
}catch(SQLException se){
	se.printStackTrace();
	%>
	죄송합니다. 글 저장에 문제가 발생하였습니다<br/>
	잠시 후 다시 시도해 주세요.
	
	<%
}//end catch

%>
<%=name %><br/>
<%=interest %>
</div>
</body>
</html>