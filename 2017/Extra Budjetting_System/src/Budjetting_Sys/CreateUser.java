package Budjetting_Sys;

public class CreateUser {
	String name, password;
	double maxBalance;
	int id;

	public CreateUser(){
		this.password = "";
		this.name = "";
		this.maxBalance = 0;
		this.id = 1000 * (int)Math.random();
		
	}
	public void Create(String Name, String Password){
		this.name = Name;
		this.password = Password;
		System.out.printf("User created: %s with ID %d", name, id);
}
	public String getName(){
		return name;
	}
	public int id(){
		return id;
	}
}
