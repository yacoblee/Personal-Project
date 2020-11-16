import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;


public class MainGui extends JPanel {
	private static final long serialVersionUID = 1L;

	public MainGui (PanelSwitch win) {
		setLayout(null);
		setSize(300,800);
		setLocation(600,0);
		
		
		setBackground(Color.BLACK);
		JButton bt1 =new JButton("회원관리"); //목록과 관리(가입,조회)
		JButton bt2	=new JButton("도서관리");
		JButton bt3 =new JButton("책등록");
		JButton exi =new JButton("종료");
		
		bt1.setBounds(900, 130, 100, 50);
		bt2.setBounds(900, 230, 100, 50);
		bt3.setBounds(900, 330, 100, 50);
		exi.setBounds(900, 430, 100, 50);
		
		add(bt1);
		add(bt2);
		add(bt3);
		add(exi);
		
		bt1.addMouseListener(new MouseAdapter() {
		public void mousePressed(MouseEvent e) {
			win.change("SPanel02"); //패널 형태로 제작
		}
		});
		bt2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				win.change("SPanel03"); //패널형태로 제작
			}
		});
		bt3.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				win.change("SPanel03");
			}
		});
		exi.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
	}
}
