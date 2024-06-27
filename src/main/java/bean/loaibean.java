package bean;

public class loaibean {
	private String MaLoai;
	private String TenLoai;
	public loaibean(String maLoai, String tenLoai) {
		super();
		MaLoai = maLoai;
		TenLoai = tenLoai;
	}
	public loaibean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaLoai() {
		return MaLoai;
	}
	public void setMaLoai(String maLoai) {
		MaLoai = maLoai;
	}
	public String getTenLoai() {
		return TenLoai;
	}
	public void setTenLoai(String tenLoai) {
		TenLoai = tenLoai;
	}
	
}
