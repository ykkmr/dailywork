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
<% //POST방식일 때 한글 처리 ( request객체가 사용되기 전 )
	request.setCharacterEncoding("UTF-8");
%>
요청방식 : <%= request.getMethod() %><br/>
<%
	//name속성에 이름이 유일한 경우 getParameter
	String name=request.getParameter("name");
	//name속성에 이름이 중복되는 경우 getParameterValues
	String[] movie=request.getParameterValues("movie");
%>
	이름 : <strong><%= name %></strong><br/>
	선택영화 : 
		<ul>
	<%
	if( movie != null ){
	//try{
	for(int i = 0 ; i < movie.length ; i ++){ %>
	<li><%= movie[i] %></li>
	<% }//end for 
	}else{
	//}catch(NullPointerException npe){
	%>
	<li> 선택한 영화가 없습니다</li>
	<%
	//}//end catch
	}//end else
	%>
		</ul>
	<img src="../common/images/포챠코1.jpg"/>
</div>
</body>
</html>