import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Diallog extends JFrame {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/ORCL";
	String user = "green";
	String password = "green1234";
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	
	private static final long serialVersionUID = 1L;

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	
	String[] colNames = new String[] { "전화번호", "대여목록", "도서누적회차" };
	DefaultTableModel model = new DefaultTableModel(colNames, 0);
	int removeNum = 0;
	


	public Diallog() {
		
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
		
		ImageIcon icon1= new ImageIcon("C:\\Users\\yacob\\Desktop\\eclipse_data\\PeronalProject\\image\\search.png");
		ImageIcon icon2= new ImageIcon("C:\\Users\\yacob\\Desktop\\eclipse_data\\PeronalProject\\image\\rental.png");
		JPanel panel = new JPanel();
		panel.setBounds(14, 12, 535, 655);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("책 제목 :");
		label.setFont(new Font("HY강M", Font.PLAIN, 17));
		label.setBounds(60, 142, 80, 18);
		panel.add(label);
		
		JButton btRent = new JButton("",icon2);
		btRent.setFont(new Font("돋움체", Font.BOLD, 17));
		btRent.setBounds(416, 190, 105, 50);
		btRent.setSelectedIcon(icon2);
		panel.add(btRent);
		
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
		
		JButton btSearch = new JButton("",icon1);
		btSearch.setFont(new Font("돋움체", Font.BOLD, 17));
		btSearch.setBounds(296, 190, 105, 50);
		btSearch.setSelectedIcon(icon1);
		panel.add(btSearch); 
		
		btSearch.addActionListener(new ActionListener() {
			
			@Override
				public void actionPerformed(ActionEvent arg0) {
					try { // first visible table
						String phone = textField.getText();
						String query = "SELECT * FROM RECLIENT WHERE MPHONE=' "+ phone+" 'ORDER BY BCOUNT";
						stmt = con.createStatement();
						rs = stmt.executeQuery(query);
						
						while (rs.next()) {
							model.addRow(new Object[] { rs.getString("MPHONE"), rs.getString("BOOKNAME"),
									rs.getString("BCOUNT") });
							removeNum++;
						}

					} catch (Exception e) {
						JOptionPane.showConfirmDialog(new JButton("ok"), "입력값을 확인해주세요");
						e.printStackTrace();
					}
				}
			});
		
		btRent.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String phone = textField.getText();
				String book = textField_1.getText();
				
			
			
			
			try {
				for (int i = removeNum - 1; i >= 0; i--) {
					model.removeRow(i);
				}
				removeNum=0;
				
				String query2 = "SELECT RECONFIRME FROM LIBRARY WHERE RECONFIRME = 'YES' ";
				rs = stmt.executeQuery(query2);
				
				System.out.println(query2);
				
				String sql = "UPDATE library SET RECONFIRME ='NO' WHERE RECONFIRME ='YES' AND BOOKNAME ='"+book+"'";
				rs = stmt.executeQuery(sql);

				System.out.println(sql);
				
				String query = "INSERT INTO RECLIENT VALUES ('"+phone+"','"+book+"' ,(SELECT nvl(max(BCOUNT)+1,0) FROM RECLIENT) )";
				System.out.println(query);
				stmt = con.createStatement();
				rs = stmt.executeQuery(query);
				
				String query3 = "SELECT * FROM RECLIENT WHERE MPHONE=' "+ phone+" 'ORDER BY BCOUNT";
				stmt = con.createStatement();
				rs = stmt.executeQuery(query3);
				
				while (rs.next()) {
					model.addRow(new Object[] { rs.getString("MPHONE"), rs.getString("BOOKNAME"),
							rs.getString("BCOUNT") });
					removeNum++;
				}
		
							try {
								String query4 = "INSERT INTO RENT VALUES ('"+book+"','"+phone+"',to_Char(SYSDATE ,'YYYY/mm/dd'),NULL )";
								rs=stmt.executeQuery(query4);
								
							}catch (Exception e) {
								e.printStackTrace();
							}
						
				
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showConfirmDialog(new JButton(), "대여중인 도서입니다");
			}
			
			
			}
		});
			
			
			
			
			frame.setVisible(true);
	}
	
}