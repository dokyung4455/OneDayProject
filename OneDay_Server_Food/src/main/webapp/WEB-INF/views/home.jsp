<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="C"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>다이어트 도우미</h1>
	<h3>1. 섭취정보 <a href="/food/search">등록하기</a></h3>
	<form action="daylist">
	<h3>2. 날짜로 섭취목록 조회하기</h3>
	<p>
	년 <input name="year"/> 월 <input name="month"/> 일 <input name="day"/>
	<button>조회</button>
	</p>
	</form>
	<h3>3. 전체 섭취리스트</h3>
	
	<table>
	<tr>
			<th>날짜</th>
			<th>식품명</th>
			<th>섭취량</th>
			<th>총 내용량(g)</th>
			<th>에너지(kcal)</th>
			<th>단백질(g)</th>
			<th>지방(g)</th>
			<th>탄수화물(g)</th>
			<th>총 당류(g)</th>
		</tr>
	<C:forEach items="${FOOD}" var="FOOD">
		<tr><td>${FOOD.date}</td>
		<td>${FOOD.fname}</td>
		<td>${FOOD.qty}</td>
		<td>${FOOD.gram}</td>
		<td>${FOOD.kcal}</td>
		<td>${FOOD.prot}</td>
		<td>${FOOD.fat}</td>
		<td>${FOOD.carbo}</td>
		<td>${FOOD.sacc}</td></tr>
		</C:forEach>
	</table>

</body>
</html>