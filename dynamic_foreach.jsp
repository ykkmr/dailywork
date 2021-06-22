<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<div>

<form action="http://localhost/spring_mybatis/select/select_menu.do">
<input type="hidden" name="page" value="dynamic_foreach"/>
<strong>부서번호 선택</strong><br/>
<c:forEach var="i" begin="10" end="40" step="10">
<input type="checkbox" name="deptno" value="${ i }"/><c:out value="${ i }"/>
</c:forEach>
<%
String[] param=request.getParameterValues("deptno");
String temp="";
for(int i = 10, cnt=0 ; i <41 ; i += 10, cnt++ ){
	
	if(param != null){
		for(int j = 0 ; j < param.length ; j ++){
			if(param[j].equals(String.valueOf(i))){
				temp=" checked='checked'";
				break;
			}//end if
		}//end for
	}//end if
%>
<input type ="checkbox" name="deptno" value="<%= i %>"<%= temp %>/><c:out value="<%= %>"/>
<%
temp="";
}//end for
%>
<input type="submit" value="조회"><br/>
</form>

<div>
<table class="table table-hover">
<thead>
<tr>
	<th>사원번호</th><th>사원명</th><th>연봉</th><th>입사일</th>
</tr>
</thead>
<tbody>
<c:if test="${ empty empList }">
<tr>
	<td colspan="4">사원 정보가 존재하지 않습니다</td>
</tr>
</c:if>
<c:forEach var="emp" items="${empList}">
<tr>
	<td><c:out value="${emp.empno }"></c:out></td>
	<td><c:out value="${emp.ename }"></c:out></td>
	<td><c:out value="${emp.sal }"></c:out></td>
	<td><c:out value="${emp.hiredate }"></c:out></td>
</tr>
</c:forEach>
</tbody>
</table>
</div>

</div>
