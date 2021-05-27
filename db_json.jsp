<%@page import="java.util.Date"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="kr.co.sist.vo.CarVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   String maker = request.getParameter("maker");
   
   UserDAO uDAO = new UserDAO();
   List<CarVO> list = uDAO.selectModel(maker);
   
   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
   //JSONObject 생성
   JSONObject jsonCar = new JSONObject();
   //값 추가
   jsonCar.put("pubDate",sdf.format(new Date() ));
   jsonCar.put("writer","4강의실");
   jsonCar.put("cnt", list.size());

   JSONArray jaModel = new JSONArray();
   JSONObject jsonTemp = null;
   
   CarVO cVO = null;
   for(int i=0; i<list.size(); i++){
      cVO=list.get(i);
      jsonTemp=new JSONObject();
     
      jsonTemp.put("model", cVO.getModel());
      jsonTemp.put("car_option", cVO.getCar_option());
      jsonTemp.put("car_year", cVO.getCar_year());
      jsonTemp.put("price", cVO.getPrice());
      jsonTemp.put("cc", cVO.getCc());
   
      //생성되어 DB에서 조회된 결과 값을 가진 JSONObject을 JSONArray에 추가한다.
      jaModel.add(jsonTemp);
     
   }//end for
   
   //n개의 JSONObject을 가진 JSONArry를 JSONObject 추가
   jsonCar.put("data",jaModel);
         
   out.print(jsonCar.toJSONString());
%>
