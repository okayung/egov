<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학교상세정보</title>
<script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous"></script>
  
  <script type="text/javascript">
  	function fn_detail(schoolIdx){
  	  $("#schoolId").val(schoolIdx);
 	  var frm =$("#frm").serialize();
 	  console.log(frm);
	  $.ajax({
		 type:'POST',
		 url:'/school/getSchoolInfo.do',
		 data: frm,
		 dataType:'json',
		 beforeSend: function(jqXHR, settings){
			 console.log('beforSend');
		 },
		 success:function(data, testStatus, jqXHR){
			 console.log('success');
			 console.log(data);
			 var innerHtml = '';
			 innerHtml +='<tr>';
			 innerHtml +='<th>학교명</th>';
			 innerHtml +='<td>';
			 innerHtml += data.schoolInfo.schoolName;
			 innerHtml +='</td>';
			 innerHtml +='</tr>';
			 $("#schoolTb").html(innerHtml);
		 },
 		 error:function(jqXHR, testStatus, errorThrown){
 			console.log('error');
		 },
 		 complete:function(jqXHR, testStatus){
 			console.log('complete');
		 }	 
	  }); 
  }
  </script>
  
</head>
<body>
	<form id="frm" name="frm">
		<input type="hidden" id="schoolId" name="schoolId" value="" />
		
	</form>

	<table id="schoolTb">
		<tr>
			<th style="border: 1px solid #444444;">학교명</th>
			<th style="border: 1px solid #444444;">지역구</th>
			<th style="border: 1px solid #444444;">주소</th>
			<th style="border: 1px solid #444444;">연락처</th>
		</tr>
		<c:forEach var="school" items="${schoolList }">
			<tr>
				<td style="border: 1px solid #444444;"><a href="javascript:fn_detail(${school.schoolId});">${school.schoolName }</a></td>
				<td style="border: 1px solid #444444;">${school.schoolArea }</td>
				<td style="border: 1px solid #444444;">${school.schoolAddr }</td>
				<td style="border: 1px solid #444444;">${school.schoolPhone }</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>