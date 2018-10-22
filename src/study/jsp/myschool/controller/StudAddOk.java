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

@WebServlet("/stud_add_ok.do")
public class StudAddOk extends BaseController {

	private static final long serialVersionUID = 8198919006564840597L;
	WebHelper web;
	SqlSession sqlSession;
	StudentService studentService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		web = WebHelper.getInstance(request, response);

		String name = web.getString("name");
		String userid = web.getString("userid");
		int grade = web.getInt("grade");
		String idnum = web.getString("idnum");
		String birthdate = web.getString("birthdate");
		String tel = web.getString("tel");
		int height = web.getInt("height");
		int weight = web.getInt("weight");
		int deptno = web.getInt("deptno");
		int profno = web.getInt("profno");
		

		logger.debug("name=" + name);
		logger.debug("userid=" + userid);
		logger.debug("grade=" + grade);
		logger.debug("idnum=" + idnum);
		logger.debug("birthdate=" + birthdate);
		logger.debug("tel=" + tel);
		logger.debug("height=" + height);
		logger.debug("weight=" + weight);
		logger.debug("deptno=" + deptno);
		logger.debug("profno=" + profno);
		

		if (name == null) {
			web.redirect(null, "학과이름을 입력하세요.");
			return null;
		}
		if (userid == null) {
			web.redirect(null, "아이디를 입력하세요.");
			return null;
		}
		if (grade == 0) {
			web.redirect(null, "학년을 입력하세요.");
			return null;
		}
		if (idnum == null) {
			web.redirect(null, "주민번호를 입력하세요.");
			return null;
		}
		if (birthdate == null) {
			web.redirect(null, "생년월일을 입력하세요.");
			return null;
		}
		if (tel == null) {
			web.redirect(null, "전화번호를 입력하세요.");
			return null;
		}
		if (height == 0) {
			web.redirect(null, "키를 입력하세요.");
			return null;
		}
		if (weight == 0) {
			web.redirect(null, "몸무게를 입력하세요.");
			return null;
		}
		if (deptno == 0) {
			web.redirect(null, "학과번호를 선택하세요.");
			return null;
		}
		if (profno == 0) {
			web.redirect(null, "교수번호를 선택하세요.");
			return null;
		}

		Student student = new Student();
		student.setName(name);
		student.setUserid(userid);
		student.setGrade(grade);
		student.setIdnum(idnum);
		student.setBirthdate(birthdate);
		student.setTel(tel);
		student.setHeight(height);
		student.setWeight(weight);
		student.setDeptno(deptno);
		student.setProfno(profno);
		

		sqlSession = MyBatisConnectionFactory.getSqlSession();
		studentService = new StudentServiceImpl(sqlSession, logger);

		try {
			for (int i=0; i<10; i++) {
				student.setName(name + "(" + i + ")");
				studentService.addStudent(student);
			}

		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}

		String url = request.getContextPath() + "/stud_view.do?studno=" + student.getStudno();
		web.redirect(url, "저장되었습니다.");
		return null;
	}

}
