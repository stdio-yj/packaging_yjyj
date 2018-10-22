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
import study.jsp.myschool.service.DepartmentService;
import study.jsp.myschool.service.impl.DepartmentServiceImpl;

@WebServlet("/mem_add.do")
public class MemAdd extends BaseController {

	private static final long serialVersionUID = 804665786348666697L;
	WebHelper web;
	SqlSession sqlSession;
	DepartmentService departmentService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		web = WebHelper.getInstance(request, response);
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		departmentService = new DepartmentServiceImpl(sqlSession, logger);
		return "mem_add";
	}

}
