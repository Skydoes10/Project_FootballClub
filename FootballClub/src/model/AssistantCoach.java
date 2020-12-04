package model;

public class AssistantCoach extends Employee{
	
	//Relationships

	//Attributes
	private int experienceYears;
	private String wasPlayer;
	
	
	//Builder
	public AssistantCoach(String name, String id, double salary, String status, int experienceYears,  String wasPlayer) {
		super(name, id, salary, status);
		this.experienceYears = experienceYears;
		this.wasPlayer = wasPlayer;
		
	}//End Builder
	
	//Getters and Setters
	public int getExperienceYears(){
		return experienceYears;
	}
	
	public void setExperienceYears(int experienceYears) {
		this.experienceYears = experienceYears;
	}
	
	public String getWasPlayer(){
		return wasPlayer;
	}
	
	public void setWasPlayer(String wasPlayer) {
		this.wasPlayer = wasPlayer;
	}
	
	//End Getters and Setters
	
	public String toStringHC() {
		String out = "\n************* Assistant Coach *************"+toString()+"\n **  Experience years: "+getExperienceYears()+"\n **  Was a player: "+getWasPlayer()+"\n************************************";
		return out;
	}
}
