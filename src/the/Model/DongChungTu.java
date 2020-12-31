package the.Model;

import java.util.Objects;

public class DongChungTu {
    private int id;
    private int soCT;
    private int id_DV;
    private String tenDV;
    private float soLuong;
    private float donGia;
    private String ghiChu;
    private String maPhong;

    public DongChungTu(int id, int soCT, int id_DV, String tenDV, float soLuong, float donGia, String ghiChu, String maPhong) {
        this.id = id;
        this.soCT = soCT;
        this.id_DV = id_DV;
        this.tenDV = tenDV;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.ghiChu = ghiChu;
        this.maPhong = maPhong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DongChungTu that = (DongChungTu) o;
        return id == that.id &&
                soCT == that.soCT &&
                id_DV == that.id_DV &&
                Float.compare(that.soLuong, soLuong) == 0 &&
                Float.compare(that.donGia, donGia) == 0 &&
                Objects.equals(tenDV, that.tenDV) &&
                Objects.equals(ghiChu, that.ghiChu) &&
                Objects.equals(maPhong, that.maPhong);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, soCT, id_DV, tenDV, soLuong, donGia, ghiChu, maPhong);
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

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

    public DongChungTu(int soCT, int id_DV, String tenDV, float soLuong, float donGia, String ghiChu, String maPhong) {
        this.id = 0;
        this.soCT = soCT;
        this.id_DV = id_DV;
        this.tenDV = tenDV;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.ghiChu = ghiChu;
        this.maPhong = maPhong;
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
