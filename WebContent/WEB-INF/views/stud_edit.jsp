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
		<h1 class='page-header'>학생수정</h1>

		<!-- 수정을 위한 HTML 폼 시작 -->
		<form class="form-horizontal" method="post"
			action="${pageContext.request.contextPath}/stud_edit_ok.do">

			<!-- 상태유지를 위한 일련번호 값의 처리 -->
			<input type="hidden" name="studno" value="${item.studno}" />

			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">이름</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name" name="name"
						value="${item.name}" />
				</div>
			</div>

			<div class="form-group">
				<label for="userid" class="col-sm-2 control-label">아이디</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="userid"
						name="userid" value="${item.userid}" />
				</div>
			</div>

			<div class="form-group">
				<label for="grade" class="col-sm-2 control-label">학년</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="grade" name="grade" value="${item.grade}" />
				</div>
			</div>

			<div class="form-group">
				<label for="idnum" class="col-sm-2 control-label">주민번호</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="idnum" name="idnum" value="${item.idnum}"  />
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
						name="tel" value="${item.tel}"  />
				</div>
			</div>
			
			<div class="form-group">
				<label for="height" class="col-sm-2 control-label">키</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="height"
						name="height" value="${item.height}" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="weight" class="col-sm-2 control-label">몸무게</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="weight"
						name="weight" value="${item.weight}" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="deptno" class="col-sm-2 control-label">학과번호</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="deptno"
						name="deptno" value="${item.deptno}" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="profno" class="col-sm-2 control-label">교수번호</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="profno"
						name="profno" value="${item.profno}" />
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



