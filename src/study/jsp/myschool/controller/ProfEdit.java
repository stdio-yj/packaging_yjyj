package study.jsp.myschool.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import study.jsp.helper.BaseController;
import study.jsp.helper.WebHelper;
import study.jsp.myschool.dao.MyBatisConnectionFactory;
import study.jsp.myschool.model.Department;
import study.jsp.myschool.model.Professor;
import study.jsp.myschool.service.DepartmentService;
import study.jsp.myschool.service.ProfessorService;
import study.jsp.myschool.service.impl.DepartmentServiceImpl;
import study.jsp.myschool.service.impl.ProfessorServiceImpl;

@WebServlet("/prof_edit.do")
public class ProfEdit extends BaseController {

	private static final long serialVersionUID = -1787762578677590227L;
	WebHelper web;
	SqlSession sqlSession;
	ProfessorService professorService;
	DepartmentService departmentService;

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
		departmentService = new DepartmentServiceImpl(sqlSession, logger);
		
		Professor item = null;
		List<Department> deptList = null;
		try {
			item = professorService.getProfessorItem(professor);
			deptList = departmentService.getDepartmentList(null);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		request.setAttribute("item", item);
		request.setAttribute("dept_list", deptList);
		
		return "prof_edit";
	}

}
