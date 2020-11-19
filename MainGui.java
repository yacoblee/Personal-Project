import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainGui extends JPanel {
	private static final long serialVersionUID = 1L;

	public MainGui (PanelSwitch win) {
		
		ImageIcon ic = new ImageIcon("C:\\Users\\pc\\Desktop\\bookimage.jpg");
		JLabel lbImage = new JLabel(ic);	
		add(lbImage);
		
//		setLayout(null);
		lbImage.setSize(1080,700);
		setLocation(0,0);
//		setVisible(true);
		
		JButton bt1 =new JButton("ȸ������"); //��ϰ� ����(����,��ȸ)
		JButton bt2	=new JButton("��������");
		JButton bt3 =new JButton("å���");
		JButton exi =new JButton("����");
		
		bt1.setBounds(520, 50, 100, 50);
		bt2.setBounds(640, 50, 100, 50);
		bt3.setBounds(760, 50, 100, 50);
		exi.setBounds(880, 50, 100, 50);
		
		lbImage.add(bt1);
		lbImage.add(bt2);
		lbImage.add(bt3);
		lbImage.add(exi);
		
		bt1.addMouseListener(new MouseAdapter() {
		public void mousePressed(MouseEvent e) {
			win.change("Member"); //�г� ���·� ����
		}
		});
		bt2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				win.change("Book"); //�г����·� ����
			}
		});
		bt3.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				win.change("Manage");
			}
		});
		exi.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
	}
}
