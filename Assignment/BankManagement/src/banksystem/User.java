package banksystem;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class User extends Account {
	private double balance;
	
	public User() {
		
	}

	public User(String name, int id, int password, String phoneNumber, double balance) {
		super(name, id, password, phoneNumber);
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void deposit(Bank bank, User user, database data) {
		// Create new frame for deposit method
		JFrame frame = new JFrame("Deposit Window");
		frame.setSize(400, 300);
		frame.setLocationRelativeTo(null);
		
		JLabel title = main.Label("Please enter an amount!", 25);
		JLabel label1 = main.Label("Amount", 20);
		JTextField amountText = main.TextField(20);
		JLabel label2 = main.Label("Your password", 20);
		JPasswordField passText = main.PasswordField(20);
		
		JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel.add(label1);
		panel.add(amountText);
		panel.add(label2);
		panel.add(passText);
		
		JButton confirm = main.Button("OK", 20);
		JPanel panel2 = new JPanel(new GridLayout(1, 1, 10, 10));
		panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel2.add(confirm);
		
		frame.add(title, BorderLayout.NORTH);
		frame.add(panel, BorderLayout.CENTER);
		frame.add(panel2, BorderLayout.SOUTH);
		frame.setVisible(true);
		// Button confirm: click to deposit
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Create constraints
				try {
					Double.parseDouble(amountText.getText().toString());
				} catch (Exception n1) {
					JOptionPane.showMessageDialog(frame, "Amount of money must be a number.");
					return;
				}
				try {
					Integer.parseInt(String.valueOf(passText.getPassword()));
				} catch (Exception n1) {
					JOptionPane.showMessageDialog(frame, "Password must be a number.");
					return;
				}
				// Implement method
				if (user.getPassword() == Integer.parseInt(String.valueOf(passText.getPassword()))) {
					user.setBalance(user.getBalance() + Double.parseDouble(amountText.getText().toString()));
					data.saveUser(bank.getListUser());
					JOptionPane.showMessageDialog(frame, "Successfully.");
				} else {
					JOptionPane.showMessageDialog(frame, "Your password is not correct.");
					return;
				}
				frame.dispose();
			}
		});
	}
	
	public void withdraw(Bank bank, User user, database data) {
		// Create new frame for withdraw method
		JFrame frame = new JFrame("Withdraw Window");
		frame.setSize(400, 300);
		frame.setLocationRelativeTo(null);
		
		JLabel title = main.Label("Please enter an amount!", 25);
		JLabel label1 = main.Label("Amount", 20);
		JTextField amountText = main.TextField(20);
		JLabel label2 = main.Label("Your password", 20);
		JPasswordField passText = main.PasswordField(20);
		
		JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel.add(label1);
		panel.add(amountText);
		panel.add(label2);
		panel.add(passText);
		
		JButton confirm = main.Button("OK", 20);
		JPanel panel2 = new JPanel(new GridLayout(1, 1, 10, 10));
		panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel2.add(confirm);
		
		frame.add(title, BorderLayout.NORTH);
		frame.add(panel, BorderLayout.CENTER);
		frame.add(panel2, BorderLayout.SOUTH);
		frame.setVisible(true);
		// Button confirm: click to withdraw
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Create constraints
				try {
					Double.parseDouble(amountText.getText().toString());
				} catch (Exception n1) {
					JOptionPane.showMessageDialog(frame, "Amount of money must be a number.");
					return;
				}
				try {
					Integer.parseInt(String.valueOf(passText.getPassword()));
				} catch (Exception n1) {
					JOptionPane.showMessageDialog(frame, "Password must be a number.");
					return;
				}
				// Implement method
				if (user.getPassword() == Integer.parseInt(String.valueOf(passText.getPassword()))) {
					double amount = Double.parseDouble(amountText.getText().toString());
					if (user.getBalance() >= amount) {
						user.setBalance(user.getBalance() - amount);
						data.saveUser(bank.getListUser());
						JOptionPane.showMessageDialog(frame, "Successfully.");
					} else {
						JOptionPane.showMessageDialog(frame, "Your balance is lower than the amount.");
						return;
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Your password is not correct.");
					return;
				}
				frame.dispose();
			}
		});
	}
	
	public void transfer(Bank bank, User user, database data) {
		// Create enw frame for transfer method
		JFrame frame = new JFrame("Transfer Window");
		frame.setSize(400, 350);
		frame.setLocationRelativeTo(null);
		
		JLabel title = main.Label("Please enter ID and Amount!", 25);
		JLabel label1 = main.Label("ID to transfer", 20);
		JTextField idText = main.TextField(20);
		JLabel label2 = main.Label("Amount", 20);
		JTextField amountText = main.TextField(20);
		JLabel label3 = main.Label("Your password", 20);
		JPasswordField passText = main.PasswordField(20);
		
		JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel.add(label1);
		panel.add(idText);
		panel.add(label2);
		panel.add(amountText);
		panel.add(label3);
		panel.add(passText);
		
		JButton confirm = main.Button("OK", 20);
		JPanel panel2 = new JPanel(new GridLayout(1, 1, 10, 10));
		panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel2.add(confirm);
		frame.add(title, BorderLayout.NORTH);
		frame.add(panel, BorderLayout.CENTER);
		frame.add(panel2, BorderLayout.SOUTH);
		frame.setVisible(true);
		
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Create constraints
				try {
					Integer.parseInt(idText.getText().toString());
				} catch (Exception n1) {
					JOptionPane.showMessageDialog(frame, "ID must be a number.");
					return;
				}
				try {
					Double.parseDouble(amountText.getText().toString());
				} catch (Exception n1) {
					JOptionPane.showMessageDialog(frame, "Amount of money must be a number.");
					return;
				}
				try {
					Integer.parseInt(String.valueOf(passText.getPassword()));
				} catch (Exception n1) {
					JOptionPane.showMessageDialog(frame, "Password must be a number.");
					return;
				}
				// check password of user to implement
				if (user.getPassword() == Integer.parseInt(String.valueOf(passText.getPassword()))) {
					boolean flag = false;
					User user1 = new User();
					// find user1 to transfer to (user1 must be different from user)
					for (User iterator : bank.getListUser()) {
						if (iterator.getId() == Integer.parseInt(idText.getText().toString()) && iterator.getId() != user.getId()) {
							flag = true;
							user1 = iterator;	
							break;
						}
					}
					// user1 finded -> check balance of user and implement if user.getBalance >= amount
					if (flag) {
						double amount = Double.parseDouble(amountText.getText().toString());
						if (user.getBalance() >= amount) {
							user.setBalance(user.getBalance() - amount);
							user1.setBalance(user1.getBalance() + amount);
							data.saveUser(bank.getListUser());
							JOptionPane.showMessageDialog(frame, "Successfully.");
						} else {
							JOptionPane.showMessageDialog(frame, "Your balance is lower than the amount.");
							return;
						}
					// user1 is not finded	
					} else {
						JOptionPane.showMessageDialog(frame, "The id is not existed.");
						return;
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Your password is not correct.");
					return;
				}
				frame.dispose();
			}
		});
	}
	
	public void checkBalance(JFrame frame, User user) {
		JOptionPane.showMessageDialog(frame, "Your Balance is " + user.getBalance());
	}
}
