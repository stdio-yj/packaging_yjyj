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
		<div class="page-header clearfix">
			<h1 class='pull-left'>회원목록</h1>

			<div style='margin-top: 30px;' class="pull-right">
				<form method='get'
					action='${pageContext.request.contextPath}/mem_list.do'
					style="width: 300px;">
					<div class="input-group">
						<input type="text" name='keyword' class="form-control"
							placeholder="회원이름 검색" value="${keyword}" /> <span
							class="input-group-btn">
							<button class="btn btn-success" type="submit">
								<i class='glyphicon glyphicon-search'></i>
							</button> <a href="${pageContext.request.contextPath}/mem_add.do" class="btn btn-primary">회원추가</a>
						</span>
					</div>
				</form>
			</div>
		</div>

		<!-- 조회결과를 출력하기 위한 표 시작 -->
		<table class="table">
			<thead>
				<tr>
					<th class="info text-center">회원번호</th>
					<th class="info text-center">이름</th>
					<th class="info text-center">아이디</th>
					<th class="info text-center">비밀번호</th>
					<th class="info text-center">이메일</th>
					<th class="info text-center">성별</th>
					<th class="info text-center">생년월일</th>
					<th class="info text-center">연락처</th>
					<th class="info text-center">우편번호</th>
					<th class="info text-center">주소1</th>
					<th class="info text-center">주소2</th>
					<th class="info text-center">프로필 이미지</th>
					<th class="info text-center">가입일시</th>
					<th class="info text-center">변경일시</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${fn:length(list) > 0 }">
						<c:forEach var="item" items="${list}">
							<tr>
								<td class="text-center">${item.id}</td>
								<td class="text-center"><c:url var="readUrl"
										value="/mem_view.do">
										<c:param name="id" value="${item.id}" />
									</c:url> <a href="${readUrl}">${item.name}</a></td>
								<td class="text-center">${item.userId}</td>
								<td class="text-center">${item.userPw}</td>
								<td class="text-center">${item.email}</td>
								<td class="text-center">${item.gender}</td>
								<td class="text-center">${item.birthdate}</td>
								<td class="text-center">${item.tel}</td>
								<td class="text-center">${item.postcode}</td>
								<td class="text-center">${item.addr1}</td>
								<td class="text-center">${item.addr2}</td>
								<td class="text-center">${item.profileImg}</td>
								<td class="text-center">${item.regDate}</td>
								<td class="text-center">${item.editDate}</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="8" class="text-center">조회된 데이터가 없습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
		<nav class='text-center'>
			<ul class="pagination">
				<!-- 이전 그룹 -->
				<c:choose>
					<c:when test="${page.prevPage > 0 }">
						<c:url var="prevUrl" value="/mem_list.do">
							<c:param name="keyword" value="${keyword}"></c:param>
							<c:param name="page" value="${page.prevPage}"></c:param>
						</c:url>
						<li><a href="${prevUrl}">&laquo;</a></li>
					</c:when>
					<c:otherwise>
						<li class="disabled"><a href="#">&laquo;</a></li>
					</c:otherwise>
				</c:choose>

				<!-- 페이지 번호 -->
				<c:forEach var="i" begin="${page.startPage}"
					end="${page.endPage}" step="1">
					<c:url var="pageUrl" value="/mem_list.do">
						<c:param name="keyword" value="${keyword}"></c:param>
						<c:param name="page" value="${i}"></c:param>
					</c:url>
					<c:choose>
						<c:when test="${page.page == i }">
							<li class='active'><a href="#">${i}</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="${pageUrl}">${i}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>

				<!-- 다음 그룹 -->
				<c:choose>
					<c:when test="${page.nextPage > 0 }">
						<c:url var="nextUrl" value="/mem_list.do">
							<c:param name="keyword" value="${keyword}"></c:param>
							<c:param name="page" value="${page.nextPage}"></c:param>
						</c:url>
						<li><a href="${nextUrl}">&raquo;</a></li>
					</c:when>
					<c:otherwise>
						<li class="disabled"><a href="#">&raquo;</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</nav>
	</div>
</body>
</html>



