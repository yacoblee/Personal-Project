
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
	
	public Manage(PanelSwitch win) {

		setVisible(true);
		setLayout(null);

		JPanel jpn1 = new JPanel();
		jpn1.setLayout(null);
		jpn1.setBorder(new LineBorder(Color.BLACK));
		jpn1.setBackground(Color.LIGHT_GRAY);
		jpn1.setBounds(62, 30, 970, 491);

		add(jpn1);
		
	
		

		btnNewButton = new JButton("Á¶Èñ");
		btnNewButton.setFont(new Font("±¼¸²", Font.BOLD, 17));
		btnNewButton.setBounds(620, 97, 125, 46);
		jpn1.add(btnNewButton);

		button = new JButton("´ë¿©");
		button.setFont(new Font("±¼¸²", Font.BOLD, 17));
		button.setBounds(620, 168, 125, 46);
		jpn1.add(button);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
//				JInternalFrame intenal = new JInternalFrame("Ã¥ ´ë¿©");
//				
//				intenal.setBackground(Color.darkGray);
//				intenal.setBounds(230,366,404,240);
//				intenal.setLayout(null);
//				intenal.setVisible(true);
//
//				jpn1.add(intenal);

				JOptionPane.showInputDialog("´ë¿© È¸¿ø ÀüÈ­¹øÈ£");
			}
		});
		
		
		
		button_1 = new JButton("¹Ý³³");
		button_1.setFont(new Font("±¼¸²", Font.BOLD, 17));
		button_1.setBounds(620, 238, 125, 46);
		jpn1.add(button_1);
		
		
		
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
//				JInternalFrame intenal = new JInternalFrame("Ã¥ ´ë¿©");
//				intenal.setBackground(Color.darkGray);
//				intenal.setBounds(230,366,404,240);
//				intenal.setLayout(null);
//				intenal.setVisible(true);
//
//				jpn1.add(intenal);

				JOptionPane.showInputDialog("¹Ý³³ È¸¿ø ÀüÈ­¹øÈ£");
			}
		});
		
		
		

		button_2 = new JButton("¸ÞÀÎÈ¨");
		button_2.setFont(new Font("±¼¸²", Font.BOLD, 17));
		button_2.setBounds(620, 396, 125, 46);
		jpn1.add(button_2);

		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				win.change("MainGui");
			}
		});

		JLabel lblNewLabel = new JLabel("Ã¥ Á¦¸ñ ");
		lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 16));
		lblNewLabel.setBounds(152, 111, 62, 18);
		jpn1.add(lblNewLabel);

		JLabel label = new JLabel("ÀúÀÚ ");
		label.setFont(new Font("±¼¸²", Font.PLAIN, 16));
		label.setBounds(152, 163, 62, 18);
		jpn1.add(label);

		JLabel label_1 = new JLabel("ÃâÆÇ»ç ");
		label_1.setFont(new Font("±¼¸²", Font.PLAIN, 16));
		label_1.setBounds(152, 217, 62, 18);
		jpn1.add(label_1);

		JLabel lblIsbn = new JLabel("ISBN ");
		lblIsbn.setFont(new Font("±¼¸²", Font.PLAIN, 16));
		lblIsbn.setBounds(152, 266, 62, 18);
		jpn1.add(lblIsbn);

		textField = new JTextField();
		textField.setFont(new Font("±¼¸²", Font.PLAIN, 17));
		textField.setBounds(249, 109, 230, 24);
		jpn1.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("±¼¸²", Font.PLAIN, 17));
		textField_1.setColumns(10);
		textField_1.setBounds(249, 161, 230, 24);
		jpn1.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("±¼¸²", Font.PLAIN, 17));
		textField_2.setColumns(10);
		textField_2.setBounds(249, 215, 230, 24);
		jpn1.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("±¼¸²", Font.PLAIN, 17));
		textField_3.setColumns(10);
		textField_3.setBounds(249, 260, 230, 24);
		jpn1.add(textField_3);

		JPanel jpn2 = new JPanel();
		jpn2.setLayout(null);
		add(jpn2);
		jpn2.setBounds(66, 547, 970, 174);
		jpn2.setBackground(SystemColor.activeCaption);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(0,0,970,174);
		jpn2.add(scroll);
		
		JTable jtable = new JTable();
		scroll.setViewportView(jtable);
		jtable.setModel(new DefaultTableModel(
						new Object[][] {
							{ null, null, null, null }, 
							{ null, null, null, null },
							{ null, null, null, null },
							{ null, null, null, null } 
							},
						
				new String[] { "Á¦¸ñ", "ÀúÀÚ", "ISBN", "´ë¿©Á¤º¸" })
			{
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;
					Class[] columnTypes = new Class[] {
			String.class, String.class, String.class, String.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}

				});
		jtable.getColumnModel().getColumn(0).setPreferredWidth(135);
		jtable.getColumnModel().getColumn(1).setPreferredWidth(186);
		jtable.getColumnModel().getColumn(2).setPreferredWidth(208);
		jtable.getColumnModel().getColumn(3).setPreferredWidth(191);
		jtable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

	}

}
//
//class newWindow extends JFrame{
//	
//	public newWindow() {
//		
//	
//	setSize(400,260);
//	setLayout(null);
//	JLabel lb= new JLabel("ÀÔ·Â");
//	lb.setFont(new Font("Tahoma", Font.PLAIN, 25));
//	lb.setBounds(100,30,200,50);
//	
//	JTextField field = new JTextField(10);
//	field.setBounds(100,80,200, 30);
//	
//	JButton btn = new JButton("ÀÔ·Â");
//	btn.setBounds(100,130,200,40);
//	
//	btn.addActionListener(new ActionListener() {
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			lb.setText(field.getText());
//			dispose();
//			
//		}
//	});
//	}
//}
