package the.DataTransfer;

public class DongChungTu {
	private int id;
	private int soCT;
	private int id_DV;
	private String tenDV;
	private float soLuong;
	private float donGia;
	private String ghiChu;
	public DongChungTu(int id, int soCT, int id_DV, String tenDV, float soLuong, float donGia, String ghiChu) {
		super();
		this.id = id;
		this.soCT = soCT;
		this.id_DV = id_DV;
		this.tenDV = tenDV;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.ghiChu = ghiChu;
	}
	public DongChungTu() {
		this.id = 0;
		this.soCT = 0;
		this.id_DV = 0;
		this.tenDV = "";
		this.soLuong = 0;
		this.donGia = 0;
		this.ghiChu = "";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSoCT() {
		return soCT;
	}
	public void setSoCT(int soCT) {
		this.soCT = soCT;
	}
	public int getId_DV() {
		return id_DV;
	}
	public void setId_DV(int id_DV) {
		this.id_DV = id_DV;
	}
	public String getTenDV() {
		return tenDV;
	}
	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}
	public float getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(float soLuong) {
		this.soLuong = soLuong;
	}
	public float getDonGia() {
		return donGia;
	}
	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
}
