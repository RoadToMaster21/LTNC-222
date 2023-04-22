package banksystem;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Bank {
	private String name;
	private ArrayList<Manager> listManager;
	private ArrayList<User> listUser;
	private ArrayList<User> listblock;
	
	public Bank(String name, ArrayList<Manager> listManager, ArrayList<User> listUser, ArrayList<User> listblock) {
		super();
		this.name = name;
		this.listManager = listManager;
		this.listUser = listUser;
		this.listblock = listblock;
	}
	
	public ArrayList<Manager> getListManager() {
		return listManager;
	}

	public ArrayList<User> getListUser() {
		return listUser;
	}

	public ArrayList<User> getListblock() {
		return listblock;
	}

	public void login(Bank bank, database data) {
		// Create new frame for login
		JFrame frame = new JFrame("Management Window");
		frame.setSize(500, 400);
		frame.setLocationRelativeTo(null);
		
		JLabel title = main.Label("Welcome to " + name + "!", 25);
		title.setBorder(BorderFactory.createEmptyBorder(30, 10, 20, 10));
		JLabel titleID = main.Label("Account ID", 20);
		JTextField idText = main.TextField(20);
		JLabel titlePass = main.Label("Password", 20);
		JPasswordField passwordText = main.PasswordField(20);
		
		JPanel panel = new JPanel(new GridLayout(2, 2, 2, 40));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 50));
		panel.add(titleID);
		panel.add(idText);
		panel.add(titlePass);
		panel.add(passwordText);
		
		JPanel panel2 = new JPanel(new GridLayout(2, 2, 20, 10));
		panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		JButton managerBt = main.Button("Login with manager account", 20);
		panel2.add(managerBt);
		JButton userBt = main.Button("Login with user account", 20);
		panel2.add(userBt);
		
		frame.add(title, BorderLayout.NORTH);
		frame.add(panel, BorderLayout.CENTER);
		frame.add(panel2, BorderLayout.SOUTH);
		frame.setVisible(true);
		// login with manager account
		managerBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Create constraints
				String loginId = idText.getText().toString();
				String loginPass = String.valueOf(passwordText.getPassword());
				
				if (loginId.equals("")) {
					JOptionPane.showMessageDialog(frame, "Please enter your ID Account.");
					return;
				}
				if (loginPass.equals("")) {
					JOptionPane.showMessageDialog(frame, "Please enter your password.");
					return;
				}
				int id = Integer.parseInt(loginId);
				int password = Integer.parseInt(loginPass);
				Manager manager = new Manager();
				boolean flag = false;
				for (Manager iterator : listManager) {
					if (iterator.getId() == id && iterator.getPassword() == password) {
						flag = true;
						manager = iterator;
					}
				}
				// if successfully login -> manager menu
				if (flag) {
					bank.managerMenu(bank, manager, data);
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(frame, "Wrong ID or password, or your account does not exist.");
				}
			}
		});
		// login with user acccount
		userBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Create constraints
				String loginId = idText.getText().toString();
				String loginPass = String.valueOf(passwordText.getPassword());
				
				if (loginId.equals("")) {
					JOptionPane.showMessageDialog(frame, "Please enter your ID Account.");
					return;
				}
				if (loginPass.equals("")) {
					JOptionPane.showMessageDialog(frame, "Please enter your password.");
					return;
				}
				int id = Integer.parseInt(loginId);
				int password = Integer.parseInt(loginPass);
				User user = new User();
				boolean flag = false;
				for (User iterator : listUser) {
					if (iterator.getId() == id && iterator.getPassword() == password) {
						flag = true;
						user = iterator;
					}
				}
				// if successfully login -> user menu 
				if (flag) {
					bank.userMenu(bank, user, data);
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(frame, "Wrong ID or password, or your account does not exist.");
				}
			}
		});
		
	}
	
	public void managerMenu(Bank bank, Manager manager, database data) {
		// Create new frame for manger menu
		JFrame frame = new JFrame("Manager Window");
		frame.setSize(600, 500);
		frame.setLocationRelativeTo(null);
		JLabel title = main.Label("Welcome " + manager.getName() + " to DN Bank!", 25);
		
		JButton createManager = main.Button("1. Create Manager", 20);
		createManager.setHorizontalAlignment(SwingConstants.LEFT);
		JButton createUser = main.Button("2. Create User", 20);
		createUser.setHorizontalAlignment(SwingConstants.LEFT);
		JButton deposit = main.Button("3. Deposit to User", 20);
		deposit.setHorizontalAlignment(SwingConstants.LEFT);
		JButton withdraw = main.Button("4. Withdraw from User", 20);
		withdraw.setHorizontalAlignment(SwingConstants.LEFT);
		JButton transfer = main.Button("5. Transfer", 20);
		transfer.setHorizontalAlignment(SwingConstants.LEFT);
		JButton showinfo = main.Button("6. Information of User", 20);
		showinfo.setHorizontalAlignment(SwingConstants.LEFT);
		JButton block = main.Button("7. Block User", 20);
		block.setHorizontalAlignment(SwingConstants.LEFT);
		JButton unblock = main.Button("8. Unblock User", 20);
		unblock.setHorizontalAlignment(SwingConstants.LEFT);
		JButton exit = main.Button("9. Exit", 20);
		exit.setHorizontalAlignment(SwingConstants.LEFT);
		
		JPanel panel = new JPanel(new GridLayout(5, 2, 20, 20));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		panel.add(createManager);
		panel.add(createUser);
		panel.add(deposit);
		panel.add(withdraw);
		panel.add(transfer);
		panel.add(showinfo);
		panel.add(block);
		panel.add(unblock);
		panel.add(exit);
		
		frame.add(title, BorderLayout.NORTH);
		frame.add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
		// Implement method: create manager account
		createManager.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if (manager.getPosition() == 1) {
					manager.createManager(bank, manager, data);
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(frame, "Your positon can not do this task!");
				}
			}
		});
		// Implement method: create user account
		createUser.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				manager.createUser(bank, manager, data);
				frame.dispose();
			}
		});
		// Implement method: deposit to an user account
		deposit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				manager.deposit(bank, manager, data);
			}
		});
		// Implement method: withdraw from an user account
		withdraw.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				manager.withdraw(bank, manager, data);
			}
		});
		// Implement method:transfer money from user to user
		transfer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				manager.transfer(bank, manager, data);
			}
		});
		// Implement method: get information of user
		showinfo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				manager.showInfo(bank);
			}
		});	
		// Implement method:transfer money from user to user
		block.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if (manager.getPosition() == 1) {
					manager.blockUser(bank, manager, data);
				} else {
					JOptionPane.showMessageDialog(frame, "Your positon can not do this task!");
				}
			}
		});	
		unblock.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				manager.unblockUser(bank, manager, data);
			}
		});	
		
		// Exit button to back to login 
		exit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				bank.login(bank, data);
				frame.dispose();
			}
		});
	}
	
	public void userMenu(Bank bank, User user, database data) {
		// Create a frame for user menu 
		JFrame frame = new JFrame("User Window");
		frame.setSize(500, 400);
		frame.setLocationRelativeTo(null);
		
		JLabel title = main.Label("Welcome " + user.getName() + " to DN Bank!", 25);
		
		JButton deposit = main.Button("1. Deposit", 20);
		deposit.setHorizontalAlignment(SwingConstants.LEFT);
		JButton withdraw = main.Button("2. Withdraw", 20);
		withdraw.setHorizontalAlignment(SwingConstants.LEFT);
		JButton transfer = main.Button("3. Transfer", 20);
		transfer.setHorizontalAlignment(SwingConstants.LEFT);
		JButton balance = main.Button("4. Check Balance", 20);
		balance.setHorizontalAlignment(SwingConstants.LEFT);
		JButton exit = main.Button("5. Exit", 20);
		exit.setHorizontalAlignment(SwingConstants.LEFT);
		
		JPanel panel = new JPanel(new GridLayout(3, 2, 20, 20));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
		panel.add(deposit);
		panel.add(withdraw);
		panel.add(transfer);
		panel.add(balance);
		panel.add(exit);
		
		frame.add(title, BorderLayout.NORTH);
		frame.add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
		// Implement deposit method in user menu
		deposit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				user.deposit(bank, user, data);
			}
		});
		// Implement withdraw method in user menu
		withdraw.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				user.withdraw(bank, user, data);
			}
		});
		// Implement method: check balance of user account
		transfer.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				user.transfer(bank, user, data);
			}
		});
		// Implement method: check balance of user account
		balance.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				user.checkBalance(frame, user);
			}
		});
		// Exit button to back to login
		exit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				bank.login(bank, data);
				frame.dispose();
			}
		});
	}
	
}
