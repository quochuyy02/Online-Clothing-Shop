package bo;

import java.util.ArrayList;

//import bean.adminXacNhanbean;
import dao.chitiethoadondao;

public class chitiethoadonbo {
	chitiethoadondao cthddao = new chitiethoadondao();

	public int themchitiethoadon(String maSach, int soLuongMua, long maHoaDon, Boolean damua) throws Exception {
		return cthddao.themchitiethoadon(maSach, soLuongMua, maHoaDon, damua);
	}

	public int Sua(long mact) throws Exception {
		return cthddao.Sua(mact);
	}

	public int SuaTheoMaHD(long mahd) throws Exception {
		return cthddao.SuaTheoMaHD(mahd);
	}

//	public ArrayList<adminXacNhanbean> getdsXacNhan() throws Exception {
//		return cthddao.getdsXacNhan();
//	}
}
