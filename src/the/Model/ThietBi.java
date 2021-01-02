package the.Model;

public class ThietBi {
    private int id;
    private int maPhong;
    private int id_dv;
    private int soluong;
    private String trangthai;
    private String serialNo;

    public ThietBi() {
        this.trangthai="";
        this.serialNo="";
    }

    public ThietBi(int id, int maPhong, int id_dv, int soluong, String trangthai, String serialNo) {
        this.id = id;
        this.maPhong = maPhong;
        this.id_dv = id_dv;
        this.soluong = soluong;
        this.trangthai = trangthai;
        this.serialNo = serialNo;
    }

    public ThietBi(int id, int id_dv, int soluong, String trangthai, String serialNo) {
        this.id = id;
        this.id_dv = id_dv;
        this.soluong = soluong;
        this.trangthai = trangthai;
        this.serialNo = serialNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(int maPhong) {
        this.maPhong = maPhong;
    }

    public int getId_dv() {
        return id_dv;
    }

    public void setId_dv(int id_dv) {
        this.id_dv = id_dv;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }
}
