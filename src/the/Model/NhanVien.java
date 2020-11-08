package the.Model;

import java.util.Objects;

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
	
	public NhanVien(int iD, String hoTen, String taiKhoan, int loai) {
		super();
		this.iD = iD;
		this.hoTen = hoTen;
		this.taiKhoan = taiKhoan;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NhanVien nhanVien = (NhanVien) o;
		return iD == nhanVien.iD &&
				loai == nhanVien.loai &&
				Objects.equals(hoTen, nhanVien.hoTen) &&
				Objects.equals(soDT, nhanVien.soDT) &&
				Objects.equals(taiKhoan, nhanVien.taiKhoan) &&
				Objects.equals(matKhau, nhanVien.matKhau);
	}

	@Override
	public int hashCode() {
		return Objects.hash(iD, hoTen, soDT, taiKhoan, matKhau, loai);
	}
}
