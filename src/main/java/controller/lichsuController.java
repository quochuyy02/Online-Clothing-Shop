package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.khachhangbean;
import bean.lichsubean;
import bo.lichsubo;

/**
 * Servlet implementation class lichsuController
 */
@WebServlet("/lichsuController")
public class lichsuController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public lichsuController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");// gá»­i dá»¯ liá»‡u lÃªn kiá»ƒu unicode
			response.setCharacterEncoding("utf-8");// nháº­n dá»¯ liá»‡u vá»� kiá»ƒu unicode
			HttpSession session = request.getSession();
			if (session.getAttribute("dn") == null) {
				response.sendRedirect("aoquanController");
			} else {

				khachhangbean kh = (khachhangbean) session.getAttribute("dn");
				lichsubo lsbo1 = new lichsubo();
				ArrayList<lichsubean> dslsdm = new ArrayList<lichsubean>();
				dslsdm = lsbo1.getLichSu(kh.getMaKH(), 1);
				request.setAttribute("dslichsudm", dslsdm);

				lichsubo lsbo2 = new lichsubo();
				ArrayList<lichsubean> dslscm = new ArrayList<lichsubean>();
				dslscm = lsbo2.getLichSu(kh.getMaKH(), 0);
				request.setAttribute("dslichsucm", dslscm);
				RequestDispatcher rd = request.getRequestDispatcher("htlichsu.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
