package bo;

import java.util.ArrayList;

import bean.loaibean;
import dao.loaidao;

public class loaibo {
	loaidao ldao = new loaidao();
	ArrayList<loaibean> ds;

	public ArrayList<loaibean> getloai() throws Exception {
		ds = ldao.getloai();
		return ds;
	}

	public int themLoai(String maloai, String tenloai) throws Exception {
		for (loaibean loai : ds) {
			if (loai.getMaLoai().equals(maloai)) {
				return 0;
			}
		}
		return ldao.themLoai(maloai, tenloai);
	}

	public String Tim(String maloai) throws Exception {
		for (loaibean loai : ds) {
			if (loai.getMaLoai().equals(maloai)) {
				return loai.getTenLoai();
			}
		}
		return null;
	}

	public int xoaLoai(String maloai) throws Exception {
		return ldao.xoaLoai(maloai);
	}

	public int suaLoai(String maloai, String tenloai) throws Exception {
		return ldao.suaLoai(maloai, tenloai);
	}
}
