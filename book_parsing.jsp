<%@page import="java.util.List"%>
<%@page import="org.jdom2.Element"%>
<%@page import="java.net.URL"%>
<%@page import="org.jdom2.Document"%>
<%@page import="org.jdom2.input.SAXBuilder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info="xml을 parsing하여 보여주는 JSP"%>
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
<table class= "table table-hover">
<thead>
<tr>
<th style = "width:400px;text-align : center">제목</th>
<th style = "width:120px;text-align : center">저자</th>
<th style = "width:100px;text-align : center">출판사</th>
<th style = "width:80px;text-align : center">가격</th>
<th style = "width:150px;text-align : center">ISBN</th>
</tr>
</thead>
<tbody>
<%
	//1. XML에 접근할 수 있는 객체 생성 (Parser를 생성)
	SAXBuilder sb = new SAXBuilder();
	//2. XML에 접근하여 문서를 객체에 저장한다
	Document doc = sb.build(new URL("http://localhost/jsp_prj/xml0601/book.xml"));
	//3. 최상위 부모노드 얻기 : < books >
	Element rootNode = doc.getRootElement();
	//4. 자식노드들 얻기 <book>노드 여려개 나온다
	List<Element> bookNodes=rootNode.getChildren();
	//5. book 노드 들을 반복시키고
	List<Element> someNodes=null;
	boolean strongFlag = false;
	for( Element BookNode : bookNodes ){
		out.println("<tr>");
		//6. book 노드의 자식 노드들 얻기
		someNodes = BookNode.getChildren();
		for( Element someNode : someNodes ){
			//저자는 진하게 보여주기
			strongFlag = "auth".equals(someNode.getName());
			%>
			<td><%= strongFlag?"<strong>":""%><%= someNode.getText() %><%= strongFlag?"<strong>":""%></td>
			<%
		}//end for
		out.println("</tr>");
	}//end for
%>
</tbody>

</table>
</div>
</body>
</html>