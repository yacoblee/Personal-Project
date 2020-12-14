
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainGui extends JPanel {
	private static final long serialVersionUID = 1L;
	private Font f1;
	
	public MainGui (PanelSwitch win) {
		
		ImageIcon ic = new ImageIcon("C:\\Users\\yacob\\Desktop\\bookimage.jpg");
		JLabel lbImage = new JLabel(ic);	
		add(lbImage);
		
		f1 = new Font("HY동녘M", Font.PLAIN, 15);

		lbImage.setSize(1080,700);
		setLocation(0,0);
		
		ImageIcon icon1= new ImageIcon("C:\\Users\\yacob\\Desktop\\eclipse_data\\PeronalProject\\image\\member.png");
		ImageIcon icon2= new ImageIcon("C:\\Users\\yacob\\Desktop\\eclipse_data\\PeronalProject\\image\\manage.png");
		ImageIcon icon3= new ImageIcon("C:\\Users\\yacob\\Desktop\\eclipse_data\\PeronalProject\\image\\rental.png");
		ImageIcon icon4= new ImageIcon("C:\\Users\\yacob\\Desktop\\eclipse_data\\PeronalProject\\image\\exit.png");

		
		JButton bt1 =new JButton("",icon1); //목록과 관리(가입,조회)
		JButton bt2	=new JButton("",icon2);
		JButton bt3 =new JButton("",icon3);
		JButton exi =new JButton("",icon4);
		
		bt1.setSelectedIcon(icon1);
		bt1.setSelectedIcon(icon2);
		bt1.setSelectedIcon(icon3);
		exi.setSelectedIcon(icon4);
		
		bt1.setFont(f1);
		bt2.setFont(f1);
		bt3.setFont(f1);
		exi.setFont(f1);
		
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
			win.change("Member"); //패널 형태로 제작
		}
		});
		bt2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				win.change("Book"); //패널형태로 제작
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
