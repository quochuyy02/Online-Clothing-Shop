package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.khachhangbo;


/**
 * Servlet implementation class dangkyController
 */
@WebServlet("/dangkyController")
public class dangkyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public dangkyController() {
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

			String tendn = request.getParameter("txttk");
			String hoten = request.getParameter("txtht");
			String diachi = request.getParameter("txtdc");
			String sodt = request.getParameter("txtsdt");
			String email = request.getParameter("txtemail");
			String pass = request.getParameter("txtmk");
			khachhangbo khbo = new khachhangbo();
			int result = khbo.kttontai(tendn, hoten, diachi, sodt, email, pass);
			HttpSession session = request.getSession();
			session.setAttribute("kt", (int) result);

			/*
			 * if (result == 1) { request.setAttribute("kt", "Ä�Äƒng kÃ½ thÃ nh cÃ´ng"); } else {
			 * request.setAttribute("kt", "TÃªn tÃ i khoáº£n Ä‘Ã£ cÃ³ ngÆ°á»�i sá»­ dá»¥ng"); }
			 */
//
//			RequestDispatcher rd = request.getRequestDispatcher("htsach.jsp");
//			rd.forward(request, response);
			response.sendRedirect("aoquanController");
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
