<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학교상세정보</title>
</head>
<body>
	<table>
		<tr>
			<th style="border: 1px solid #444444;">학교명</th>
			<th style="border: 1px solid #444444;">지역구</th>
			<th style="border: 1px solid #444444;">주소</th>
			<th style="border: 1px solid #444444;">연락처</th>
		</tr>
		<c:forEach var="school" items="${schoolList }">
			<tr>
				<td style="border: 1px solid #444444;"><a href="/school/getSchoolInfo.do?schoolIdx=${school.schoolId}">${school.schoolName }</a></td>
				<td style="border: 1px solid #444444;">${school.schoolArea }</td>
				<td style="border: 1px solid #444444;">${school.schoolAddr }</td>
				<td style="border: 1px solid #444444;">${school.schoolPhone }</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>