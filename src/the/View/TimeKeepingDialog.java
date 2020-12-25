package the.View;

import the.DTO.DataStorage;
import the.DTO.DataSynchronizer;
import the.DTO.DatabaseConnection;
import the.Model.CaLamViec;
import the.Model.ChamCong;
import the.Model.Lich;
import the.Model.NhanVien;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeKeepingDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton btnCheckin;
    private JButton btnCheckout;
    private JTextField txtTen;
    private JLabel lbVao;
    private JLabel lbTangca;
    private JLabel lbRa;
    private JLabel lbCI;
    private JLabel lbCO;
    private JPanel pnIcon;
    private JLabel lbIco;
    private static int OFF = 0;
    private static int PREPARE = 1;
    private static int CHECKED = 2;
    private Lich lichHomNay;
    private NhanVien nhanVien;
    private CaLamViec ca;
    private LocalTime gioVao;
    private LocalTime gioRa;

    public TimeKeepingDialog(Lich lich) {
        this.lichHomNay = lich;
        setTitle("Chấm công");
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        ImageIcon img = new ImageIcon("img\\chamcong.gif");
        lbIco.setIcon(img);

        nhanVien = DataStorage.loader.getNhanVien(lich.getId_NV());
        ca = DataStorage.loader.getCaLam(lich.getId_Ca());
        gioVao = ca.getTu();
        gioRa = ca.getDen().plusHours(lich.getTangCa());

        txtTen.setText(nhanVien.getHoTen());
        lbVao.setText(gioVao.toString());
        lbRa.setText(gioRa.toString());
        lbTangca.setText(lich.getTangCa() + "");
        lbCI.setForeground(Color.RED);
        lbCO.setForeground(Color.RED);

        btnCheckin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ca.getiD() != 3) {
                    if (LocalTime.now().isBefore(gioVao.minusMinutes(30)))
                        JOptionPane.showMessageDialog(rootPane, "Qúa sớm để vào ca");
                    else {
                        lbCI.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                        DataStorage.loader.getListChamCong().add(new ChamCong(DataStorage.loader.nextChamCong(), lichHomNay.getId(), LocalTime.now(), null));
                        btnCheckin.setEnabled(false);
                        btnCheckout.setEnabled(true);
                        JOptionPane.showMessageDialog(rootPane, "Checkin thành công!");
                    }
                } else {
                    if (LocalTime.now().isBefore(gioVao.minusMinutes(30)) && LocalDate.now().equals(lichHomNay.getNgay())) {
                        JOptionPane.showMessageDialog(rootPane, "Qúa sớm để vào ca");
                    }
                    if (LocalTime.now().isAfter(gioVao.minusMinutes(30)) && LocalDate.now().equals(lichHomNay.getNgay())) {
                        lbCI.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                        DataStorage.loader.getListChamCong().add(new ChamCong(DataStorage.loader.nextChamCong(), lichHomNay.getId(), LocalTime.now(), null));
                        btnCheckin.setEnabled(false);
                        btnCheckout.setEnabled(true);
                        JOptionPane.showMessageDialog(rootPane, "Checkin thành công!");
                    }
                    if (LocalDate.now().equals(lichHomNay.getNgay().plusDays(1))) {
                        lbCI.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                        DataStorage.loader.getListChamCong().add(new ChamCong(DataStorage.loader.nextChamCong(), lichHomNay.getId(), LocalTime.now(), null));
                        btnCheckin.setEnabled(false);
                        btnCheckout.setEnabled(true);
                        JOptionPane.showMessageDialog(rootPane, "Checkin thành công!");
                    }
                }
            }
        });

        btnCheckout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChamCong cur = new ChamCong();
                for (ChamCong c : DataStorage.loader.getListChamCong()
                ) {
                    if (c.getId_lich() == lichHomNay.getId()) {
                        cur = c;
                        c.setRa(LocalTime.now());
                    }
                }
                lbCO.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                btnCheckout.setEnabled(false);
                JOptionPane.showMessageDialog(rootPane, "Checkout thành công!");
            }
        });

        buttonOK.setText("Lưu");
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.setText("Hủy");
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
        System.out.println(infoCheck() + "abc");

        if (infoCheck() == OFF) {
            btnCheckin.setEnabled(false);
            btnCheckout.setEnabled(false);
        }
        if (infoCheck() == PREPARE) {
            btnCheckout.setEnabled(false);
        }
        if (infoCheck() == CHECKED) {
            btnCheckin.setEnabled(false);
        }

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private void onOK() {
        // add your code here
        DataSynchronizer.synchronizer.syncChamCong();
        dispose();
    }

    private void onCancel() {
        DataStorage.loader.setListChamCong(new DatabaseConnection().getlistChamCong());
        dispose();
    }

    public int infoCheck() {
        LocalTime checkTime = LocalTime.now();

        boolean checked = false;
        for (ChamCong c : DataStorage.loader.getListChamCong()
        ) {
            if (c.getId_lich() == lichHomNay.getId() && c.getRa() == null) {
                checked = true;
                lbCI.setText(c.getVao().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
            }
            if (c.getId_lich() == lichHomNay.getId() && c.getRa() != null) {
                lbCI.setText(c.getVao().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                lbCO.setText(c.getRa().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                return OFF;
            }
        }
        if (checked) return CHECKED;

        if (lichHomNay.getId_Ca() == 4) return OFF;
        else {
            if (checkTime.isAfter(gioRa) && lichHomNay.getNgay().equals(LocalDate.now())) {
                if (ca.getiD() != 3) return OFF;
                else if (ca.getiD() == 3 && LocalTime.now().isAfter(LocalTime.parse("12:00"))) return PREPARE;
                else return OFF;
            } else return PREPARE;

        }
    }

}
