package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bean.aoquanbean;

public class aoquandao {
	public ArrayList<aoquanbean> getAoQuan() throws Exception {
		ArrayList<aoquanbean> ds = new ArrayList<aoquanbean>();
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "select * from AoQuan";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			String MaAoQuan = rs.getString("MaAoQuan");
			String TenAoQuan = rs.getString("TenAoQuan");
			long SoLuong = rs.getLong("SoLuong");
			long Gia = rs.getLong("Gia");
			String MaLoai = rs.getString("MaLoai");
			String Size = rs.getString("Size");
			String Anh = rs.getString("Anh");
			Date NgayNhap = rs.getDate("NgayNhap");
			ds.add(new aoquanbean(MaAoQuan, TenAoQuan, SoLuong, Gia, MaLoai, Size, Anh, NgayNhap));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}

	public int xoaAoQuan(String maaoquan) throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "delete from AoQuan where MaAoQuan = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, maaoquan);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public int suaAoQuan(String maaoquan, String tenaoquan, String soluong, String gia, String maloai, String size,
			String anh, String ngaynhap) throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "update AoQuan set TenAoQuan = ?,SoLuong= ?,Gia=?,MaLoai=?,Size=?, Anh=? where MaAoQuan = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(7, maaoquan);
		cmd.setString(1, tenaoquan);
		cmd.setLong(2, Long.parseLong(soluong));
		cmd.setLong(3, Long.parseLong(gia));
		cmd.setLong(4, Long.parseLong(maloai));
		cmd.setString(5, size);
		cmd.setString(6, anh);

		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public int themAoQuan(String maAoQuan, String tenAoQuan, String soLuong, String gia, String maLoai, String size,
			String anh, String ngayNhap) throws Exception {

		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "insert into AoQuan (MaAoQuan,TenAoQuan, SoLuong,Gia,MaLoai,Size,Anh,NgayNhap) values(?, ?,?,?,?,?,?,?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, maAoQuan);
		cmd.setString(2, tenAoQuan);
		cmd.setLong(3, Long.parseLong(soLuong));
		cmd.setLong(4, Long.parseLong(gia));
		cmd.setString(5, maLoai);
		cmd.setString(6, size);
		cmd.setString(7, anh);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date parsed = format.parse(ngayNhap);
		java.sql.Date datesql = new java.sql.Date(parsed.getTime());
		cmd.setDate(8, datesql);

		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}
}
