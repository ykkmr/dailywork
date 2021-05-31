<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="false"%>
<%
UserDAO uDAO=new UserDAO();

JSONArray ja=new JSONArray();
try{
	List<String> listMaker=uDAO.selectMaker();
	
	JSONObject json=null;
	for(String maker : listMaker ){
		json=new JSONObject();// { }
		json.put("maker", maker);// { "maker":"현대" }
		ja.add(json);//[{ "maker":"현대" },{ "maker":"기아" }]
	}//end for
}catch(SQLException se){
	JSONObject json=new JSONObject();
	json.put("maker", "문제발생");
	se.printStackTrace();
}//end catch

 out.print( ja.toJSONString() );
%>