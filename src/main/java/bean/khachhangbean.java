package bean;

public class khachhangbean {
	private long MaKH;
	private String HoTen;
	private String DiaChi;
	private String SoDT;
	private String Email;
	private String TenDN;
	private String MatKhau;
	public khachhangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public khachhangbean(long maKH, String hoTen, String diaChi, String soDT, String email, String tenDN,
			String matKhau) {
		super();
		MaKH = maKH;
		HoTen = hoTen;
		DiaChi = diaChi;
		SoDT = soDT;
		Email = email;
		TenDN = tenDN;
		MatKhau = matKhau;
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
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getSoDT() {
		return SoDT;
	}
	public void setSoDT(String soDT) {
		SoDT = soDT;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTenDN() {
		return TenDN;
	}
	public void setTenDN(String tenDN) {
		TenDN = tenDN;
	}
	public String getMatKhau() {
		return MatKhau;
	}
	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}
}
