package the.Model;

public class LoaiPhong {
    private int id;
    private String tenLoai;

    public LoaiPhong(int id, String tenLoai) {
        this.id = id;
        this.tenLoai = tenLoai;
    }

    public LoaiPhong() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }
}
