package study.jsp.myschool.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import study.jsp.helper.BaseController;
import study.jsp.helper.WebHelper;
import study.jsp.myschool.dao.MyBatisConnectionFactory;
import study.jsp.myschool.model.Member;
import study.jsp.myschool.service.MemberService;
import study.jsp.myschool.service.impl.MemberServiceImpl;

@WebServlet("/mem_edit.do")
public class MemEdit extends BaseController {

	private static final long serialVersionUID = -2627312890472256815L;
	WebHelper web;
	SqlSession sqlSession;
	MemberService memberService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		web = WebHelper.getInstance(request, response);
		
		int id = web.getInt("id");
		logger.debug("id=" + id);
		
		if (id == 0) {
			web.redirect(null, "회원번호가 없습니다.");
			return null;
		}
		
		Member member = new Member();
		member.setId(id);
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		memberService = new MemberServiceImpl(sqlSession, logger);
		
		Member item = null;
		try {
			item = memberService.getMemberItem(member);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		request.setAttribute("item", item);
		
		return "mem_edit";
	}

}
