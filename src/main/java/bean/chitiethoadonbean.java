package bean;

public class chitiethoadonbean {
	private long MaChiTietHD;
	private String MaAoQuan;
	private long SoLuongMua;
	private long MaHoaDon;
	private Boolean DaMua;
	public chitiethoadonbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public chitiethoadonbean(long maChiTietHD, String maAoQuan, long soLuongMua, long maHoaDon, Boolean daMua) {
		super();
		MaChiTietHD = maChiTietHD;
		MaAoQuan = maAoQuan;
		SoLuongMua = soLuongMua;
		MaHoaDon = maHoaDon;
		DaMua = daMua;
	}

	public long getMaChiTietHD() {
		return MaChiTietHD;
	}
	public void setMaChiTietHD(long maChiTietHD) {
		MaChiTietHD = maChiTietHD;
	}
	public String getMaAoQuan() {
		return MaAoQuan;
	}
	public void setMaAoQuan(String maAoQuan) {
		MaAoQuan = maAoQuan;
	}
	public long getSoLuongMua() {
		return SoLuongMua;
	}
	public void setSoLuongMua(long soLuongMua) {
		SoLuongMua = soLuongMua;
	}
	public long getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(long maHoaDon) {
		MaHoaDon = maHoaDon;
	}
	public Boolean getDaMua() {
		return DaMua;
	}
	public void setDaMua(Boolean daMua) {
		DaMua = daMua;
	}
	
	
}
