import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Book extends JPanel {
	/**
	 * 
	 */


	private static final long serialVersionUID = 1L;
	private JButton btIm, btEx, bthome;
	private JScrollPane textscroll;
	private JList list;
	private JTextField txname, txnum, txaddress;
	private JLabel laname, lanum, laaddress;
	static PanelSwitch sw;
	public Book(PanelSwitch win) {
		sw = new PanelSwitch();
		setLayout(null);
		
		Font f1 = new Font("한컴 윤체L", Font.BOLD, 15);
		
		btIm = new JButton("등록");
		btIm.setBounds(816, 80, 127, 43);
		btEx = new JButton("삭제");
		btEx.setBounds(816, 147, 127, 43);
		
		laname = new JLabel("첵제목");
		laname.setFont(f1);
		laname.setBounds(714, 368, 62, 18);
		txname = new JTextField();
		txname.setBounds(816, 368, 224, 32);
		
		lanum = new JLabel("저자");
		lanum.setFont(f1);
		lanum.setBounds(714, 428, 62, 18);
		txnum = new JTextField();
		txnum.setBounds(816, 428, 192, 32);
		
		laaddress = new JLabel("출판사");
		laaddress.setFont(f1);
		laaddress.setBounds(714, 486, 62, 18);
		txaddress = new JTextField();
		txaddress.setBounds(816, 486, 192, 32);
		
		JTextPane textPane_3 = new JTextPane(); // ISBN 코드 추가 필드
		textPane_3.setBounds(816, 539, 192, 32);
		add(textPane_3);
		
		JLabel label_4 = new JLabel("ISBN");
		label_4.setBounds(714, 539, 62, 18);
		add(label_4);
		
	
		
		bthome = new JButton("홈으로");
		bthome.setBounds(913, 645, 127, 43);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 12, 1080, 17);
		add(separator);
		separator.setBackground(Color.DARK_GRAY);
		separator.setForeground(Color.DARK_GRAY);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.DARK_GRAY);
		separator_1.setBackground(Color.DARK_GRAY);
		separator_1.setBounds(0, 700, 1054, 17);
		add(separator_1);
		
		// scroll and separate

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(14, 92, 693, 569);
		add(scrollPane_1);

		String[] colNames = new String[] {"제목", "저자", "출판사", "ISBN", "대출현황"};
		DefaultTableModel model1 = new DefaultTableModel(colNames, 0);
		
		JTable table = new JTable(model1);
		scrollPane_1.setViewportView(table);
		scrollPane_1.setBackground(Color.GRAY);
		scrollPane_1.setViewportView(table);
		
		
		add(btIm);
		add(btEx);
		add(laname);
		add(txname);
		add(lanum);
		add(txnum);
		add(laaddress);
		add(txaddress);
		add(bthome);

		bthome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				win.change("MainGui");

			}
		});
		
		btIm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String [] rows = new String [5];
				rows[0]=txname.getText();
				rows[1]=txnum.getText();
				rows[2]=txaddress.getText();
				model1.addRow(rows);
//				int rowIndex = table.getSelectedRow();
				
			}
		});
	}
}

