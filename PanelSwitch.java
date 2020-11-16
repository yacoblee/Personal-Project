import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PanelSwitch extends JFrame {
	private static final long serialVersionUID = 1L;
	public MainGui gui;
	public SPanel02 p2;
	public SPanel03 p3;
	public Login login;
	static PanelSwitch win = new PanelSwitch();

	public void change(String name) {
		switch (name) {
		case "MainGui":
			win.gui = new MainGui(win);
			getContentPane().removeAll();
			getContentPane().add(gui);
			revalidate();
			repaint();

//		case "" :
//			= new 
//			getContentPane().removeAll();
//			getContentPane().add(p2);
//			revalidate();
//			repaint();
//		}
//		case " ":
//			
//			getContentPane().removeAll();
//			getContentPane().add(p3);
//			revalidate();
//			repaint();
//		break;
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

class GUI extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton bt1, bt2;
	private JScrollPane jsc;
	private JTextArea jarea;
	private PanelSwitch ps;

	public GUI(PanelSwitch ps) {
		this.ps = ps;
		setLayout(null);

		bt1 = new JButton("도서목록");
		bt1.setBounds(650, 100, 100, 60);
		bt2 = new JButton("책등록");
		bt2.setBounds(650, 200, 100, 60);
		add(bt1);
		add(bt2);

		jarea = new JTextArea();

		jsc = new JScrollPane();
		jsc.setBounds(50, 100, 550, 470);
		add(jsc);

		bt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ps.change("SPanel02");
			}
		});
		bt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ps.change("SPanel03");
			}
		});
	}
}

class SPanel02 extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton bt1, bt2, bt3;
	private JScrollPane jsc;
	private JTextArea jarea;
	private PanelSwitch ps;

	public SPanel02(PanelSwitch ps) {
		this.ps = ps;
		setLayout(null);

		bt1 = new JButton("뒤로");
		bt1.setBounds(650, 100, 100, 60);
		bt2 = new JButton("삭제");
		bt2.setBounds(650, 200, 100, 60);
		bt3 = new JButton("업데이트");
		bt3.setBounds(650, 300, 100, 60);
		add(bt1);
		add(bt2);
		add(bt3);

		jsc = new JScrollPane();

		jarea = new JTextArea();
		jsc.setBounds(50, 100, 550, 470);
		add(jsc);

		bt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ps.change("GUI");

			}
		});
	}

}

class SPanel03 extends JPanel {
	private JButton bt1, bt2, bt3;
	private JScrollPane jsc;
	private JTextArea jarea;
	private PanelSwitch ps;

	public SPanel03(PanelSwitch ps) {
		this.ps = ps;
		setLayout(null);

		bt1 = new JButton("뒤로");
		bt1.setBounds(650, 100, 100, 60);
		bt2 = new JButton("탈퇴");
		bt2.setBounds(650, 200, 100, 60);
		bt3 = new JButton("도움말");
		bt3.setBounds(650, 300, 100, 60);
		add(bt1);
		add(bt2);
		add(bt3);

		jsc = new JScrollPane();

		jarea = new JTextArea();
		jsc.setBounds(50, 100, 550, 470);
		add(jsc);

		bt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ps.change("GUI");

			}
		});
	}
}
