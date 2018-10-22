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
import study.jsp.myschool.model.ProfessorDepartment;
import study.jsp.myschool.service.ProfessorJoinService;
import study.jsp.myschool.service.impl.ProfessorJoinServiceImpl;

@WebServlet("/prof_view.do")
public class ProfView extends BaseController {

	private static final long serialVersionUID = -3040700005624955235L;
	WebHelper web;
	ProfessorJoinService professorJoinService;
	SqlSession sqlSession;	

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		WebHelper web = WebHelper.getInstance(request, response);
		
		int profno = web.getInt("profno");
		/*logger.debug("profno=" + profno);*/
		
		if (profno == 0) {
			web.redirect(null, "교수번호가 없습니다.");
			return null;
		}
		
		ProfessorDepartment professor = new ProfessorDepartment();
		professor.setProfno(profno);
		
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		professorJoinService = new ProfessorJoinServiceImpl(sqlSession, logger);
		
		/** (4) Service를 통한 SQL 수행 */
		// 조회 결과를 저장하기 위한 객체
		ProfessorDepartment item = null;
		try {
			item = professorJoinService.getProfessorJoinItem(professor);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		request.setAttribute("item", item);
		return "prof_view";
	}

}
