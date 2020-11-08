package the.Model;

import java.time.LocalDate;
import java.util.Objects;

public class Lich {
	private int id;
	private LocalDate ngay;
	private int id_NV;
	private int id_Ca;
	private int tangCa;
	private String ghiChu;
	public Lich(int id, LocalDate ngay, int id_NV, int id_Ca, int tangCa, String ghiChu) {
		super();
		this.id = id;
		this.ngay = ngay;
		this.id_NV = id_NV;
		this.id_Ca = id_Ca;
		this.tangCa = tangCa;
		this.ghiChu = ghiChu;
	}

	public Lich(LocalDate ngay, int id_NV, int id_Ca, int tangCa, String ghiChu) {
		this.ngay = ngay;
		this.id_NV = id_NV;
		this.id_Ca = id_Ca;
		this.tangCa = tangCa;
		this.ghiChu = ghiChu;
	}

	public Lich() {
		super();
		this.id = 0;
		this.tangCa = 0;
		this.ghiChu = "";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getNgay() {
		return ngay;
	}
	public void setNgay(LocalDate ngay) {
		this.ngay = ngay;
	}
	public int getId_NV() {
		return id_NV;
	}
	public void setId_NV(int id_NV) {
		this.id_NV = id_NV;
	}
	public int getId_Ca() {
		return id_Ca;
	}
	public void setId_Ca(int id_Ca) {
		this.id_Ca = id_Ca;
	}
	public int getTangCa() {
		return tangCa;
	}
	public void setTangCa(int tangCa) {
		this.tangCa = tangCa;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Lich lich = (Lich) o;
		return id == lich.id &&
				id_NV == lich.id_NV &&
				id_Ca == lich.id_Ca &&
				tangCa == lich.tangCa &&
				Objects.equals(ngay, lich.ngay) &&
				Objects.equals(ghiChu, lich.ghiChu);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, ngay, id_NV, id_Ca, tangCa, ghiChu);
	}
}
