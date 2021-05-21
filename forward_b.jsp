<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// forward_a.jsp에서 처리된 결과를 받아 출력화면을 만든다
List<String> list=(List<String>)request.getAttribute("data");
Calendar cal=(Calendar)request.getAttribute("cal");
String name=(String)request.getAttribute("name");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <title><%=name %>님 안녕하세요?</title>
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
<select>
<option>---선택---</option>
<% for(int i = 0; i < list.size(); i++){ %>
<option value="<%=list.get(i) %>"><%=list.get(i) %></option>
<%}//end for %>
</select>
<br/>
<!-- cal객체를 사용하여 select에  -->
<% int nowYear=cal.get(Calendar.YEAR); %>
<select>
<% for(int i = -2; i < 3; i++){ %>
<option value="<%=nowYear+i %>"<%=nowYear==nowYear+i?" selected='selected'":"%>><%= request
<%}//end for %>
</select>
<br/>


</div>
</body>
</html>