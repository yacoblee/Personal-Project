import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Member extends JPanel {
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
	private JButton btIm, btEx,bthome;
	private JScrollPane textscroll;
	private JList list;
	private JTextField txname, txnum,txaddress;
	private JLabel laname,lanum,laaddress;
	
	public Member (PanelSwitch win) {
		
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
		setLayout(null);
		
		Font f1 =new Font("���� ��üL", Font.BOLD, 15);
		
		
		
		btIm = new JButton("���");
		btIm.setBounds(816, 80, 127, 43);
		btEx = new JButton("����");
		btEx.setBounds(816, 147, 127, 43);
		
		laname = new JLabel("�̸�");
		laname.setFont(f1);
		laname.setBounds(714, 368, 62, 18);
		txname =new JTextField();
		txname.setBounds(816, 428, 192, 32);
		
		lanum=new JLabel("��ȣ");
		lanum.setFont(f1);
		lanum.setBounds(714, 428, 62, 18);
		txnum = new JTextField();
		txnum.setBounds(816, 368, 192, 32);
		
		
		laaddress = new JLabel("�ּ�");
		laaddress.setFont(f1);
		laaddress.setBounds(714, 486, 62, 18);
		txaddress = new JTextField();
		txaddress.setBounds(816, 486, 224, 32);
		
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 74, 677, 586);
		add(scrollPane);
		
		String[] colNames = new String[] { "�̸�", "��ȭ��ȣ", "�ּ�" };
		DefaultTableModel model0 = new DefaultTableModel(colNames, 0);
		JTable table = new JTable(model0);
		scrollPane.setViewportView(table);
		
		add(btIm);
		add(btEx);
		add(laname);
		add(txname);
		add(lanum);
		add(txnum);
		add(laaddress);
		add(txaddress);
		add(bthome);
		
//		try {
//		String sql = "select * from client";
//		stmt = con.prepareStatement(sql);
//		rs= stmt.executeQuery(sql);
//		
//		while (rs.next()) {
//			String name = rs.getString("MNAME");
//			String num = rs.getString("MPHONE");
//			String address = rs.getString("MADDRESS");
//			
//			Object data[] = {name,num,address};
//			model0.addRow(data);
//		}
//	
//	
//	}catch (Exception e) {
//		// TODO: handle exception
//	}
		
		
		btIm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String name = txname.getText();
					String number = txnum.getText();
					String address = txaddress.getText();
					
					System.out.println(name.length());
					System.out.println(number.length());
					System.out.println(address.length());
					if (number.length() >= 1 && name.length() > 10 && address.length() >= 5) {

						String query = "INSERT INTO CLIENT VALUES('" + number + "','" + name + "','" + address + "')";
						System.out.println(query);
						rs = stmt.executeQuery(query);
						
						String sql = "select * from client";
						stmt = con.prepareStatement(sql);
						rs= stmt.executeQuery(sql);
						
						while (rs.next()) {
							name = rs.getString("MNAME");
							number = rs.getString("MPHONE");
							address = rs.getString("MADDRESS");
							
							Object data[] = {name,number,address};
							model0.addRow(data);
						}
					} else {
						JOptionPane.showConfirmDialog(null, "�Է� ������ Ȯ�����ּ���");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		
		
		bthome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("MainGui");
				
			}
		});
		
	}
}
