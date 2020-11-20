package ui;

import java.util.Scanner;
import model.Club;

public class Main {
	
	private Scanner sc;
	private Club mainClub;
	
	public Main(){
		sc = new Scanner(System.in);
		mainClub = new Club();
	}
	
	public static void main(String[] args) {
		Main objMain = new Main();
		objMain.menu();
	}
	
	public void menu(){
		boolean menu = true;
		int option;
		while(menu) {
			System.out.println("\n******************************************************" +
								"\nSeleccione una opción para empezar:\n" + 
								"\n(1) " + 
								"\n(2) " + 
								"\n(3) " + 
								"\n(4) " + 
								"\n(5) " + 
								"\n(6) " +
								"\n(0) Salir" +
								"\n******************************************************\n"
								);
		option = sc.nextInt();
		sc.nextLine();
		switch(option) {
			case 1: 
				break;
			case 2: 
				break;
			case 3: 
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
					System.out.println("\nError, opción no válida");
		}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
