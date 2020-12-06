package model;

public class HeadCoach extends Employee implements Calculate{
	
	//Relationships

	//Attributes
	private int experienceYears;
	private int numberTeams;
	private int championships;
	
	//Builder
	public HeadCoach(String name, String id, double salary, String status, int experienceYears, int numberTeams, int championships) {
		super(name, id, salary, status);
		this.experienceYears = experienceYears;
		this.numberTeams = numberTeams;
		this.championships = championships;
	}//End Builder
	
	//Getters and Setters
	public int getExperienceYears(){
		return experienceYears;
	}
	
	public void setExperienceYears(int experienceYears) {
		this.experienceYears = experienceYears;
	}
	
	public int getNumberTeams(){
		return numberTeams;
	}
	
	public void setNumberTeams(int numberTeams) {
		this.numberTeams = numberTeams;
	}
	
	public int getChampionships(){
		return championships;
	}
	
	public void setChampionships(int championships) {
		this.championships = championships;
	}//End Getters and Setters

	@Override
	public double calculatePrice() {
		double marketPrice = 0.0;
		marketPrice = (super.getSalary()*10)+(getExperienceYears()*100)+(getChampionships()*50);
		return marketPrice;
	}

	@Override
	public double calculateLevel() {
		double level = 0.0;
		level = 5+(getChampionships()/10);
		return level;
	}
	
	public String toStringHC() {
		String out = "\n**************** Head Coach ***************"+toString()+"\n **  Experience years: "+getExperienceYears()+"\n **  Managed teams: "+getNumberTeams()+"\n **  Championships won: "+getChampionships()+"\n*******************************************";
		return out;
	}
}
