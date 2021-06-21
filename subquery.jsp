<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
전체 게시물의 수 : <c:out value = "${ totalCnt }"/>건<br/>
한 화면에 보여줄 게시물의 수 : <c:out value = "${ pageScale }"/>건<br/>
총 페이지 수 : <c:out value = "${ totalPage }"/>장<br/>
시작 번호 : <c:out value = "${ startNum }"/><br/>
끝 번호 : <c:out value = "${ endNum }"/><br/>

<div>
<table class="table">
<thead>
<tr>
	<th style="width: 50px">번호</th>
	<th style="width: 120px">모델명</th>
	<th style="width: 400px">옵션</th>
	<th style="width: 100px">연식</th>
	<th style="width: 150px">입력일</th>
</tr>
</thead>
<tbody>
<c:if test="${ empty boardList }">
<tr>
	<td colspan="5" align="center">
	조회된 차량 정보가 존재하지 않습니다
	</td>
</tr>
</c:if>
<c:forEach var="bd" items="${ boardList }">
<c:set var="j" value="${ j+1 }"/>
<c:set var="i" value="${ totalCnt-( param.currentPage-1)*pageScale-j }"/>
<tr>
<td><c:out value="${ i }"/></td>
<td><c:out value="${ bd.model }"/></td>
<td><c:out value="${ bd.car_option }"/></td>
<td><c:out value="${ bd.car_year }"/></td>
<td><c:out value="${ bd.hiredate }"/></td>
</tr>
</c:forEach>
</tbody>
</table>
</div>

<div>
	<c:forEach var="pageNum" begin="1" end ="${ totalPage }" step="1">
	[<a href="http://localhost/spring_mybatis/select/select_menu.do?page=subquery&currentPage=${ pageNum }"><c:out value="${ pageNum }"/></a>]
	</c:forEach>
</div>
</div>