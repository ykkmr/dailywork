package day0607;

public class LoginDataVO {
	private String name, email;
	
	public LoginDataVO() {
		
	}

	public LoginDataVO(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
