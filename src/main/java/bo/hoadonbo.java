package bo;

import java.util.ArrayList;
import java.util.Date;

import bean.adminXNHoaDonbean;
//import bean.adminXNHoaDonbean;
import dao.hoadondao;

public class hoadonbo {
	hoadondao hddao = new hoadondao();

	public int themhoadon(long makh, Date ngayMua, Boolean damua) throws Exception {
		return hddao.themhoadon(makh, ngayMua, damua);
	}

	public long getMaHoaDon() throws Exception {
		return hddao.getMaHoaDon();
	}

	public int SuaHD(long mahd) throws Exception {
		return hddao.SuaHD(mahd);
	}

	public ArrayList<adminXNHoaDonbean> getdsHoaDon() throws Exception {
		return hddao.getdsHoaDon();
	}

	public int xoaQuaHan() throws Exception {
		return hddao.xoaQuaHan();
	}
}
