package the.Model;

import java.time.LocalTime;
import java.util.Objects;

public class ChamCong {
    private int id;
    private int id_lich;
    private LocalTime vao;
    private LocalTime ra;

    public ChamCong(int id, int id_lich, LocalTime vao, LocalTime ra) {
        this.id = id;
        this.id_lich = id_lich;
        this.vao = vao;
        this.ra = ra;
    }

    public ChamCong() {
        this.id=0;
        this.id_lich=0;
        this.ra=null;
        this.vao=null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChamCong chamCong = (ChamCong) o;
        return id == chamCong.id &&
                id_lich == chamCong.id_lich &&
                Objects.equals(vao, chamCong.vao) &&
                Objects.equals(ra, chamCong.ra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, id_lich, vao, ra);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_lich() {
        return id_lich;
    }

    public void setId_lich(int id_lich) {
        this.id_lich = id_lich;
    }

    public LocalTime getVao() {
        return vao;
    }

    public void setVao(LocalTime vao) {
        this.vao = vao;
    }

    public LocalTime getRa() {
        return ra;
    }

    public void setRa(LocalTime ra) {
        this.ra = ra;
    }
}
