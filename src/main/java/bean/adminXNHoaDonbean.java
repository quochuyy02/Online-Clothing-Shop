package bean;

import java.util.Date;

public class adminXNHoaDonbean {
	private long MaHoaDon;
	private long MaKH;
	private String HoTen;
	private String SoDT;
	private Date NgayMua;
	public adminXNHoaDonbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public adminXNHoaDonbean(long maHoaDon, long maKH, String hoTen, String soDT, Date ngayMua) {
		super();
		MaHoaDon = maHoaDon;
		MaKH = maKH;
		HoTen = hoTen;
		SoDT = soDT;
		NgayMua = ngayMua;
	}
	public long getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(long maHoaDon) {
		MaHoaDon = maHoaDon;
	}
	public long getMaKH() {
		return MaKH;
	}
	public void setMaKH(long maKH) {
		MaKH = maKH;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getSoDT() {
		return SoDT;
	}
	public void setSoDT(String soDT) {
		SoDT = soDT;
	}
	public Date getNgayMua() {
		return NgayMua;
	}
	public void setNgayMua(Date ngayMua) {
		NgayMua = ngayMua;
	}

	
	
}
