package the.Model;

import java.time.*;
import java.util.Objects;

public class ChungTu {
    private int soCT;
    private LocalDate ngayCT;
    private int loai;
    private int id_KH;
    private int id_NV;
    private String NoiDung;
    private float giam;
    private float VAT;
    private String soHD;
    private int id_QL;

    public int getSoCT() {
        return soCT;
    }

    public void setSoCT(int soCT) {
        this.soCT = soCT;
    }

    public LocalDate getNgayCT() {
        return ngayCT;
    }

    public void setNgayCT(LocalDate ngayCT) {
        this.ngayCT = ngayCT;
    }

    public int getLoai() {
        return loai;
    }

    public void setLoai(int loai) {
        this.loai = loai;
    }

    public int getId_KH() {
        return id_KH;
    }

    public void setId_KH(int id_KH) {
        this.id_KH = id_KH;
    }

    public int getId_NV() {
        return id_NV;
    }

    public void setId_NV(int id_NV) {
        this.id_NV = id_NV;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        NoiDung = noiDung;
    }

    public float getGiam() {
        return giam;
    }

    public void setGiam(float giam) {
        this.giam = giam;
    }

    public float getVAT() {
        return VAT;
    }

    public void setVAT(float VAT) {
        this.VAT = VAT;
    }

    public String getSoHD() {
        return soHD;
    }

    public void setSoHD(String soHD) {
        this.soHD = soHD;
    }

    public int getId_QL() {
        return id_QL;
    }

    public void setId_QL(int id_QL) {
        this.id_QL = id_QL;
    }

    public ChungTu() {
        this.soCT = 0;
        this.loai = 0;
        this.id_KH = 0;
        this.id_NV = 0;
        NoiDung = "";
        this.giam = 0;
        this.VAT = 0;
        this.soHD = "";
        this.id_QL = 0;
    }

    public ChungTu(int soCT, int loai, int id_KH, int id_NV, String noiDung, float giam, float VAT, String soHD, int id_QL) {
        this.soCT = soCT;
        this.loai = loai;
        this.id_KH = id_KH;
        this.id_NV = id_NV;
        NoiDung = noiDung;
        this.giam = giam;
        this.VAT = VAT;
        this.soHD = soHD;
        this.id_QL = id_QL;
    }

    public ChungTu(int soCT, LocalDate ngayCT, int loai, int id_KH, int id_NV, String noiDung, float giam, float VAT, String soHD, int id_QL) {
        this.soCT = soCT;
        this.ngayCT = ngayCT;
        this.loai = loai;
        this.id_KH = id_KH;
        this.id_NV = id_NV;
        NoiDung = noiDung;
        this.giam = giam;
        this.VAT = VAT;
        this.soHD = soHD;
        this.id_QL = id_QL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChungTu chungTu = (ChungTu) o;
        return soCT == chungTu.soCT &&
                loai == chungTu.loai &&
                id_KH == chungTu.id_KH &&
                id_NV == chungTu.id_NV &&
                Float.compare(chungTu.giam, giam) == 0 &&
                Float.compare(chungTu.VAT, VAT) == 0 &&
                id_QL == chungTu.id_QL &&
                Objects.equals(ngayCT, chungTu.ngayCT) &&
                Objects.equals(NoiDung, chungTu.NoiDung) &&
                Objects.equals(soHD, chungTu.soHD);
    }

    @Override
    public int hashCode() {
        return Objects.hash(soCT, ngayCT, loai, id_KH, id_NV, NoiDung, giam, VAT, soHD, id_QL);
    }
}
