<%@page import="javax.naming.Context"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
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
//<Context>에 DBCP가 설정된 후 사용
//1. JNDI사용 객체 생성
Context ctx = new InitialContext(); 
//2. 이름(name="jdbc/dbcp")을 사용하여 실행 중인 자바 환경에서 객체를 찾는다
DataSource ds=(DataSource)ctx.lookup("java:/comp/env/jdbc/dbcp");
//3. DBCP에서 꺼내온 객체로부터 Connection 얻기
Connection con=ds.getConnection();
%>
<%= con %>
<%
	if( con != null ){ con.close(); }//end if
%>
</div>
</body>
</html>