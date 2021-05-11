<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>드신 식품을 솔직하게 기입하세요.</title>
</head>
<body>

	<form method="POST" action="">
		<h3>식품섭취량 등록</h3>
		<table>
			<tr>
				<th>섭취한 음식 : </th>
				<td><input name="FOOD" Value="${FOOD}"/> 코드 : <input name="CODE" value="${CODE}"/></td>
			</tr>
			<tr>
				<th>섭취한 날짜 : </th>
				<td><input name="date"></td>
			</tr>

			<tr>
				<th>섭취량 : </th>
				<td><input name="qty"></td>
			</tr>
		

			<tr>
				<th></th>
				<td><button>저장</button></td>
			</tr>
		</table>
	</form>
</body>
</html>