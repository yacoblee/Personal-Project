
import javax.naming.directory.SearchControls;
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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btSearch, btRent, btReturn, btHome;
	private JTextField textField, textField_1, textField_2, textField_3;
	static Diallog dial;
	static PanelSwitch sw;

	int removeNum = 0;
	String[] colNames = new String[] { "제목", "저자", "출판사", "ISBN", "대출현황" };
	DefaultTableModel model = new DefaultTableModel(colNames, 0);
	PreparedStatement ptst = null;

	JComboBox combo;
	String items[] = { "제목", "저자", "출판사", "ISBN" };

	public Manage(PanelSwitch win) {

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

		JPanel jpn1 = new JPanel();
		jpn1.setLayout(null);
		jpn1.setBorder(new LineBorder(Color.BLACK));
		jpn1.setBackground(Color.LIGHT_GRAY);
		jpn1.setBounds(62, 30, 970, 491);

		add(jpn1);

		combo = new JComboBox(items);
		combo.setBounds(152, 111, 62, 18);
		jpn1.add(combo);

		btSearch = new JButton("조회");
		btSearch.setFont(new Font("굴림", Font.BOLD, 17));
		btSearch.setBounds(620, 97, 125, 46);
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

		btRent = new JButton("대여");
		btRent.setFont(new Font("굴림", Font.BOLD, 17));
		btRent.setBounds(620, 168, 125, 46);
		jpn1.add(btRent);

		btRent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				dial = new Diallog();
				dial.dispose();
			}
		});

		btReturn = new JButton("반납");
		btReturn.setFont(new Font("굴림", Font.BOLD, 17));
		btReturn.setBounds(620, 238, 125, 46);
		jpn1.add(btReturn);

		btReturn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dial = new Diallog();
				dial.dispose();
			}
		});

		btHome = new JButton("메인홈");
		btHome.setFont(new Font("굴림", Font.BOLD, 17));
		btHome.setBounds(620, 396, 125, 46);
		jpn1.add(btHome);

		btHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				win.change("MainGui");
			}
		});

//		JLabel lblNewLabel = new JLabel("책 제목 ");
//		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 16));
//		lblNewLabel.setBounds(152, 111, 62, 18);
//		jpn1.add(lblNewLabel);

		JLabel label = new JLabel("저자 ");
		label.setFont(new Font("굴림", Font.PLAIN, 16));
		label.setBounds(152, 163, 62, 18);
		jpn1.add(label);

		JLabel label_1 = new JLabel("출판사 ");
		label_1.setFont(new Font("굴림", Font.PLAIN, 16));
		label_1.setBounds(152, 217, 62, 18);
		jpn1.add(label_1);

		JLabel lblIsbn = new JLabel("ISBN ");
		lblIsbn.setFont(new Font("굴림", Font.PLAIN, 16));
		lblIsbn.setBounds(152, 266, 62, 18);
		jpn1.add(lblIsbn);

		textField = new JTextField(); // 책제목
		textField.setFont(new Font("굴림", Font.PLAIN, 17));
		textField.setBounds(249, 109, 230, 24);
		jpn1.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField(); // 저자
		textField_1.setFont(new Font("굴림", Font.PLAIN, 17));
		textField_1.setColumns(10);
		textField_1.setBounds(249, 161, 230, 24);
		jpn1.add(textField_1);

		textField_2 = new JTextField(); // 출판사
		textField_2.setFont(new Font("굴림", Font.PLAIN, 17));
		textField_2.setColumns(10);
		textField_2.setBounds(249, 215, 230, 24);
		jpn1.add(textField_2);

		textField_3 = new JTextField(); // ISBN
		textField_3.setFont(new Font("굴림", Font.PLAIN, 17));
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

		JTable jtable = new JTable(model);
		scroll.setViewportView(jtable);

		jtable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

	}
}
