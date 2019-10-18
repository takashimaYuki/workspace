package web;

public class ECsitegetset {
	private String name ="";
	private String password="";

//入力された値を保管して（get）返している（set）
//ここではnameとpassword	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}
