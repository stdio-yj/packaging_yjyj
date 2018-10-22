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
		<h1 class='page-header'>회원추가</h1>

		<!-- 추가를 위한 HTML 폼 시작 -->
		<form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/mem_add_ok.do">

			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">이름</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name" name="name" />
				</div>
			</div>

			<div class="form-group">
				<label for="userId" class="col-sm-2 control-label">아이디</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="userId"
						name="userId" />
				</div>
			</div>

			<div class="form-group">
				<label for="userPw" class="col-sm-2 control-label">비밀번호</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="userPw" name="userPw" />
				</div>
			</div>

			<div class="form-group">
				<label for="email" class="col-sm-2 control-label">이메일</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="email" name="email" />
				</div>
			</div>

			<div class="form-group">
				<label for="gender" class="col-sm-2 control-label">성별</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="gender"
						name="gender" />
				</div>
			</div>

			<div class="form-group">
				<label for="birthdate" class="col-sm-2 control-label">생년월일</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="birthdate"
						name="birthdate" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="tel" class="col-sm-2 control-label">연락처</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="tel"
						name="tel" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="postcode" class="col-sm-2 control-label">우편번호</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="postcode"
						name="postcode" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="addr1" class="col-sm-2 control-label">주소1</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="addr1"
						name="addr1" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="addr2" class="col-sm-2 control-label">주소2</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="addr2"
						name="addr2" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="profileImg" class="col-sm-2 control-label">프로필 이미지</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="profileImg"
						name="profileImg" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="regDate" class="col-sm-2 control-label">가입일시</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="regDate"
						name="regDate" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="editDate" class="col-sm-2 control-label">변경일시</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="editDate"
						name="editDate" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">저장하기</button>
				</div>
			</div>
		</form>
		<!--// 추가를 위한 HTML 폼 끝  -->
	</div>
</body>
</html>



