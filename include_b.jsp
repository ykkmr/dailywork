<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info=""%>
<!-- 공통코드가 정의도는 JSP에서는 사용되는 JSP에서 디자인에 영향을 주지 않도록
(소스보기했을 때 하나의 HTML처럼 보이도록) 중복디자인에대한 부분을 신경써서 만든다 -->
 
 <!-- bootstrap -->
 <link href="http://localhost/jsp_prj/common/bootstrap-3.3.2/css/bootstrap.min.css" rel="stylesheet">

 <!-- jQuery CDN(Contents Delivery Network) -->
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
 <!-- bootstrap -->
 <script src="http://localhost/jsp_prj/common/bootstrap-3.3.2/js/bootstrap.min.js"></script>
<%
//변수, method가 공유되므로 끼워지는 모든 페이지에서 사용될 공통 값(코드)를 정의
String name="공통값";
%>
<%!
public String method(){
	return "공통으로 사용될 코드";
}
%>
<%-- 공통로직을 가진 페이지에선 외부 JSP에 존재하는 변수를 사용할 수 있으나
모든 페이지에 해당 변수가 존재하는 것이 아니기 때문에 사용하지 않는게 좋다
<%=test%> --%>