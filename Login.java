import java.awt.Color;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField text;
	private JPasswordField passfield;
	private String id = "Green";
	private String password = "green1234";
	private Font f1, f2;

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public Login(PanelSwitch win) {

		setBounds(0, 0, 1080, 740);

		ImageIcon ic = new ImageIcon("C:\\Users\\yacob\\Desktop\\bookimage.jpg");
		JLabel lbImage = new JLabel(ic);
		add(lbImage);

		f1 = new Font("HY동녘M", Font.PLAIN, 17);
		f2 = new Font("Hight Tower Text", Font.BOLD, 25);
		
		JLabel title = new JLabel("도서관리 프로그램");
		
		title.setForeground(Color.white);
		title.setBounds(500, 70, 300, 100);
		title.setFont(f2);

		lbImage.add(title);

		JLabel inputid = new JLabel("아이디: ");
		inputid.setForeground(Color.white);
		inputid.setBounds(380, 170, 100, 50);
		inputid.setFont(f1);
		lbImage.add(inputid);

		text = new JTextField(10);
		text.setBounds(450, 180, 200, 30);
		lbImage.add(text);
		
		JLabel inputpass = new JLabel("암호:");
		inputpass.setForeground(Color.white);
		inputpass.setBounds(400, 230, 100, 50);
		inputpass.setFont(f1);
		
		lbImage.add(inputpass);
		passfield = new JPasswordField();
		passfield.setBounds(450, 240, 200, 30);
		lbImage.add(passfield);

		ImageIcon icon = new ImageIcon("C:\\Users\\yacob\\Desktop\\eclipse_data\\PeronalProject\\image\\login.png");
		
		JButton btJoin = new JButton("",icon);
		btJoin.setSize(80, 50);
		btJoin.setLocation(665, 200);
		btJoin.setPressedIcon(icon);
		lbImage.add(btJoin);
		
		btJoin.setBorderPainted(false);
//		btJoin.setContentAreaFilled(true);

		btJoin.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			public void mousePressed(MouseEvent e) {
				if (text.getText().equals(getId()) && passfield.getText().equals(getPassword())) {
					JOptionPane.showMessageDialog(null,"로그인 되었습니다.");
					win.change("MainGui");
				} else {
					JOptionPane.showMessageDialog(null, "아이디와 암호를 확인해주세요.");
				}
			}

		});
		
		passfield.addKeyListener(new KeyAdapter()  {
	         public void keyPressed(KeyEvent e)
	         {
	           if (e.getKeyCode() == 10)
	           {JOptionPane.showMessageDialog(null,"로그인 되었습니다.");
	        	   win.change("MainGui");
	           }
	         }
	       });

	}

}
