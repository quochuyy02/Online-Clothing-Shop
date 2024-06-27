package bean;

public class giohangbean {
	private String MaAoQuan;
	private String TenAoQuan;
	private long Gia;
	private long SoLuongMua;
	private String Anh;
	private long ThanhTien;
	public giohangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public giohangbean(String maAoQuan, String tenAoQuan, long gia, long soLuongMua, String anh) {
		super();
		MaAoQuan = maAoQuan;
		TenAoQuan = tenAoQuan;
		Gia = gia;
		SoLuongMua = soLuongMua;
		Anh = anh;
		ThanhTien = SoLuongMua * Gia;
	}
	public String getMaAoQuan() {
		return MaAoQuan;
	}
	public void setMaAoQuan(String maAoQuan) {
		MaAoQuan = maAoQuan;
	}
	public String getTenAoQuan() {
		return TenAoQuan;
	}
	public void setTenAoQuan(String tenAoQuan) {
		TenAoQuan = tenAoQuan;
	}
	public long getGia() {
		return Gia;
	}
	public void setGia(long gia) {
		Gia = gia;
	}
	public long getSoLuongMua() {
		return SoLuongMua;
	}
	public void setSoLuongMua(long soLuongMua) {
		SoLuongMua = soLuongMua;
	}
	public String getAnh() {
		return Anh;
	}
	public void setAnh(String anh) {
		Anh = anh;
	}
	public long getThanhTien() {
		return SoLuongMua*Gia;
	}
	public void setThanhTien(long thanhTien) {
		ThanhTien = thanhTien;
	}
	
	
}
