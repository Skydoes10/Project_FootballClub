package model;

public class Player extends Employee{
	
	//Relationships

	//Attributes
	private int numberTshirt;
	private int amountGoals;
	private int averageGrade;
	private Position position;
	
	//Builder
	public Player(String name, String id, double salary, int numberTshirt, int amountGoals, int averageGrade) {
		super(name, id, salary);
		this.numberTshirt = numberTshirt;
		this.amountGoals = amountGoals;
		this.averageGrade = averageGrade;
	}//End Builder
	
	//Getters and Setters
	public int getNumberTshirt(){
		return numberTshirt;
	}
	
	public void setNumberTshirt(int numberTshirt) {
		this.numberTshirt = numberTshirt;
	}

	public int getAmountGoals(){
		return amountGoals;
	}
	
	public void setAmountGoals(int amountGoals) {
		this.amountGoals = amountGoals;
	}
	
	public int getAverageGrade(){
		return averageGrade;
	}
	
	public void setAverageGrade(int averageGrade) {
		this.averageGrade = averageGrade;
	}
	
	public Position getPosition(){
		return position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
	//End Getters and Setters
}
