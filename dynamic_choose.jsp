<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<div>

<form action="http://localhost/spring_mybatis/select/select_menu.do">
<input type="hidden" name="page" value="dynamic_choose"/>
<strong>부서번호 선택</strong><br/>
<c:forEach var="i" begin="1" end="10" step="1">
<input type="radio" name="deptno" value="${ i }"/><c:out value="${ i }"/>
</c:forEach>
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
