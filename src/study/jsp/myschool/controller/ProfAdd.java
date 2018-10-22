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
import study.jsp.myschool.service.DepartmentService;
import study.jsp.myschool.service.impl.DepartmentServiceImpl;

@WebServlet("/prof_add.do")
public class ProfAdd extends BaseController {

	private static final long serialVersionUID = 804665786348666697L;
	WebHelper web;
	SqlSession sqlSession;
	DepartmentService departmentService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* 어차피 부모로부터 log4j를 상속 받을 것이기때문에 지움 -> Spring에서는 할당 부분이 없어진다 */
		
		web = WebHelper.getInstance(request, response);
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		departmentService = new DepartmentServiceImpl(sqlSession, logger);

		List<Department> deptList = null;
		try {
			deptList = departmentService.getDepartmentList(null);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		request.setAttribute("dept_list", deptList);
		return "prof_add";
	}

}
