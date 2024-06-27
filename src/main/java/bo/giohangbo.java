package bo;

import java.util.ArrayList;

import bean.giohangbean;

public class giohangbo {
	public ArrayList<giohangbean> ds = new ArrayList<giohangbean>();

	public void Them(String MaAoQuan, String TenAoQuan, long Gia, long SoLuongMua, String Anh) throws Exception {

		// kiem tra hang da co chua, ne co thi tang sl
		for (giohangbean h : ds) {
			if (h.getMaAoQuan().equals(MaAoQuan)) {
				h.setSoLuongMua(h.getSoLuongMua() + SoLuongMua);
				return;
			}
		}
		giohangbean g = new giohangbean(MaAoQuan, TenAoQuan, Gia, SoLuongMua, Anh);
		ds.add(g);
	}

	public void Xoa(String MaAoQuan) throws Exception {
		int n = ds.size();
		for (int i = 0; i < n; i++) {
			if (ds.get(i).getMaAoQuan().equals(MaAoQuan)) {
				ds.remove(i);
				return;
			}
		}
	}

	public void Sua(String MaAoQuan, long slmoi) throws Exception {
		int n = ds.size();
		for (int i = 0; i < n; i++) {
			if (ds.get(i).getMaAoQuan().equals(MaAoQuan)) {
				giohangbean g = ds.get(i);
				g.setSoLuongMua(slmoi); // sua lai so luong
				ds.set(i, g); // sua lai hang o vi tri i
				return;
			}
		}
	}

	public long Tong() throws Exception {
		long tong = 0;
		for (giohangbean h : ds) {
			tong += h.getThanhTien();
		}
		return tong;
	}
}
