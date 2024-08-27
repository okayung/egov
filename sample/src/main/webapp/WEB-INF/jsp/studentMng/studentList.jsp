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
	$(document).ready(function(){
		fn_selectList();
	});
	
	
	function fn_selectList(){
		$.ajax({
		    url: '/studentMng/selectStudentMngList.do',
		    method: 'post',
		    data : {},
		    dataType : 'json',
		    success: function (data, status, xhr) {
		        var innerHtml = '';
		        
		        for(var i=0; i<data.list.length; i++){
		        	innerHtml += '<tr>';
		        	innerHtml += '<td>';
		        	innerHtml += data.list[i].rNum;
		        	innerHtml += '</td>';
		        	innerHtml += '<td>';
		        	innerHtml += data.list[i].studentName;
		        	innerHtml += '</td>';
		        	innerHtml += '<td>';
		        	innerHtml += data.list[i].schoolName;
		        	innerHtml += '</td>';
		        	innerHtml += '<td>';
		        	innerHtml += data.list[i].graduateYn;
		        	innerHtml += '</td>';
		        	innerHtml += '</tr>';
		        }
		        $("#bodyList").html(innerHtml);
		    },
		    error: function (data, status, err) {
		    }
		});
	}
	
</script>
</head>
<body>
	<table style="border: 1px solid #444444;">
	<thead>
		<tr>
			<th style="border: 1px solid #444444;">순번</th>
			<th style="border: 1px solid #444444;">학생이름</th>
			<th style="border: 1px solid #444444;">학교명</th>
			<th style="border: 1px solid #444444;">졸업여부</th>
		</tr>
	</thead>
	<tbody id="bodyList">
	</tbody>
	</table>
</body>
</html>