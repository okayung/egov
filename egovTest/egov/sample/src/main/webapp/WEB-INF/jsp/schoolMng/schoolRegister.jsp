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
		$("#btn_insert").on('click', function(){
			fn_insertSchool();
		});
		$("#btn_update").on('click', function(){
			fn_updateSchool();
		});
		$("#btn_delete").on('click', function(){
			
		});
	});
	
	function fn_insertSchool(){
		var frm = $("#frm").serialize();
		$.ajax({
		    url: '/schoolMng/insertSchoolInfo.do',
		    method: 'post',
// 		    data : {
// 		    	"schoolName" : $("#schoolName").val(),
// 		    	"schoolArea" : $("#schoolArea").val(),
// 		    	"schoolAddr" : $("#schoolAddr").val(),
// 		    	"schoolPhone" : $("#schoolPhone").val()
// 		    },
			data : frm,
		    dataType : 'json',
		    success: function (data, status, xhr) {
		        if(data.resultChk > 0){
		        	alert("저장되었습니다.");
		        	location.href="/schoolMng/getSchoolList.do";

		        }
		    },
		    error: function (data, status, err) {
		    }
		});
	}
		function fn_updateSchool(){
			var frm = $("#frm").serialize();
			$.ajax({
			    url: '/schoolMng/updateSchoolInfo.do',
			    method: 'post',
//	 		    data : {
//	 		    	"schoolName" : $("#schoolName").val(),
//	 		    	"schoolArea" : $("#schoolArea").val(),
//	 		    	"schoolAddr" : $("#schoolAddr").val(),
//	 		    	"schoolPhone" : $("#schoolPhone").val()
//	 		    },
				data : frm,
			    dataType : 'json',
			    success: function (data, status, xhr) {
			        if(data.resultChk > 0){
			        	alert("수정되었습니다.");
			        	location.href="/schoolMng/getSchoolList.do";
//						location.href="#"; 제자리, 새로고침
			        }
			    },
			    error: function (data, status, err) {
			    }
			});
		}
</script>
</head>
<body>
	<form id="frm" name="frm">
		<input type="hidden" id="schoolId" name="schoolId" value="${schoolInfo.schoolId }"/>
	
		<table style="border: 1px solid #444444;">
			<tr>
				<th style="border: 1px solid #444444;">학교명</th>
				<td style="border: 1px solid #444444; width:200px;">
					<input type="text" id="schoolName" name="schoolName" value="${schoolInfo.schoolName }"/>
				</td>
				
			</tr>
			<tr>
				<th style="border: 1px solid #444444;">지역구</th>
				<td style="border: 1px solid #444444; width:200px;">
					<input type="text" id="schoolArea" name="schoolArea" value="${schoolInfo.schoolArea }"/>
				</td>
			</tr>
			<tr>
				<th style="border: 1px solid #444444;">학교 주소</th>
				<td style="border: 1px solid #444444; width:200px;">
					<input type="text" id="schoolAddr" name="schoolAddr" value="${schoolInfo.schoolAddr }"/>
				</td>
			</tr>
			<tr>
				<th style="border: 1px solid #444444;">학교 연락처</th>
				<td style="border: 1px solid #444444; width:200px;">
					<input type="text" id="schoolPhone" name="schoolPhone" value="${schoolInfo.schoolPhone }"/>
				</td>
			</tr>
			
		</table>
	</form>
	<c:if test="${flag =='I' }">
	<input type="button" id="btn_insert" name="btn_insert" value="저장"/>
	</c:if>
	<c:if test="${flag =='U' }">
	<input type="button" id="btn_update" name="btn_update" value="수정"/>
	</c:if>
	
	
	<a href="/schoolMng/getSchoolList.do">목록으로</a>
</body>
</html>