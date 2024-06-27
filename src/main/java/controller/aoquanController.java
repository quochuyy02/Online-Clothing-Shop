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

import bean.aoquanbean;
import bean.loaibean;
import bo.aoquanbo;
import bo.loaibo;

/**
 * Servlet implementation class aoquanController
 */
@WebServlet("/aoquanController")
public class aoquanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public aoquanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			// Dat cau hinh gui len va lay ve =utf-8

			HttpSession session = request.getSession();
			request.setCharacterEncoding("utf-8");// gá»­i dá»¯ liá»‡u lÃªn kiá»ƒu unicode
			response.setCharacterEncoding("utf-8");// nháº­n dá»¯ liá»‡u vá»� kiá»ƒu unicode

			// sai loaibo lay ve dsloai
			loaibo lbo = new loaibo();
			ArrayList<loaibean> dsloai = lbo.getloai();

			// sai sachbo lay ve dssach
			aoquanbo sbo = new aoquanbo();
			ArrayList<aoquanbean> ds = sbo.getAoQuan();

			String ml = request.getParameter("ml");
			String key = request.getParameter("txttim");
			if (ml != null) {
				ds = sbo.TimMa(ml);
			} else {
				if (key != null) {
					ds = sbo.Tim(key);
				}
			}

			// chuyen dsloai va dssach ve ht.sach
			request.setAttribute("dsaoquan", ds);
			request.setAttribute("dsloai", dsloai);
			RequestDispatcher rd = request.getRequestDispatcher("htaoquan.jsp");
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
