package bo;

import java.util.ArrayList;

import bean.aoquanbean;
import dao.aoquandao;

public class aoquanbo {
	aoquandao aqdao = new aoquandao();
	ArrayList<aoquanbean> ds;

	public ArrayList<aoquanbean> getAoQuan() throws Exception {
		ds = aqdao.getAoQuan();
		return ds;
	}

	// ham de tim ma loai
	public ArrayList<aoquanbean> TimMa(String maloai) throws Exception {
		ArrayList<aoquanbean> tam = new ArrayList<aoquanbean>();
		for (aoquanbean s : ds) {
			if (s.getMaLoai().equals(maloai)) {
				tam.add(s);
			}

		}
		return tam;
	}


	public ArrayList<aoquanbean> Tim(String key) throws Exception {
		ArrayList<aoquanbean> tam = new ArrayList<aoquanbean>();
		for (aoquanbean s : ds) {
			if (s.getTenAoQuan().toLowerCase().contains(key.toLowerCase())
					|| s.getSize().toLowerCase().contains(key.toLowerCase())) {
				tam.add(s);
			}

		}
		return tam;
	}
	public int xoaAoQuan(String maaoquan) throws Exception {
		return aqdao.xoaAoQuan(maaoquan);
		
	}
	public int suaAoQuan(String maaoquan, String tenaoquan, String soluong, String gia, String maloai, String size,
			String anh, String ngaynhap) throws Exception { 
		return aqdao.suaAoQuan(maaoquan, tenaoquan, soluong, gia, maloai, size, anh, ngaynhap);
		
	}
	public int themAoQuan(String maaoquan, String tenaoquan, String soluong, String gia, String maloai, String size,
			String anh, String ngaynhap) throws Exception { 
		return aqdao.themAoQuan(maaoquan, tenaoquan, soluong,gia, maloai, size, anh, ngaynhap);
		
	}
}
