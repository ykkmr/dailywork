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
<% //POST방식의 한글 처리: (GET방식에서는 동작하지 않는다)
	//request객체가 사용되기 전에 encoding하여 변환한 문자열을 받는다.
	request.setCharacterEncoding("UTF-8");
	%>
<strong><%= request.getMethod() %></strong>방식의 요청
<div>
<%
	//name속성의 이름이 유일한 HTML Form Control의 값 받기
	String name=request.getParameter("name");//<input type="text" name="name"/>
	String age=request.getParameter("age");//<input type="password" name="age"/>
	//checkbox가 하나면 getParameter로 받는다
	//value속성이 없고 체크된 상태면 "on"이 입력되고, 체크된 상태가 아니면 null 입력된다
	String mail=request.getParameter("mail");//<input type="password" name="mail"/>
	//radio는 여러개가 존재하더라도 하나만 선택가능하기 때문에 배열로 들어오지 않는다
	String gender=request.getParameter("gender");//<input type="radio" name="mail"/>
	String addr=request.getParameter("addr");//<input type="hidden" name="addr" value=""/>
	String domain=request.getParameter("domain");//<select name="domain"/>
	//select은 선택한 <option>의 값 하나만 들어온다
	String info=request.getParameter("info");//<textarea>
%>
<label>이름</label>: <strong><%= name %></strong><br/>
<label>나이</label>: <strong><%= age %></strong><br/>
<label>메일</label>: <strong><%= mail %></strong><br/>
<label>성별</label>: <strong><%= gender %></strong><br/>
<label>주소</label>: <strong><%= addr %></strong><br/>
<label>도메인</label>: <strong><%= domain %></strong><br/>
<label>정보</label>: <strong><%= info.replaceAll("\n", "<br/>")  %></strong><br/>
<br>
<input type="text" value="<%= name %>"/>
</br>
<label>성별</label>
	<input type="radio" name="gender" value="M"<%= "M".equals(gender)?"checked='checked'":"" %>/>남자
	<input type="radio" name="gender" value="F"<%= "F".equals(gender)?"checked='checked'":"" %>/>여자<br/>
<br/>
	<label>select</label>
	<%
	String[] optValue={"daum.net","naver.com","google.com","nate.com","hotmail.com"};
	String[] optView={"다음","네이버","구글"};
	%>
		<select name="domain">
		<% for( int i = 0 ; i < optValue.length ; i ++){ %>
		<option value="<%= optValue[i] %>"<%= domain.equals(optValue[i])?"selected='selected'":"" %>><%= optView[i] %></option>
		<% }//end for %>
	</select><br/>
<textarea style="width: 400px; height: 100px" ><%=info %></textarea>
<br/>		
<a href="#" onclick="history.back();">뒤로</a>
</div>

</div>
</body>
</html>