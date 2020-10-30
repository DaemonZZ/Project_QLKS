package the.View;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;

public class LogDialog extends JDialog {
	public LogDialog(int id) {
		getContentPane().setLayout(null);
		setSize(575, 453);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("coming soon...");
		lblNewLabel.setToolTipText("Lịch Sử đăng nhập, giao dịch ...");
		lblNewLabel.setBounds(10, 11, 534, 63);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setBounds(10, 97, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên:");
		lblNewLabel_1_1.setBounds(198, 97, 46, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Bộ Phận");
		lblNewLabel_1_2.setBounds(375, 97, 46, 14);
		getContentPane().add(lblNewLabel_1_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 127, 534, 253);
		getContentPane().add(scrollPane);
		
		JButton btnNewButton = new JButton("In");
		btnNewButton.setBounds(110, 383, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Đóng");
		btnNewButton_1.setBounds(362, 383, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				AccountManagementForm.s.setEnabled(true);
				dispose();
			}
			
		});
	}
}
