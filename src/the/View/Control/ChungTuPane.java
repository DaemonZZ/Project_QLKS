package the.View.Control;

import javax.swing.JLayeredPane;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class ChungTuPane extends JLayeredPane {
    private JTable table;
    JPanel centerPanel, pnHoaDon, pnthietBi, pnDv, pnNhapXuat;

    public ChungTuPane() {
        setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        add(panel, BorderLayout.NORTH);

        JButton btnNewButton = new JButton("New button");
        panel.add(btnNewButton);

        JPanel topMenu = new JPanel();
        add(topMenu, BorderLayout.EAST);

        JButton btnNewButton_1 = new JButton("New button");
        topMenu.add(btnNewButton_1);

        JPanel sideBar = new JPanel();
        add(sideBar, BorderLayout.WEST);
        GridBagLayout gbl_sideBar = new GridBagLayout();
        gbl_sideBar.columnWidths = new int[]{85, 0};
        gbl_sideBar.rowHeights = new int[]{21, 0, 0, 0, 0, 0, 0};
        gbl_sideBar.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_sideBar.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        sideBar.setLayout(gbl_sideBar);

        JButton btnHD = new JButton("Hóa đơn thanh toán");
        btnHD.setBackground(SystemColor.text);
        btnHD.setHorizontalAlignment(SwingConstants.LEFT);
        btnHD.setMargin(new Insets(20, 14, 2, 14));
        btnHD.setIconTextGap(10);
        btnHD.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnHD.setBorder(new EmptyBorder(0, 10, 0, 0));
        btnHD.setAlignmentY(0.0f);
        btnHD.addActionListener(btn);
        GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
        gbc_btnNewButton_3.ipady = 15;
        gbc_btnNewButton_3.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnNewButton_3.gridx = 0;
        gbc_btnNewButton_3.gridy = 0;
        sideBar.add(btnHD, gbc_btnNewButton_3);

        JButton btnNhapXuat = new JButton("Nhập xuất hàng");
        btnNhapXuat.setBackground(SystemColor.inactiveCaptionBorder);
        btnNhapXuat.setHorizontalAlignment(SwingConstants.LEFT);
        btnNhapXuat.setMargin(new Insets(20, 14, 2, 14));
        btnNhapXuat.setIconTextGap(10);
        btnNhapXuat.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnNhapXuat.setBorder(new EmptyBorder(0, 10, 0, 0));
        btnNhapXuat.addActionListener(btn);
        GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
        gbc_btnNewButton_2.ipady = 15;
        gbc_btnNewButton_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnNewButton_2.gridx = 0;
        gbc_btnNewButton_2.gridy = 1;
        sideBar.add(btnNhapXuat, gbc_btnNewButton_2);

        JButton btnKhodv = new JButton("Kho dịch vụ");
		btnKhodv.setBackground(SystemColor.inactiveCaptionBorder);
		btnKhodv.setHorizontalAlignment(SwingConstants.LEFT);
		btnKhodv.setMargin(new Insets(20, 14, 2, 14));
		btnKhodv.setIconTextGap(10);
		btnKhodv.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnKhodv.setBorder(new EmptyBorder(0, 10, 0, 0));
		btnKhodv.addActionListener(btn);
        GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
        gbc_btnNewButton_4.ipady = 15;
        gbc_btnNewButton_4.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnNewButton_4.gridx = 0;
        gbc_btnNewButton_4.gridy = 2;
        sideBar.add(btnKhodv, gbc_btnNewButton_4);

        JButton btnKhoTB = new JButton("Kho thiết bị");
        btnKhoTB.setBackground(SystemColor.inactiveCaptionBorder);
        btnKhoTB.setHorizontalAlignment(SwingConstants.LEFT);
        btnKhoTB.setMargin(new Insets(20, 14, 2, 14));
        btnKhoTB.setIconTextGap(10);
        btnKhoTB.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnKhoTB.setBorder(new EmptyBorder(0, 10, 0, 0));
        btnKhoTB.addActionListener(btn);
        GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
        gbc_btnNewButton_5.ipady = 15;
        gbc_btnNewButton_5.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnNewButton_5.gridx = 0;
        gbc_btnNewButton_5.gridy = 3;
        sideBar.add(btnKhoTB, gbc_btnNewButton_5);

        centerPanel = new JPanel();
        add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(new BorderLayout());

        pnthietBi = new JPanel();
        centerPanel.add(pnthietBi,BorderLayout.CENTER);

        pnDv = new JPanel();
        centerPanel.add(pnDv,BorderLayout.CENTER);

        pnNhapXuat = new JPanel();
        centerPanel.add(pnNhapXuat,BorderLayout.CENTER);

        pnHoaDon = new JPanel();
        centerPanel.add(pnHoaDon,BorderLayout.CENTER);
        pnHoaDon.setLayout(new BorderLayout(0, 0));

        JPanel pnbot = new JPanel();
        pnHoaDon.add(pnbot, BorderLayout.SOUTH);

        JButton btnNewButton_8 = new JButton("New button");
		pnbot.add(btnNewButton_8);

        JScrollPane scrollPane = new JScrollPane();
        pnHoaDon.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        scrollPane.setViewportView(table);
    }

    private ActionListener btn = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Hóa đơn thanh toán")) {
				pnHoaDon.setVisible(true);
				pnDv.setVisible(false);
				pnthietBi.setVisible(false);
				pnNhapXuat.setVisible(false);
            }
			if (e.getActionCommand().equals("Nhập xuất hàng")) {
				pnHoaDon.setVisible(false);
				pnDv.setVisible(false);
				pnthietBi.setVisible(false);
				pnNhapXuat.setVisible(true);
			}
			if (e.getActionCommand().equals("Kho dịch vụ")) {
				pnHoaDon.setVisible(false);
				pnDv.setVisible(true);
				pnthietBi.setVisible(false);
				pnNhapXuat.setVisible(false);
			}
			if (e.getActionCommand().equals("Kho thiết bị")) {
				pnHoaDon.setVisible(false);
				pnDv.setVisible(false);
				pnthietBi.setVisible(true);
				pnNhapXuat.setVisible(false);
			}
        }
    };

}
