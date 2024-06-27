package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.adminDangNhapbean;
import bo.adminDangNhapBo;

/**
 * Servlet implementation class adminDangNhap
 */
@WebServlet("/adminDangNhap")
public class adminDangNhap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminDangNhap() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			adminDangNhapBo adminDNbo = new adminDangNhapBo();
			HttpSession session = request.getSession();
			if (session.getAttribute("admindn")!=null) {
				session.setAttribute("dtthang", adminDNbo.getDoanhThuThang());
				session.setAttribute("dtnam", adminDNbo.getDoanhThuNam());
				session.setAttribute("donchuaxn",adminDNbo.getSoHoaDonChuaXN());
				session.setAttribute("tkdt", adminDNbo.getTKDT());
				RequestDispatcher rd = request.getRequestDispatcher("trangchuAdmin.jsp");
				rd.forward(request, response);
			}
			String tk = request.getParameter("txttk");
			String mk = request.getParameter("txtmk");
		

			if (tk == null && mk == null) {
				RequestDispatcher rd = request.getRequestDispatcher("dangnhapadmin.jsp");
				rd.forward(request, response);

			} else {
				
				if (adminDNbo.getAdmin(tk, mk) != null) {
					adminDangNhapbean adminDNbean = adminDNbo.getAdmin(tk, mk);
					
				
					session.setAttribute("dtthang", adminDNbo.getDoanhThuThang());
					session.setAttribute("dtnam", adminDNbo.getDoanhThuNam());
					session.setAttribute("donchuaxn",adminDNbo.getSoHoaDonChuaXN());
					session.setAttribute("admindn", adminDNbean);
					session.setAttribute("tkdt", adminDNbo.getTKDT());
					System.out.println(adminDNbo.getTKDT());
					RequestDispatcher rd = request.getRequestDispatcher("trangchuAdmin.jsp");
					rd.forward(request, response);
				} else {
					response.sendRedirect("adminDangNhap");
				}
			}
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
