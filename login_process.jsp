<%@page import="kr.co.sist.vo.LoginDataVO"%>
<%@page import="kr.co.sist.dao.UserDAO"%>
<%@page import="kr.co.sist.vo.LoginVO"%>
<%@page import="kr.co.sist.util.cipher.DataEncrypt"%>
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
<% 
	//parameter 값 받기
	String id = request.getParameter("id");//<input type="text" name="id"
	String pass = request.getParameter("pass");//<input type="password" name="pass"
	//비밀번호가 암호화되어 저장되었기 때문에 로그인 할 때에도 비밀번호를 암호화하여 비교해야한다
	pass=DataEncrypt.messageDigest("MD5", pass);
	//분리된 아이디와 비밀번호를 손쉽게 관리하기 위해 VO에 설정
	LoginVO lVO = new LoginVO( id, pass );
	//DAO단의 클래스를 사용하여 DB작업 수행
	UserDAO uDAO = new UserDAO();
	
	LoginDataVO ldVO = uDAO.selectLogin(lVO); //DB 작업 수행
	
	if(ldVO == null ){
		%>
		아이디나 비밀번호를 확인해주세요<br/>
		<a href = "login_form.jsp">뒤로</a>
		<%
	}else{
		//다른 페이지에서 사용될 값을 세션에 저장 (반드시 로그인 후에 서비스를 이용해야할 페이지에서 로그인 여부를 체크할 수 있다)
		session.setMaxInactiveInterval(60);//요청이 끝난 다음에 다음 요청이 발생하기전까지의 시간
		session.setAttribute("id", id); //세션에 값을 설정
		session.setAttribute("userData", ldVO);
		
		/////////////////////// 쿠키에 아이디를 설정 ////////////////////////
		//1. 아이디 저장 체크박스 체크되었는지 얻기
		String idSaveFlag=request.getParameter("idFlag");
		if( idSaveFlag != null ){ //value속성이 없는 상태에서 check하면 "on"이 들어온다
			//2. 쿠키생성 (parameter로 받은 아이디를 save_id라는 이름으로 쿠키 저장)
			Cookie idCookie= new Cookie("save_id",id);
			//3. 쿠키 생존시간(파기시간)을 설정 (접속자가 브라우저를 저장하는 시간)
			idCookie.setMaxAge(60*60*1);
			//4. 쿠키 심기 (HttpServletResponse)
			response.addCookie(idCookie);
		}else{ //checkbox가 체크되지않은상태 (쿠키를 삭제해야하는 상태)
			//쿠키를 삭제
			//1. 삭제하려는 이름의 쿠키를 생성
			Cookie cookie= new Cookie("save_id","");
			//2. 생존시간을 0으로 설정
			cookie.setMaxAge(0);
			//3. 쿠키심기
			response.addCookie(cookie);
		}//end if
	 %>
	 <%= id %>,<%= ldVO.getName() %>(<a href="mailto:<%= ldVO.getEmail() %>">메일쓰기</a>)님 로그인 하셨습니다
	 <%
	}//end else
		
%>
<a href="use_info.jsp">작업페이지</a>
</div>
</body>
</html>