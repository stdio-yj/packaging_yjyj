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
import study.jsp.myschool.model.Department;
import study.jsp.myschool.service.DepartmentService;
import study.jsp.myschool.service.impl.DepartmentServiceImpl;

@WebServlet("/dept_list.do")
public class DeptList extends BaseController{

	private static final long serialVersionUID = 5289272503048858898L;
	WebHelper web;
	SqlSession sqlSession;
	DepartmentService departmentService;
	PageHelper pageHelper;
	

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		web = WebHelper.getInstance(request, response);

		String keyword = web.getString("keyword", "");
		Department department = new Department();
		department.setDname(keyword);

		int nowPage = web.getInt("page", 1);

		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		departmentService = new DepartmentServiceImpl(sqlSession, logger);

		int totalCount = 0;
		try {
			totalCount = departmentService.getDepartmentCount(department);
		} catch (Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}

		pageHelper = PageHelper.getInstance(nowPage, totalCount, 10, 5);
		department.setLimitStart(pageHelper.getLimitStart());
		department.setListCount(pageHelper.getListCount());

		List<Department> list = null;
		try {
			list = departmentService.getDepartmentList(department);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		request.setAttribute("list", list);
		request.setAttribute("page", pageHelper);
		request.setAttribute("keyword", keyword);
		
		return "dept_list";

	}

}
