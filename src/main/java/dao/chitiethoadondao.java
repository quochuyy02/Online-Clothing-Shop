package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//import bean.adminXacNhanbean;
import dao.ketnoidao;

public class chitiethoadondao {
	public int themchitiethoadon(String maSach, int soLuongMua, long maHoaDon, Boolean damua) throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "insert into ChiTietHoaDon(MaAoQuan, SoLuongMua, MaHoaDon, DaMua) values(?,?,?,?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// truyen tham so
		cmd.setString(1, maSach);
		cmd.setInt(2, soLuongMua);
		cmd.setLong(3, maHoaDon);
		cmd.setBoolean(4, damua);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public int Sua(long mact) throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "update ChiTietHoaDon set DaMua = 1 where MaChiTietHD = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// truyen tham so
		cmd.setLong(1, mact);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public int SuaTheoMaHD(long mahd) throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "update ChiTietHoaDon set DaMua = 1 where MaHoaDon = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// truyen tham so
		cmd.setLong(1, mahd);
		cmd.executeUpdate();;
		cmd.close();
		kn.cn.close();
		return 1;
	}

//	public ArrayList<adminXacNhanbean> getdsXacNhan() throws Exception {
//		ArrayList<adminXacNhanbean> dsxn = new ArrayList<adminXacNhanbean>();
//		ketnoidao kn = new ketnoidao();
//		kn.ketnoi();
//		String sql = "select * from VAdminXacNhan";
//		PreparedStatement cmd = kn.cn.prepareStatement(sql);
//		ResultSet rs = cmd.executeQuery();
//
//		while (rs.next()) {
//			long MaChiTietHD = rs.getLong("MaChiTietHD");
//			String hoten = rs.getString("hoten");
//			String tensach = rs.getString("tensach");
//			long gia = rs.getLong("gia");
//			int SoLuongMua = rs.getInt("SoLuongMua");
//			long thanhtien = rs.getLong("thanhtien");
//			boolean damua = rs.getBoolean("damua");
//			dsxn.add(new adminXacNhanbean(MaChiTietHD, hoten, tensach, gia, SoLuongMua, thanhtien, damua));
//		}
//
//		rs.close();
//		cmd.close();
//		kn.cn.close();
//		return dsxn;
//	}

}
