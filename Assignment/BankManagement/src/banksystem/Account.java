package banksystem;

public class Account {
	private String name;
	private int id;
	private int password;
	private String phoneNumber;
	
	public Account() {
		
	}
	
	public Account(String name, int id, int password, String phoneNumber) {
		this.name = name;
		this.id = id;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
