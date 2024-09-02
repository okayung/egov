<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<table style="border: 1px solid #444444;">
			<tr>
				<th style="border: 1px solid #444444;">학생이름</th>
				<td style="border: 1px solid #444444; width:200px;">
					<input type="text" id="studentName" name="studentName" value="${studentInfo.studentName }"/>
				</td>
			</tr>
			<tr>
				<th style="border: 1px solid #444444;">학교명</th>
				<td style="border: 1px solid #444444; width:200px;">
					<input type="text" id="schoolName" name="schoolName" value="${studentInfo.schoolName }"/>
				</td>
			</tr>
			<tr>
				<th style="border: 1px solid #444444;">졸업여부</th>
				<td style="border: 1px solid #444444; width:200px;">
					<input type="text" id="graduateYn" name="graduateYn" value="${studentInfo.graduateYn }"/>
				</td>
			</tr>
			
		</table>
	<a href="/studentMng/getStudentList.do">목록으로</a>
</body>
</html>