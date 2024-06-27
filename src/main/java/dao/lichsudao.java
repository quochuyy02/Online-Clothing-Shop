package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.lichsubean;

public class lichsudao {
	public ArrayList<lichsubean> ds = new ArrayList<lichsubean>();

	public ArrayList<lichsubean> getLichSu(long ma, int check) throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "select * from ChiTietHoaDon join HoaDon on ChiTietHoaDon.MaHoaDon=HoaDon.MaHoaDon\r\n"
				+ "join AoQuan on AoQuan.MaAoQuan=ChiTietHoaDon.MaAoQuan join KhachHang on HoaDon.MaKH=KhachHang.MaKH\r\n"
				+ "where khachhang.MaKH = ? and chitiethoadon.DaMua = ? order by hoadon.MaHoaDon desc";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, ma);
		cmd.setInt(2, check);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			String masach = rs.getString("MaAoQuan");
			String tensach = rs.getString("TenAoQuan");
			int soLuongMua = rs.getInt("SoLuongMua");
			long gia = rs.getLong("Gia");
			long makh = rs.getLong("MaKH");
//			long thanhtien = rs.getLong("thanhtien");
			Date NgayMua = rs.getDate("NgayMua");
			Boolean damua = rs.getBoolean("DaMua");
			String anh = rs.getString("Anh");
			lichsubean ls = new lichsubean(masach, tensach, soLuongMua, gia, makh, soLuongMua*gia, NgayMua, damua, anh);
			ds.add(ls);
			System.out.println("da them lich su");
		}
		rs.close();
		cmd.close();
		kn.cn.close();
		return ds;
	}
}
