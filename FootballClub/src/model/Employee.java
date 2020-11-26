package model;

abstract public class Employee {
	
	//Relationships

	//Attributes
	private String name;
	private String id;
	private double salary;
	
	//Builder
	public Employee(String name, String id, double salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
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
	
	//End Getters and Setters
}
