import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
	private JTextField txbook, txwriter, txpublish, txisbn;
	private JLabel laname, lanum, laaddress;
	static PanelSwitch sw;

	int removeNum = 0;
	String[] colNames = new String[] { "제목", "저자", "출판사", "ISBN", "대출현황" };
	DefaultTableModel model = new DefaultTableModel(colNames, 0);
	PreparedStatement ptst = null;

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

		ImageIcon icon1 = new ImageIcon("C:\\Users\\yacob\\Desktop\\eclipse_data\\PeronalProject\\image\\enroll.png");
		ImageIcon icon2 = new ImageIcon("C:\\Users\\yacob\\Desktop\\eclipse_data\\PeronalProject\\image\\delete.png");
		ImageIcon icon3 = new ImageIcon("C:\\Users\\yacob\\Desktop\\eclipse_data\\PeronalProject\\image\\revise.png");
		ImageIcon icon4 = new ImageIcon("C:\\Users\\yacob\\Desktop\\eclipse_data\\PeronalProject\\image\\home.png");
		
		btIm = new JButton("",icon1);
		btIm.setBounds(816, 80, 127, 43);
		btIm.setSelectedIcon(icon1);
		
		
		btEx = new JButton("",icon2);
		btEx.setBounds(816, 147, 127, 43);
		btEx.setSelectedIcon(icon2);
		laname = new JLabel("첵제목");
		laname.setFont(f1);
		laname.setBounds(714, 368, 62, 18);
		txbook = new JTextField();
		txbook.setBounds(816, 368, 224, 32);

		lanum = new JLabel("저자");
		lanum.setFont(f1);
		lanum.setBounds(714, 428, 62, 18);
		txwriter = new JTextField();
		txwriter.setBounds(816, 428, 192, 32);

		laaddress = new JLabel("출판사");
		laaddress.setFont(f1);
		laaddress.setBounds(714, 486, 62, 18);
		txpublish = new JTextField();
		txpublish.setBounds(816, 486, 192, 32);

		
		txisbn = new JTextField(); // ISBN texfield
		txisbn.setBounds(816, 539, 192, 32);
		
		JLabel label_4 = new JLabel("ISBN"); // ISBN label.
		label_4.setBounds(714, 539, 62, 18);
		label_4.setFont(f1);
		
//		JTextPane textPane_3 = new JTextPane(); // ISBN 코드 추가 필드
//		textPane_3.setBounds(816, 539, 192, 32);
//		add(textPane_3);

		bthome = new JButton("",icon4);
		bthome.setBounds(913, 645, 127, 43);
		bthome.setSelectedIcon(icon4);
		JButton btchange = new JButton("",icon3);
		btchange.setBounds(816, 204, 127, 43);
		btchange.setSelectedIcon(icon3);

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

		JTable table = new JTable(model);
		scrollPane_1.setViewportView(table);
		scrollPane_1.setBackground(Color.GRAY);
		scrollPane_1.setViewportView(table);
		
		add(btIm);
		add(btEx);
		add(laname);
		add(txbook);
		add(lanum);
		add(txwriter);
		add(laaddress);
		add(txpublish);
		add(label_4);
		
		add(txisbn);
		add(bthome);
		add(btchange);
		try { // first visible table

			String query = "SELECT * FROM LIBRARY ORDER BY BOOKNAME";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				model.addRow(new Object[] { rs.getString("BOOKNAME"), rs.getString("BOOKWRITER"),
						rs.getString("BOOKPUB"), rs.getString("ISBN"), rs.getString("RECONFIRME") });
				removeNum++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		btIm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String isbn = txisbn.getText();
				String book = txbook.getText();
				String writer = txwriter.getText();
				String publish = txpublish.getText();

				if (isbn.length() < 13 && book.length() < 1 && writer.length() < 1 && publish.length() < 1) {
					JOptionPane.showConfirmDialog(new JButton(), "입력값을 확인해주세요");
					return; 
					//value check
					
				} else {
					try {
					String sql = "INSERT INTO LIBRARY VALUES('" + book + "','" + writer + "','" + publish + "','"
								+ isbn+"','" + "YES" + "')";
						System.out.println(sql);
						rs = stmt.executeQuery(sql);

						for (int i = removeNum - 1; i >= 0; i--) {
							model.removeRow(i);
						}

						String query = "SELECT * FROM LIBRARY ORDER BY BOOKNAME";
						stmt = con.createStatement();
						rs = stmt.executeQuery(query);
						while (rs.next()) {
							model.addRow(new Object[] { rs.getString("BOOKNAME"), rs.getString("BOOKWRITER"),
									rs.getString("BOOKPUB"), rs.getString("ISBN"), rs.getString("RECONFIRME") });
							removeNum++;
						}
						txisbn.setText("");
						txbook.setText("");
						txwriter.setText("");
						txpublish.setText("");
					} catch (Exception e) {
						e.printStackTrace();

					}
				}

			}
		});
		
		btEx.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
				int rows = table.getSelectedRow();
				if (rows < 0) {
					JOptionPane.showMessageDialog(table, "행을 선택해주세요");
					return;
				} else {
					System.out.println(rows);
					String sql = "DELETE FROM LIBRARY WHERE ROWNUM = ?";
					ptst = con.prepareStatement(sql);
					ptst.setInt(1, rows+1);
					ptst.executeUpdate();
					
					System.out.println(removeNum);
					for(int i=removeNum-1;i>=0;i--) {
						model.removeRow(i);
						
					}
					removeNum=0;
					
					//repaint
					String query= "SELECT * FROM LIBRARY ORDER BY BOOKNAME";
					stmt=con.createStatement();
					rs=stmt.executeQuery(query);
					while (rs.next()) {
						model.addRow(new Object[] { rs.getString("BOOKNAME"), rs.getString("BOOKWRITER"),
								rs.getString("BOOKPUB"), rs.getString("ISBN"), rs.getString("RECONFIRME") });
						removeNum++;
					}
					JOptionPane.showMessageDialog(new JButton(), "삭제되었습니다.");
				}
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		btchange.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int rows = table.getSelectedRow();
				int column = table.getSelectedColumn();
				String a = (String) table.getModel().getValueAt(rows,column);
				 System.out.println(a);
				 System.out.println(column);
				 String index = "";
				 String isbn = txisbn.getText();
				String book = txbook.getText();
				String writer = txwriter.getText();
				String publish = txpublish.getText();
				
				if (column == 0)
					index = "set BOOKNAME = '" + book + "' where BOOKNAME = '" + a + "'";
				else if (column == 1)
					index = "set BOOKWRITER = '" + writer + "' where BOOKWRITER = '" + a + "'";
				else if (column == 2)
					index = "set BOOKPUB = '" + publish + "' where BOOKPUB = '" + a + "'";
				else if (column == 3)
					index = "set ISBN = '" + isbn + "' where ISBN = '" + a + "'";
					try {
						String sql = "update LIBRARY "+ index;
						System.out.println(sql);
						stmt = con.createStatement();
						rs = stmt.executeQuery(sql);
					
								String query= "SELECT * FROM LIBRARY ORDER BY BOOKNAME";
								stmt=con.createStatement();
								rs=stmt.executeQuery(query);
								while (rs.next()) {
									model.addRow(new Object[] { rs.getString("BOOKNAME"), rs.getString("BOOKWRITER"),
											rs.getString("BOOKPUB"), rs.getString("ISBN"), rs.getString("RECONFIRME") });
									removeNum++;
								}
					
					
					
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					 
				
				
			}
		});

		bthome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				win.change("MainGui");

			}
		});
	}
}
