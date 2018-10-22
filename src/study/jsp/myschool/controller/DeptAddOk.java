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

@WebServlet("/dept_add_ok.do")
public class DeptAddOk extends BaseController {

	private static final long serialVersionUID = -3204597523851921772L;
	WebHelper web;
	SqlSession sqlSession;
	DepartmentService departmentService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		web = WebHelper.getInstance(request, response);

		String dname = web.getString("dname");
		String loc = web.getString("loc");

		logger.debug("dname=" + dname);
		logger.debug("loc=" + loc);

		if (dname == null) {
			web.redirect(null, "학과이름을 입력하세요.");
			return null;
		}
		if (loc == null) {
			web.redirect(null, "위치를 입력하세요.");
			return null;
		}

		Department department = new Department();
		department.setDname(dname);
		department.setLoc(loc);

		sqlSession = MyBatisConnectionFactory.getSqlSession();
		departmentService = new DepartmentServiceImpl(sqlSession, logger);

		try {
			for (int i=0; i<10; i++) {
				department.setDname(dname + "(" + i + ")");
				department.setLoc(loc + "(" + i + ")");
				departmentService.addDepartment(department);
			}

		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}

		String url = request.getContextPath() + "/dept_view.do?deptno=" + department.getDeptno();
		web.redirect(url, "저장되었습니다.");
		return null;
	}

}
