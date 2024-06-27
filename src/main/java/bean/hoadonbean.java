package bean;

import java.util.Date;

public class hoadonbean {
	private long MaHoaDon;
	private String MaKH;
	private Date NgayMua;
	private Boolean DaMua;
	public hoadonbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public hoadonbean(long maHoaDon, String maKH, Date ngayMua, Boolean daMua) {
		super();
		MaHoaDon = maHoaDon;
		MaKH = maKH;
		NgayMua = ngayMua;
		DaMua = daMua;
	}

	public long getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(long maHoaDon) {
		MaHoaDon = maHoaDon;
	}
	public String getMaKH() {
		return MaKH;
	}
	public void setMaKH(String maKH) {
		MaKH = maKH;
	}
	public Date getNgayMua() {
		return NgayMua;
	}
	public void setNgayMua(Date ngayMua) {
		NgayMua = ngayMua;
	}
	public Boolean getDaMua() {
		return DaMua;
	}
	public void setDaMua(Boolean daMua) {
		DaMua = daMua;
	}
	
	
	
}
