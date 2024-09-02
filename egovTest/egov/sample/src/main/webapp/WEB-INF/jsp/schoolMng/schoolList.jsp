<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous"></script>
<title>Insert title here</title>

<script type="text/javascript">
	function fn_detail(schoolId){
		
		$("#schoolId").val(schoolId);
		var frm = $("#jsonFrm").serialize();
		console.log(frm);
		$.ajax({
		    url: '/school/getSchoolInfo.do',
		    method: 'post',
		    data : frm,
		    dataType : 'json',
		    success: function (data, status, xhr) {
		        console.log(data);
		    },
		    error: function (data, status, err) {
		    }
		});
	}
</script>

</head>
<body>
	<form id="jsonFrm" name="jsonFrm">
		<input type="hidden" id="schoolId" name="schoolId" value=""/>
	</form>
	<table style="border: 1px solid #444444;">
	<thead>
		<tr>
			<th style="border: 1px solid #444444;">학교명</th>
			<th style="border: 1px solid #444444;">지역구</th>
			<th style="border: 1px solid #444444;">학교 주소</th>
			<th style="border: 1px solid #444444;">학교 연락처</th>
		</tr>
	</thead>
	<tbody >
		<c:forEach var="school" items="${schoolList }">
			<tr>
				<td style="border: 1px solid #444444;"><a href="/schoolMng/getSchoolInfo.do?schoolId=${school.schoolId }" >${school.schoolName }</a></td>
				<td style="border: 1px solid #444444;">${school.schoolArea }</td>
				<td style="border: 1px solid #444444;">${school.schoolAddr }</td>
				<td style="border: 1px solid #444444;">${school.schoolPhone }</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	<a href="/schoolMng/registerSchool.do">등록</a>
</body>
</html>