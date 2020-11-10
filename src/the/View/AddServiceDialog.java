package the.View;

import the.DTO.DataStorage;
import the.Model.DichVu;
import the.DTO.DatabaseConnection;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AddServiceDialog extends JDialog {
    private JPanel contentPane ;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JSpinner spnSl;
    private JComboBox cbDV;
    private JButton lưuThayĐổiButton;
    private JTextField tctGia;
    private JTextArea taGhichu;

    public AddServiceDialog() {

        setContentPane(contentPane);
        setModal(true);
        setTitle("Thêm dịch vụ");

        DefaultComboBoxModel cbModel = new DefaultComboBoxModel();
        cbModel.addAll(DataStorage.loader.getListDV());
        cbDV.setModel(cbModel);

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

        SpinnerNumberModel spnModel = new SpinnerNumberModel();
        spnModel.setMinimum(0);
        spnSl.setModel(spnModel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);




    }

    private void onOK() {
        // add your code here
        MainForm.m.setEnabled(true);
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        MainForm.m.setEnabled(true);
        dispose();
    }

    public static void main(String[] args) {
        new AddServiceDialog();
    }
}
