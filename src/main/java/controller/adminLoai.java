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

import bean.loaibean;
import bo.loaibo;

/**
 * Servlet implementation class adminLoai
 */
@WebServlet("/adminLoai")
public class adminLoai extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminLoai() {
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
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String maloai = request.getParameter("txtmaloai");
			String tenloai = request.getParameter("txttenloai");

			String butadd = request.getParameter("butadd");
			String butupdate = request.getParameter("butupdate");
			loaibo lbo = new loaibo();
			ArrayList<loaibean> ds = lbo.getloai();
			if (butadd != null) {
				lbo.themLoai(maloai, tenloai);
			} else {
				if (butupdate != null) {
					lbo.suaLoai(maloai, tenloai);
				} else {
					String ml = request.getParameter("ml");
					String tab = request.getParameter("tab");
					if (ml != null && tab.equals("select")) {
						lbo.Tim(ml);
						request.setAttribute("maloaisua", ml);
						request.setAttribute("tenloaisua", lbo.Tim(ml));
					}
					if (ml != null && tab.equals("delete")) {
						lbo.xoaLoai(ml);
					}
				}
			}
			request.setAttribute("ds", lbo.getloai());
			RequestDispatcher rd = request.getRequestDispatcher("adminloai.jsp");
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
