<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String paramFlag=request.getParameter("flag");
    	boolean flag=false;
    	if( paramFlag != null){ //QuertString이나 HTTP header에 parameter명이 존재하지 않으면 null이 입력된다
    		flag=Boolean.valueOf(paramFlag);
    	}//end if   
    	
    	if( !flag ){ //비정상적인 요청을 한 상황. 다른 페이지로 이동을 해야할 상황
    		response.sendRedirect("redirect_c.jsp"); //URL을 넣어 페이지를 이동
    		return;
    	}//end if
    	
    %>
    
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
<img src="../common/images/포챠코1.jpg"/>
<div class="alert alert-success" role="alert" style="width: 400px; height: 140px">
정상적인 요청이 있을 때 사용자에게 제공할 내용
</div>
</div>
<%
//Servlet과 JSP에서 콘솔에 출력할 때에는 Sysrem.out.println()을 사용해도 되지만
//GenericServlet에서 제공하는 log()를 사욯랄 수 있다
log("----------------------콘솔로 출력된다");
%>
</body>
</html>