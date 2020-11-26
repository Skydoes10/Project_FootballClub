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
								"\n(2) Players" + 
								"\n(3) Coaches" + 
								"\n(4) " + 
								"\n(5) " + 
								"\n(6) " +
								"\n(0) Exit" +
								"\n******************************************************\n"
								);
		option = sc.nextInt();
		sc.nextLine();
		switch(option) {
			case 1: createTeam();
				break;
			case 2: menu1();
				break;
			case 3: menu2();
				break;
			case 4: 
				break;
			case 5: 
				break;
			case 6: 
				break;
			case 0: menu = false;
					System.out.println("\nBye!");
				break;
			default:
					System.out.println("\nError, invalid option");
		}
		}
	}
	
	public void menu1() {
		boolean menu = true;
		while(menu) {
			System.out.println(
					"\n******************************************************" +
					"\ntype the desired option:" +
					"\n(1) Hire player"+
					"\n(2) Fire player"+
					"\n(3) "+ 
					"\n(4) "+ 
					"\n(0) Return" +
					"\n******************************************************\n"
					);
			int option = sc.nextInt();
			sc.nextLine();
			switch(option) {
				case 1:	hirePLayer();
						menu = false;
					break;
				case 2:	fireEmployee();
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
	
	public void menu2() {
		boolean menu = true;
		while(menu) {
			System.out.println(
					"\n******************************************************" +
					"\ntype the desired option:" +
					"\n(1) Hire coach"+
					"\n(2) Fire coach"+
					"\n(3) "+ 
					"\n(4) "+ 
					"\n(0) Return" +
					"\n******************************************************\n"
					);
			int option = sc.nextInt();
			sc.nextLine();
			switch(option) {
				case 1:	hireCoach();
						menu = false;
					break;
				case 2:	fireEmployee();
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
		String name, NIT, creationDate;
		System.out.println("\nType the name of the club:");
		name = sc.nextLine();
		System.out.println("\nType the NIT:");
		NIT = sc.nextLine();
		System.out.println("\nEnter the Club's founding date:");
		creationDate = sc.nextLine();
		mainClub = new Club(name, NIT, creationDate);
	}
	
	public void createTeam() {
		String name;
		System.out.println("\nType the name of the Team:");
		name = sc.nextLine();
		String message = mainClub.createTeam(name);
		System.out.println(message);
	}
	
	public void hirePLayer() {
		String name, id;
		double salary;
		System.out.println("\nType the name of the player:");
		name = sc.nextLine();
		System.out.println("\nType the id of the player:");
		id = sc.nextLine();
		System.out.println("\nType the player's salary:");
		salary = sc.nextDouble();
		sc.nextLine();
		String message = mainClub.hirePlayer(name, id, salary);
		System.out.println(message);
	}
	
	public void hireCoach() {
		String name, id;
		double salary;
		int experienceYears;
		System.out.println("\nType the name of the coach:");
		name = sc.nextLine();
		System.out.println("\nType the id of the coach:");
		id = sc.nextLine();
		System.out.println("\nType the coach's salary:");
		salary = sc.nextDouble();
		sc.nextLine();
		System.out.println("\nEnter the coach's years of experience:");
		experienceYears = sc.nextInt();
		sc.nextLine();
		String message = mainClub.hireCoach(name, id, salary, experienceYears);
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
	
	
	
	
}
