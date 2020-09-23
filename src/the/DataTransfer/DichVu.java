package the.DataTransfer;

public class DichVu {
	private int iD;
	private String tenDV;
	private String donViTinh;
	private float donGIa;
	private String ghiChu;
	private int loai;
	private float sLDK;
	private float gTDK;
	public DichVu(int iD, String tenDV, String donViTinh, float donGIa, String ghiChu, int loai, float sLDK,
			float gTDK) {
		super();
		this.iD = iD;
		this.tenDV = tenDV;
		this.donViTinh = donViTinh;
		this.donGIa = donGIa;
		this.ghiChu = ghiChu;
		this.loai = loai;
		this.sLDK = sLDK;
		this.gTDK = gTDK;
	}
	public DichVu() {
		super();
		this.iD = 0;
		this.tenDV = "";
		this.donViTinh = "";
		this.donGIa = 0;
		this.ghiChu = "";
		this.loai = 0;
		this.sLDK = 0;
		this.gTDK = 0;
	}
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public String getTenDV() {
		return tenDV;
	}
	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}
	public String getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}
	public float getDonGIa() {
		return donGIa;
	}
	public void setDonGIa(float donGIa) {
		this.donGIa = donGIa;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public int getLoai() {
		return loai;
	}
	public void setLoai(int loai) {
		this.loai = loai;
	}
	public float getsLDK() {
		return sLDK;
	}
	public void setsLDK(float sLDK) {
		this.sLDK = sLDK;
	}
	public float getgTDK() {
		return gTDK;
	}
	public void setgTDK(float gTDK) {
		this.gTDK = gTDK;
	}
	
}
