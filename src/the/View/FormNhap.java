package the.View;

import org.codehaus.groovy.tools.shell.Main;
import the.DTO.DataStorage;
import the.DTO.DataSynchronizer;
import the.Model.ChungTu;
import the.Model.DichVu;
import the.Model.DongChungTu;
import the.Model.KhachHang;
import the.View.Control.ChungTuPane;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class FormNhap extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTable tb;
    private JComboBox cbTen;
    private JTextField txtDiaChi;
    private JTextField txtMatHang;
    private JButton btnNewKH;
    private JButton btnAdd;
    private JComboBox cbLoai;
    private ArrayList<DongChungTu> listNhap = new ArrayList<>();
    private int loai =2;
    public static FormNhap f;

    public int getLoai() {
        return loai;
    }

    public ArrayList<DongChungTu> getListNhap() {
        return listNhap;
    }

    public JTable getTb() {
        return tb;
    }

    public JComboBox getCbTen() {
        return cbTen;
    }


    public FormNhap() {
        f=this;
        setContentPane(contentPane);
        setModal(false);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Nhập hàng");

        cbTen.setModel(getCbModel());
        cbTen.setSelectedIndex(-1);
        cbTen.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                KhachHang k = (KhachHang) e.getItem();
                txtDiaChi.setText(k.getDonVi());
                txtMatHang.setText(k.getQuocTich());
                listNhap = new ArrayList<>();
                tb.setModel(getTBModel());
            }
        });

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FormHH();
            }
        });
        cbLoai.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(cbLoai.getSelectedIndex()==0) loai =2;
                else loai=0;
                listNhap= new ArrayList<>();
                reloadTB();
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void onOK() {
        ChungTu ct = new ChungTu();
        KhachHang k = ((KhachHang)cbTen.getSelectedItem());
        ct.setSoCT(DataStorage.loader.nextIdCt());
        ct.setNgayCT(LocalDate.now());
        ct.setLoai(0);
        ct.setId_KH(k.getId());
        ct.setId_NV(MainForm.nv.getiD());
        ct.setNoiDung("Nhập hàng "+txtMatHang.getText());
        DataStorage.loader.getListChungTu().add(ct);
        for (DongChungTu dct: listNhap
             ) {
            dct.setSoCT(ct.getSoCT());
            dct.setId(DataStorage.loader.nextDongCT());
            DataStorage.loader.getListDongCT().add(dct);
        }
        MainForm.m.setEnabled(true);
        if(ChungTuPane.c.getCmdPn()==2){
            ChungTuPane.c.getTb().setModel(ChungTuPane.c.getNXModel(""));
        }


        DataSynchronizer.synchronizer.syncAllData();
        dispose();
    }

    private void onCancel() {
        MainForm.m.setEnabled(true);
        dispose();
    }


    public DefaultComboBoxModel<KhachHang> getCbModel(){
        DefaultComboBoxModel<KhachHang> cbModel = new DefaultComboBoxModel<>();
        for (KhachHang k: DataStorage.loader.getListKH()
             ) {
            if(k.getLoai()==2) cbModel.addElement(k);
        }

        return cbModel;
    }

    public static void main(String[] args) {
        new DataStorage(0);
        new FormNhap();
    }
    public DefaultTableModel getTBModel (){
        DefaultTableModel model = new DefaultTableModel();
        String[] row = new String[4];
        model.addColumn("Tên mặt hàng");
        model.addColumn("Đơn giá");
        model.addColumn("Số lượng");
        model.addColumn("Ghi Chú");
        for (DongChungTu d: listNhap
             ) {
            row[0] = DataStorage.loader.getHH(d.getId_DV());
            row[1] =d.getDonGia()+"";
            row[2]=d.getSoLuong()+"";
            row[3] = d.getGhiChu();
            model.addRow(row);
        }
        return model;
    }
    public void reloadTB(){
        tb.setModel(getTBModel());
    }

}
