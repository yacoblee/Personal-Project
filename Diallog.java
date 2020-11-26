
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Diallog extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	static PanelSwitch sw;

	public Diallog() {
		sw = new PanelSwitch();
		frame = new JFrame();
		frame.setSize(581, 726);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(14, 12, 535, 655);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("전화번호 :");
		label.setFont(new Font("HY강M", Font.PLAIN, 17));
		label.setBounds(60, 142, 80, 18);
		panel.add(label);

		JButton btnNewButton = new JButton("Commit");
		btnNewButton.setFont(new Font("돋움체", Font.BOLD, 17));
		btnNewButton.setBounds(416, 190, 105, 50);
		panel.add(btnNewButton);

		textField = new JTextField();
		textField.setBounds(167, 57, 190, 24);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(167, 140, 190, 24);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel label_1 = new JLabel("이름  :");
		label_1.setFont(new Font("HY강M", Font.PLAIN, 17));
		label_1.setBounds(60, 59, 80, 18);
		panel.add(label_1);

		frame.setVisible(true);
	}

}