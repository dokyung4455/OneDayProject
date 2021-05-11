<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>식품코드</th>
			<td></td>
			<th>식품명</th>
			<td></td>
			<th>출시연도</th>
			<td></td>
			<th>제조사명</th>
			<td></td>
			<th>분류코드</th>
			<td></td>
			<th>분류명</th>
			<td></td>
			<th>1회 제공량(g)</th>
			<td></td>
			<th>총 내용량(g)</th>
			<td></td>
			<th>에너지(kcal)</th>
			<td></td>
			<th>단백질(g)</th>
			<td></td>
			<th>지방(g)</th>
			<td></td>
			<th>탄수화물(g)</th>
			<td></td>
			<th>총 당류(g)</th>
			<td></td>
		</tr>
		<C:forEach items="${FOOD}" var="FOOD">
			<tr>
				<th></th>
				<td><FORM>
				${FOOD.fd_code}
				</FORM></td>
				<th></th>

				<td><fORM action="page2" >
						<a href="page2?id=${FOOD.fd_name}">${FOOD.fd_name}</a>
					</fORM></td>

				<td>${FOOD.fd_date}</td>
				<th></th>
				<td>${FOOD.cp_name}</td>
				<th></th>
				<td>${FOOD.it_code}</td>
				<th></th>
				<td>${FOOD.it_name}</td>
				<th></th>
				<td>${FOOD.fd_one}</td>
				<th></th>
				<td>${FOOD.fd_gram}</td>
				<th></th>
				<td>${FOOD.fd_kcal}</td>
				<th></th>
				<td>${FOOD.fd_prot}</td>
				<th></th>
				<td>${FOOD.fd_fat}</td>
				<th></th>
				<td>${FOOD.carbo}</td>
				<th></th>
				<td>${FOOD.sacc}</td>
			</tr>
		</C:forEach>

	</table>



</body>
</html>