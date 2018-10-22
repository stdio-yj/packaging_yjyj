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

@WebServlet("/prof_add_ok.do")
public class ProfAddOk extends BaseController {

	private static final long serialVersionUID = -3040700005624955235L;
	WebHelper web;
	ProfessorService professorService;
	SqlSession sqlSession;	

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		web = WebHelper.getInstance(request, response);

		String name = web.getString("name");
		String userid = web.getString("userid");
		String position = web.getString("position");
		int sal = web.getInt("sal");
		int comm = web.getInt("comm");
		String hiredate = web.getString("hiredate");
		int deptno = web.getInt("deptno");

		logger.debug("name=" + name);
		logger.debug("userid=" + userid);
		logger.debug("position=" + position);
		logger.debug("sal=" + sal);
		logger.debug("comm=" + comm);
		logger.debug("hiredate=" + hiredate);
		logger.debug("deptno=" + deptno);

		if (name == null) { web.redirect(null, "이름을 입력하세요."); return null; }
		if (userid == null) { web.redirect(null, "아이디를 입력하세요."); return null; }
		if (position == null) { web.redirect(null, "직급을 입력하세요."); return null; }
		if (sal == 0) { web.redirect(null, "급여를 입력하세요."); return null; }		
		if (hiredate == null) { web.redirect(null, "입사일을 입력하세요."); return null; }		
		if (deptno == 0) { web.redirect(null, "학과번호를 입력하세요."); return null; 	}

		Professor professor = new Professor();
		professor.setName(name);
		professor.setUserid(userid);
		professor.setPosition(position);
		professor.setSal(sal);
		professor.setComm(comm);
		professor.setHiredate(hiredate);
		professor.setDeptno(deptno);
		
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		professorService = new ProfessorServiceImpl(sqlSession, logger);

		try {
			for (int i=0; i<1; i++) {
				professor.setName(name + "(" + i + ")");
				professor.setUserid(userid + "(" + i + ")");
				professorService.addProfessor(professor);
			}
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}

		String url = request.getContextPath() + "/prof_view.do?profno=" + professor.getProfno();
		web.redirect(url, "저장되었습니다.");
		return null;
	}

}
