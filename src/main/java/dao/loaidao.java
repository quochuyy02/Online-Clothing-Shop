package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.loaibean;

public class loaidao {
	public ArrayList<loaibean> getloai() throws Exception {
		ArrayList<loaibean> ds = new ArrayList<loaibean>();
		// b1: ket noi vao csdl
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		// b2: tao cau lenh sql
		String sql = "select * from LoaiAoQuan";
		// b3: tao cau lenh prepareStatement
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// b4: thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		// b5 Duyet rs de luu vao mang ds
		while (rs.next()) {
			String maloai = rs.getString("maloai");
			String tenloai = rs.getString("tenloai");
			ds.add(new loaibean(maloai, tenloai));
		}
		// b6: dong ket noi rs
		rs.close();
		kn.cn.close();
		return ds;
	}

	public int themLoai(String maloai, String tenloai) throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "insert into LoaiAoQuan (maloai,tenloai) values(?, ?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		cmd.setString(2, tenloai);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public int xoaLoai(String maloai) throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "delete from LoaiAoQuan where MaLoai = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public int suaLoai(String maloai, String tenloai) throws Exception {
		ketnoidao kn = new ketnoidao();
		kn.ketnoi();
		String sql = "update LoaiAoQuan set tenloai = ? where maloai = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, tenloai);
		cmd.setString(2, maloai);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}
}
