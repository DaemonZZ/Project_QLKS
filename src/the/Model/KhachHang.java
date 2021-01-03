package the.Model;

import java.util.Objects;

public class KhachHang {
    private int id;
    private String hoTen;
    private int gioiTinh;
    private String donVi;
    private String cMND;
    private String ngayCap;
    private String noiCap;
    private int loai;
    private String quocTich;
    private int idDoan;

    public KhachHang(int id, String hoTen, int gioiTinh, String donVi, String cMND, String ngayCap, String noiCap,
                     int loai, String quocTich, int idDoan) {
        super();
        this.id = id;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.donVi = donVi;
        this.cMND = cMND;
        this.ngayCap = ngayCap;
        this.noiCap = noiCap;
        this.loai = loai;
        this.quocTich = quocTich;
        this.idDoan = idDoan;
    }

    public KhachHang(int id, String hoTen, int gioiTinh, String donVi, String cMND, String ngayCap, String noiCap,
                     int loai, String quocTich) {
        super();
        this.id = id;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.donVi = donVi;
        this.cMND = cMND;
        this.ngayCap = ngayCap;
        this.noiCap = noiCap;
        this.loai = loai;
        this.quocTich = quocTich;
    }

    public KhachHang() {
        super();
        this.id = 0;
        this.hoTen = "";
        this.gioiTinh = 0;
        this.donVi = "";
        this.cMND = "";
        this.ngayCap = "";
        this.noiCap = "";
        this.loai = 0;
        this.quocTich = "";
        this.idDoan = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public String getcMND() {
        return cMND;
    }

    public void setcMND(String cMND) {
        this.cMND = cMND;
    }

    public String getNgayCap() {
        return ngayCap;
    }

    public void setNgayCap(String ngayCap) {
        this.ngayCap = ngayCap;
    }

    public String getNoiCap() {
        return noiCap;
    }

    public void setNoiCap(String noiCap) {
        this.noiCap = noiCap;
    }

    public int getLoai() {
        return loai;
    }

    public void setLoai(int loai) {
        this.loai = loai;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public int getIdDoan() {
        return idDoan;
    }

    public void setIdDoan(int idDoan) {
        this.idDoan = idDoan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KhachHang khachHang = (KhachHang) o;
        return id == khachHang.id &&
                gioiTinh == khachHang.gioiTinh &&
                loai == khachHang.loai &&
                idDoan == khachHang.idDoan &&
                Objects.equals(hoTen, khachHang.hoTen) &&
                Objects.equals(donVi, khachHang.donVi) &&
                Objects.equals(cMND, khachHang.cMND) &&
                Objects.equals(ngayCap, khachHang.ngayCap) &&
                Objects.equals(noiCap, khachHang.noiCap) &&
                Objects.equals(quocTich, khachHang.quocTich);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hoTen, gioiTinh, donVi, cMND, ngayCap, noiCap, loai, quocTich, idDoan);
    }

    @Override
    public String toString() {
        return hoTen;
    }
}
