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
		JButton bt1 =new JButton("ȸ������"); //��ϰ� ����(����,��ȸ)
		JButton bt2	=new JButton("��������");
		JButton bt3 =new JButton("å���");
		JButton exi =new JButton("����");
		
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
			win.change("SPanel02"); //�г� ���·� ����
		}
		});
		bt2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				win.change("SPanel03"); //�г����·� ����
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
