<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
		<h1 class='page-header'>회원수정</h1>

		<!-- 수정을 위한 HTML 폼 시작 -->
		<form class="form-horizontal" method="post"
			action="${pageContext.request.contextPath}/mem_edit_ok.do">

			<!-- 상태유지를 위한 일련번호 값의 처리 -->
			<input type="hidden" name="id" value="${item.id}" />

			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">이름</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name" name="name"
						value="${item.name}" />
				</div>
			</div>

			<div class="form-group">
				<label for="userId" class="col-sm-2 control-label">아이디</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="userId"
						name="userId" value="${item.userId}" />
				</div>
			</div>

			<div class="form-group">
				<label for="userPw" class="col-sm-2 control-label">비밀번호</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="userPw" name="userPw" value="${item.userPw}" />
				</div>
			</div>

			<div class="form-group">
				<label for="email" class="col-sm-2 control-label">이메일</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="email" name="email" value="${item.email}" />
				</div>
			</div>

			<div class="form-group">
				<label for="gender" class="col-sm-2 control-label">성별</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="gender"
						name="gender" value="${item.gender}" />
				</div>
			</div>

			<div class="form-group">
				<label for="birthdate" class="col-sm-2 control-label">생년월일</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="birthdate"
						name="birthdate" value="${item.birthdate}" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="tel" class="col-sm-2 control-label">연락처</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="tel"
						name="tel" value="${item.tel}" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="postcode" class="col-sm-2 control-label">우편번호</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="postcode"
						name="postcode" value="${item.postcode}" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="addr1" class="col-sm-2 control-label">주소1</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="addr1"
						name="addr1" value="${item.addr1}" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="addr2" class="col-sm-2 control-label">주소2</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="addr2"
						name="addr2" value="${item.addr2}" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="profileImg" class="col-sm-2 control-label">프로필 이미지</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="profileImg"
						name="profileImg" value="${item.profileImg}" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="regDate" class="col-sm-2 control-label">가입일시</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="regDate"
						name="regDate" value="${item.regDate}" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="editDate" class="col-sm-2 control-label">변경일시</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="editDate"
						name="editDate" value="${item.editDate}" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">저장하기</button>
				</div>
			</div>
		</form>
		<!--// 수정을 위한 HTML 폼 끝  -->
	</div>
</body>
</html>



