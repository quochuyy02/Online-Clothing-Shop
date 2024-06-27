package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.khachhangbean;

public class khachhangdao {

	public khachhangbean ktdn(String dn, String password) throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "select * from KhachHang where TenDN = ? and MatKhau =?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// truyen tham so
		cmd.setString(1, dn);
		cmd.setString(2, password);
		ResultSet rs = cmd.executeQuery();
		khachhangbean kh = null;
		if (rs.next()) {
			long makh = rs.getLong("MaKH");
			String hoten = rs.getString("HoTen");
			String diachi = rs.getString("DiaChi");
			String sodt = rs.getString("SoDT");
			String email = rs.getString("Email");
			kh = new khachhangbean(makh, hoten, diachi, sodt, email, dn, password);
		}
		rs.close();
		kn.cn.close();
		return kh;
	}

	public int them(String tendn, String hoten, String diachi, String sodt, String email, String pass)
			throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "select * from KhachHang where TenDN = ?";
		
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// truyen tham so
		cmd.setString(1, tendn);

		ResultSet rs = cmd.executeQuery();

		if (rs.next()) {
			return 0;
		}
		String insert = "insert into KhachHang(HoTen, DiaChi, SoDT, Email, TenDN, MatKhau) values (?, ?, ?, ?, ?, ?)";
		cmd = kn.cn.prepareStatement(insert);
		cmd.setString(1, hoten);
		cmd.setString(2, diachi);
		cmd.setString(3, sodt);
		cmd.setString(4, email);
		cmd.setString(5, tendn);
		cmd.setString(6, pass);
		System.out.println("dathem");
		return cmd.executeUpdate();
	}
}
