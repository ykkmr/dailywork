<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info="요청을 받아 데이터를 처리하는 페이지"%>
<%-- 사용자에게 응답이 되지 않기 때문에 디자인을 만들 필요가 없다 --%>
<%-- <jsp:forward page ="forward_b.jsp"/> --%>
<%
	request.setCharacterEncoding("UTF-8");
	String addr="서울시 강남구 역삼동";
	String[] names= {"강인섭","곽범수","박기범","이상철","한상민"};
	request.setAttribute("names", names ); //파라메터방식이 아닌 방식으로 데이터를 전달
	//모든 데이터형을 view페이지로 전달할 수 있다.
%>
	<%-- jsp:forward안에서 html주석, JSP주석을 열면 에러 
		파라메터를 생성하고 한글을 넣을 때에는 post방식의 한글처리를 해야 한글이 깨지지 않는다.
	--%>
<jsp:forward page ="forward_b.jsp">
	<jsp:param name="age" value="25"/>
	<jsp:param name="addr" value="<%=addr %>"/>
</jsp:forward>