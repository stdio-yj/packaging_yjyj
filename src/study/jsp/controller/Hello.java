package study.jsp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study.jsp.helper.BaseController;
import study.jsp.helper.WebHelper;

import javax.servlet.annotation.WebServlet;

@WebServlet("/hello.do")
public class Hello extends BaseController {

	private static final long serialVersionUID = 5912473010422851655L;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		WebHelper web = WebHelper.getInstance(request, response);
		String msg = web.getString("msg");
		
		logger.debug("Hello 클래스의 doRun 메서드 실행됨");
		
		request.setAttribute("msg", msg);

		String view = "hello";
		return view;
	}

}
