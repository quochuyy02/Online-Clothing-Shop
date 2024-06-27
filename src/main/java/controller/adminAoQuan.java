package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.aoquanbean;
import bean.loaibean;
import bo.aoquanbo;
import bo.loaibo;

/**
 * Servlet implementation class adminAoQuan
 */
@WebServlet("/adminAoQuan")
public class adminAoQuan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public adminAoQuan() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (session.getAttribute("admindn")==null) response.sendRedirect("adminDangNhap");
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String maaoquan = request.getParameter("txtmaaq");
			String tenaoquan = request.getParameter("txttenaq");
			String soluong = request.getParameter("txtsl");
			String gia = request.getParameter("txtgia");
			String maloai = request.getParameter("txtmaloai");
			String size = request.getParameter("txtsize");
			String anh = request.getParameter("txtanh");
			String ngaynhap = request.getParameter("txtngaynhap");

			String butadd = request.getParameter("butadd");
			String butupdate = request.getParameter("butupdate");

			aoquanbo aqbo = new aoquanbo();
			ArrayList<aoquanbean> ds = aqbo.getAoQuan();
			DiskFileItemFactory factory = new DiskFileItemFactory();
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
			String dirUrl1 = request.getServletContext().getRealPath("") + File.separator + "files";
			response.getWriter().println(dirUrl1);

			try {
				List<FileItem> fileItems = upload.parseRequest(request);// Lấy về các đối tượng gửi lên
				// duyệt qua các đối tượng gửi lên từ client gồm file và các control
				for (FileItem fileItem : fileItems) {
					if (!fileItem.isFormField()) {// Nếu ko phải các control=>upfile lên
						// xử lý file
						String nameimg = fileItem.getName();
						if (!nameimg.equals("")) {
							// Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
							String dirUrl = request.getServletContext().getRealPath("") + File.separator + "files";
							File dir = new File(dirUrl);
							if (!dir.exists()) {// nếu ko có thư mục thì tạo ra
								dir.mkdir();
							}
							String fileImg = dirUrl + File.separator + nameimg;
							File file = new File(fileImg);// tạo file
							try {
								fileItem.write(file);// lưu file
								System.out.println("UPLOAD THÀNH CÔNG...!" +nameimg);
								System.out.println("Đường dẫn lưu file là: " + dirUrl);
								anh = "files/"+nameimg;
										
								
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					} else// Neu la control
					{
						String aq = fileItem.getFieldName();
						if (aq.equals("txtmaaq"))
							maaoquan = fileItem.getString();
						if (aq.equals("txttenaq"))
							tenaoquan = fileItem.getString();
						if (aq.equals("txtsl"))
							soluong = fileItem.getString();
						if (aq.equals("txtgia"))
							gia = fileItem.getString();
						if (aq.equals("txtmaloai"))
							maloai = fileItem.getString();
						if (aq.equals("txtsize"))
							size = fileItem.getString();
						if (aq.equals("txtanh"))
							anh = fileItem.getString();
						if (aq.equals("txtngaynhap"))
							ngaynhap = fileItem.getString();
						if (aq.equals("butadd"))
							butadd = fileItem.getString();
						if (aq.equals("butupdate"))
							butupdate = fileItem.getString();
					}
				}

			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			if (butadd != null) {
				aqbo.themAoQuan(maaoquan, tenaoquan, soluong, gia, maloai, size, anh, ngaynhap);
			} else if (butupdate != null) {
				aqbo.suaAoQuan(maaoquan, tenaoquan, soluong, gia, maloai, size, anh, ngaynhap);
			} else {
				// String ml = request.getParameter("ml");
				String tab = request.getParameter("tab");
				if (maaoquan != null && tab.equals("select")) {

					request.setAttribute("maaqsua", maaoquan);
					request.setAttribute("tenaqsua", tenaoquan);
					request.setAttribute("slsua", soluong);
					request.setAttribute("giasua", gia);
					request.setAttribute("maloaisua", maloai);
					request.setAttribute("sizesua", size);
					request.setAttribute("anhsua", anh);
					request.setAttribute("ngaynhapsua", ngaynhap);
				}
				if (maaoquan != null && tab.equals("delete")) {
					System.out.println(maaoquan);
					aqbo.xoaAoQuan(maaoquan);
				}
			}

			request.setAttribute("dsaoquan", aqbo.getAoQuan());
			RequestDispatcher rd = request.getRequestDispatcher("adminaoquan.jsp");
			rd.forward(request, response);

		} catch (

		Exception e) {
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
