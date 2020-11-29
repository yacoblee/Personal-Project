import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Book extends JPanel {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/ORCL";
	String user = "green";
	String password = "green1234";
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	/**
	 * 
	 */


	private static final long serialVersionUID = 1L;
	private JButton btIm, btEx, bthome;
	@SuppressWarnings("unused")
	private JScrollPane textscroll;
	private JTextField txname, txnum, txaddress, txisbn;
	private JLabel laname, lanum, laaddress;
	static PanelSwitch sw;
	public Book(PanelSwitch win) {
		
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
		
		JLabel label_4 = new JLabel("ISBN"); //ISBN label.
		label_4.setBounds(714, 539, 62, 18);
		label_4.setFont(f1);
		txisbn = new JTextField(); //ISBN texfield
		txisbn.setBounds(816,539,192,32);
		
	
		
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

		String[] colNames = new String[] {"ISBN","제목", "저자", "출판사", "대출현황"};
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
		add(label_4);
		add(txisbn);
		add(bthome);
		
		
		try { // first visible table
			ArrayList<MemberVo> list = new ArrayList<MemberVo>();

			String query = "SELECT * FROM CLIENT ";

			System.out.println("SQL : " + query);

			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				System.out.println("0 row selected...");
			} else {
				System.out.println(rs.getRow() + "rows selected");
				rs.first();
				while (rs.next()) {
					String name = rs.getString("MNAME");
					String number = rs.getString("MPHONE");
					String address = rs.getString("MADDRESS");

					MemberVo data = new MemberVo(name, number, address);
					list.add(data);

					Object data1[] = { name, number, address };
					model1.addRow(data1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		bthome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				win.change("MainGui");

			}
		});
		
		btIm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
			
//				int rowIndex = table.getSelectedRow();
				
			}
		});
	}
}

