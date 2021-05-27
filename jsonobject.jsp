<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//1. 생성
JSONObject json = new JSONObject();
//2. 값 할당
json.put("name", "박기범");
json.put("age", 20);
json.put("addr", "서울시 강남구 역삼동");
out.println( json.toJSONString() );
%>