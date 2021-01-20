package the.View;

import the.DTO.DataStorage;
import the.Model.DichVu;
import the.Model.DongChungTu;
import the.Model.QuanLyPhong;
import the.View.Panel.SoDoPane;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class AddServiceDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JSpinner spnSl;
    private JComboBox cbDV;
    private JButton btnSave;
    private JTextField tctGia;
    private JTextArea taGhichu;
    private QuanLyPhong ql;
    private ArrayList<DongChungTu> listDCT;

    public AddServiceDialog(int id_ql) {
        ql = DataStorage.loader.getQL(id_ql);
        listDCT = DataStorage.loader.getListDongCT(ql.getId());
        setContentPane(contentPane);
        setModal(true);
        setTitle("Thêm dịch vụ");

        DefaultComboBoxModel cbModel = new DefaultComboBoxModel();
        cbModel.addAll(DataStorage.loader.getListDV());
        cbDV.setModel(cbModel);
        cbDV.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                DichVu dv = (DichVu) cbDV.getSelectedItem();
                tctGia.setText(dv.getDonGIa() + "");
                boolean isExist = false;
                for (DongChungTu dong : listDCT
                ) {
                    if (dv.getiD() == dong.getId_DV()) {
                        isExist = true;
                        spnSl.setValue(dong.getSoLuong());
                        tctGia.setText(dong.getDonGia() + "");
                    }
                }
                if (!isExist) spnSl.setValue(0);
                if (dv.getiD() == 11 || dv.getiD() == 15 || dv.getiD() == 16) {
                    tctGia.setEditable(true);
                } else {
                    tctGia.setEditable(false);
                }
                if (dv.getiD() == 11) {
                    spnSl.setValue(daysCount(ql.getCI(), LocalDate.now()));
                }
            }
        });

        getRootPane().setDefaultButton(buttonOK);

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

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSave();
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

        SpinnerNumberModel spnModel = new SpinnerNumberModel();
        spnModel.setMinimum(0);
        spnSl.setModel(spnModel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);


    }

    private void onOK() {
        listDCT = DataStorage.loader.getListDongCT(ql.getId());
        DongChungTu dong = new DongChungTu();
        dong.setId(DataStorage.loader.nextDongCT());
        dong.setSoLuong((int) spnSl.getValue());
        dong.setDonGia(Float.parseFloat(tctGia.getText()));
        dong.setGhiChu(taGhichu.getText());
        dong.setId_DV(((DichVu) cbDV.getSelectedItem()).getiD());
        dong.setTenDV(((DichVu) cbDV.getSelectedItem()).getTenDV());
        dong.setSoCT(DataStorage.loader.getSoCT(ql.getId()));
        dong.setMaPhong(ql.getMaPhong());
        boolean b = false;
        DongChungTu del = new DongChungTu();
        for (DongChungTu d : listDCT
        ) {
            if (d.getId_DV() == dong.getId_DV()) {
                b = true;
                dong.setId(d.getId());
                del = d;
            }
        }
        if (b) {
            DataStorage.loader.getListDongCT().remove(del);
            DataStorage.loader.getListDongCT().add(dong);
        } else {
            DataStorage.loader.getListDongCT().add(dong);
        }
        SoDoPane.s.reloadTable();
        if (ProfileDialog.p != null) ProfileDialog.p.getTable1().setModel(new DefaultTableModel());
        if (ProfileDialog.p != null) ProfileDialog.p.getTable1().setModel(MainForm.m.getRoomInfoModel(ql.getId()));
        MainForm.m.setEnabled(true);
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        MainForm.m.setEnabled(true);
        dispose();
    }

    public int daysCount(LocalDate d1, LocalDate d2) {
        int soNgay = 1;

        while (!d1.equals(d2)) {
            soNgay++;
            d1 = d1.plusDays(1);
        }
        return soNgay;
    }

    private void onSave() {
        listDCT = DataStorage.loader.getListDongCT(ql.getId());
        DongChungTu dong = new DongChungTu();
        dong.setId(DataStorage.loader.nextDongCT());
        dong.setSoLuong((int) spnSl.getValue());
        dong.setDonGia(Float.parseFloat(tctGia.getText()));
        dong.setGhiChu(taGhichu.getText());
        dong.setId_DV(((DichVu) cbDV.getSelectedItem()).getiD());
        dong.setTenDV(((DichVu) cbDV.getSelectedItem()).getTenDV());
        dong.setSoCT(DataStorage.loader.getSoCT(ql.getId()));
        dong.setMaPhong(ql.getMaPhong());
        boolean b = false;
        DongChungTu del = new DongChungTu();
        for (DongChungTu d : listDCT
        ) {
            if (d.getId_DV() == dong.getId_DV()) {
                b = true;
                dong.setId(d.getId());
                del = d;
            }
        }
        if (b) {
            DataStorage.loader.getListDongCT().remove(del);
            DataStorage.loader.getListDongCT().add(dong);
        } else {
            DataStorage.loader.getListDongCT().add(dong);
        }
        SoDoPane.s.reloadTable();
        if (ProfileDialog.p != null) ProfileDialog.p.getTable1().setModel(new DefaultTableModel());
        if (ProfileDialog.p != null) ProfileDialog.p.getTable1().setModel(MainForm.m.getRoomInfoModel(ql.getId()));
    }


}
