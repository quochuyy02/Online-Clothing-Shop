package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.giohangbean;
import bean.khachhangbean;
import bo.chitiethoadonbo;
import bo.hoadonbo;

/**
 * Servlet implementation class xacnhanController
 */
@WebServlet("/xacnhanController")
public class xacnhanController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public xacnhanController() {
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
			String xacnhan = request.getParameter("txtxacnhan");
			if (xacnhan != null) {

				khachhangbean kh = (khachhangbean) session.getAttribute("dn");
				if (kh != null) {
					ArrayList<giohangbean> dsgio = (ArrayList<giohangbean>) session.getAttribute("dsgio");
					Date a = new Date();
					SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
					String ns = f.format(a);
					Date ngayMua = f.parse(ns);
					hoadonbo hdbo = new hoadonbo();
					hdbo.themhoadon(kh.getMaKH(), ngayMua, false);
					long maHD = hdbo.getMaHoaDon();
					chitiethoadonbo cthdbo = new chitiethoadonbo();
					for (giohangbean h : dsgio) {
						cthdbo.themchitiethoadon(h.getMaAoQuan(), (int) h.getSoLuongMua(), maHD, false);
					}
					session.removeAttribute("dsgio");
					response.sendRedirect("lichsuController");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
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
