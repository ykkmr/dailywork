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
	String msg="오늘은 금요일 입니다";
	out.println(msg);
	
	for(int i=1; i <101 ; i++){
		out.println(i);
	}//end for
	%>
	<div>
	<%
	String[] url={"daum.net","naver.com","nate.com"};
	String[] urlTitle={"다음","네이버","네이트"};
			
	for(int i=0; i< url.length ; i++){
		out.println("<a href='http://");
		out.println(url[i]);
		out.println("'>");
		out.println(urlTitle[i]);
		out.println("</a>");
	}//end for
		%>
		</div>
		<div>
		<% for(int i =0; i < url.length ; i ++){ %>
		<a href="http://<%= url[i] %>"><%= urlTitle[i] %></a>
		<%}//end for %>
		</div>
</body>
</html>