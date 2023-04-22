package banksystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class database {
	File managerFile = new File("Files/managers");;
	File userFile = new File("Files/users");
	File blockFile = new File("Files/listBlock");
	// constructor default: if file is not exist -> create file
	public database() {
		if (!managerFile.exists()) {
			try {
				managerFile.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			};
		}
		if (!userFile.exists()) {
			try {
				userFile.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			};
		}
		if (!blockFile.exists()) {
			try {
				blockFile.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			};
		}
	}
	// read from file managers
	public ArrayList<Manager> getManagers() {
		String text = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(managerFile));
			String s;
			while ((s = br.readLine()) != null) {
				text = text + s;
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ArrayList<Manager> listManager = new ArrayList<>();
		String[] array1 = text.split("NewAccount");
		for (String v : array1) {
			if (!v.equals("")) {
				String[] array2 = v.split(" / ");
				Manager manager = new Manager();
				manager.setName(array2[0]);
				manager.setId(Integer.parseInt(array2[1]));
				manager.setPassword(Integer.parseInt(array2[2]));
				manager.setPhoneNumber(array2[3]);
				manager.setPosition(Integer.parseInt(array2[4]));
				listManager.add(manager);
			}
		}
		return listManager;
	}
	// read from file users
	public ArrayList<User> getUsers() {
		String text = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(userFile));
			String s;
			while ((s = br.readLine()) != null) {
				text = text + s;
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ArrayList<User> listUser = new ArrayList<>();
		String[] array1 = text.split("NewAccount");
		for (String v : array1) {
			if (!v.equals("")) {
				String[] array2 = v.split(" / ");
				User user = new User();
				user.setName(array2[0]);
				user.setId(Integer.parseInt(array2[1]));
				user.setPassword(Integer.parseInt(array2[2]));
				user.setPhoneNumber(array2[3]);
				user.setBalance(Double.parseDouble(array2[4]));
				listUser.add(user);
			}
		}
		return listUser;
	}
	// read from file listBlock
	public ArrayList<User> getBlock() {
		String text = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(blockFile));
			String s;
			while ((s = br.readLine()) != null) {
				text = text + s;
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ArrayList<User> listblock = new ArrayList<>();
		String[] array1 = text.split("BlockAccount");
		for (String v : array1) {
			if (!v.equals("")) {
				String[] array2 = v.split(" / ");
				User user = new User();
				user.setName(array2[0]);
				user.setId(Integer.parseInt(array2[1]));
				user.setPassword(Integer.parseInt(array2[2]));
				user.setPhoneNumber(array2[3]);
				user.setBalance(Double.parseDouble(array2[4]));
				listblock.add(user);
			}
		}
		return listblock;
	}
	// write to file managers
	public void saveManager(ArrayList<Manager> listManager) {
		String text = "";
		for (Manager m : listManager) {
			StringBuilder bd = new StringBuilder();
			bd.append(m.getName()).append(" / ");
			bd.append(String.valueOf(m.getId())).append(" / ");
			bd.append(String.valueOf(m.getPassword())).append(" / ");
			bd.append(m.getPhoneNumber()).append(" / ");
			bd.append(String.valueOf(m.getPosition())).append(" / ");
			bd.append("NewAccount\n");
			text = text + bd.toString();
		}
		try {
			PrintWriter pw = new PrintWriter(managerFile);
			pw.print(text);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	// write to file users
	public void saveUser(ArrayList<User> listUser) {
		String text = "";
		for (User u : listUser) {
			StringBuilder bd = new StringBuilder();
			bd.append(u.getName()).append(" / ");
			bd.append(String.valueOf(u.getId())).append(" / ");
			bd.append(String.valueOf(u.getPassword())).append(" / ");
			bd.append(u.getPhoneNumber()).append(" / ");
			bd.append(String.valueOf(u.getBalance())).append(" / ");
			bd.append("NewAccount\n");
			text = text + bd.toString();
		}
		try {
			PrintWriter pw = new PrintWriter(userFile);
			pw.print(text);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	// write to file listBlock
	public void saveBlock(ArrayList<User> listblock) {
		String text = "";
		for (User u : listblock) {
			StringBuilder bd = new StringBuilder();
			bd.append(u.getName()).append(" / ");
			bd.append(String.valueOf(u.getId())).append(" / ");
			bd.append(String.valueOf(u.getPassword())).append(" / ");
			bd.append(u.getPhoneNumber()).append(" / ");
			bd.append(String.valueOf(u.getBalance())).append(" / ");
			bd.append("BlockAccount\n");
			text = text + bd.toString();
		}
		try {
			PrintWriter pw = new PrintWriter(blockFile);
			pw.print(text);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}