<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<div>

<form action="http://localhost/spring_mybatis/select/select_menu.do">
<input type="hidden" name="page" value="procedure_insert"/>
<strong>매니저 번호 입력</strong><br/>
<label>사원번호</label><input type="text" name="empno" /><br/>
<label>사원명</label><input type="text" name="ename" /><br/>
<label>부서번호</label><input type="text" name="deptno" /><br/>
<label>직무</label><input type="text" name="job" /><br/>
<input type="submit" value="입력"><br/>
</form>
<c:if test="${ cnt eq 1 }">
사원정보가 <c:out value="${ cnt }"/>건 추가되었습니다
</c:if>
</div>
