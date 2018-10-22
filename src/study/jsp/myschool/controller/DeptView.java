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
import study.jsp.myschool.model.Department;
import study.jsp.myschool.service.DepartmentService;
import study.jsp.myschool.service.impl.DepartmentServiceImpl;

@WebServlet("/dept_view.do")
public class DeptView extends BaseController {

	private static final long serialVersionUID = 3527132834561155109L;
	WebHelper web;
	SqlSession sqlSession;
	DepartmentService departmentService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		WebHelper web = WebHelper.getInstance(request, response);
		
		int deptno = web.getInt("deptno");
		logger.debug("deptno=" + deptno);
		
		if (deptno == 0) {
			web.redirect(null, "학과번호가 없습니다.");
			return null;
		}
		
		Department department = new Department();
		department.setDeptno(deptno);
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		departmentService = new DepartmentServiceImpl(sqlSession, logger);
		
		Department item = null;
		try {
			item = departmentService.getDepartmentItem(department);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		request.setAttribute("item", item);
		return "dept_view";
	}

}
