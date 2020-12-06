package model;

public class Player extends Employee implements Calculate{
	
	//Relationships

	//Attributes
	private int numberTshirt;
	private int amountGoals;
	private int averageGrade;
	private Position position;
	
	//Builder
	public Player(String name, String id, double salary, String status, int numberTshirt, int amountGoals, int averageGrade) {
		super(name, id, salary, status);
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
	}//End Getters and Setters

	@Override
	public double calculatePrice() {
		double marketPrice = 0.0;
		if (getPosition() == Position.GOALKEEPER) {
			marketPrice = (super.getSalary()*12)+(getAverageGrade()*150);
		}
		else if (getPosition() == Position.DEFENDER) {
			marketPrice = (super.getSalary()*13)+(getAverageGrade()*125)+(getAmountGoals()*100);
		}
		else if (getPosition() == Position.MIDFIELDER) {
			marketPrice = (super.getSalary()*14)+(getAverageGrade()*135)+(getAmountGoals()*125);
		}
		else if (getPosition() == Position.FORWARD) {
			marketPrice = (super.getSalary()*15)+(getAverageGrade()*145)+(getAmountGoals()*150);
		}
		return marketPrice;
	}

	@Override
	public double calculateLevel() {
		double level = 0.0;
		if (getPosition() == Position.GOALKEEPER) {
			level = (getAverageGrade()*0.9);
		}
		else if (getPosition() == Position.DEFENDER) {
			level = (getAverageGrade()*0.9)+(getAmountGoals()/100);
		}
		else if (getPosition() == Position.MIDFIELDER) {
			level = +(getAverageGrade()*0.9)+(getAmountGoals()/90);
		}
		else if (getPosition() == Position.FORWARD) {
			level = +(getAverageGrade()*0.9)+(getAmountGoals()/80);
		}
		return level;
	}
	
	public String toStringP() {
		String out = "\n****************** Player *****************"+toString()+"\n **  T-shirt number: "+getNumberTshirt()+"\n **  Amount goals: "+getAmountGoals()+"\n **  Average grade: "+getAverageGrade()+"\n **  Position: "+getPosition()+"\n*******************************************";
		return out;
	}
}
