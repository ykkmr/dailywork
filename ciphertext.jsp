<%@page import="kr.co.sist.util.cipher.DataDecrypt"%>
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
	String password="1234";
	//gdyb21LQTcIANtvYMT7QVQ==
	String email="test@test.com";
	//암호화키는 16자 이상으로 처리
	DataEncrypt de= new DataEncrypt("gdyb21LQTcIANtvYMT7QVQ==");
	String cipherText=de.encryption(email);
	
	DataDecrypt dd= new DataDecrypt("gdyb21LQTcIANtvYMT7QVQ==");
	String plainText ="";
	try{
	dd.decryption(cipherText); //암호문으로 변경된 문자열을 동일키를 넣어
	//평문으로 변경한다
	}catch(javax.crypto.BadPaddingException bpe){
		bpe.printStackTrace();
	}
%>
SHA로 변환 : <%=DataEncrypt.messageDigest("MD5", password) %><br/>
cipherText : <%= cipherText %>
plainText : <%= plainText %>
</div>
</body>
</html>