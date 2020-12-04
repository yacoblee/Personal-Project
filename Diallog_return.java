
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Diallog_return extends JFrame {
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

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	static PanelSwitch sw;
	String[] colNames = new String[] { "책 제목", "전화번호", "대여일자","반납일자"};
	DefaultTableModel model = new DefaultTableModel(colNames, 0);
	int removeNum = 0;
	
	public Diallog_return() {
		
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
		frame = new JFrame();
		frame.setSize(581, 726);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(14, 12, 535, 655);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("책제목 :");
		label.setFont(new Font("HY강M", Font.PLAIN, 17));
		label.setBounds(60, 142, 80, 18);
		panel.add(label);
		
		JButton btReturn = new JButton("반납");
		btReturn.setFont(new Font("돋움체", Font.BOLD, 17));
		btReturn.setBounds(416, 190, 105, 50);
		panel.add(btReturn);
		
		JButton btSearch = new JButton("조회");
		btSearch.setFont(new Font("돋움체", Font.BOLD, 17));
		btSearch.setBounds(296, 190, 105, 50);
		panel.add(btSearch);
		
		textField = new JTextField();
		textField.setBounds(167, 57, 190, 24);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(167, 140, 190, 24);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("전화번호 :");
		label_1.setFont(new Font("HY강M", Font.PLAIN, 17));
		label_1.setBounds(60, 59, 80, 18);
		panel.add(label_1);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 258, 509, 387);
		panel.add(panel_1);
		panel_1.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 509, 387);
		JTable jtable = new JTable(model);
		scrollPane.setViewportView(jtable);
		panel_1.add(scrollPane);
		
		
		btSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String phone = textField.getText();
				String book = textField_1.getText();
				
				try {
					for (int i = removeNum - 1; i >= 0; i--) {
						model.removeRow(i);
					}
					removeNum=0;
					
					if (phone.length() > 10) {
						String query = "select * from RENT where MPHONE= '" + phone + "'";
						stmt = con.createStatement();
						rs = stmt.executeQuery(query);
						
						System.out.println(query);
						
						while (rs.next()) {
							model.addRow(new Object[] { rs.getString("BOOKNAME"), rs.getString("MPHONE"),
									rs.getString("REDATE"), rs.getString("RETURNDATE") });
							removeNum++;
						}
						
					}else if (book.length() > 1) {
						String query2 = "select * from RENT where bookname= '" + book + "'";
						stmt = con.createStatement();
						rs = stmt.executeQuery(query2);
						System.out.println(query2);
						while (rs.next()) {
							model.addRow(new Object[] { rs.getString("BOOKNAME"), rs.getString("MPHONE"),
									rs.getString("REDATE"), rs.getString("RETURNDATE") });
							removeNum++;
						}
						
						System.out.println(query2);
					}
					
					
					

				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showConfirmDialog(null, "입력값을 확인해주세요");
				}
			}
		});
		
		btReturn.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int rows = jtable.getSelectedRow();
				System.out.println(rows);
				String phone = textField.getText();
				String book = textField_1.getText();
				
				try {
				String query = "SELECT RECONFIRME FROM LIBRARY WHERE RECONFIRME = 'NO' ";
				rs = stmt.executeQuery(query);
				
				System.out.println(query);
				
				String sql = "UPDATE library SET RECONFIRME ='YES' WHERE RECONFIRME ='NO' AND BOOKNAME ='"+book+"'";
				
				rs = stmt.executeQuery(sql);

				
								try {
									for (int i = removeNum - 1; i >= 0; i--) {
										model.removeRow(i);
									}
									removeNum=0;
							
									if(book.length()>=1) {
									
									System.out.println(rows);
									String query2= "UPDATE RENT SET RETURNDATE = to_Char(SYSDATE ,'YYYY/mm/dd') where BOOKNAME = '"+book+"'";
									stmt=con.createStatement();
									rs=stmt.executeQuery(query2);
								
									}
									else if(rows>=0) {
										rows+=1;
										System.out.println(rows);
										String query2= "UPDATE RENT SET RETURNDATE = to_Char(SYSDATE ,'YYYY/mm/dd') where rownum= '"+rows+"'";
										stmt=con.createStatement();
										rs=stmt.executeQuery(query2);
									}
									else {
										JOptionPane.showConfirmDialog(null, "다시 확인해주세요");
										return;
									}
									
									if (phone.length() == 11) {
										String query3 = "select * from RENT where MPHONE= '" + phone + "'";
										stmt = con.createStatement();
										rs = stmt.executeQuery(query3);
					
										while (rs.next()) {
											model.addRow(new Object[] { rs.getString("BOOKNAME"), rs.getString("MPHONE"),
													rs.getString("REDATE"), rs.getString("RETURNDATE") });
											removeNum++;
										}
										
											}else if (book.length() > 1) {
												String query4 = "select * from RENT where bookname= '" + book + "'";
												stmt = con.createStatement();
												rs = stmt.executeQuery(query4);
											
												while (rs.next()) {
													model.addRow(new Object[] { rs.getString("BOOKNAME"), rs.getString("MPHONE"),
															rs.getString("REDATE"), rs.getString("RETURNDATE") });
													removeNum++;
												}
											
											
										}
								}catch (Exception e) {
									e.printStackTrace();
								}
				}catch (Exception e) {
					JOptionPane.showConfirmDialog(null, "이미 처리되었습니다");
					e.printStackTrace();
					
				}
			}
		});
		
		
		frame.setVisible(true);
	}
	
}