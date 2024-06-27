package bo;

import bean.khachhangbean;
import dao.khachhangdao;

public class khachhangbo {
	khachhangdao khdao = new khachhangdao();

	public khachhangbean ktdn(String ten, String pass) throws Exception {
		return khdao.ktdn(ten, pass);
	}

	public int kttontai(String tendn, String hoten, String diachi, String sodt, String email, String pass)
			throws Exception {
		return khdao.them(tendn, hoten, diachi, sodt, email, pass);
	}
}
