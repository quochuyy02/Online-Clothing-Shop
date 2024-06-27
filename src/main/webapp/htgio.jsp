<%@page import="bean.loaibean"%>
<%@page import="bean.khachhangbean"%>

<%@page import="bean.giohangbean"%>

<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
				<li class="active"><a href="thanhtoanController">Thanh toán</a></li>
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
						data-toggle="modal" data-target="#dangkygio">Đăng ký</button> <!-- Modal đăng ký-->
					<div class="modal fade" id="dangkygio" role="dialog">
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
						data-toggle="modal" data-target="#dangnhapgio">Đăng nhập</button>
					<!-- Modal đăng nhập-->
					<div class="modal fade" id="dangnhapgio" role="dialog">
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
	<%if(session.getAttribute("kt") != null){ %>
	<%int result = (int) session.getAttribute("kt"); 
	if(result == 1){
	%>
	<div class="container">
		<div class="alert alert-success alert-dismissible fade in">
			<a href="aoquanController" class="close" data-dismiss="alert"
				aria-label="close">&times;</a> Đăng ký thành công
		</div>
	</div>
	<%}else{ %>
	<div class="container">
		<div class="alert alert-danger alert-dismissible fade in">
			<a href="aoquanController" class="close" data-dismiss="alert"
				aria-label="close">&times;</a> Tài khoản đã có người sử dụng
		</div>
	</div>
	<%} %>
	<%} %>
	</nav>
	<div class="container ">
		<div class="table-responsive-sm">

			<table align="center" class="row">
				<tr>
					<td valign="top" class="col-sm-2 col-xs-1">
						<table class="table table-hover ">
							<%
					ArrayList<loaibean> dsloai = (ArrayList<loaibean>) request.getAttribute("dsloai");
					for (loaibean loai : dsloai) {
					%>
							<tr>
								<td><a href="aoquanController?ml=<%=loai.getMaLoai()%>">
										<%=loai.getTenLoai()%>
								</a></td>
							</tr>
							<%
					}
					%>

						</table>
					</td>

					<td valign="top" class="col-sm-8 col-xs-10">
						<table class="table">
							<%
					
					String xoa = request.getParameter("btnXoa");
					%>
							<%
								//giohangbo gh = null;
								//gh = (giohangbo) session.getAttribute("gh");
								ArrayList<giohangbean> dsgio = (ArrayList<giohangbean>) session.getAttribute("dsgio");
								/* if(gh.ds.size() == 0){
									response.sendRedirect("aoquanController");
								} */
								
								%>
							<form action="gio.jsp" method="post">
								<input type="submit" name="btnXoaTungPhan" value="Xóa chọn">
								<%
								for(giohangbean h : dsgio){ %>
								<tr>
									<td><input type="checkbox" name="txtCheckBox"
										value=<%=h.getMaAoQuan()%>>
							</form>
							<img src="<%=h.getAnh()%>" width="100" height="100">
							</td>
							<td><%=h.getMaAoQuan()%></td>
							<td><%=h.getTenAoQuan()%></td>
							<td><%=h.getGia()%></td>
							<form action="gioController?maSachSua=<%=h.getMaAoQuan() %>"
								method="post">
								<td><input type="number" name="txtSua"
									value=<%=h.getSoLuongMua()%> style="width: 40px" min="1">
								</td>
								<td><input type="submit" value="Sửa"></td>
							</form>

							<td><%=h.getThanhTien() %></td>

							<td><a href="gioController?xoa=<%=h.getMaAoQuan()%>"
								class="btn btn-primary">Xóa</a></td>

							</tr>
							<%}%>
							<tr>
								<td>Tổng tiền: <%=session.getAttribute("tong") %></td>
							</tr>

						</table>
						<form action="gioController">
							<input type="submit" name="txtxoaall" value="Xóa all">
						</form>
						<form action="xacnhanController">

							<%if(tk == null){ %>
							<button type="button" data-toggle="modal"
								data-target="#dangnhapgio">Xác nhận</button>
							<%}else{ %>
							<input type="submit" name="txtxacnhan" value="Xác nhận">
							<%} %>
						</form>
					</td>
					<td valign="top" class="col-sm-2 col-xs-1">

						<form action="aoquanController" method="post">
							<input type="text" name="txttim" placeholder="Whap key"
								class="form-control"> <input type="submit" name="th"
								value="Search" class="btn btn-primary form-control">
						</form>
					</td>
				</tr>
			</table>
		</div>

	</div>
</body>
</html>

