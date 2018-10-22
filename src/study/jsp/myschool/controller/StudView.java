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
import study.jsp.myschool.model.StudentDepartment;
import study.jsp.myschool.service.StudentJoinService;
import study.jsp.myschool.service.impl.StudentJoinServiceImpl;

@WebServlet("/stud_view.do")
public class StudView extends BaseController {

	private static final long serialVersionUID = -4278166806892499240L;
	WebHelper web;
	SqlSession sqlSession;
	StudentJoinService studentJoinService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		WebHelper web = WebHelper.getInstance(request, response);
		
		int studno = web.getInt("studno");
		logger.debug("studno=" + studno);
		
		if (studno == 0) {
			web.redirect(null, "학생번호가 없습니다.");
			return null;
		}
		
		StudentDepartment student = new StudentDepartment();
		student.setStudno(studno);
		
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		studentJoinService = new StudentJoinServiceImpl(sqlSession, logger);
		
		StudentDepartment item = null;
		try {
			item = studentJoinService.getStudentJoinItem(student);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		request.setAttribute("item", item);
		return "stud_view";
	}

}
