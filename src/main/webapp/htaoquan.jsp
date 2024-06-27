<%@page import="bean.loaibean"%>
<%@page import="bean.aoquanbean"%>
<%@page import="bean.khachhangbean"%>
<%@page import="bean.giohangbean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<title>Clothing</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<link rel="stylesheet"
	href="htaoquan.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
body {
	margin: auto
}
</style>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="aoquanController">Trang chủ</a>
			</div>
			<ul class="nav navbar-nav">
				<%
				/* giohangbo gh = null;
				if(session.getAttribute("gh") == null){
					gh = new giohangbo();
					session.setAttribute("gh", gh);
				}
				gh = (giohangbo) session.getAttribute("gh");
				int a = gh.ds.size(); */

				int a;
				if (session.getAttribute("dsgio") == null) {
					a = 0;
				} else {
					ArrayList<giohangbean> dsgio = (ArrayList<giohangbean>) session.getAttribute("dsgio");
					a = dsgio.size();
				}
				%>
				<li class="active"><a href="gioController">Giỏ hàng (<%=a%>)
				</a></li>
				<li class="active"><a href="thanhtoanController">Xác nhận
						mua</a></li>
				<li class="active"><a href="lichsuController">Lịch sử mua
						hàng</a></li>


			</ul>
			<ul class="nav navbar-nav navbar-right">

				<%
				khachhangbean tk = (khachhangbean) session.getAttribute("dn");
				if (tk != null) {
				%>

				<li><a href="#" style="color: white; cursor: default;"> Xin
						chào <%=tk.getHoTen()%></a></li>
				<li><a href="dangxuatController"> Đăng xuất</a></li>
				<%
				} else {
				%>
				<li><button type="button" class="btn btn-info btn-lg"
						data-toggle="modal" data-target="#dangky">Đăng ký</button> <!-- Modal đăng ký-->
					<div class="modal fade" id="dangky" role="dialog">
						<div class="modal-dialog">

							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>

									<h4 class="modal-title">Đăng ký</h4>
								</div>
								<div class="modal-body">
									<form action="dangkyController" method="post">
										<label>Tài khoản:</label><br> <input type="text"
											name="txttk"><br> <label>Họ tên:</label><br>
										<input type="text" name="txtht"><br> <label>Địa
											chỉ:</label><br> <input type="text" name="txtdc"><br>
										<label>Số điện thoại:</label><br> <input type="text"
											name="txtsdt"><br> <label>email:</label><br>
										<input type="text" name="txtemail"><br> <label>Mật
											khẩu:</label><br> <input type="password" name="txtmk"><br>
								</div>
								<div class="modal-footer">
									<input type="submit" value="Xác nhận" class="btn btn-primary">
									</form>
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
								</div>
							</div>

						</div>
					</div></li>
				</li>
				<li><button type="button" class="btn btn-info btn-lg"
						data-toggle="modal" data-target="#myModal">Đăng nhập</button> <!-- Modal đăng nhập-->
					<div class="modal fade" id="myModal" role="dialog">
						<div class="modal-dialog">

							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title">Đăng nhập</h4>
								</div>
								<div class="modal-body">
									<form action="dangnhapController" method="post">
										<label>Tài khoản:</label><br> <input type="text"
											name="txttk"><br> <label>Mật khẩu:</label><br>
										<input type="password" name="txtmk"><br>
								</div>
								<div class="modal-footer">
									<input type="submit" value="Xác nhận" class="btn btn-primary">
									</form>
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
								</div>
							</div>

						</div>
					</div></li>


				<%
				}
				%>


			</ul>
		</div>
	</nav>
	<%
	if (session.getAttribute("kt") != null) {
	%>
	<%
	int result = (int) session.getAttribute("kt");
	if (result == 1) {
		
	%>
	<div class="container">
		<div class="alert alert-success alert-dismissible fade in">
			<a href="aoquanController" class="close" data-dismiss="alert"
				aria-label="close">&times;</a> Đăng ký thành công
		</div>
	</div>
	<%
	} else {
	%>
	<div class="container">
		<div class="alert alert-danger alert-dismissible fade in">
			<a href="aoquanController" class="close" data-dismiss="alert"
				aria-label="close">&times;</a> Tài khoản đã có người sử dụng
		</div>
	</div>
	<%
	}
	%>
	<%
	session.removeAttribute("kt");
	}
	%>
	<div class="row">
		<div class="col-lg-3">
			<div class="list-group-item">
				<%
				ArrayList<loaibean> dsloai = (ArrayList<loaibean>) request.getAttribute("dsloai");
				for (loaibean loai : dsloai) {
				%>
				<div class="list-group-item">
					<a href="aoquanController?ml=<%=loai.getMaLoai()%>"> <%=loai.getTenLoai()%>
					</a>
				</div>
				<%
				}
				%>
			</div>
		</div>
		<div class="col-lg-6">
			<div class="clothing-ctn">
				<%
				//sach_bo sbo = new sach_bo();

				//<aoquanbean> ds = sbo.getsach();

				/* 	String ml = request.getParameter("ml");
					 key = request.getParameter("txttim");
					if (ml != null) {
						ds = sbo.TimMa(ml);
					} else {
						if (key != null) {
					ds = sbo.Tim(key);
						}
					} */
				//lay dssach
				ArrayList<aoquanbean> dssach = (ArrayList<aoquanbean>) request.getAttribute("dsaoquan");
				int n = dssach.size();
				for (int i = 0; i < n; i++) {
					aoquanbean s = dssach.get(i);
				%>

				<div class="clothing-item">
					<img src="<%=s.getAnh()%>" width="150" height="150">
					<h5>
						<%=s.getTenAoQuan()%></h5>
					<h6><%=s.getGia()%>$
					</h6>
					<a
						href="gioController?ms=<%=s.getMaAoQuan()%>&ts=<%=s.getTenAoQuan()%>&gia=<%=s.getGia()%>&anh=<%=s.getAnh()%>">
						Đặt mua
					</a>
				</div>



				<%
				}
				%>
			</div>
		</div>

		<div class="col-lg-3">
			<form action="aoquanController" method="post">
				<input type="text" name="txttim" placeholder="Whap key"
					class="form-control"> <input type="submit" name="th"
					value="Search" class="btn btn-primary form-control">
			</form>

		</div>
	</div>
</body>
</html>