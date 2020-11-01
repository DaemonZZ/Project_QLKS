package the.DataTransfer;

import java.time.LocalTime;

public class CaLamViec {
    private int iD;
    private String tenCa;
    private LocalTime tu;
    private LocalTime den;

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getTenCa() {
        return tenCa;
    }

    public void setTenCa(String tenCa) {
        this.tenCa = tenCa;
    }

    public LocalTime getTu() {
        return tu;
    }

    public void setTu(LocalTime tu) {
        this.tu = tu;
    }

    public LocalTime getDen() {
        return den;
    }

    public void setDen(LocalTime den) {
        this.den = den;
    }

    public CaLamViec(int iD, String tenCa, LocalTime tu, LocalTime den) {
        this.iD = iD;
        this.tenCa = tenCa;
        this.tu = tu;
        this.den = den;
    }

    public CaLamViec() {
    }
}
