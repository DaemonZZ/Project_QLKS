package the.DataTransfer;

public class NhanVien {
	private int iD;
	private String hoTen;
	private String soDT;
	private String taiKhoan;
	private String matKhau;
	private int loai;
	public NhanVien(int iD, String hoTen, String soDT, String taiKhoan, String matKhau, int loai) {
		this.iD = iD;
		this.hoTen = hoTen;
		this.soDT = soDT;
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.loai = loai;
	}
	public NhanVien() {
		this.iD = 0;
		this.hoTen = "";
		this.soDT = "";
		this.taiKhoan = "";
		this.matKhau = "";
		this.loai = 0;
	}
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getSoDT() {
		return soDT;
	}
	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}
	public String getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public int getLoai() {
		return loai;
	}
	public void setLoai(int loai) {
		this.loai = loai;
	}
	
	
}
