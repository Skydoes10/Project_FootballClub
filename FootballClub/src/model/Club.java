package model;

import java.util.ArrayList;

public class Club {
	
	//Relationships
	private ArrayList<Employee> workers;
	private Team[] teams;
	
	//Attributes
	private String name;
	private String NIT;
	private String creationDate;
	private int [][] offices;
	
	//Builder
	public Club(String name, String NIT, String creationDate) {
		this.name = name;
		this.NIT = NIT;
		this.creationDate = creationDate;
		offices = new int[6][6];
		teams = new Team[2];
		workers = new ArrayList<Employee>();
	}//End Builder
	
	//Getters and Setters
	public String getName(){
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNIT(){
		return NIT;
	}
	
	public void setNIT(String NIT) {
		this.NIT = NIT;
	}
	
	public String getCreationDate(){
		return creationDate;
	}
	
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}//End Getters and Setters
	
	public String createTeam(String name){
		boolean added = false;
		String message = "\nTeam "+name+" was created successfully";
		for(int i=0; i<teams.length && !added; i++) {
			if(teams[i] == null) {
				teams[i] = new Team(name);
				added = true;
			}
		}
		if (added == false){
			message = "\nTeams limit reached";
		}
		return message;
	}
	
	public String hirePlayer(String name, String id, double salary){
		String message = "\nThe player "+name+" was hired successfully";
		Player player = new Player(name, id, salary, 0, 0, 0);
		workers.add(player);
		return message;
	}
	
	public String hireCoach(String name, String id, double salary, int experienceYears){
		String message = "\nThe coach "+name+" was hired successfully";
		Coach coach = new Coach(name, id, salary, experienceYears);
		workers.add(coach);
		return message;
	}
	
	public String fireEmployee(String name, String id){
		String message = "\n"+name+" was successfully dismissed";
		Employee employee = findEmployee(id);
		if(employee != null) {
			workers.remove(employee);
		}
		else{
			message = "\n"+name+" has not been found";
		}
		return message;
	}
	
	public Employee findEmployee(String id) {
		Employee foundE = null;
		boolean found = false;
		if(workers.isEmpty() == false) {
			for(int i=0; i<workers.size() && !found; i++) {
				if(workers.get(i).getId().equalsIgnoreCase(id)) {
					foundE = workers.get(i);
					found = true;
				}
			}
		}
		return foundE;
	}
	
	public String addPlayerToTeam(String name, String id, int numberTshirt, int position, String teamName) {
		String message = "The player or team was not found";
		Team team = findTeam(teamName);
		Player player = (Player) findEmployee(id);
		if(team != null && player != null) {
			Position posit = null;
			switch(position){
		    case 1: posit = Position.DEFENDER;
		        break;
		    case 2: posit = Position.MIDFIELDER;
		        break;
		    case 3: posit = Position.FORWARD;
		    	break;
		    default: message = "\nInvalid position option";
			}
			player.setPosition(posit);
			player.setNumberTshirt(numberTshirt);
		    message = team.addPlayer(player);
		}
		
		return message;
	}
	
	public Team findTeam(String name) {
		Team foundT = null;
		boolean found = false;
		for(int i=0; i<teams.length && !found; i++){
			if(teams[i] != null && teams[i].getName().equalsIgnoreCase(name)){
				foundT = teams[i];
				found = true;
			}
		}
		return foundT;
	}
	

}
