package the.View;

import the.DTO.DataStorage;
import the.Model.ChungTu;
import the.Model.DichVu;
import the.Model.DongChungTu;
import the.View.Control.ChungTuPane;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class FormHH extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox comboBox1;
    private JTextField txtDonGia;
    private JButton btnMoi;
    private JTextArea taGhiChu;
    private JSpinner spSoluong;
    private JButton btnOkTao;
    private JButton btnhuy;
    private JTextField txtHHmoi;
    private JButton btnSave;

    public FormHH() {
        setContentPane(contentPane);
        setModal(true);
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

        btnhuy.setVisible(false);
        btnOkTao.setVisible(false);
        txtHHmoi.setVisible(false);
        SpinnerNumberModel spm = new SpinnerNumberModel();
        spm.setMinimum(0);
        spSoluong.setModel(spm);
        comboBox1.setModel(getCbmodel());
        comboBox1.setSelectedIndex(-1);
        comboBox1.addItemListener(cbEvent);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    private void onOK() {

        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
    private void onSave(){
        boolean isExist = false;
        DongChungTu cur = new DongChungTu();
        DongChungTu del = new DongChungTu();
        DichVu c = (DichVu)comboBox1.getSelectedItem();
        for (DongChungTu d: FormNhap.f.getListNhap()
             ) {
            if(d.getId_DV()==c.getiD()){
                if((int)spSoluong.getValue()!=0){

                    isExist=true;
                    d.setSoLuong((int)spSoluong.getValue());
                }
                else {
                    del = d;
                }
            }
        }
        FormNhap.f.getListNhap().remove(del);
        if(!isExist&&(int)spSoluong.getValue()!=0){
            cur.setId_DV(c.getiD());
            cur.setSoLuong((int)spSoluong.getValue());
            cur.setDonGia(Float.parseFloat(txtDonGia.getText()));
            cur.setGhiChu(taGhiChu.getText());
            FormNhap.f.getListNhap().add(cur);
            System.out.println("OK?");
        }
        FormNhap.f.reloadTB();

    }

    public static void main(String[] args) {
        new DataStorage(0);
        new FormHH();
    }
    DefaultComboBoxModel<DichVu> getCbmodel(){
        DefaultComboBoxModel<DichVu> list = new DefaultComboBoxModel<>();
        ArrayList<DichVu> listdv;
        if(FormNhap.f.getLoai()==0) listdv = DataStorage.loader.getListTenTB();
        else listdv = DataStorage.loader.getListHangHoa();
        for (DichVu d: listdv
             ) {
            list.addElement(d);
        }
        return list;
    }
    ItemListener cbEvent = new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            spSoluong.setValue(0);
            DichVu v = (DichVu) e.getItem();
            txtDonGia.setText(v.getDonGIa()+"");
            taGhiChu.setText(v.getGhiChu());
            for (DongChungTu d: FormNhap.f.getListNhap()
                 ) {
                if(d.getId_DV()==v.getiD()) spSoluong.setValue(d.getSoLuong());
            };
        }
    };
}
