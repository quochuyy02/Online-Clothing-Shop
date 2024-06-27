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

import bean.giohangbean;
import bo.giohangbo;
import bo.loaibo;

/**
 * Servlet implementation class gioController
 */
@WebServlet("/gioController")
public class gioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			loaibo lbo = new loaibo();
			request.setAttribute("dsloai", lbo.getloai());

			request.setCharacterEncoding("utf-8");// gá»­i dá»¯ liá»‡u lÃªn kiá»ƒu unicode
			response.setCharacterEncoding("utf-8");// nháº­n dá»¯ liá»‡u vá»� kiá»ƒu unicode

			String ms = request.getParameter("ms");
			String ts = request.getParameter("ts");
			String gia = request.getParameter("gia");
			String anh = request.getParameter("anh");

			HttpSession session = request.getSession();

			if (ts != null && ms != null && gia != null && anh != null) {
				giohangbo gh = null;
				ArrayList<giohangbean> dsgio = null;
				if (session.getAttribute("dsgio") == null) {
					gh = new giohangbo();
					session.setAttribute("gh", gh);
					dsgio = gh.ds;
					session.setAttribute("dsgio", dsgio);
				}
				gh = (giohangbo) session.getAttribute("gh");
				dsgio = (ArrayList<giohangbean>) session.getAttribute("dsgio");
				long g = Long.parseLong(gia);
				gh.Them(ms, ts, g, 1, anh);
				dsgio = gh.ds;
				session.setAttribute("dsgio", dsgio);
				// session.setAttribute("gh", gh);

				session.setAttribute("tong", (long) gh.Tong());
				response.sendRedirect("gioController");
			}

			// xoa tung cai
			String btnXoa = request.getParameter("xoa");
			if (btnXoa != null) {
				giohangbo gh = (giohangbo) session.getAttribute("gh");
				ArrayList<giohangbean> dsgio = (ArrayList<giohangbean>) session.getAttribute("dsgio");
				gh.Xoa(btnXoa);

				dsgio = gh.ds;
				session.setAttribute("dsgio", dsgio);
				session.setAttribute("tong", (long) gh.Tong());
			}

			// xoa all
			String btnXoaAll = request.getParameter("txtxoaall");
			if (btnXoaAll != null) {
				session.removeAttribute("gh");
				session.removeAttribute("dsgio");
			}

			// xoa chon
			String[] btnXoaChon = request.getParameterValues("txtBox");
			if (btnXoaChon != null) {
				giohangbo gh = (giohangbo) session.getAttribute("gh");
				ArrayList<giohangbean> dsgio = (ArrayList<giohangbean>) session.getAttribute("dsgio");
				int n = btnXoaChon.length;
				for (int i = 0; i < n; i++) {
					gh.Xoa(btnXoaChon[i]);
				}
				dsgio = gh.ds;
				session.setAttribute("dsgio", dsgio);
			}

			// sua
			String maSachSua = request.getParameter("maSachSua");
			String sua = request.getParameter("txtSua");
			if (sua != null && maSachSua != null) {
				giohangbo gh = (giohangbo) session.getAttribute("gh");
				ArrayList<giohangbean> dsgio = (ArrayList<giohangbean>) session.getAttribute("dsgio");

				gh.Sua(maSachSua, Long.parseLong(sua));
				session.setAttribute("gh", gh);
				dsgio = gh.ds;
				session.setAttribute("dsgio", dsgio);

				session.setAttribute("tong", gh.Tong());
			}
			// ktra lan dau
			if (session.getAttribute("dsgio") == null || ((long) session.getAttribute("tong")) == 0) {
				response.sendRedirect("aoquanController");
			}
			RequestDispatcher rd = request.getRequestDispatcher("htgio.jsp");
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
