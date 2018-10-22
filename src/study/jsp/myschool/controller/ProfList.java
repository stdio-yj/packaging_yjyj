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
import study.jsp.myschool.model.ProfessorDepartment;
import study.jsp.myschool.service.ProfessorJoinService;
import study.jsp.myschool.service.impl.ProfessorJoinServiceImpl;

@WebServlet("/prof_list.do")
public class ProfList extends BaseController{

	private static final long serialVersionUID = 5335046586490151787L;
	WebHelper web;
	SqlSession sqlSession;
	ProfessorJoinService professorJoinService;
	PageHelper pageHelper;
	

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		web = WebHelper.getInstance(request, response);
		ProfessorDepartment professor = new ProfessorDepartment();
		
		String keyword = web.getString("keyword", "");
		professor.setName(keyword);
		
		int nowPage = web.getInt("page", 1);
		
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		professorJoinService = new ProfessorJoinServiceImpl(sqlSession, logger);
		
		int totalCount = 0;
		try {
			totalCount = professorJoinService.getProfessorCount(professor);
		}  catch (Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}
		
		pageHelper = PageHelper.getInstance(nowPage, totalCount, 10, 5);
		professor.setLimitStart(pageHelper.getLimitStart());
		professor.setListCount(pageHelper.getListCount());
		
		List<ProfessorDepartment> list = null;
		try {
			list = professorJoinService.getProfessorJoinList(professor);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		request.setAttribute("list", list);
		request.setAttribute("page", pageHelper);
		request.setAttribute("keyword", keyword);
		
		return "prof_list";

	}

}
