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
$(function() {
	$("#btn").click(function() {
		var name = $("#name").val();
		if(name==""){
			alert("이름을 입력해 주세요");
			$("#name").focus();
			return;
		}//end if

		var age = $("#age").val();
		if(age==""){
			alert("나이를 입력해 주세요");
			return;
		}//end if
	
		var upfile = $("#upfile").val();
		if(upfile==""){
			alert("업로드할 파일을 선택해 주세요");
			return;
		}//end if
		
		//서버에서 실행가능한 파일은 업로드하지 못하게 막는다
		//선택한 파일의 확장자가 이미지 (jpg,gif,png,bmp)인 경우에만 submit 되도록
		//확장자 유효성 검증
		var blockExt=["jpg","gif","png","bmp"];
		var ext=upfile.substring(upfile.lastIndexOf(".")+1);
		var blockFlag=false;
		for(var i= 0 ; i < blockExt.length ; i ++){
			if( ext.toLowerCase() == blockExt[i]){
				blockFlag=true;
				break;
			}//end if
		}//end for
		
		if( !blockFlag ){
			alert("업로드 가능한 파일이 아닙니다");
			return;
		}//end if
		
		$("#frm").submit();//서버로 전송한다
	});//click
});//ready
</script>
</head>
<body>
<div>
<form action="upload_process.jsp" id="frm" enctype="multipart/form-data" method="post">
<label>업로더명</label>
<input type="text" name="name" id="name"/><br/>
<label>나이</label>
<select name="age" id="age">
<option value="none">---나이---</option>
<% for(int i = 10 ; i < 71 ; i += 10 ){ %>
<option value="<%= i %>"><%= i %></option>
<%} //end for %>
</select>
<br/>
<label>업로드파일</label>
<input type="file" name="upfile" id="upfile"/><br/>
<input type="button" value="전송" id="btn"/>
</form>
</div>
</body>
</html>