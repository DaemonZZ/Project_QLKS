package the.Model;

public class Doan {
    private int id;
    private String tenDoan;

    public Doan() {
        this.id=0;
        this.tenDoan = "";
    }

    public Doan(int id, String tenDoan) {
        this.id = id;
        this.tenDoan = tenDoan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenDoan() {
        return tenDoan;
    }

    public void setTenDoan(String tenDoan) {
        this.tenDoan = tenDoan;
    }

    @Override
    public String toString() {
        return tenDoan;
    }
}
