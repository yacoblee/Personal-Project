import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


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
		
		Font f1 =new Font("���� ��üL", Font.BOLD, 15);
		
		btIm = new JButton("���");
		btIm.setBounds(816, 80, 127, 43);
		btEx = new JButton("����");
		btEx.setBounds(816, 147, 127, 43);
		
		laname = new JLabel("�̸�");
		laname.setFont(f1);
		laname.setBounds(714, 368, 62, 18);
		txname =new JTextField();
		txname.setBounds(816, 428, 192, 32);
		
		lanum=new JLabel("��ȣ");
		lanum.setFont(f1);
		lanum.setBounds(714, 428, 62, 18);
		txnum = new JTextField();
		txnum.setBounds(816, 368, 192, 32);
		
		
		laaddress = new JLabel("�ּ�");
		laaddress.setFont(f1);
		laaddress.setBounds(714, 486, 62, 18);
		txaddress = new JTextField();
		txaddress.setBounds(816, 486, 224, 32);
		
		bthome = new JButton("Ȩ����");
		bthome.setBounds(913, 645, 127, 43);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 12, 1080, 17);
		add(separator);
		separator.setBackground(Color.DARK_GRAY);
		separator.setForeground(Color.DARK_GRAY);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.DARK_GRAY);
		separator_1.setBackground(Color.DARK_GRAY);
		separator_1.setBounds(0, 700, 1054, 17);
		add(separator_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 74, 677, 586);
		add(scrollPane);
		
		JTable table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"�̸�", "��ȭ��ȣ", "�ּ�"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(110);
		table.getColumnModel().getColumn(1).setPreferredWidth(207);
		table.getColumnModel().getColumn(2).setPreferredWidth(395);
		scrollPane.setViewportView(table);
		
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