package bean;

import java.util.Date;

public class lichsubean {
	private String MaAoQuan;
	private String TenAoQuan;
	private long SoLuongMua;
	private long Gia;
	private long MaKH;
	private long ThanhTien;
	private Date NgayMua;
	private Boolean DaMua;
	private String Anh;
	public lichsubean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public lichsubean(String maAoQuan, String tenAoQuan, long soLuongMua, long gia, long maKH, long thanhTien,
			Date ngayMua, Boolean daMua, String anh) {
		super();
		MaAoQuan = maAoQuan;
		TenAoQuan = tenAoQuan;
		SoLuongMua = soLuongMua;
		Gia = gia;
		MaKH = maKH;
		ThanhTien = thanhTien;
		NgayMua = ngayMua;
		DaMua = daMua;
		Anh = anh;
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
	public long getSoLuongMua() {
		return SoLuongMua;
	}
	public void setSoLuongMua(long soLuongMua) {
		SoLuongMua = soLuongMua;
	}
	public long getGia() {
		return Gia;
	}
	public void setGia(long gia) {
		Gia = gia;
	}
	public long getMaKH() {
		return MaKH;
	}
	public void setMaKH(long maKH) {
		MaKH = maKH;
	}
	public long getThanhTien() {
		return ThanhTien;
	}
	public void setThanhTien(long thanhTien) {
		ThanhTien = thanhTien;
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
	public String getAnh() {
		return Anh;
	}
	public void setAnh(String anh) {
		Anh = anh;
	}
	
	
	
}
