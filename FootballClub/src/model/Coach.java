package model;

public class Coach extends Employee{
	
	//Relationships

	//Attributes
	private int experienceYears;
	
	//Builder
	public Coach(String name, String id, double salary, int experienceYears) {
		super(name, id, salary);
		this.experienceYears = experienceYears;
	}//End Builder
	
	//Getters and Setters
	public int getExperienceYears(){
		return experienceYears;
	}
	
	public void setExperienceYears(int experienceYears) {
		this.experienceYears = experienceYears;
	}
	
	//End Getters and Setters
}
