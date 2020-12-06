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
								"\n(1) Team" + 
								"\n(2) Hire employee" + 
								"\n(3) Fire employee" + 
								"\n(4) Add employee to a team" + 
								"\n(5) Organizing coaches in the offices" + 
								"\n(6) Show information" +
								"\n(0) Exit" +
								"\n******************************************************\n"
								);
		option = sc.nextInt();
		sc.nextLine();
		switch(option) {
			case 1: menu3();
				break;
			case 2: menu1(option);
				break;
			case 3: menu1(option);
				break;
			case 4: menu1(option);
				break;
			case 5: organizeCoaches();
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
				case 2:	addCoachToTeam(option);
						menu = false;
					break;
				case 3:	addCoachToTeam(option);
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
					"\n(1) Show imformation of the club"+
					"\n(2) Show imformation of all teams"+
					"\n(3) Show information of all employees"+ 
					"\n(0) Return" +
					"\n******************************************************\n"
					);
			int option = sc.nextInt();
			sc.nextLine();
			switch(option) {
				case 1:	ShowClub();
						menu = false;
					break;
				case 2:	ShowAllTeams();
						menu = false;
					break;
				case 3:	ShowAllEmployees();
						menu = false;
					break;
				case 0:	menu = false;
					break;
				default: System.out.println("\nInvalid option");
			}
		}
	}
	
	public void menu3() {
		boolean menu = true;
		while(menu) {
			System.out.println(
					"\n******************************************************" +
					"\ntype the desired option:" +
					"\n(1) Create a Team"+
					"\n(2) Design alignment"+
					"\n(3) Organizing players in the locker rooms"+ 
					"\n(0) Return" +
					"\n******************************************************\n"
					);
			int option = sc.nextInt();
			sc.nextLine();
			switch(option) {
				case 1:	createTeam();
						menu = false;
					break;
				case 2:	designAlignment();
						menu = false;
					break;
				case 3:	organizePlayers();
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
		System.out.println("\nType the name of the employee:");
		name = sc.nextLine();
		System.out.println("\nType the id of the employee:");
		id = sc.nextLine();
		System.out.println("\nType the employee's salary:");
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
		String wasPlayer, expertise;
		System.out.println("\nEnter the coach's years of experience:");
		experienceYears = sc.nextInt();
		sc.nextLine();
		System.out.println("\nWas the assistant coach a professional player? YES/NO");
		wasPlayer = sc.nextLine();
		System.out.println("\nWrite down any expertise the assistant coach has. Ex: Offensive, defensive, possession, laboratory plays");
		expertise = sc.nextLine();
		String message = mainClub.hireAssistantCoach(name, id, salary, status, experienceYears, wasPlayer, expertise);
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
				"(1) GOALKEEPER\n" + 
				"(2) DEFENDER\n" +
				"(3) MIDFIELDER\n"+
				"(4) FORWARD\n"
				);
		position = sc.nextInt();
		sc.nextLine();
		System.out.println("\nType the name of the team the player will belong:");
		team = sc.nextLine();
		String message = mainClub.addPlayerToTeam(name, id, numberTshirt, position, team);
		System.out.println(message);
	}
	
	public void addCoachToTeam(int option) {
		String name, id, team;
		System.out.println("\nType the name of the coach:");
		name = sc.nextLine();
		System.out.println("\nType the id of the coach:");
		id = sc.nextLine();
		System.out.println("\nType the name of the team the coach will belong:");
		team = sc.nextLine();
		String message = mainClub.addCoachToTeam(name, id, team, option);
		System.out.println(message);
	}
	
	public void ShowAllEmployees() {
		mainClub.showWorkers();
	}
	
	public void ShowAllTeams() {
		mainClub.showTeams();
	}
	
	public void ShowClub() {
		mainClub.showClubInfo();
	}
	
	public void designAlignment(){
		String nameTeam, date;
		int tactic, defenders, midfielders, forwards;
		System.out.println("\nEnter the name of the team for which the lineup is to be designed:");
		nameTeam = sc.nextLine();
		System.out.println("\nEnter the date of the match where the lineup will be used: (DD/MM/YY)");
		date = sc.nextLine();
		System.out.println("\nSelect alignment tactics:\n" +
				"(1) POSSESSION\n" +
				"(2) COUNTERATTACK\n" +
				"(3) HIGH PRESSURE\n" +
				"(4) DEFAULT\n"
				);
		tactic = sc.nextInt();
		sc.nextLine();
		System.out.println("\nEnter the number of defenders that will be on the soccer field:");
		defenders = sc.nextInt();
		sc.nextLine();
		System.out.println("\nEnter the number of midfielders that will be on the soccer field:");
		midfielders = sc.nextInt();
		sc.nextLine();
		System.out.println("\nEnter the number of forwards that will be on the soccer field:");
		forwards = sc.nextInt();
		sc.nextLine();
		String message = mainClub.designAlignment(nameTeam, date, tactic, defenders, midfielders, forwards);
		System.out.println(message);
	}
	
	public void organizePlayers() {
		String nameTeam;
		int locker;
		System.out.println("\nEnter the name of the team for which the lineup is to be designed:");
		nameTeam = sc.nextLine();
		System.out.println("\nSelect a locker room:\n" +
				"(1) Locker room A\n" +
				"(2) Locker room B\n"
				);
		locker = sc.nextInt();
		sc.nextLine();
		String message = mainClub.organizePinLocker(nameTeam, locker);
		System.out.println(message);
	}
	
	public void organizeCoaches() {
		String message = mainClub.organizeCinOffices();
		System.out.println(message);
	}
}
