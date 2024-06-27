package bean;

import java.util.Date;

public class aoquanbean {
	private String MaAoQuan;
	private String TenAoQuan;
	private long SoLuong;
	private long gia;
	private String MaLoai;
	private String Size;
	private String Anh;
	private Date NgayNhap;
	public aoquanbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public aoquanbean(String maAoQuan, String tenAoQuan, long soLuong, long gia, String maLoai, String size, String anh,
			Date ngayNhap) {
		super();
		MaAoQuan = maAoQuan;
		TenAoQuan = tenAoQuan;
		SoLuong = soLuong;
		this.gia = gia;
		MaLoai = maLoai;
		Size = size;
		Anh = anh;
		NgayNhap = ngayNhap;
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
	public long getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(long soLuong) {
		SoLuong = soLuong;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public String getMaLoai() {
		return MaLoai;
	}
	public void setMaLoai(String maLoai) {
		MaLoai = maLoai;
	}
	public String getSize() {
		return Size;
	}
	public void setSize(String size) {
		Size = size;
	}
	public String getAnh() {
		return Anh;
	}
	public void setAnh(String anh) {
		Anh = anh;
	}
	public Date getNgayNhap() {
		return NgayNhap;
	}
	public void setNgayNhap(Date ngayNhap) {
		NgayNhap = ngayNhap;
	}
	
	
	
}
