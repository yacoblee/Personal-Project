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
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/ORCL";
	String user = "green";
	String password = "green1234";
	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	private static final long serialVersionUID = 1L;
	private JButton btIm, btEx, bthome;
	private JScrollPane textscroll;
	private JList list;
	private JTextField txname, txnum, txaddress;
	private JLabel laname, lanum, laaddress;
	
	public Book(PanelSwitch win) {
		setLayout(null);
		
		Font f1 = new Font("���� ��üL", Font.BOLD, 15);
		
		btIm = new JButton("���");
		btIm.setBounds(816, 80, 127, 43);
		btEx = new JButton("����");
		btEx.setBounds(816, 147, 127, 43);
		
		laname = new JLabel("ý����");
		laname.setFont(f1);
		laname.setBounds(714, 368, 62, 18);
		txname = new JTextField();
		txname.setBounds(816, 368, 224, 32);
		
		lanum = new JLabel("����");
		lanum.setFont(f1);
		lanum.setBounds(714, 428, 62, 18);
		txnum = new JTextField();
		txnum.setBounds(816, 428, 192, 32);
		
		laaddress = new JLabel("���ǻ�");
		laaddress.setFont(f1);
		laaddress.setBounds(714, 486, 62, 18);
		txaddress = new JTextField();
		txaddress.setBounds(816, 486, 192, 32);
		
		JTextPane textPane_3 = new JTextPane(); // ISBN �ڵ� �߰� �ʵ�
		textPane_3.setBounds(816, 539, 192, 32);
		add(textPane_3);
		
		JLabel label_4 = new JLabel("ISBN");
		label_4.setBounds(714, 539, 62, 18);
		add(label_4);
		
	
		
		bthome = new JButton("Ȩ����");
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

		String[] colNames = new String[] {"����", "����", "���ǻ�", "ISBN", "������Ȳ"};
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

	public void connDB() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success");
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println("statement create success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
