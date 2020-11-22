package the.Model;

import java.time.LocalDate;

public class DangKy {
    private int id;
    private int soPhong;
    private LocalDate ngayDat;
    private LocalDate tuNgay;
    private LocalDate toiNgay;
    private  int soKhach;
    private int nam;
    private int nu;
    private int treEm;
    private int id_kh;
    private int id_nv;
    private float coc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSoPhong() {
        return soPhong;
    }

    public void setSoPhong(int soPhong) {
        this.soPhong = soPhong;
    }

    public LocalDate getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(LocalDate ngayDat) {
        this.ngayDat = ngayDat;
    }

    public LocalDate getTuNgay() {
        return tuNgay;
    }

    public void setTuNgay(LocalDate tuNgay) {
        this.tuNgay = tuNgay;
    }

    public LocalDate getToiNgay() {
        return toiNgay;
    }

    public void setToiNgay(LocalDate toiNgay) {
        this.toiNgay = toiNgay;
    }

    public int getSoKhach() {
        return soKhach;
    }

    public void setSoKhach(int soKhach) {
        this.soKhach = soKhach;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public int getNu() {
        return nu;
    }

    public void setNu(int nu) {
        this.nu = nu;
    }

    public int getTreEm() {
        return treEm;
    }

    public void setTreEm(int treEm) {
        this.treEm = treEm;
    }

    public int getId_kh() {
        return id_kh;
    }

    public void setId_kh(int id_kh) {
        this.id_kh = id_kh;
    }

    public int getId_nv() {
        return id_nv;
    }

    public void setId_nv(int id_nv) {
        this.id_nv = id_nv;
    }

    public float getCoc() {
        return coc;
    }

    public void setCoc(float coc) {
        this.coc = coc;
    }

    public DangKy() {
        this.id = 0;
        this.soPhong = 0;
        this.ngayDat = LocalDate.now();
        this.tuNgay = LocalDate.now();
        this.toiNgay = LocalDate.now();
        this.soKhach = 0;
        this.nam = 0;
        this.nu = 0;
        this.treEm = 0;
        this.id_kh = 0;
        this.id_nv = 0;
        this.coc = 0;
    }

    public DangKy(int id, int soPhong, LocalDate ngayDat, LocalDate tuNgay, LocalDate toiNgay, int soKhach, int nam, int nu, int treEm, int id_kh, int id_nv, float coc) {
        this.id = id;
        this.soPhong = soPhong;
        this.ngayDat = ngayDat;
        this.tuNgay = tuNgay;
        this.toiNgay = toiNgay;
        this.soKhach = soKhach;
        this.nam = nam;
        this.nu = nu;
        this.treEm = treEm;
        this.id_kh = id_kh;
        this.id_nv = id_nv;
        this.coc = coc;
    }

   
}
