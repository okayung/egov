<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>학교명</th>
			<th>이름</th>
			<th>학년</th>
			<th>주소</th>
			<th>연락처</th>
		</tr>
		<c:forEach var="student" items="${list }">
			<tr>
				<td>${student.student_school }</td>
				<td>${student.student_name }</td>
				<td>${student.student_grade }</td>
				<td>${student.student_addr }</td>
				<td>${student.student_phone }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>