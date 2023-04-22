package banksystem;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class main {
	
	public static void main(String[] args) {
		database data = new database();
		Bank bank = new Bank("DN Bank", data.getManagers(), data.getUsers(), data.getBlock());

		if (bank.getListManager().isEmpty()) {
			Manager boss = new Manager("Boss", 1, 1234, "0843961713", 1);
			bank.getListManager().add(boss);
			data.saveManager(bank.getListManager());
		}
		bank.login(bank, data);
	}
	
	public static JLabel Label(String text, int size) {
		JLabel title = new JLabel (text);
		title.setFont(new Font("Tahoma", Font.BOLD, size));
		title.setForeground(Color.black);
		title.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		return title;
	}

	public static JTextField TextField(int size) {
		JTextField text = new JTextField();
		text.setFont(new Font("Tahoma", Font.BOLD, size));
		text.setForeground(Color.black);
		text.setBorder(BorderFactory.createEmptyBorder(2, 2, 10, 10));
		text.setHorizontalAlignment(SwingConstants.CENTER);
		return text;
	}
	
	public static JPasswordField PasswordField(int size) {
		JPasswordField pass = new JPasswordField();
		pass.setFont(new Font("Tahoma", Font.BOLD, size));
		pass.setForeground(Color.black);
		pass.setHorizontalAlignment(SwingConstants.CENTER);
		pass.setBorder(new LineBorder(Color.white,1));
		return pass;
	}
	
	public static JButton Button(String text, int size) {
		JButton bt = new JButton(text);
		bt.setFont(new Font("Tahoma", Font.BOLD, size));
		bt.setForeground(Color.black);
		bt.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		bt.setHorizontalAlignment(SwingConstants.CENTER);
		return bt;
	}
}


