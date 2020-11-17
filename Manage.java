
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.*;

public class Manage extends JPanel{
	/**
	 * 
	 */
	private JFrame frame;
	private static final long serialVersionUID = 1L;
	private JButton btnNewButton, button, button_1,button_2;
	private JTextField textField,textField_1,textField_2,textField_3 ;
	
	public Manage(PanelSwitch win) {
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(128, 128, 128)));
		panel.setBackground(new Color(210, 180, 140));
		panel.setBounds(14, 12, 1054, 729);
		panel.setVisible(true);
		panel.setLayout(null);
		add(panel);
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.BLACK));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(240, 12, 800, 502);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		btnNewButton = new JButton("¡∂»Ò");
		btnNewButton.setFont(new Font("±º∏≤", Font.BOLD, 17));
		btnNewButton.setBounds(620, 97, 125, 46);
		panel_1.add(btnNewButton);
		
		button = new JButton("µÓ∑œ");
		button.setFont(new Font("±º∏≤", Font.BOLD, 17));
		button.setBounds(620, 168, 125, 46);
		panel_1.add(button);
		
		button_1 = new JButton("ªË¡¶");
		button_1.setFont(new Font("±º∏≤", Font.BOLD, 17));
		button_1.setBounds(620, 238, 125, 46);
		panel_1.add(button_1);
		
		button_2 = new JButton("¡æ∑·");
		button_2.setFont(new Font("±º∏≤", Font.BOLD, 17));
		button_2.setBounds(620, 396, 125, 46);
		panel_1.add(button_2);
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				win.change("MainGui");
			}
		});
		
		JLabel lblNewLabel = new JLabel("√• ¡¶∏Ò ");
		lblNewLabel.setFont(new Font("±º∏≤", Font.PLAIN, 16));
		lblNewLabel.setBounds(152, 111, 62, 18);
		panel_1.add(lblNewLabel);
		
		JLabel label = new JLabel("¿˙¿⁄ ");
		label.setFont(new Font("±º∏≤", Font.PLAIN, 16));
		label.setBounds(152, 163, 62, 18);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("√‚∆«ªÁ ");
		label_1.setFont(new Font("±º∏≤", Font.PLAIN, 16));
		label_1.setBounds(152, 217, 62, 18);
		panel_1.add(label_1);
		
		JLabel lblIsbn = new JLabel("ISBN ");
		lblIsbn.setFont(new Font("±º∏≤", Font.PLAIN, 16));
		lblIsbn.setBounds(152, 266, 62, 18);
		panel_1.add(lblIsbn);
		
		textField = new JTextField();
		textField.setFont(new Font("±º∏≤", Font.PLAIN, 17));
		textField.setBounds(249, 109, 243, 32);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("±º∏≤", Font.PLAIN, 17));
		textField_1.setColumns(10);
		textField_1.setBounds(249, 161, 185, 32);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("±º∏≤", Font.PLAIN, 17));
		textField_2.setColumns(10);
		textField_2.setBounds(249, 215, 185, 32);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("±º∏≤", Font.PLAIN, 17));
		textField_3.setColumns(10);
		textField_3.setBounds(249, 264, 230, 32);
		panel_1.add(textField_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 12, 226, 705);
		panel.add(scrollPane);
		
		JTable table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"¿Ã∏ß", "¿¸»≠π¯»£", "√•¡¶∏Ò"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(73);
		table.getColumnModel().getColumn(1).setPreferredWidth(93);
		table.getColumnModel().getColumn(2).setPreferredWidth(106);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(240, 513, 800, 204);
		panel.add(scrollPane_1);
		
		JTable table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane_1.setViewportView(table_1);
		table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage window = new Manage(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	}

