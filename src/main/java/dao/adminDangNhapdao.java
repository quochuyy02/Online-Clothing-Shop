package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

import bean.adminDangNhapbean;

public class adminDangNhapdao {
	public adminDangNhapbean getAdmin(String tendn, String matkhau) throws Exception {
		adminDangNhapbean admin = null;
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "select  * from DangNhap where TenDangNhap = ? and MatKhau = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, tendn);
		cmd.setString(2, matkhau);
		ResultSet rs = cmd.executeQuery();
		if (rs.next()) {
			String TenDangNhap = rs.getString("TenDangNhap");
			String MatKhau = rs.getString("MatKhau");
			boolean Quyen = rs.getBoolean("Quyen");
			admin = new adminDangNhapbean(TenDangNhap, MatKhau, Quyen);
		}
		rs.close();
		cmd.close();
		kn.cn.close();
		return admin;
	}
	public long getDoanhThuThang() throws Exception {
		
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "select Sum(soluongmua*gia) as doanhthuthang\r\n"
				+ "from ChiTietHoaDon join AoQuan on ChiTietHoaDon.MaAoQuan = AoQuan.MaAoQuan join hoadon on hoadon.MaHoaDon=ChiTietHoaDon.MaHoaDon\r\n"
				+ "where Month(NgayMua) = Month(GETDATE()) and ChiTietHoaDon.DaMua=1";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		long doanhthu = 0;
		if (rs.next()) {
			 doanhthu = rs.getLong("doanhthuthang");
		}
		return doanhthu;
		
	}
	public long getDoanhThuNam() throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "select Sum(soluongmua*gia) as doanhthunam\r\n"
				+ "from ChiTietHoaDon join AoQuan on ChiTietHoaDon.MaAoQuan = AoQuan.MaAoQuan join hoadon on hoadon.MaHoaDon=ChiTietHoaDon.MaHoaDon\r\n"
				+ "where year(NgayMua) = year(GETDATE()) and ChiTietHoaDon.DaMua=1";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		long doanhthu = 0;
		if (rs.next()) {
			 doanhthu = rs.getLong("doanhthunam");
		}
		return doanhthu;
		
	}
	public long getSoHoaDonChuaXN() throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "select count(MaHoaDon) as 'chuaxn' from HoaDon\r\n"
				+ "where DaMua = 0";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		long chuaxn = 0;
		if (rs.next()) {
			 chuaxn = rs.getLong("chuaxn");
		}
		return chuaxn;
	}
	public String getTKDT() throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "select month(NgayMua) as thang,Sum(soluongmua*gia) as doanhthuthang\r\n"
				+ "from ChiTietHoaDon join AoQuan on ChiTietHoaDon.MaAoQuan = AoQuan.MaAoQuan join hoadon on hoadon.MaHoaDon=ChiTietHoaDon.MaHoaDon\r\n"
				+ "where  ChiTietHoaDon.DaMua=1\r\n"
				+ "group by month(NgayMua)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		long doanhthuthang[]= new long[] {0,0,0,0,0,0,0,0,0,0,0,0};
		while (rs.next()) {
			 long thang = rs.getLong("thang");
			 long doanhthu = rs.getLong("doanhthuthang");
			 doanhthuthang[(int) thang-1]=doanhthu;
		}

		return Arrays.toString(doanhthuthang);
	}
}
