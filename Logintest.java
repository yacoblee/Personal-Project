
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Logintest {
	private JFrame f;
	private JButton login;
	private PanelSwitch win;

	public Logintest() {

		this.win = win;
		JPanel panel = new JPanel();
		panel.setLayout(null);

		JLabel id = new JLabel("ID  :  ");
		JTextField text = new JTextField(10);
		id.setBounds(200, 170, 100, 50);
		text.setBounds(250, 170, 100, 50);
		panel.add(id);
		panel.add(text);
		
		JLabel pw = new JLabel("password : ");
		JPasswordField pwd = new JPasswordField(10); // password : ****
		pw.setBounds(200, 230, 100, 50);
		pwd.setBounds(250, 240, 100, 30);
		panel.add(pw);
		panel.add(pwd);

		JButton login = new JButton("Log-in");
		login.setBounds(460, 230, 80, 50);
		panel.add(login);

		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String Id = "Green";
				String Pass = "green12";

				if (Id.equals(text.getText()) && Pass.equals(pwd.getText())) {
					JOptionPane.showMessageDialog(null, "login Sucess!");
					win.change("GUI");
				} else {
					JOptionPane.showConfirmDialog(null, "return to login");
				}
			}
		});

	}

	public static void main(String[] args) {
		new Logintest();
	}
}
