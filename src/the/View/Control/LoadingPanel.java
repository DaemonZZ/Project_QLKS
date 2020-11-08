package the.View.Control;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;

public class LoadingPanel extends JFrame {
	JPanel panel = new JPanel();
	private JLabel lblNewLabel;
	public LoadingPanel() {
		setLayout(new BorderLayout());
		setSize(350,200);
		setLocationRelativeTo(null);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);

		add(panel,BorderLayout.CENTER);
		panel.setBorder(new LineBorder(SystemColor.activeCaption, 15));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(new GridLayout());


		lblNewLabel = new JLabel("Loading.....");
		lblNewLabel.setBackground(Color.ORANGE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 313, 162);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(lblNewLabel);
	}

	public static void main(String[] args) {
		new LoadingPanel();
	}
}
