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
import study.jsp.myschool.model.Student;
import study.jsp.myschool.service.StudentService;
import study.jsp.myschool.service.impl.StudentServiceImpl;

@WebServlet("/stud_delete.do")
public class StudDelete extends BaseController {

	private static final long serialVersionUID = -3775335279645135499L;
	WebHelper web;
	SqlSession sqlSession;
	StudentService studentService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		web = WebHelper.getInstance(request, response);
		
		int studno = web.getInt("studno");
		logger.debug("studno=" + studno);
		
		if (studno == 0) {
			web.redirect(null, "학생번호가 없습니다.");
			return null;
		}
		Student student = new Student();
		student.setStudno(studno);
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		studentService = new StudentServiceImpl(sqlSession, logger);
		
		try {
			studentService.deleteStudent(student);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		web.redirect("stud_list.do", "삭제되었습니다.");
		return null;
	}

}
