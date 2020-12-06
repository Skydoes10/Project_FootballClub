package model;

public class AssistantCoach extends Employee{
	
	//Relationships

	//Attributes
	private int experienceYears;
	private String wasPlayer;
	private String expertise;
	
	//Builder
	public AssistantCoach(String name, String id, double salary, String status, int experienceYears,  String wasPlayer, String expertise) {
		super(name, id, salary, status);
		this.experienceYears = experienceYears;
		this.wasPlayer = wasPlayer;
		this.expertise = expertise;
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
	
	public String getExpertise(){
		return expertise;
	}
	
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}//End Getters and Setters
	
	public String toStringAC() {
		String out = "\n************* Assistant Coach *************"+toString()+"\n **  Experience years: "+getExperienceYears()+"\n **  Was a player: "+getWasPlayer()+"\n **  Expertise: "+getExpertise()+"\n*******************************************";
		return out;
	}
}
