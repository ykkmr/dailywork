<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//업무처리 후 데이터 생성
List<String>list=new ArrayList<String>();
list.add("ㅋㅋㅋㅋㅋ");
list.add("ㅎㅎㅎㅎㅎ");
list.add("wwwww");

Calendar cal= Calendar.getInstance();


//발생한 값을 view로 전달하기 위해 request객체에 속성 값으로 설정한다
request.setAttribute("data", list);
request.setAttribute("cal", cal);
request.setAttribute("name", "르르");

//1. 이동할 페이지를 설정
RequestDispatcher rd= request.getRequestDispatcher("forward_b.jsp");
//2. 이동()
rd.forward(request, response);
%>