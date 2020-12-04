package model;

abstract public class Employee {
	
	//Relationships

	//Attributes
	private String name;
	private String id;
	private double salary;
	private String status;
	
	//Builder
	public Employee(String name, String id, double salary, String status) {
		this.name = name;
		this.id = id;
		this.salary = salary;
		this.status = status;
	}//End Builder
	
	//Getters and Setters
	public String getName(){
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getId(){
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public double getSalary(){
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String getStatus(){
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}//End Getters and Setters
	
	public String toString() {
		String out = "\n **  Name: "+getName()+"\n **  ID: "+getId()+"\n **  Salary: "+getSalary()+"\n **  Status: "+getStatus();
		return out;
	}
}