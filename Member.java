import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;


public class Member extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btIm, btEx,bthome;
	private JScrollPane textscroll;
	private JList list;
	private JTextField txname, txnum,txaddress;
	private JLabel laname,lanum,laaddress;
	
	public Member (PanelSwitch win) {
		setLayout(null);
		
		
		btIm = new JButton("���");
		btIm.setBounds(816, 80, 127, 43);
		btEx = new JButton("����");
		btEx.setBounds(816, 147, 127, 43);
		
		laname = new JLabel("�̸�");
		laname.setBounds(714, 251, 62, 18);
		txname =new JTextField();
		txname.setBounds(816, 311, 192, 32);
		
		lanum=new JLabel("��ȣ");
		lanum.setBounds(714, 311, 62, 18);
		txnum = new JTextField();
		txnum.setBounds(816, 251, 192, 32);
		
		
		laaddress = new JLabel("�ּ�");
		laaddress.setBounds(714, 369, 62, 18);
		txaddress = new JTextField();
		txaddress.setBounds(816, 369, 224, 32);
		
		bthome = new JButton("Ȩ����");
		bthome.setBounds(913, 530, 127, 43);
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 12, 1080, 17);
		add(separator);
		separator.setBackground(Color.DARK_GRAY);
		separator.setForeground(Color.DARK_GRAY);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.DARK_GRAY);
		separator_1.setBackground(Color.DARK_GRAY);
		separator_1.setBounds(0, 582, 1054, 17);
		add(separator_1);
		
		add(btIm);
		add(btEx);
		add(laname);
		add(txname);
		add(lanum);
		add(txnum);
		add(laaddress);
		add(txaddress);
		add(bthome);
		
		bthome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("MainGui");
				
			}
		});
		
	}
	
}
