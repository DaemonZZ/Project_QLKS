package the.View.Control;

import the.DTO.DataStorage;
import the.DTO.DataSynchronizer;
import the.Model.ChamCong;
import the.Model.Lich;
import the.Model.NhanVien;
import the.DTO.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

public class LichPane extends JLayeredPane {
    private final JButton btnAdd;

    public JButton getBtnAdd() {
        return btnAdd;
    }

    private final JTextField txtTimKiem;
    private ArrayList<NhanVien> listNhanVien = (ArrayList<NhanVien>) DataStorage.loader.getListNV().clone();
    JPanel panel = new JPanel();
    JScrollPane scrollPane;
    JComboBox ttCb;

    public LichPane() {
        setLayout(new BorderLayout(0, 0));

        btnAdd = new JButton("+");
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnAdd.setBackground(Color.CYAN);
        btnAdd.setEnabled(false);
        btnAdd.setPreferredSize(new Dimension(20, -1));
        add(btnAdd, BorderLayout.EAST);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<LocalDate> listNgay = new ArrayList<>();
                LocalDate today = LocalDate.now();
                int dem = 0;
                while (!today.getDayOfWeek().equals(DayOfWeek.MONDAY) || dem < 7) {
                    listNgay.add(today);
                    dem++;
                    today = today.plusDays(1);
                }
                for (NhanVien nv :
                        listNhanVien) {
                    if (nv.getLoai() != 0) {
                        for (LocalDate ngay : listNgay
                        ) {
                            if (!isExist(ngay, nv)) {
                                Lich l = new Lich(DataStorage.loader.nextLich(), ngay, nv.getiD(), 4, 0, "");
                                DataStorage.loader.getListLich().add(l);
                                System.out.println(l.getId() + " alo");
                            }

                        }
                    }

                }
                DataSynchronizer.synchronizer.syncLich();
                reloadLichPane();
            }
        });

        scrollPane = new JScrollPane();
        add(scrollPane, BorderLayout.CENTER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);


        panel.setBackground(Color.WHITE);
        scrollPane.setViewportView(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JMenuBar menuBar_Sodo = new JMenuBar();
        menuBar_Sodo.setBackground(Color.WHITE);
        add(menuBar_Sodo, BorderLayout.NORTH);

        JLabel lblNewLabel_1 = new JLabel("Nhập tên: ");
        menuBar_Sodo.add(lblNewLabel_1);

        txtTimKiem = new JTextField();
        menuBar_Sodo.add(txtTimKiem);
        txtTimKiem.setColumns(10);

        JButton btnTim = new JButton("Tìm Kiếm");
        menuBar_Sodo.add(btnTim);
        btnTim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtTimKiem.getText().equals("") && ttCb.getSelectedIndex() == 0) {
                    listNhanVien = (ArrayList<NhanVien>) DataStorage.loader.getListNV().clone();

                } else {
                    if (ttCb.getSelectedIndex() != 0) {
                        listNhanVien.clear();
                        for (NhanVien n : DataStorage.loader.getListNV()
                        ) {
                            if (n.getHoTen().contains(txtTimKiem.getText()) && n.getLoai() == ttCb.getSelectedIndex()) {
                                listNhanVien.add(n);
                                System.out.println("true");
                            }
                        }
                    } else {
                        listNhanVien.clear();
                        for (NhanVien n : DataStorage.loader.getListNV()
                        ) {
                            if (n.getHoTen().contains(txtTimKiem.getText())) {
                                listNhanVien.add(n);

                            }
                        }
                    }

                }
                panel.removeAll();

                for (NhanVien nv : listNhanVien) {
                    if (nv.getLoai() != 0) {
                        panel.add(new NVPanel(nv));
                        System.out.println(nv.getHoTen());
                    }
                }
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        repaint();
                    }
                });

            }
        });


        JPanel filterPanel = new JPanel();
        filterPanel.setBackground(Color.WHITE);
        menuBar_Sodo.add(filterPanel);

        JLabel lblNewLabel = new JLabel("Lọc: ");
        lblNewLabel.setForeground(Color.RED);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        filterPanel.add(lblNewLabel);

        JLabel lb = new JLabel("Bộ phận:");
        filterPanel.add(lb);

        ttCb = new JComboBox();
        ttCb.setModel(new DefaultComboBoxModel(new String[]{"Tất cả", "Lễ Tân", "Kinh Doanh", "Buồng Phòng", "Kế Toán"}));
        filterPanel.add(ttCb);
        ttCb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (txtTimKiem.getText().equals("") && ttCb.getSelectedIndex() == 0) {
                    listNhanVien = (ArrayList<NhanVien>) DataStorage.loader.getListNV().clone();
                } else {
                    if (ttCb.getSelectedIndex() != 0) {
                        listNhanVien.clear();
                        for (NhanVien n : DataStorage.loader.getListNV()
                        ) {
                            if (n.getHoTen().contains(txtTimKiem.getText()) && n.getLoai() == ttCb.getSelectedIndex()) {
                                listNhanVien.add(n);
                                System.out.println("true");
                            }
                        }
                    } else {
                        listNhanVien.clear();
                        for (NhanVien n : DataStorage.loader.getListNV()
                        ) {
                            if (n.getHoTen().contains(txtTimKiem.getText())) {
                                listNhanVien.add(n);

                            }
                        }
                    }
                }
                panel.removeAll();
                for (NhanVien nv : listNhanVien) {
                    if (nv.getLoai() != 0) {
                        panel.add(new NVPanel(nv));
                    }
                }
                panel.repaint();
            }

        });

        for (NhanVien nv : listNhanVien) {
            if (nv.getLoai() != 0) {
                panel.add(new NVPanel(nv));
            }
        }
    }

    public boolean isExist(LocalDate ngay, NhanVien nv) {
        boolean b = false;
        for (Lich l : DataStorage.loader.getListLich()
        ) {
            if (l.getId_NV() == nv.getiD() && l.getNgay().equals(ngay)) {
                b = true;
                break;
            }
        }
        return b;
    }

    public void reloadLichPane() {
        panel.removeAll();
        panel.repaint();
        for (NhanVien nv : listNhanVien) {
            if (nv.getLoai() != 0) {
                panel.add(new NVPanel(nv));
            }
        }
        panel.repaint();
    }
}
