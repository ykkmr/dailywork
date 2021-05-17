<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title></title>
</head>
<body>
<% 
	String name = "이학민"; //scriptlet안에서 선언된 변수는 지역변수
	int age;
	age =27;
	Calendar cal = Calendar.getInstance();
	%>
안녕하세요?<strong><%= name %></strong> 입니다.<br/>
나이는 <strong><%= age %></strong>살 입니다.
올해는 <strong><%= cal.get( Calendar.YEAR ) %></strong>년 입니다.
</body>
</html>