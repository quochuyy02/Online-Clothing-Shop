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

import bean.adminXNHoaDonbean;

import bo.chitiethoadonbo;
import bo.hoadonbo;

/**
 * Servlet implementation class adminXNHoaDon
 */
@WebServlet("/adminXNHoaDon")
public class adminXNHoaDon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminXNHoaDon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession session = request.getSession();
			if (session.getAttribute("admindn")==null) response.sendRedirect("adminDangNhap");
			request.setCharacterEncoding("utf-8");// gá»­i dá»¯ liá»‡u lÃªn kiá»ƒu unicode
			response.setCharacterEncoding("utf-8");// nháº­n dá»¯ liá»‡u vá»� kiá»ƒu unicode
			chitiethoadonbo cthdbo = new chitiethoadonbo();
			hoadonbo hdbo = new hoadonbo();
			String mahd = request.getParameter("mahd");
			if (mahd != null) {
				hdbo.SuaHD(Long.parseLong(mahd));
				cthdbo.SuaTheoMaHD(Long.parseLong(mahd));
			}
			
//			hdbo.xoaQuaHan();
			request.setAttribute("dshd", (ArrayList<adminXNHoaDonbean>) hdbo.getdsHoaDon());
			RequestDispatcher rd = request.getRequestDispatcher("adminxacnhanhd.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
