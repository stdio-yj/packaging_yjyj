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
			<h1 class='pull-left'>교수목록</h1>

			<div style='margin-top: 30px;' class="pull-right">
				<form method='get'
					action='${pageContext.request.contextPath}/prof_list.do'
					style="width: 300px;">
					<div class="input-group">
						<input type="text" name='keyword' class="form-control"
							placeholder="교수이름 검색" value="${keyword}" /> <span
							class="input-group-btn">
							<button class="btn btn-success" type="submit">
								<i class='glyphicon glyphicon-search'></i>
							</button> <a href="${pageContext.request.contextPath}/prof_add.do" class="btn btn-primary">교수추가</a>
						</span>
					</div>
				</form>
			</div>
		</div>

		<!-- 조회결과를 출력하기 위한 표 시작 -->
		<table class="table">
			<thead>
				<tr>
					<th class="info text-center">교수번호</th>
					<th class="info text-center">이름</th>
					<th class="info text-center">아이디</th>
					<th class="info text-center">직급</th>
					<th class="info text-center">급여</th>
					<th class="info text-center">보직수당</th>
					<th class="info text-center">입사일</th>
					<th class="info text-center">소속학과</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${fn:length(list) > 0 }">
						<c:forEach var="item" items="${list}">
							<tr>
								<td class="text-center">${item.profno}</td>
								<td class="text-center"><c:url var="readUrl"
										value="/prof_view.do">
										<c:param name="profno" value="${item.profno}" />
									</c:url> <a href="${readUrl}">${item.name}</a></td>
								<td class="text-center">${item.userid}</td>
								<td class="text-center">${item.position}</td>
								<td class="text-center">${item.sal}</td>
								<td class="text-center">${item.comm}</td>
								<td class="text-center">${item.hiredate}</td>
								<td class="text-center">${item.dname}</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="8" class="text-center">조회된 데이터가 없습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>

				<%-- <%
	if (list.size() > 0) {
		/** 조회결과가 존재하는 경우 >> 반복문 안에서 조회결과를 출력한다. */
		for (int i=0; i<list.size(); i++) {
			ProfessorDepartment item = list.get(i);
%>
				<tr>
					<td class="text-center"><%=item.getProfno()%></td>
					<td class="text-center">
						<a href="prof_view.jsp?profno=<%=item.getProfno()%>"><%=item.getName()%></a>
					</td>
					<td class="text-center"><%=item.getUserid()%></td>
					<td class="text-center"><%=item.getPosition()%></td>
					<td class="text-center"><%=item.getSal()%></td>
					<td class="text-center"><%=item.getComm()%></td>
					<td class="text-center"><%=item.getHiredate()%></td>
					<td class="text-center"><%=item.getDname()%></td>
				</tr>
<%
		} // end for		
	} else {
		/** 조회결과가 존재하지 않는 경우 */
%>
				<tr>
					<td colspan="8" class="text-center">조회된 데이터가 없습니다.</td>
				</tr>
<%		
	} // end if
%> --%>
			</tbody>
		</table>
		<nav class='text-center'>
			<ul class="pagination">
				<!-- 이전 그룹 -->
				<c:choose>
					<c:when test="${page.prevPage > 0 }">
						<c:url var="prevUrl" value="/prof_list.do">
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
					<c:url var="pageUrl" value="/prof_list.do">
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
						<c:url var="nextUrl" value="/prof_list.do">
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
		<!--// 조회결과를 출력하기 위한 표 끝  -->

		<!-- 페이지 번호 -->
		<%-- <%
			// 검색결과가 2페이지 이상 존재한다면, 페이지 번호를 클릭했을 때
			// 검색어에 대한 상태유지가 GET방식으로 처리되어야 한다.
			// 검색어가 한글일 경우 GET파라미터에 포함시키기 위해서는 URLEncoding 처리가 필요하다.
			keyword = URLEncoder.encode(keyword, "utf-8");
		%>
		<nav class='text-center'>
			<ul class="pagination">
				<!-- 이전 그룹 -->
				<%
					if (pageHelper.getPrevPage() > 0) {
				%>
				<li><a
					href="prof_list.jsp?page=<%=pageHelper.getPrevPage()%>&keyword=<%=keyword%>">
						<span aria-hidden="true">&laquo;</span>
				</a></li>
				<%
					} else {
				%>
				<li class='disabled'><a href="#"><span aria-hidden="true">&laquo;</span></a>
				</li>
				<%
					}
				%>

				<!-- 페이지 번호 -->
				<%
					for (int i = pageHelper.getStartPage(); i <= pageHelper.getEndPage(); i++) {
						if (i == nowPage) {
				%>
				<li class='active'><a href="#"><%=i%></a></li>
				<%
					} else {
				%>
				<li><a href="prof_list.jsp?page=<%=i%>&keyword=<%=keyword%>"><%=i%></a></li>
				<%
					} // end if
					} // end for
				%>

				<!-- 다음 그룹 -->
				<%
					if (pageHelper.getNextPage() > 0) {
				%>
				<li><a
					href="prof_list.jsp?page=<%=pageHelper.getNextPage()%>&keyword=<%=keyword%>">
						<span aria-hidden="true">&raquo;</span>
				</a></li>
				<%
					} else {
				%>
				<li class='disabled'><a href="#"><span aria-hidden="true">&raquo;</span></a>
				</li>
				<%
					}
				%>
			</ul>
		</nav> --%>
	</div>
</body>
</html>



