package study.jsp.helper;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Servlet implementation class BaseController
 */
/*@WebServlet("/BaseController")*/
public abstract class BaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Logger logger = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BaseController() {
		/* super(); */
		String className = this.getClass().getName();
		/*System.out.println(className);*/
		logger = LogManager.getLogger(className);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.pageInit(request, response);
		/*
		 * response.getWriter().append("Served at: ").append(request.getContextPath());
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.pageInit(request, response);
	}

	private void pageInit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String url = request.getRequestURL().toString();
		if(request.getQueryString() != null) {
			url = url + "?" + request.getQueryString();
		}
		
		String methodName = request.getMethod();
		
		logger.info("["+ methodName +"]" + url);
		
		String view = doRun(request, response);

		if (view != null) {
			view = "/WEB-INF/views/" + view + ".jsp";
			logger.info("[View]" + view);
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}

	}
	
	public abstract String doRun(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

}
