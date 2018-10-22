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
		<h1 class='page-header'>회원 상세 보기</h1>

		<!-- 조회결과를 출력하기 위한 표 시작 -->
		<table class="table table-bordered">
			<tbody>
				<tr>
					<th class="info text-center" width="130">회원번호</th>
					<td>${item.id}</td>
				</tr>
				<tr>
					<th class="info text-center" width="130">이름</th>
					<td>${item.name}</td>
				</tr>
				<tr>
					<th class="info text-center" width="130">아이디</th>
					<td>${item.userId}</td>
				</tr>
				<tr>
					<th class="info text-center" width="130">비밀번호</th>
					<td>${item.userPw}</td>
				</tr>
				<tr>
					<th class="info text-center" width="130">이메일</th>
					<td>${item.email}</td>
				</tr>
				<tr>
					<th class="info text-center" width="130">성별</th>
					<td>${item.gender}</td>
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
					<th class="info text-center" width="130">우편번호</th>
					<td>${item.postcode}</td>
				</tr>
				<tr>
					<th class="info text-center" width="130">주소1</th>
					<td>${item.addr1}</td>
				</tr>
				<tr>
					<th class="info text-center" width="130">주소2</th>
					<td>${item.addr2}</td>
				</tr>
				<tr>
					<th class="info text-center" width="130">프로필 이미지</th>
					<td>${item.profileImg}</td>
				</tr>
				<tr>
					<th class="info text-center" width="130">가입일시</th>
					<td>${item.regDate}</td>
				</tr>
				<tr>
					<th class="info text-center" width="130">변경일시</th>
					<td>${item.editDate}</td>
				</tr>
			</tbody>
		</table>
		<!--// 조회결과를 출력하기 위한 표 끝  -->

		<!-- 버튼 시작 -->
		<div class="text-center">
			<a href="mem_list.do" class="btn btn-primary">목록</a> <a
				href="mem_add.do" class="btn btn-info">추가</a> <a
				href="mem_edit.do?id=${item.id}" class="btn btn-warning">수정</a>
			<a href="mem_delete.do?id=${item.id}" class="btn btn-danger">삭제</a>
		</div>
		<!--// 버튼 끝 -->
	</div>
</body>
</html>



