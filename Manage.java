
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

import java.awt.Font;
import java.awt.SystemColor;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class Manage extends JPanel {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/ORCL";
	String user = "green";
	String password = "green1234";
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
//==================================================================
	private static final long serialVersionUID = 1L;
	private JButton btSearch, btRent, btReturn, btHome;
	private JTextField textField;
	public JTable jtable;
	
	static Diallog dial;
	static PanelSwitch sw;
	static Diallog_return dial2;
	int removeNum = 0;

	PreparedStatement ptst = null;

	JComboBox<String> combo;
	String items[] = { "제목", "저자", "출판사", "ISBN" };

// ============================================================================================================

	public Manage(PanelSwitch win) {
		String[] colNames = new String[] { "제목", "저자", "출판사", "ISBN", "대출현황" };
		DefaultTableModel model = new DefaultTableModel(colNames, 0);
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

		sw = new PanelSwitch(); // connect database

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

		setVisible(true);
		setLayout(null);

		ImageIcon icon1 = new ImageIcon("C:\\Users\\yacob\\Desktop\\eclipse_data\\PeronalProject\\image\\search.png");
		ImageIcon icon2= new ImageIcon("C:\\Users\\yacob\\Desktop\\eclipse_data\\PeronalProject\\image\\rental1.png");
		ImageIcon icon3 = new ImageIcon("C:\\Users\\yacob\\Desktop\\eclipse_data\\PeronalProject\\image\\revise.png");
		ImageIcon icon4 = new ImageIcon("C:\\Users\\yacob\\Desktop\\eclipse_data\\PeronalProject\\image\\home.png");
		
		JPanel jpn1 = new JPanel();
		jpn1.setLayout(null);
		jpn1.setBorder(new LineBorder(Color.BLACK));
		jpn1.setBackground(Color.LIGHT_GRAY);
		jpn1.setBounds(66, 31, 970, 265);

		add(jpn1);

		combo = new JComboBox<String>(items);
		combo.setFont(new Font("맑은고딕", Font.PLAIN, 15));

		combo.setBounds(157, 109, 66, 24);
		jpn1.add(combo);

		btSearch = new JButton("",icon1);
		btSearch.setFont(new Font("굴림", Font.BOLD, 17));
		btSearch.setBounds(491, 97, 125, 46);
		btSearch.setSelectedIcon(icon1);
		jpn1.add(btSearch);

		btSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {

					for (int i = removeNum - 1; i >= 0; i--) {
						model.removeRow(i);
					}
					removeNum = 0;

					String keyWord = textField.getText();
					int i = combo.getSelectedIndex();
					// part search system
					String index;
					if (i == 0)
						index = "BOOKNAME";
					else if (i == 1)
						index = "BOOKWRITER";
					else if (i == 2)
						index = "BOOKPUB";
					else
						index = "ISBN";

					System.out.println(index);
					System.out.println(keyWord);

					String sql = "SELECT * FROM LIBRARY WHERE " + index + " LIKE'%" + keyWord + "%'";
					stmt = con.createStatement();
					System.out.println(sql);
					rs = stmt.executeQuery(sql);

					while (rs.next()) {
						model.addRow(new Object[] { rs.getString("BOOKNAME"), rs.getString("BOOKWRITER"),
								rs.getString("BOOKPUB"), rs.getString("ISBN"), rs.getString("RECONFIRME") });
						removeNum++;
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

		btRent = new JButton("",icon2);
		btRent.setFont(new Font("굴림", Font.BOLD, 17));
		btRent.setBounds(620, 97, 125, 46);
		btRent.setSelectedIcon(icon2);
		jpn1.add(btRent);

		btReturn = new JButton("",icon3);
		btReturn.setFont(new Font("굴림", Font.BOLD, 17));
		btReturn.setBounds(756, 97, 125, 46);
		btReturn.setSelectedIcon(icon3);
		jpn1.add(btReturn);

		btHome = new JButton("",icon4);
		btHome.setFont(new Font("굴림", Font.BOLD, 17));
		btHome.setBounds(756, 194, 125, 46);
		btHome.setSelectedIcon(icon4);
		jpn1.add(btHome);

		btHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				win.change("MainGui");
			}
		});

		textField = new JTextField(); // 책제목
		textField.setFont(new Font("굴림", Font.PLAIN, 17));
		textField.setBounds(249, 109, 230, 24);
		jpn1.add(textField);
		textField.setColumns(10);

		JPanel jpn2 = new JPanel();
		jpn2.setLayout(null);
		add(jpn2);
		jpn2.setBounds(66, 306, 970, 415);
		jpn2.setBackground(SystemColor.activeCaption);

		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(0, 0, 970, 415);
		jpn2.add(scroll);

		jtable = new JTable(model);
		scroll.setViewportView(jtable);
		
		btRent.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {

//					int rows = jtable.getSelectedRow();
//					int column = jtable.getSelectedColumn();
//					String isbn = (String) jtable.getModel().getValueAt(rows, column);
//					System.out.println(column);
//
//					String index = "";
//					System.out.println(isbn);
//					if (column == 0) {
//						index = "BOOKNAME";
//					} else if (column == 1) {
//						index = "BOOKWRITER";
//					} else if (column == 2) {
//						index = "BOOKPUB";
//					} else if (column == 3) {
//						index = "ISBN";
//					} else {
//						JOptionPane.showConfirmDialog(new JButton(), "입력 열을 확인해주세요");
//					}
//					System.out.println(index);
					
					dial = new Diallog();
					dial.hide();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		btReturn.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dial2 = new Diallog_return();
				dial2.hide();
			}
		});

		jtable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	}
}
