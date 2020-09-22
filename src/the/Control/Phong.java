package the.Control;

public class Phong {
	private String maPhong;
	private int tang;
	private int loai;
	private float donGia;
	private int trangThai;
	private String phone;
	private int soGiuong;
	private int soNguoi;
	public Phong(String maPhong, int tang, int loai, float donGia, int trangThai, String phone, int soGiuong,
			int soNguoi) {
		super();
		this.maPhong = maPhong;
		this.tang = tang;
		this.loai = loai;
		this.donGia = donGia;
		this.trangThai = trangThai;
		this.phone = phone;
		this.soGiuong = soGiuong;
		this.soNguoi = soNguoi;
	}
	public Phong() {
		super();
		this.maPhong = "";
		this.tang = 0;
		this.loai = 0;
		this.donGia = 0;
		this.trangThai = 0;
		this.phone = "";
		this.soGiuong = 0;
		this.soNguoi = 0;
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public int getTang() {
		return tang;
	}
	public void setTang(int tang) {
		this.tang = tang;
	}
	public int getLoai() {
		return loai;
	}
	public void setLoai(int loai) {
		this.loai = loai;
	}
	public float getDonGia() {
		return donGia;
	}
	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}
	public int getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getSoGiuong() {
		return soGiuong;
	}
	public void setSoGiuong(int soGiuong) {
		this.soGiuong = soGiuong;
	}
	public int getSoNguoi() {
		return soNguoi;
	}
	public void setSoNguoi(int soNguoi) {
		this.soNguoi = soNguoi;
	}
	
	
}
