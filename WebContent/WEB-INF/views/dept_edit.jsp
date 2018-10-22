<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page import="java.util.List"%>
<%@ page import="study.jsp.helper.WebHelper"%>
<%@ page import="study.jsp.myschool.dao.MyBatisConnectionFactory"%>
<%@ page import="study.jsp.myschool.service.DepartmentService"%>
<%@ page import="study.jsp.myschool.service.DepartmentService"%>
<%@ page import="study.jsp.myschool.service.impl.DepartmentServiceImpl"%>
<%@ page import="study.jsp.myschool.service.impl.DepartmentServiceImpl"%>
<%@ page import="study.jsp.myschool.model.Department"%>
<%@ page import="study.jsp.myschool.model.Department"%>
<%@ page import="org.apache.ibatis.session.SqlSession"%>
<%@ page import="org.apache.logging.log4j.LogManager"%>
<%@ page import="org.apache.logging.log4j.Logger"%>
<%
%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8" />
	<title>My JSP Page</title>
	<!-- Twitter Bootstrap3 & jQuery -->
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" />
	<script src="http://code.jquery.com/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1 class='page-header'>학과수정</h1>
		
		<!-- 수정을 위한 HTML 폼 시작 -->
		<form class="form-horizontal" method="post" action="dept_edit_ok.do">
		  
		  <!-- 상태유지를 위한 일련번호 값의 처리 -->
		  <input type="hidden" name="deptno" value="${item.deptno}" />
		  
		  <div class="form-group">
		    <label for="dname" class="col-sm-2 control-label">학과이름</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="dname" name="dname" value="${item.dname}" />
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="loc" class="col-sm-2 control-label">위치</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="loc" name="loc" value="${item.loc}" />
		    </div>
		  </div>

		  <div class="form-group">
		    <div class="col-md-offset-4 col-md-4">
		      <button type="submit" class="btn btn-primary">작성완료</button>
		      <button type="submit" class="btn btn-warning">다시작성</button>
		    </div>
		  </div>
		</form>
		<!--// 수정을 위한 HTML 폼 끝  -->
	</div>
</body>
</html>



