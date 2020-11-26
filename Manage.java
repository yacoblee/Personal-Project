
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.Dialog.ModalityType;
import java.awt.event.*;

public class Manage extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnNewButton, button, button_1, button_2;
	private JTextField textField, textField_1, textField_2, textField_3;
	static Diallog dial;

	public Manage(PanelSwitch win) {

		setVisible(true);
		setLayout(null);

		JPanel jpn1 = new JPanel();
		jpn1.setLayout(null);
		jpn1.setBorder(new LineBorder(Color.BLACK));
		jpn1.setBackground(Color.LIGHT_GRAY);
		jpn1.setBounds(62, 30, 970, 491);

		add(jpn1);

		btnNewButton = new JButton("¡∂»Ò");
		btnNewButton.setFont(new Font("±º∏≤", Font.BOLD, 17));
		btnNewButton.setBounds(620, 97, 125, 46);
		jpn1.add(btnNewButton);

		button = new JButton("¥Îø©");
		button.setFont(new Font("±º∏≤", Font.BOLD, 17));
		button.setBounds(620, 168, 125, 46);
		jpn1.add(button);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				dial = new Diallog();
				dial.dispose();
			}
		});

		button_1 = new JButton("π›≥≥");
		button_1.setFont(new Font("±º∏≤", Font.BOLD, 17));
		button_1.setBounds(620, 238, 125, 46);
		jpn1.add(button_1);

		button_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dial = new Diallog();
				dial.dispose();
			}
		});

		button_2 = new JButton("∏ﬁ¿Œ»®");
		button_2.setFont(new Font("±º∏≤", Font.BOLD, 17));
		button_2.setBounds(620, 396, 125, 46);
		jpn1.add(button_2);

		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				win.change("MainGui");
			}
		});

		JLabel lblNewLabel = new JLabel("√• ¡¶∏Ò ");
		lblNewLabel.setFont(new Font("±º∏≤", Font.PLAIN, 16));
		lblNewLabel.setBounds(152, 111, 62, 18);
		jpn1.add(lblNewLabel);

		JLabel label = new JLabel("¿˙¿⁄ ");
		label.setFont(new Font("±º∏≤", Font.PLAIN, 16));
		label.setBounds(152, 163, 62, 18);
		jpn1.add(label);

		JLabel label_1 = new JLabel("√‚∆«ªÁ ");
		label_1.setFont(new Font("±º∏≤", Font.PLAIN, 16));
		label_1.setBounds(152, 217, 62, 18);
		jpn1.add(label_1);

		JLabel lblIsbn = new JLabel("ISBN ");
		lblIsbn.setFont(new Font("±º∏≤", Font.PLAIN, 16));
		lblIsbn.setBounds(152, 266, 62, 18);
		jpn1.add(lblIsbn);

		textField = new JTextField();
		textField.setFont(new Font("±º∏≤", Font.PLAIN, 17));
		textField.setBounds(249, 109, 230, 24);
		jpn1.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("±º∏≤", Font.PLAIN, 17));
		textField_1.setColumns(10);
		textField_1.setBounds(249, 161, 230, 24);
		jpn1.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("±º∏≤", Font.PLAIN, 17));
		textField_2.setColumns(10);
		textField_2.setBounds(249, 215, 230, 24);
		jpn1.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("±º∏≤", Font.PLAIN, 17));
		textField_3.setColumns(10);
		textField_3.setBounds(249, 260, 230, 24);
		jpn1.add(textField_3);

		JPanel jpn2 = new JPanel();
		jpn2.setLayout(null);
		add(jpn2);
		jpn2.setBounds(66, 547, 970, 174);
		jpn2.setBackground(SystemColor.activeCaption);

		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(0, 0, 970, 174);
		jpn2.add(scroll);

		String[] colNames = new String[] { "¡¶∏Ò", "¿˙¿⁄", "√‚∆«ªÁ", "¥Î√‚«ˆ»≤", "¥Î√‚≥Ø¬•" };
		DefaultTableModel model3 = new DefaultTableModel(colNames, 0);
		JTable jtable = new JTable(model3);
		scroll.setViewportView(jtable);

		jtable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		String[] rows = new String[5];
		model3.addRow(rows);
	}
}
