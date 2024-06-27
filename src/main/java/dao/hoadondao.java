package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.adminXNHoaDonbean;

//import bean.adminXNHoaDonbean;

public class hoadondao {
	public int themhoadon(long makh, Date ngayMua, Boolean damua) throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "insert into HoaDon(MaKH, NgayMua, DaMua) values(?,?,?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// truyen tham so
		cmd.setLong(1, makh);
		java.sql.Date ngaysql = new java.sql.Date(ngayMua.getTime());
		cmd.setDate(2, ngaysql);
		cmd.setBoolean(3, damua);
		int kq = cmd.executeUpdate();
		System.out.println(kq + "alooooooooooooooooooooooooo");
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public long getMaHoaDon() throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "select max(MaHoaDon) as HDLN from HoaDon";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		long max = 0;
		if (rs.next()) {
			max = rs.getLong(1);
		}
		cmd.close();
		kn.cn.close();
		return max;
	}

	public int SuaHD(long mahd) throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "update HoaDon set DaMua = 1 where MaHoaDon = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// truyen tham so
		cmd.setLong(1, mahd);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public ArrayList<adminXNHoaDonbean> getdsHoaDon() throws Exception {
		ArrayList<adminXNHoaDonbean> dshd = new ArrayList<adminXNHoaDonbean>();
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "select MaHoaDon,KhachHang.MaKH,HoTen,SoDT,NgayMua from hoadon join KhachHang on HoaDon.MaKH=KhachHang.MaKH\r\n"
				+ "where DaMua=0";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			long MaHoaDon = rs.getLong("MaHoaDon");
			long MaKH =rs.getLong("MaKH");
			String HoTen = rs.getString("HoTen");
			String SoDT = rs.getString("SoDT");
			Date NgayMua = rs.getDate("NgayMua");
			dshd.add(new adminXNHoaDonbean(MaHoaDon, MaKH, HoTen, SoDT,NgayMua));
		}
		rs.close();
		cmd.close();
		kn.cn.close();
		return dshd;
	}

	public int xoaQuaHan() throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "delete from HoaDon where DATEDIFF(DAY, NgayMua, GETDATE()) > 15";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// truyen tham so
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}
}
