import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;

public class PanelSwitch extends JFrame {
	
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/ORCL";
	String user = "green";
	String password = "green1234";
	static Connection con;
	@SuppressWarnings("unused")
	private Statement stmt;
	@SuppressWarnings("unused")
	private ResultSet rs;
	
	
	private static final long serialVersionUID = 1L;
	public MainGui gui;
	public Login login;
	public Member member;
	public Book book;
	public Manage manage;
	static PanelSwitch win = new PanelSwitch();
	

	public void change(String name)  {
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
		
		switch (name) {
		case "MainGui":
			win.gui = new MainGui(win);
			getContentPane().removeAll();
			getContentPane().add(gui);
			revalidate();
			repaint();
			break;
			
		case "Member" :
			win.member= new Member(win); 
			getContentPane().removeAll();
			getContentPane().add(member);
			revalidate();
			repaint();
			break;
			
		case "Book":
			win.book = new Book(win);
			getContentPane().removeAll();
			getContentPane().add(book);
			revalidate();
			repaint();
			break;
			
		case "Manage":
			win.manage = new Manage(win);
			getContentPane().removeAll();
			getContentPane().add(manage);
			revalidate();
			paint(this.getGraphics());
			break;

		}
	}

	public static void main(String[] args) {
		
		win.login = new Login(win);
	
		win.add(win.login);
		
//		Manage manage = new Manage(null);
//		Diallog dial = new Diallog();
		
		
		win.setTitle("library");
		win.setSize(1100, 800);
		win.setVisible(true);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setResizable(false);
	}
}


