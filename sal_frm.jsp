<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
<form action="http://localhost/spring_mybatis/select/select_menu.do">
<input type="hidden" name="page" value="dynamicTable">본사
<strong>사원 정보 조회</strong><br/>
<input type="radio" name="loc" value="emp" ${ param.loc eq 'emp'?"checked='checked'":"" }>본사
<input type="radio" name="loc" value="cp_emp1"${ param.loc eq 'cp_emp1'?"checked='checked'":"" }>중국지사
<input type="radio" name="loc" value="cp_table2"${ param.loc eq 'cp_table2'?"checked='checked'":"" }>미국지사
<input type="submit" value="조회"/><br/>
</form>
<table class="table">
<thead>
<tr>
	<th>사원번호</th><th>사원명</th><th>연봉</th><th>입사일</th>
</tr>
</thead>
<tbody>
<c:forEach var="emp" items="${ empList }">
<tr>
<td><c:out value="${ emp.empno }"/></td>
<td><c:out value="${ emp.ename }"/></td>
<td><c:out value="${ emp.sal }"/></td>
<td><c:out value="${ emp.hiredate }"/></td>
</tr>
</c:forEach>
</tbody>
</table>
</div>