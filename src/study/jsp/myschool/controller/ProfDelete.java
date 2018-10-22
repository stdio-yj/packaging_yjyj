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
import study.jsp.myschool.model.Professor;
import study.jsp.myschool.service.ProfessorService;
import study.jsp.myschool.service.impl.ProfessorServiceImpl;

@WebServlet("/prof_delete.do")
public class ProfDelete extends BaseController {


	private static final long serialVersionUID = -5683216243527784382L;
	WebHelper web;
	SqlSession sqlSession;
	ProfessorService professorService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		web = WebHelper.getInstance(request, response);

		int profno = web.getInt("profno");
		logger.debug("profno=" + profno);

		if (profno == 0) {
			web.redirect(null, "교수번호가 없습니다.");
			return null;
		}

		Professor professor = new Professor();
		professor.setProfno(profno);

		sqlSession = MyBatisConnectionFactory.getSqlSession();
		professorService = new ProfessorServiceImpl(sqlSession, logger);

		try {
			professorService.deleteProfessor(professor);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}

		web.redirect(request.getContextPath()+ "/prof_list.do", "삭제되었습니다.");
		return null;
	}

}
