package the.View;

import the.DTO.DataStorage;
import the.Model.DichVu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;
import java.awt.event.*;

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
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        new DataStorage(0);
        new FormHH();
    }
    DefaultComboBoxModel<DichVu> getCbmodel(){
        DefaultComboBoxModel<DichVu> list = new DefaultComboBoxModel<>();
        for (DichVu d: DataStorage.loader.getListHangHoa()
             ) {
            list.addElement(d);
        }
        return list;
    }
    ItemListener cbEvent = new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            DichVu v = (DichVu) e.getItem();
            spSoluong.setValue(v.getsLDK());
            txtDonGia.setText(v.getDonGIa()+"");
            taGhiChu.setText(v.getGhiChu());
        }
    };
}
