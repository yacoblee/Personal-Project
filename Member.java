import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
	private JButton btIm, btEx, bthome;
	private JScrollPane textscroll;

	private JTextField txname, txnum, txaddress;
	private JLabel laname, lanum, laaddress;
	static PanelSwitch sw;

	String isbn;
	public String a = isbn;
	PreparedStatement ptst = null;
	int removeNum = 0;
	String[] colNames = new String[] { "이름", "전화번호", "주소" };
	DefaultTableModel model0 = new DefaultTableModel(colNames, 0);

	public Member(PanelSwitch win) {

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

		Font f1 = new Font("한컴 윤체L", Font.BOLD, 15);

		btIm = new JButton("등록");
		btIm.setBounds(816, 80, 127, 43);
		btEx = new JButton("삭제");
		btEx.setBounds(816, 147, 127, 43);

		laname = new JLabel("이름");
		laname.setFont(f1);
		laname.setBounds(714, 368, 62, 18);

		txname = new JTextField(); // name field
		txname.setBounds(816, 368, 192, 32);

		lanum = new JLabel("번호");
		lanum.setFont(f1);
		lanum.setBounds(714, 428, 62, 18);

		txnum = new JTextField(); // phone number field
		txnum.setBounds(816, 428, 192, 32);

		laaddress = new JLabel("주소");
		laaddress.setFont(f1);
		laaddress.setBounds(714, 486, 62, 18);
		txaddress = new JTextField();
		txaddress.setBounds(816, 486, 224, 32);

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

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 74, 677, 586);
		add(scrollPane);

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

		try { // first visible table

			String query = "SELECT * FROM CLIENT ORDER BY MNAME";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				model0.addRow(new Object[] { rs.getString("MNAME"), rs.getString("MPHONE"), rs.getString("MADDRESS") });
				removeNum++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		btIm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String name = txname.getText();
					String number = txnum.getText().toString();
					String address = txaddress.getText();

//					System.out.println(name + " " + number + " " + address);

					if (name.length() >= 1 && number.length() > 10 && address.length() >= 5) {

						String sql = "INSERT INTO CLIENT VALUES('" + name + "','" + number + "','" + address + "')";
						System.out.println(sql);
						rs = stmt.executeQuery(sql);
						sql = "commit";
						rs = stmt.executeQuery(sql);
						System.out.println(sql);

						for (int i = removeNum - 1; i >= 0; i--) {
							model0.removeRow(i);
						}
						removeNum = 0;

						String query = "SELECT * FROM CLIENT ORDER BY MNAME";
						stmt = con.createStatement();
						rs = stmt.executeQuery(query);
						while (rs.next()) {
							model0.addRow(new Object[] { rs.getString("MNAME"), rs.getString("MPHONE"),
									rs.getString("MADDRESS") });
							removeNum++;
						}
						txname.setText("");
						txnum.setText("");
						txaddress.setText("");
					} else {
						JOptionPane.showConfirmDialog(null, "입력 정보를 확인해주세요");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

		btEx.addActionListener(new ActionListener() {
			// remove rows

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					int rows = table.getSelectedRow();
					if (rows < 0) {
						JOptionPane.showMessageDialog(table, "행을 선택해주세요");
						return;
					} else {

						System.out.println(rows);
						String sql = "DELETE FROM client WHERE ROWNUM = ?";
						ptst = con.prepareStatement(sql);
						ptst.setInt(1, rows + 1);
						ptst.executeUpdate();

						System.out.println(removeNum);
						for (int i = removeNum - 1; i >= 0; i--) {
							model0.removeRow(i);

						}
						removeNum = 0;

						// repaint
						String query = "SELECT * FROM CLIENT ORDER BY MNAME";
						stmt = con.createStatement();
						rs = stmt.executeQuery(query);
						while (rs.next()) {
							model0.addRow(new Object[] { rs.getString("MNAME"), rs.getString("MPHONE"),
									rs.getString("MADDRESS") });
							removeNum++;
						}
						JOptionPane.showMessageDialog(new JButton(), "삭제되었습니다.");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				// remove Query

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
