<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<div>

<form action="http://localhost/spring_mybatis/select/select_menu.do">
<input type="hidden" name="page" value="procedure_select"/>
<strong>우편번호 검색</strong><br/>
<label>동이름</label><input type="text" name="dong" /><br/>
<input type="submit" value="검색"><br/>
</form>
<c:out value="${ param.dong }"/> 검색 결과 <br/>
<table class="table">
<thead>
<tr>
	<th style="width: 80px">우편번호</th>
	<th style="width: 400px">주소</th>
</tr>
</thead>
</table>
<c:if test="${ not empty param.dong }">
<c:if test="${ empty zipcodeList }">
<tr>
	<td colspan="2">동은 존재하지 않습니다</td>
</tr>
</c:if>
<c:forEach var = "data" items="${ zipcodeList }">
<tr>
<td><c:out value="${ data.zipcode }"/></td>
<td>
	<c:out value="${ data.sido } ${ data.gugun } ${ data.dong } ${ data.bunji }"/>
</td>
</tr>
</c:forEach>
</c:if>
</div>
