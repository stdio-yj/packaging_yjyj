package study.jsp.myschool.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import study.jsp.helper.BaseController;
import study.jsp.helper.PageHelper;
import study.jsp.helper.WebHelper;
import study.jsp.myschool.dao.MyBatisConnectionFactory;
import study.jsp.myschool.model.Member;
import study.jsp.myschool.service.MemberService;
import study.jsp.myschool.service.impl.MemberServiceImpl;

@WebServlet("/mem_list.do")
public class MemList extends BaseController{

	private static final long serialVersionUID = -745708871232720095L;
	WebHelper web;
	SqlSession sqlSession;
	MemberService memberService;
	PageHelper pageHelper;
	

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		web = WebHelper.getInstance(request, response);
		Member member = new Member();
		
		String keyword = web.getString("keyword", "");
		member.setName(keyword);
		
		int nowPage = web.getInt("page", 1);
		
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		memberService = new MemberServiceImpl(sqlSession, logger);
		
		int totalCount = 0;
		try {
			totalCount = memberService.getMemberCount(member);
		}  catch (Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}
		
		pageHelper = PageHelper.getInstance(nowPage, totalCount, 10, 5);
		member.setLimitStart(pageHelper.getLimitStart());
		member.setListCount(pageHelper.getListCount());
		
		List<Member> list = null;
		try {
			list = memberService.getMemberList(member);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		request.setAttribute("list", list);
		request.setAttribute("page", pageHelper);
		request.setAttribute("keyword", keyword);
		
		return "mem_list";

	}

}
