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
import study.jsp.myschool.service.StudentJoinService;
import study.jsp.myschool.service.impl.StudentJoinServiceImpl;

@WebServlet("/stud_add.do")
public class StudAdd extends BaseController {

	private static final long serialVersionUID = -6637353004438890629L;
	WebHelper web;
	SqlSession sqlSession;
	StudentJoinService studentJoinService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		web = WebHelper.getInstance(request, response);		
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		studentJoinService = new StudentJoinServiceImpl(sqlSession, logger);
		return "stud_add";
		
	}

}
