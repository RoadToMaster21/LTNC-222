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

public class Manager extends Account {
	private int position;
	
	public Manager() {
		
	}

	public Manager(String name, int id, int password, String phoneNumber, int position) {
		super(name, id, password, phoneNumber);
		this.position = position;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	public void createManager(Bank bank, Manager manager, database data) {
		// New frame for creating manager method
		JFrame frame = new JFrame("Management Window");
		frame.setSize(600, 500);
		frame.setLocationRelativeTo(null);
		
		JLabel title = main.Label("Create New Manager Account", 25);
		JLabel label1 = main.Label("Name of Manager", 20);
		JTextField nameText = main.TextField(20);
		JLabel label2 = main.Label("Password (4 digits)", 20);
		JTextField passText = main.TextField(20);
		JLabel label3 = main.Label("Confirm password", 20);
		JTextField repassText = main.TextField(20);
		JLabel label4 = main.Label("Phone number", 20);
		JTextField phoneText = main.TextField(20);
		JLabel label5 = main.Label("Postion", 20);
		JTextField positionText = main.TextField(20);
		JLabel label6 = main.Label("Enter your password", 20);
		JPasswordField confirmText = main.PasswordField(20);
		
		JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(2, 10, 2, 10));
		panel.add(label1);
		panel.add(nameText);
		panel.add(label2);
		panel.add(passText);
		panel.add(label3);
		panel.add(repassText);
		panel.add(label4);
		panel.add(phoneText);
		panel.add(label5);
		panel.add(positionText);
		panel.add(label6);
		panel.add(confirmText);
		
		JButton create = main.Button("Click to Create", 20);
		JButton exit = main.Button("Back to Menu", 20);
		JPanel panel2 = new JPanel(new GridLayout(1, 2, 10, 10));
		panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel2.add(create);
		panel2.add(exit);
		
		frame.add(title, BorderLayout.NORTH);
		frame.add(panel, BorderLayout.CENTER);
		frame.add(panel2, BorderLayout.SOUTH);
		frame.setVisible(true);
		// button create
		create.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// create constraints
				if (bank.getListManager().size() > 1000) {
					JOptionPane.showMessageDialog(frame, "Can not create due to the number of managers more than 1000.");
					return;
				}
				String name = nameText.getText().toString();
				String password = passText.getText().toString();
				String repassword = repassText.getText().toString();
				String phone = phoneText.getText().toString();
				String position = positionText.getText().toString();
				String confirm = String.valueOf(confirmText.getPassword());
				
				if (name.equals("")) {
					JOptionPane.showMessageDialog(frame, "Name can not be emptied.");
					return;
				}
				try {
					Integer.parseInt(password);
				} catch (Exception n1) {
					JOptionPane.showMessageDialog(frame, "Password must be digits.");
					return;
				}
				if (Integer.parseInt(password) / 1000 <= 0 || Integer.parseInt(password) / 10000 !=0) {
					JOptionPane.showMessageDialog(frame, "Please create your password with 4 digits.");
					return;
				}
				if (!password.equals(repassword)) {
					JOptionPane.showMessageDialog(frame, "Password is not matching.");
					return;
				}
				try {
					Long.parseLong(phone);
				} catch (Exception n1) {
					JOptionPane.showMessageDialog(frame, "Phone must be a number.");
					return;
				}
				try {
					Integer.parseInt(position);
				} catch (Exception n1) {
					JOptionPane.showMessageDialog(frame, "Position must be a number.");
					return;
				}
				if (Integer.parseInt(position) != 1 && Integer.parseInt(position) != 2) {
					JOptionPane.showMessageDialog(frame, "Position must be 1 or 2");
					return;
				}
				try {
					Integer.parseInt(confirm);
				} catch (Exception n1) {
					JOptionPane.showMessageDialog(frame, "Your password must be a number.");
					return;
				}
				// if correct password -> create and add to list manager
				if (Integer.parseInt(confirm) == manager.getPassword()) {
					Manager mng = new Manager(name, bank.getListManager().size() + 1, Integer.parseInt(password), phone, Integer.parseInt(position));
					bank.getListManager().add(mng);
					data.saveManager(bank.getListManager());
					JOptionPane.showMessageDialog(frame, "Succesfully. ID of Manager is " + mng.getId());
					bank.managerMenu(bank, manager, data);
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(frame, "Your password is not correct. Please try again.");
					return;
				}
			}
		});
		// button exit : back to user menu
		exit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				bank.managerMenu(bank, manager, data);
				frame.dispose();
			}
		});
	}
	 
	public void createUser(Bank bank, Manager manager, database data) {
		// Create new frame for creating user method
		JFrame frame = new JFrame("Management Window");
		frame.setSize(600, 500);
		frame.setLocationRelativeTo(null);
		
		JLabel title = main.Label("Create New User Account", 25);
		JLabel label1 = main.Label("Name of User", 20);
		JTextField nameText = main.TextField(20);
		JLabel label2 = main.Label("Password (4 digits)", 20);
		JTextField passText = main.TextField(20);
		JLabel label3 = main.Label("Confirm password", 20);
		JTextField repassText = main.TextField(20);
		JLabel label4 = main.Label("Phone number", 20);
		JTextField phoneText = main.TextField(20);
		JLabel label5 = main.Label("Balance", 20);
		JTextField balanceText = main.TextField(20);
		JLabel label6 = main.Label("Enter your password", 20);
		JPasswordField confirmText = main.PasswordField(20);
		
		JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(2, 10, 2, 10));
		panel.add(label1);
		panel.add(nameText);
		panel.add(label2);
		panel.add(passText);
		panel.add(label3);
		panel.add(repassText);
		panel.add(label4);
		panel.add(phoneText);
		panel.add(label5);
		panel.add(balanceText);
		panel.add(label6);
		panel.add(confirmText);
		
		JButton create = main.Button("Click to Create", 20);
		JButton exit = main.Button("Back to Menu", 20);
		JPanel panel2 = new JPanel(new GridLayout(1, 2, 10, 10));
		panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel2.add(create);
		panel2.add(exit);
		
		frame.add(title, BorderLayout.NORTH);
		frame.add(panel, BorderLayout.CENTER);
		frame.add(panel2, BorderLayout.SOUTH);
		frame.setVisible(true);
		// Button create
		create.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameText.getText().toString();
				String password = passText.getText().toString();
				String repassword = repassText.getText().toString();
				String phone = phoneText.getText().toString();
				String balance = balanceText.getText().toString();
				String confirm = String.valueOf(confirmText.getPassword());
				// Create constraints
				if (name.equals("")) {
					JOptionPane.showMessageDialog(frame, "Name can not be emptied.");
					return;
				}
				try {
					Integer.parseInt(password);
				} catch (Exception n1) {
					JOptionPane.showMessageDialog(frame, "Password must be digits.");
					return;
				}
				if (Integer.parseInt(password) / 1000 <= 0 || Integer.parseInt(password) / 10000 !=0) {
					JOptionPane.showMessageDialog(frame, "Please create your password with 4 digits.");
					return;
				}
				if (!password.equals(repassword)) {
					JOptionPane.showMessageDialog(frame, "Password is not matching.");
					return;
				}
				try {
					Long.parseLong(phone);
				} catch (Exception n1) {
					JOptionPane.showMessageDialog(frame, "Phone must be a number.");
					return;
				}
				try {
					Double.parseDouble(balance);
				} catch (Exception n1) {
					JOptionPane.showMessageDialog(frame, "Balance must be a number.");
					return;
				}
				if (Double.parseDouble(balance) <= 0) {
					JOptionPane.showMessageDialog(frame, "Balance must be a positive number.");
					return;
				}
				try {
					Integer.parseInt(confirm);
				} catch (Exception n1) {
					JOptionPane.showMessageDialog(frame, "Your password must be a number.");
					return;
				}
				// if correct password -> create and add to list user
				if (Integer.parseInt(confirm) == manager.getPassword()) {
					User user = new User(name, bank.getListUser().size() + bank.getListblock().size() + 1001, Integer.parseInt(password), phone, Double.parseDouble(balance));
					bank.getListUser().add(user);
					data.saveUser(bank.getListUser());
					JOptionPane.showMessageDialog(frame, "Succesfully. ID of User is " + user.getId());
					bank.managerMenu(bank, manager, data);
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(frame, "Your password is not correct. Please try again.");
					return;
				}
			}
		});
		//button exit
		exit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				bank.managerMenu(bank, manager, data);
				frame.dispose();
			}
		});
	}
	
	public void deposit(Bank bank, Manager manager, database data) {
		// Create new frame for deposit method
		JFrame frame = new JFrame("Deposit Window");
		frame.setSize(400, 350);
		frame.setLocationRelativeTo(null);
		
		JLabel title = main.Label("Please enter ID and Amount!", 25);
		JLabel label1 = main.Label("ID", 20);
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
				if (manager.getPassword() == Integer.parseInt(String.valueOf(passText.getPassword()))) {
					boolean flag = false;
					User user = new User();
					// find user in list of users by ID
					for (User iterator : bank.getListUser()) {
						if (iterator.getId() == Integer.parseInt(idText.getText().toString())) {
							flag = true;
							user = iterator;
							break;
						}
					}
					// if finded -> deposit to user account / if not -> show message not existed
					if (flag) {
						user.setBalance(user.getBalance() + Double.parseDouble(amountText.getText().toString()));
						data.saveUser(bank.getListUser());
						JOptionPane.showMessageDialog(frame, "Successfully.");
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
	
	public void withdraw(Bank bank, Manager manager, database data) {
		// Create new frame for deposit method
		JFrame frame = new JFrame("Withdraw Window");
		frame.setSize(400, 350);
		frame.setLocationRelativeTo(null);
		
		JLabel title = main.Label("Please enter ID and Amount!", 25);
		JLabel label1 = main.Label("ID", 20);
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
				//Create constraints
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
				if (manager.getPassword() == Integer.parseInt(String.valueOf(passText.getPassword()))) {
					boolean flag = false;
					User user = new User();
					// find user in list of users by ID
					for (User iterator : bank.getListUser()) {
						if (iterator.getId() == Integer.parseInt(idText.getText().toString())) {
							flag = true;
							user = iterator;	
							break;
						}
					}
					// if finded -> check balance >= amount -> implement
					if (flag) {
						double amount = Double.parseDouble(amountText.getText().toString());
						if (user.getBalance() >= amount) {
							user.setBalance(user.getBalance() - amount);
							data.saveUser(bank.getListUser());
							JOptionPane.showMessageDialog(frame, "Successfully.");
						} else {
							JOptionPane.showMessageDialog(frame, "Balance of user is lower than the amount.");
							return;
						}
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
	
	public void transfer(Bank bank, Manager manager, database data) {
		// Create new frame for transfer method
		JFrame frame = new JFrame("Transfer Window");
		frame.setSize(500, 400);
		frame.setLocationRelativeTo(null);
		
		JLabel title = main.Label("Transfer from user1 to user2!", 25);
		JLabel label1 = main.Label("ID user1", 20);
		JTextField id1Text = main.TextField(20);
		JLabel label2 = main.Label("ID user2", 20);
		JTextField id2Text = main.TextField(20);
		JLabel label3 = main.Label("Amount", 20);
		JTextField amountText = main.TextField(20);
		JLabel label4 = main.Label("Your password", 20);
		JPasswordField passText = main.PasswordField(20);
		
		JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel.add(label1);
		panel.add(id1Text);
		panel.add(label2);
		panel.add(id2Text);
		panel.add(label3);
		panel.add(amountText);
		panel.add(label4);
		panel.add(passText);
		
		JButton confirm = main.Button("OK", 20);
		JPanel panel2 = new JPanel(new GridLayout(1, 1, 10, 10));
		panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel2.add(confirm);
		frame.add(title, BorderLayout.NORTH);
		frame.add(panel, BorderLayout.CENTER);
		frame.add(panel2, BorderLayout.SOUTH);
		frame.setVisible(true);
		// button confirm
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Create constraints
				try {
					Integer.parseInt(id1Text.getText().toString());
					Integer.parseInt(id2Text.getText().toString());
				} catch (Exception n1) {
					JOptionPane.showMessageDialog(frame, "ID of user1 and user2 must be a number.");
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
				if (id1Text.getText().toString().equals(id2Text.getText().toString())) {
					JOptionPane.showMessageDialog(frame, "ID of user1 and user2 must be different.");
					return;
				}
				// check password of user to implement
				if (manager.getPassword() == Integer.parseInt(String.valueOf(passText.getPassword()))) {
					boolean flag1 = false;
					boolean flag2 = false;
					User user1 = new User();
					User user2 = new User();
					// find user1 and user2
					for (User iterator : bank.getListUser()) {
						if (iterator.getId() == Integer.parseInt(id1Text.getText().toString())) {
							flag1 = true;
							user1 = iterator;
							break;
						}
					}
					for (User iterator : bank.getListUser()) {
						if (iterator.getId() == Integer.parseInt(id2Text.getText().toString())) {
							flag2 = true;
							user2 = iterator;
							break;
						}
					}
					// user1 and user2 finded -> check balance of user1 and implement
					if (flag1 && flag2) {
						double amount = Double.parseDouble(amountText.getText().toString());
						if (user1.getBalance() >= amount) {
							user1.setBalance(user1.getBalance() - amount);
							user2.setBalance(user2.getBalance() + amount);
							data.saveUser(bank.getListUser());
							JOptionPane.showMessageDialog(frame, "Successfully.");
						} else {
							JOptionPane.showMessageDialog(frame, "Balance of user1 is lower than the amount.");
							return;
						}
					// user1 is not finded	
					} else {
						JOptionPane.showMessageDialog(frame, "The id of user1 or user2 are not existed.");
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
	
	public void showInfo(Bank bank) {
		// Create new frame for method showInfo
		JFrame frame = new JFrame("Management Window");
		frame.setSize(300, 250);
		frame.setLocationRelativeTo(null);
		JLabel title = main.Label("Enter id of User!", 25);
		JLabel label1 = main.Label("ID", 20);
		JTextField idText = main.TextField(20);
		
		JPanel panel = new JPanel(new GridLayout(1, 2, 20, 20));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		panel.add(label1);
		panel.add(idText);
		
		JButton confirm = main.Button("OK", 20);
		JPanel panel2 = new JPanel(new GridLayout(1, 1, 10, 10));
		panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel2.add(confirm);
		
		frame.add(title, BorderLayout.NORTH);
		frame.add(panel, BorderLayout.CENTER);
		frame.add(panel2, BorderLayout.SOUTH);
		frame.setVisible(true);
		// Implement method: find the user account -> print information
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean flag = false;
				User user = new User();
				int id = Integer.parseInt(idText.getText().toString());
				for (User iterator : bank.getListUser()) {
					if (iterator.getId() == id) {
						flag = true;
						user = iterator;
						break;
					}
				}
				if (flag) {
					JOptionPane.showMessageDialog(frame, "ID Account: " + user.getId() + "\nName Account: " + user.getName() + "\nPassword: " + user.getPassword() + "\nPhoneNumber: " + user.getPhoneNumber() + "\nBalance: " + user.getBalance());
				} else {
					JOptionPane.showMessageDialog(frame, "The id is not existed.");
				}
				frame.dispose();
			}
		});
	}
	
	public void blockUser(Bank bank, Manager manager, database data) {
		// Create new frame for block method
		JFrame frame = new JFrame("Block Window");
		frame.setSize(400, 300);
		frame.setLocationRelativeTo(null);
		
		JLabel title = main.Label("Please enter an ID to block!", 25);
		JLabel label1 = main.Label("ID", 20);
		JTextField idText = main.TextField(20);
		JLabel label2 = main.Label("Your password", 20);
		JPasswordField passText = main.PasswordField(20);
		
		JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel.add(label1);
		panel.add(idText);
		panel.add(label2);
		panel.add(passText);
		
		JButton confirm = main.Button("Warning! Click to block", 20);
		JPanel panel2 = new JPanel(new GridLayout(1, 1, 10, 10));
		panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel2.add(confirm);
		
		frame.add(title, BorderLayout.NORTH);
		frame.add(panel, BorderLayout.CENTER);
		frame.add(panel2, BorderLayout.SOUTH);
		frame.setVisible(true);
		// Button confirm: click to block
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
					Integer.parseInt(String.valueOf(passText.getPassword()));
				} catch (Exception n1) {
					JOptionPane.showMessageDialog(frame, "Password must be a number.");
					return;
				}
				// Implement method
				if (manager.getPassword() == Integer.parseInt(String.valueOf(passText.getPassword()))) {
					boolean flag = false;
					User user = new User();
					// find the id to block
					for (User iterator : bank.getListUser()) {
						if (iterator.getId() == Integer.parseInt(idText.getText().toString())) {
							flag = true;
							user = iterator;
							break;
						}
					}
					if (flag) {
						bank.getListblock().add(user);
						bank.getListUser().remove(user);
						data.saveUser(bank.getListUser());
						data.saveBlock(bank.getListblock());
						JOptionPane.showMessageDialog(frame, "Succesfully.");
					} else {
						JOptionPane.showMessageDialog(frame, "The id user is not existed.");
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Your password is not correct.");
					return;
				}
				frame.dispose();
			}
		});		
	}
	
	public void unblockUser(Bank bank, Manager manager, database data) {
		// Create new frame for unblock method
		JFrame frame = new JFrame("Unblock Window");
		frame.setSize(400, 300);
		frame.setLocationRelativeTo(null);
		
		JLabel title = main.Label("Please enter an ID to block!", 25);
		JLabel label1 = main.Label("ID", 20);
		JTextField idText = main.TextField(20);
		JLabel label2 = main.Label("Your password", 20);
		JPasswordField passText = main.PasswordField(20);
		
		JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel.add(label1);
		panel.add(idText);
		panel.add(label2);
		panel.add(passText);
		
		JButton confirm = main.Button("Click to unblock", 20);
		JPanel panel2 = new JPanel(new GridLayout(1, 1, 10, 10));
		panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel2.add(confirm);
		
		frame.add(title, BorderLayout.NORTH);
		frame.add(panel, BorderLayout.CENTER);
		frame.add(panel2, BorderLayout.SOUTH);
		frame.setVisible(true);
		// Button confirm: click to unblock
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Integer.parseInt(idText.getText().toString());
				} catch (Exception n1) {
					JOptionPane.showMessageDialog(frame, "ID must be a number.");
					return;
				}
				try {
					Integer.parseInt(String.valueOf(passText.getPassword()));
				} catch (Exception n1) {
					JOptionPane.showMessageDialog(frame, "Password must be a number.");
					return;
				}
				// Implement method
				if (manager.getPassword() == Integer.parseInt(String.valueOf(passText.getPassword()))) {
					boolean flag = false;
					User user = new User();
					// find the id to unblock
					for (User iterator : bank.getListblock()) {
						if (iterator.getId() == Integer.parseInt(idText.getText().toString())) {
							flag = true;
							user = iterator;
							break;
						}
					}
					if (flag) {
						bank.getListUser().add(user);
						bank.getListblock().remove(user);
						data.saveUser(bank.getListUser());
						data.saveBlock(bank.getListblock());
						JOptionPane.showMessageDialog(frame, "Succesfully.");
					} else {
						JOptionPane.showMessageDialog(frame, "The id user is not existed in blocked list.");
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Your password is not correct.");
					return;
				}
				frame.dispose();
			}
		});			
	}
}
