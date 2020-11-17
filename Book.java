import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Book extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btIm, btEx,bthome;
	private JScrollPane textscroll;
	private JList list;
	private JTextField txname, txnum,txaddress;
	private JLabel laname,lanum,laaddress;
	
	public Book (PanelSwitch win) {
		setLayout(null);
		
		Font f1 =new Font("���� ��üL", Font.BOLD, 15);
		
		btIm = new JButton("���");
		btIm.setBounds(816, 80, 127, 43);
		btEx = new JButton("����");
		btEx.setBounds(816, 147, 127, 43);
		
		laname = new JLabel("ý����");
		laname.setFont(f1);
		laname.setBounds(714, 368, 62, 18);
		txname =new JTextField();
		txname.setBounds(816, 368, 224, 32);
		
		lanum=new JLabel("����");
		lanum.setFont(f1);
		lanum.setBounds(714, 428, 62, 18);
		txnum = new JTextField();
		txnum.setBounds(816, 428, 192, 32);
		
		
		laaddress = new JLabel("���ǻ�");
		laaddress.setFont(f1);
		laaddress.setBounds(714, 486, 62, 18);
		txaddress = new JTextField();
		txaddress.setBounds(816, 486, 192, 32);
		
		JTextPane textPane_3 = new JTextPane(); //ISBN �ڵ� �߰� �ʵ�
		textPane_3.setBounds(816, 539, 192, 32);
		add(textPane_3);
		
		JLabel label_4 = new JLabel("ISBN");
		label_4.setBounds(714, 539, 62, 18);
		add(label_4);
		
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
		
		
		//scroll and separate
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(14, 92, 693, 569);
		add(scrollPane_1);
		
		JTable table = new JTable();
		scrollPane_1.setViewportView(table);
		scrollPane_1.setBackground(Color.GRAY);
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
					"����","����","���ǻ�","ISBN","������Ȳ"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(292);
		table.getColumnModel().getColumn(1).setPreferredWidth(94);
		table.getColumnModel().getColumn(2).setPreferredWidth(93);
		table.getColumnModel().getColumn(3).setPreferredWidth(159);
		table.getColumnModel().getColumn(4).setPreferredWidth(87);
		scrollPane_1.setViewportView(table);
		
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
			public void actionPerformed(ActionEvent arg0) {
				win.change("MainGui");
				
			}
		});
	}
	
}
