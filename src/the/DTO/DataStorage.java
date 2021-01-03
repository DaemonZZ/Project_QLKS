package the.DTO;

import the.Model.*;
import the.View.Control.LoadingPanel;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class DataStorage {
    public static DataStorage loader;
    private DatabaseConnection dbc;
    private ArrayList<NhanVien> listNV;
    private ArrayList<Lich> listLich;
    private ArrayList<DichVu> listDV;
    private ArrayList<Phong> listPhong;
    private ArrayList<KhachHang> listKH;
    private ArrayList<QuanLyPhong> currentRoomInfo;
    private ArrayList<ChungTu> listChungTu;
    private ArrayList<DongChungTu> listDongCT;
    private ArrayList<LoaiPhong> listLoaiPhong;
    private ArrayList<ChamCong> listChamCong;
    private ArrayList<QuanLyPhong> listAllQLP;
    private ArrayList<Doan> listDoan;
    private ArrayList<DangKy> listDangKy;
    private ArrayList<ThietBi> listTB;
    private ArrayList<DichVu> listTenTB;
    private ArrayList<DichVu> listHangHoa;

    public ArrayList<DichVu> getListHangHoa() {
        return listHangHoa;
    }

    public ArrayList<DichVu> getListTenTB() {
        return listTenTB;
    }

    public void setListTenTB(ArrayList<DichVu> listTenTB) {
        this.listTenTB = listTenTB;
    }

    public ArrayList<ThietBi> getListTB() {
        return listTB;
    }

    public void setListTB(ArrayList<ThietBi> listTB) {
        this.listTB = listTB;
    }

    public ArrayList<Doan> getListDoan() {
        return listDoan;
    }

    public ArrayList<QuanLyPhong> getListAllQLP() {
        return listAllQLP;
    }

    public void setListAllQLP(ArrayList<QuanLyPhong> listAllQLP) {
        this.listAllQLP = listAllQLP;
    }

    public static LoadingPanel ld = new LoadingPanel();

    public ArrayList<ChamCong> getListChamCong() {
        return listChamCong;
    }

    public void setListChamCong(ArrayList<ChamCong> listChamCong) {
        this.listChamCong = listChamCong;
    }

    public ArrayList<LoaiPhong> getListLoaiPhong() {
        return listLoaiPhong;
    }

    public void setListLoaiPhong(ArrayList<LoaiPhong> listLoaiPhong) {
        this.listLoaiPhong = listLoaiPhong;
    }

    public ArrayList<DongChungTu> getListDongCT() {
        return listDongCT;
    }

    public void setListDongCT(ArrayList<DongChungTu> listDongCT) {
        this.listDongCT = listDongCT;
    }

    public ArrayList<ChungTu> getListChungTu() {
        return listChungTu;
    }

    public void setListChungTu(ArrayList<ChungTu> listChungTu) {
        this.listChungTu = listChungTu;
    }

    public ArrayList<QuanLyPhong> getCurrentRoomInfo() {
        return currentRoomInfo;
    }

    public void setCurrentRoomInfo(ArrayList<QuanLyPhong> currentRoomInfo) {
        this.currentRoomInfo = currentRoomInfo;
    }

    public ArrayList<KhachHang> getListKH() {
        return listKH;
    }

    public void setListKH(ArrayList<KhachHang> listKH) {
        this.listKH = listKH;
    }

    public ArrayList<Phong> getListPhong() {
        return listPhong;
    }

    public void setListPhong(ArrayList<Phong> listPhong) {
        this.listPhong = listPhong;
    }

    public ArrayList<CaLamViec> getListCaLam() {
        return listCaLam;
    }

    public void setListCaLam(ArrayList<CaLamViec> listCaLam) {
        this.listCaLam = listCaLam;
    }

    private ArrayList<CaLamViec> listCaLam;

    public ArrayList<DichVu> getListDV() {
        return listDV;
    }

    public void setListDV(ArrayList<DichVu> listDV) {
        this.listDV = listDV;
    }

    public ArrayList<Lich> getListLich() {
        return listLich;
    }

    public void setListLich(ArrayList<Lich> listLich) {
        this.listLich = listLich;
    }

    public ArrayList<NhanVien> getListNV() {
        return listNV;
    }

    public void setListNV(ArrayList<NhanVien> listNV) {
        this.listNV = listNV;
    }

    public ArrayList<DangKy> getListDangKy() {
        return listDangKy;
    }

    public void setListDangKy(ArrayList<DangKy> listDangKy) {
        this.listDangKy = listDangKy;
    }

    public DataStorage(int AR) {
        loader = this;

        ld.setVisible(true);
        dbc = new DatabaseConnection();
        listKH = dbc.getListKH();
        listLich = dbc.getlistLich();
        listNV = dbc.getListNV();
        listDV = dbc.getListDichVu();
        listCaLam = dbc.getListCaLam();
        listPhong = dbc.getListPhong();
        currentRoomInfo = dbc.getCurrentRoomInfo();
        listChungTu = dbc.getlistCT();
        listDongCT = dbc.getListDongChungTu();
        listLoaiPhong = dbc.getListLoaiPhong();
        listChamCong = dbc.getlistChamCong();
        listAllQLP = dbc.getlistAllQLP();
        listDoan = dbc.getListDoan();
        listDangKy = dbc.getListDangKi();
        listTB = dbc.getListTBP();
        listTenTB = dbc.getListTenTB();
        listHangHoa = dbc.getListHangHoa();
    }

    /**
     * lấy thông tin ca làm từ id
     *
     * @param id
     * @return CalamViec
     */
    public CaLamViec getCaLam(int id) {
        CaLamViec ca = new CaLamViec();
        for (CaLamViec c : getListCaLam()
        ) {
            if (c.getiD() == id) ca = c;
        }
        return ca;
    }

    /**
     * Lấy thông tin nhân viên tư id
     *
     * @param id
     * @return
     */

    public NhanVien getNhanVien(int id) {
        NhanVien nv = new NhanVien();
        for (NhanVien n : getListNV()
        ) {
            if (n.getiD() == id) nv = n;
        }
        return nv;
    }

    /**
     * Tự tao id QL
     *
     * @return
     */
    public int nextIdQL() {
        int max = 0;
        for (QuanLyPhong ql : getCurrentRoomInfo()
        ) {
            if (ql.getId() > max) max = ql.getId();
        }
        return max + 1;
    }

    /**
     * Tu tao id Chung tu
     *
     * @return
     */
    public int nextIdCt() {
        int max = 0;
        for (ChungTu ct : getListChungTu()
        ) {
            if (ct.getSoCT() > max) max = ct.getSoCT();
        }
        return max + 1;
    }

    /**
     * Tao id khach hang tiep theo
     *
     * @return
     */
    public int nextKH() {
        int max = 0;
        for (KhachHang k : getListKH()
        ) {
            if (k.getId() > max) max = k.getId();
        }
        return max + 1;
    }

    /**
     * Id lich lam viec tiep theo
     *
     * @return
     */
    public int nextLich() {
        int max = 0;
        for (Lich l : getListLich()
        ) {
            if (l.getId() > max) max = l.getId();
        }
        return max + 1;
    }

    /**
     * Id Cham cong moiws
     *
     * @return
     */
    public int nextChamCong() {
        int max = 0;
        for (ChamCong c : listChamCong
        ) {
            if (c.getId() > max) max = c.getId();
        }
        return max + 1;
    }

    public int nextDongCT() {
        int max = 0;
        for (DongChungTu c : listDongCT
        ) {
            if (c.getId() > max) max = c.getId();
        }
        return max + 1;
    }

    public int nextDichVu() {
        int max = 0;
        for (DichVu c : listDV
        ) {
            if (c.getiD() > max) max = c.getiD();
        }
        return max + 1;
    }

    public int nextDangKy() {
        int max = 0;
        for (DangKy c : listDangKy
        ) {
            if (c.getId() > max) max = c.getId();
        }
        return max + 1;
    }

    public int nextDoan() {
        int max = 0;
        for (Doan c : listDoan
        ) {
            if (c.getId() > max) max = c.getId();
        }
        return max + 1;
    }

    /**
     * So tnag trong ks
     *
     * @return
     */
    public int getSoTang() {
        int max = 0;
        for (Phong p : getListPhong()
        ) {
            if (p.getTang() > max) max = p.getTang();
        }
        return max;
    }

    /**
     * Dat trang thai phong
     *
     * @param maPhong
     * @param tt
     */
    public void setSttPhong(String maPhong, int tt) {
        for (Phong p : getListPhong()
        ) {
            if (p.getMaPhong().equals(maPhong)) p.setTrangThai(tt);
        }
    }

    /**
     * Lấy giá phòng
     *
     * @param maPhong
     * @return
     */
    public float getGia(String maPhong) {
        float gia = 0;
        for (Phong p : getListPhong()
        ) {
            if (maPhong.equals(p.getMaPhong())) gia = p.getDonGia();
        }
        return gia;
    }

    public ArrayList<DongChungTu> getListDongCT(int ID_Ql) {
        ArrayList<DongChungTu> list = new ArrayList<>();
        for (DongChungTu d : getListDongCT()
        ) {
            if (getIDQL(d.getSoCT()) == ID_Ql) {
                list.add(d);
                if (d.getId() == 11) {
                    QuanLyPhong ql = getQL(ID_Ql);
                    d.setSoLuong(daysAgo(ql.getCI()));
                }
            }
        }
        return list;
    }

    public int getIDQL(int SoCT) {
        for (ChungTu c : getListChungTu()
        ) {
            if (c.getSoCT() == SoCT) return c.getId_QL();
        }
        return 0;
    }

    /**
     * tinh so ngay cho toi hien tai
     *
     * @param past ngay trong qua khu
     * @return khoang cach ngay
     */
    public int daysAgo(LocalDate past) {
        LocalDate today = LocalDate.now();
        LocalDate date = past;
        int count = 0;
        while (!date.equals(today)) {
            count++;
            date.plusDays(1);
        }
        return count;
    }

    public QuanLyPhong getQL(int Id) {
        for (QuanLyPhong ql : getListAllQLP()
        ) {
            if (Id == ql.getId()) return ql;
        }
        return null;
    }

    public KhachHang getKH(int id) {
        for (KhachHang k : listKH
        ) {
            if (k.getId() == id) return k;
        }
        return null;
    }

    public int getSoCT(int id_ql) {
        for (ChungTu c : listChungTu
        ) {
            if (c.getId_QL() == id_ql) return c.getSoCT();
        }
        return 0;
    }

    public void setCheckoutInfo(int current_idQL, float sum) {
        for (QuanLyPhong q : currentRoomInfo
        ) {
            if (q.getId() == current_idQL) {
                q.setCO(LocalDate.now());
                q.setGia(sum);
            }
        }
        for (ChungTu c : listChungTu
             ) {
            if(c.getId_QL()==current_idQL){
                c.setNgayCT(LocalDate.now());
            }
        }
    }

    public void updateLich(int id, int ca, int tangca, String ghichu) {
        for (Lich l : listLich
        ) {
            if (l.getId() == id) {
                l.setId_Ca(ca);
                l.setTangCa(tangca);
                l.setGhiChu(ghichu);
            }
        }
    }

    public int checkSttPhong(String maPhong) {
        for (Phong p : listPhong
        ) {
            if (p.getMaPhong().equals(maPhong)) return p.getTrangThai();
        }
        return -1;
    }

    public String getTenLoai(int loai) {
        for (LoaiPhong l : listLoaiPhong
        ) {
            if (l.getId() == loai) return l.getTenLoai();
        }
        return "";
    }

    public DangKy getDangKy(int id) {
        DangKy d = new DangKy();
        for (DangKy l : listDangKy
        ) {
            if (l.getId() == id) d = l;
        }
        return d;
    }

    public String getTenDoan(int id) {
        Doan d = new Doan();
        for (Doan it : listDoan
        ) {
            if (it.getId() == id) d = it;
        }
        return d.getTenDoan();
    }

    public Phong getPhong(String maPhong) {
        Phong p = new Phong();
        for (Phong it : listPhong
        ) {
            if (it.getMaPhong().equals(maPhong)) p = it;
        }
        return p;
    }

    public void updateDongCT(int oldCT, int newCT) {
        for (DongChungTu d : listDongCT
        ) {
            if (d.getSoCT() == oldCT) {
                d.setSoCT(newCT);
            }
        }
    }
    public String getLoaiCT(int loai){
        switch (loai) {
            case 0:
                return "Nhập";
            case 2:
                return "Xuất";
            case 3:
                return "Thu";
            case 4:
                return "Chi";
        }
        return "";
    }

    public int getSoLuongTB(int iddv){
        int count = 0;
        for (ThietBi tb: listTB
             ) {
            if(tb.getId_dv()==iddv) count++;
        }
        return count;
    }
}