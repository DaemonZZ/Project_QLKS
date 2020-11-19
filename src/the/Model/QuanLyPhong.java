package the.Model;

import java.time.*;
import java.util.Objects;

public class QuanLyPhong {
	private int id;
	private int id_Dk;
	private String hoTen;
	private String maPhong;
	private LocalDate  CI;
	private LocalDate  CO;
	private  float gia;
	private String ghiChu;
	private int trangThai;
	private int id_KH;
	public QuanLyPhong(int id, int id_Dk, String hoTen, String maPhong, LocalDate  cI, LocalDate  cO, float gia,
			String ghiChu, int trangThai,int id_KH) {
		super();
		this.id = id;
		this.id_Dk = id_Dk;
		this.hoTen = hoTen;
		this.maPhong = maPhong;
		CI = cI;
		CO = cO;
		this.gia = gia;
		this.ghiChu = ghiChu;
		this.trangThai = trangThai;
		this.id_KH=id_KH;
	}
	public QuanLyPhong() {
		super();
		this.id = 0;
		this.id_Dk = 0;
		this.hoTen = "";
		this.maPhong = "";
//		CI = new LocalDate ();
//		CO = new LocalDate ();
		this.gia = 0;
		this.ghiChu = "";
		this.trangThai = 0;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_Dk() {
		return id_Dk;
	}
	public void setId_Dk(int id_Dk) {
		this.id_Dk = id_Dk;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public LocalDate  getCI() {
		return CI;
	}
	public void setCI(LocalDate  cI) {
		CI = cI;
	}
	public LocalDate  getCO() {
		return CO;
	}
	public void setCO(LocalDate  cO) {
		CO = cO;
	}
	public float getGia() {
		return gia;
	}
	public void setGia(float gia) {
		this.gia = gia;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public int getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	public int getId_KH() {
		return id_KH;
	}
	public void setId_KH(int id_KH) {
		this.id_KH = id_KH;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		QuanLyPhong that = (QuanLyPhong) o;
		return id == that.id &&
				id_Dk == that.id_Dk &&
				Float.compare(that.gia, gia) == 0 &&
				trangThai == that.trangThai &&
				id_KH == that.id_KH &&
				Objects.equals(hoTen, that.hoTen) &&
				Objects.equals(maPhong, that.maPhong) &&
				Objects.equals(CI, that.CI) &&
				Objects.equals(CO, that.CO) &&
				Objects.equals(ghiChu, that.ghiChu);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, id_Dk, hoTen, maPhong, CI, CO, gia, ghiChu, trangThai, id_KH);
	}

	@Override
	public String toString() {
		return CI.toString();
	}
}

