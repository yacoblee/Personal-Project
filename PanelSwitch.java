import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PanelSwitch extends JFrame {
	private static final long serialVersionUID = 1L;
	public MainGui gui;
	public Login login;
	public Member member;
	public Book book;
	public Manage manage;
	static PanelSwitch win = new PanelSwitch();
	

	public void change(String name)  {
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

		win.setTitle("library");
		win.setSize(1100, 800);
		win.setVisible(true);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setResizable(false);
	}
}


