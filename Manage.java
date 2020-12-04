
import javax.swing.*;
import javax.swing.border.LineBorder;
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
import java.util.ArrayList;

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
	private JTextField textField, textField_1;
	public JTable jtable;
	private JFrame frame;
	static Diallog dial;
	static PanelSwitch sw;
	static Diallog_return dial2;
	int removeNum = 0;

	PreparedStatement ptst = null;

	JComboBox<String> combo;
	String items[] = { "����", "����", "���ǻ�", "ISBN" };

// ============================================================================================================

	public Manage(PanelSwitch win) {
		String[] colNames = new String[] { "����", "����", "���ǻ�", "ISBN", "������Ȳ" };
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

		JPanel jpn1 = new JPanel();
		jpn1.setLayout(null);
		jpn1.setBorder(new LineBorder(Color.BLACK));
		jpn1.setBackground(Color.LIGHT_GRAY);
		jpn1.setBounds(66, 31, 970, 265);

		add(jpn1);

		combo = new JComboBox<String>(items);
		combo.setFont(new Font("�������", Font.PLAIN, 15));

		combo.setBounds(157, 109, 66, 24);
		jpn1.add(combo);

		btSearch = new JButton("��ȸ");
		btSearch.setFont(new Font("����", Font.BOLD, 17));
		btSearch.setBounds(491, 97, 125, 46);
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

		btRent = new JButton("�뿩");
		btRent.setFont(new Font("����", Font.BOLD, 17));
		btRent.setBounds(620, 97, 125, 46);
		jpn1.add(btRent);

		btReturn = new JButton("�ݳ�");
		btReturn.setFont(new Font("����", Font.BOLD, 17));
		btReturn.setBounds(756, 97, 125, 46);
		jpn1.add(btReturn);

		btHome = new JButton("����Ȩ");
		btHome.setFont(new Font("����", Font.BOLD, 17));
		btHome.setBounds(756, 194, 125, 46);
		jpn1.add(btHome);

		btHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				win.change("MainGui");
			}
		});

		textField = new JTextField(); // å����
		textField.setFont(new Font("����", Font.PLAIN, 17));
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
//						JOptionPane.showConfirmDialog(new JButton(), "�Է� ���� Ȯ�����ּ���");
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
