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
import study.jsp.myschool.model.StudentDepartment;
import study.jsp.myschool.service.StudentJoinService;
import study.jsp.myschool.service.impl.StudentJoinServiceImpl;

@WebServlet("/stud_list.do")
public class StudList extends BaseController{

	private static final long serialVersionUID = -3102851884312753245L;
	WebHelper web;
	SqlSession sqlSession;
	/*StudentService studentService;*/
	StudentJoinService studentJoinService;
	PageHelper pageHelper;
	

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		web = WebHelper.getInstance(request, response);
		StudentDepartment student = new StudentDepartment();

		String keyword = web.getString("keyword", "");
		/*Student student = new Student();*/
		student.setName(keyword);

		int nowPage = web.getInt("page", 1);

		sqlSession = MyBatisConnectionFactory.getSqlSession();
		studentJoinService = new StudentJoinServiceImpl(sqlSession, logger);

		int totalCount = 0;
		try {
			totalCount = studentJoinService.getStudentCount(student);
		} catch (Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}

		pageHelper = PageHelper.getInstance(nowPage, totalCount, 10, 5);
		student.setLimitStart(pageHelper.getLimitStart());
		student.setListCount(pageHelper.getListCount());

		List<StudentDepartment> list = null;
		try {
			list = studentJoinService.getStudentJoinList(student);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		request.setAttribute("list", list);
		request.setAttribute("page", pageHelper);
		request.setAttribute("keyword", keyword);
		
		return "stud_list";

	}

}
