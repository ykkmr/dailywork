<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//사용자 로그인 한 이후의 아이디 데이터를 필요한 페이지에서 사용하기 위한 공통 JSP
	String userId = (String)session.getAttribute("id");
	if(userId == null){  
		response.sendRedirect("http://localhost/team_prj2/prj2/login/login.jsp");
		return;
	}
%>
<%-- <%
			//id를 사용할 jsp페이지에서 밑 코드를 선언하고 사용하시면 됩니다.
			//밑 코드 선언 후 로그인 없이 페이지 실행하면 무조건 null이기 떄문에 sendRedirect 되어짐
			//페이지가 달라져도 한번 세션에 저장된 값은 얻을 수 있습니다.
			
			String userId = (String)session.getAttribute("id");
			if(userId == null){
				response.sendRedirect("http://localhost/team_prj2/prj2/login/login.jsp");
				return;
			}
%> --%>
