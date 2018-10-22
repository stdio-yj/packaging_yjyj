<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<title>My JSP Page</title>
<!-- Twitter Bootstrap3 & jQuery -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" />
<script src="http://code.jquery.com/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1 class='page-header'>학생 상세 보기</h1>

		<!-- 조회결과를 출력하기 위한 표 시작 -->
		<table class="table table-bordered">
			<tbody>
				<tr>
					<th class="info text-center" width="130">학생번호</th>
					<td>${item.studno}</td>
				</tr>
				<tr>
					<th class="info text-center" width="130">이름</th>
					<td>${item.name}</td>
				</tr>
				<tr>
					<th class="info text-center" width="130">아이디</th>
					<td>${item.userid}</td>
				</tr>
				<tr>
					<th class="info text-center" width="130">학년</th>
					<td>${item.grade}</td>
				</tr>
				<tr>
					<th class="info text-center" width="130">주민번호</th>
					<td>${item.idnum}</td>
				</tr>
				<tr>
					<th class="info text-center" width="130">생년월일</th>
					<td>${item.birthdate}</td>
				</tr>
				<tr>
					<th class="info text-center" width="130">연락처</th>
					<td>${item.tel}</td>
				</tr>
				<tr>
					<th class="info text-center" width="130">키</th>
					<td>${item.height}</td>
				</tr>
				<tr>
					<th class="info text-center" width="130">몸무게</th>
					<td>${item.weight}</td>
				</tr>
				<tr>
					<th class="info text-center" width="130">학과이름</th>
					<td>${item.dname}</td>
				</tr>
				<tr>
					<th class="info text-center" width="130">담당교수</th>
					<td>${item.pname}</td>
				</tr>
			</tbody>
		</table>
		<!--// 조회결과를 출력하기 위한 표 끝  -->

		<!-- 버튼시작 -->
		<div class="text-center">
			<a href="stud_list.do" class="btn btn-primary">목록</a> <a
				href="stud_add.do" class="btn btn-info">추가</a> <a
				href="stud_edit.do?studno=${item.studno}" class="btn btn-warning">수정</a>
			<a href="stud_delete.do?studno=${item.studno}" class="btn btn-danger">삭제</a>
		</div>
		<!--// 버튼 끝 -->
	</div>
</body>
</html>



