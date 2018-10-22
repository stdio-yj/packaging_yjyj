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

@WebServlet("/dept_edit_ok.do")
public class DeptEditOk extends BaseController {

	private static final long serialVersionUID = -2094354407103079963L;
	WebHelper web;
	SqlSession sqlSession;
	DepartmentService departmentService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		web = WebHelper.getInstance(request, response);

		int deptno = web.getInt("deptno");
		String dname = web.getString("dname");
		String loc = web.getString("loc");
		
		logger.debug("deptno=" + deptno);
		logger.debug("dname=" + dname);
		logger.debug("loc=" + loc);
		
		if (deptno == 0) 		{ web.redirect(null, "학과번호가 없습니다."); 	return null; }
		if (dname == null) 		{ web.redirect(null, "학과이름을 입력하세요."); 	return null; }
		if (loc == null) 	{ web.redirect(null, "위치를 입력하세요."); 	return null; }
		
		Department department = new Department();
		department.setDeptno(deptno);
		department.setDname(dname);
		department.setLoc(loc);
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		departmentService = new DepartmentServiceImpl(sqlSession, logger);
		
		try {
			departmentService.editDepartment(department);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		String url = "dept_view.do?deptno=" + department.getDeptno();
		web.redirect(url, "수정되었습니다.");

		return null;
	}

}
