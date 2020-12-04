package ui;

import java.util.Scanner;
import model.Club;

public class Main {
	
	private Scanner sc;
	private Club mainClub;
	
	public Main(){
		sc = new Scanner(System.in);
		createClub();
	}
	
	public static void main(String[] args) {
		Main objMain = new Main();
		objMain.mainMenu();
	}
	
	public void mainMenu(){
		boolean menu = true;
		int option;
		while(menu) {
			System.out.println("\n******************************************************" +
								"\nSelect an option to start:\n" + 
								"\n(1) Create a Team" + 
								"\n(2) Hire employee" + 
								"\n(3) Fire employee" + 
								"\n(4) Add employee to a team" + 
								"\n(5) " + 
								"\n(6) Show information" +
								"\n(0) Exit" +
								"\n******************************************************\n"
								);
		option = sc.nextInt();
		sc.nextLine();
		switch(option) {
			case 1: createTeam();
				break;
			case 2: menu1(option);
				break;
			case 3: menu1(option);
				break;
			case 4: menu1(option);
				break;
			case 5: 
				break;
			case 6: menu2();
				break;
			case 0: menu = false;
					System.out.println("\nBye!");
				break;
			default:
					System.out.println("\nError, invalid option");
		}
		}
	}
	
	public void menu1(int mainOption) {
		boolean menu = true;
		while(menu) {
			System.out.println(
					"\n******************************************************" +
					"\nType the desired option:" +
					"\n(1) Player"+
					"\n(2) Head coach"+ 
					"\n(3) Assistant coach"+ 
					"\n(0) Return" +
					"\n******************************************************\n"
					);
			int option = sc.nextInt();
			sc.nextLine();
			if(mainOption == 2) {
				switch(option) {
				case 1:	hireEmployee(option);
						menu = false;
					break;
				case 2:	hireEmployee(option);
						menu = false;
					break;
				case 3:	hireEmployee(option);
						menu = false;
					break;
				case 0:	menu = false;
					break;
				default: System.out.println("\nInvalid option");
				}
			}
			else if(mainOption == 3) {
				switch(option) {
				case 1:	fireEmployee();
						menu = false;
					break;
				case 2:	fireEmployee();
						menu = false;
					break;
				case 3:	fireEmployee();
						menu = false;
					break;
				case 0:	menu = false;
					break;
				default: System.out.println("\nInvalid option");
				}
			}
			else {
				switch(option) {
				case 1:	addPlayerToTeam();
						menu = false;
					break;
				case 2:	addCoachToTeam();
						menu = false;
					break;
				case 3:	addCoachToTeam();
						menu = false;
					break;
				case 0:	menu = false;
					break;
				default: System.out.println("\nInvalid option");
				}
			}
		}
	}
	
	public void menu2() {
		boolean menu = true;
		while(menu) {
			System.out.println(
					"\n******************************************************" +
					"\ntype the desired option:" +
					"\n(1) Show information of all employees"+
					"\n(2) "+
					"\n(3) "+ 
					"\n(4) "+ 
					"\n(0) Return" +
					"\n******************************************************\n"
					);
			int option = sc.nextInt();
			sc.nextLine();
			switch(option) {
				case 1:	ShowAllEmployees();
						menu = false;
					break;
				case 2:	
						menu = false;
					break;
				case 3:	
						menu = false;
					break;
				case 4:	
						menu = false;
					break;
				case 0:	menu = false;
					break;
				default: System.out.println("\nInvalid option");
			}
		}
	}
	
	public void createClub() {
		String name, nit, creationDate;
		System.out.println("\nType the name of the club:");
		name = sc.nextLine();
		System.out.println("\nType the NIT:");
		nit = sc.nextLine();
		System.out.println("\nEnter the Club's founding date:");
		creationDate = sc.nextLine();
		mainClub = new Club(name, nit, creationDate);
	}
	
	public void createTeam() {
		String name;
		System.out.println("\nType the name of the Team:");
		name = sc.nextLine();
		String message = mainClub.createTeam(name);
		System.out.println(message);
	}
	
	public void hireEmployee(int option) {
		String name, id, status;
		double salary;
		System.out.println("\nType the name of the player:");
		name = sc.nextLine();
		System.out.println("\nType the id of the player:");
		id = sc.nextLine();
		System.out.println("\nType the player's salary:");
		salary = sc.nextDouble();
		sc.nextLine();
		status = "Inactive";
		if (option == 1) {
			hirePLayer(name, id, salary, status);
		}
		else if(option == 2) {
			hireHeadCoach(name, id, salary, status);
		}
		else {
			hireAssistantCoach(name, id, salary, status);
		}
	}
	
	public void hirePLayer(String name, String id, double salary, String status) {
		String message = mainClub.hirePlayer(name, id, salary, status);
		System.out.println(message);
	}
	
	public void hireHeadCoach(String name, String id, double salary, String status) {
		int experienceYears, numberTeams, championships;
		System.out.println("\nEnter the coach's years of experience:");
		experienceYears = sc.nextInt();
		sc.nextLine();
		System.out.println("\nEnter the number of teams the coach has been in charge of:");
		numberTeams = sc.nextInt();
		sc.nextLine();
		System.out.println("\nEnter the number of championships the coach has won:");
		championships = sc.nextInt();
		sc.nextLine();
		String message = mainClub.hireHeadCoach(name, id, salary, status, experienceYears, numberTeams, championships);
		System.out.println(message);
	}
	
	public void hireAssistantCoach(String name, String id, double salary, String status) {
		int experienceYears;
		String wasPlayer;
		System.out.println("\nEnter the coach's years of experience:");
		experienceYears = sc.nextInt();
		sc.nextLine();
		System.out.println("\nWas the assistant coach a player? YES/NO");
		wasPlayer = sc.nextLine();
		String message = mainClub.hireAssistantCoach(name, id, salary, status, experienceYears, wasPlayer);
		System.out.println(message);
	}
	
	public void fireEmployee() {
		String name, id;
		System.out.println("\nType the name of the employee:");
		name = sc.nextLine();
		System.out.println("\nType the id of the employee:");
		id = sc.nextLine();
		String message = mainClub.fireEmployee(name, id);
		System.out.println(message);
	}
	
	public void addPlayerToTeam() {
		String name, id, team;
		int numberTshirt, position;
		System.out.println("\nType the name of the player:");
		name = sc.nextLine();
		System.out.println("\nType the id of the player:");
		id = sc.nextLine();
		System.out.println("\nType the number of the shirt the player will wear:");
		numberTshirt = sc.nextInt();
		sc.nextLine();
		System.out.println("\nIndicate the player's position:\n" +
				"(1) DEFENDER\n" + 
				"(2) MIDFIELDER\n" +
				"(3) FORWARD\n"
				);
		position = sc.nextInt();
		sc.nextLine();
		System.out.println("\nType the name of the team the player will belong:");
		team = sc.nextLine();
		String message = mainClub.addPlayerToTeam(name, id, numberTshirt, position, team);
		System.out.println(message);
	}
	
	public void addCoachToTeam() {
		String name, id, team;
		int coach;
		System.out.println("\nIs coach a head coach or an assistant coach?\n" +
				"(1) Head coach\n" + 
				"(2) Assistant coach\n"
				);
		coach = sc.nextInt();
		sc.nextLine();
		System.out.println("\nType the name of the coach:");
		name = sc.nextLine();
		System.out.println("\nType the id of the coach:");
		id = sc.nextLine();
		System.out.println("\nType the name of the team the coach will belong:");
		team = sc.nextLine();
		String message = mainClub.addCoachToTeam(name, id, team, coach);
		System.out.println(message);
	}
	
	public void ShowAllEmployees() {
		mainClub.showWorkers();
	}
	
	
}
