package model;

import java.util.ArrayList;

public class Team {

	//Relationships
	private ArrayList<Alignment> lineups;
	private Player[] players;
	private HeadCoach[] hCoach;
	private AssistantCoach[] aCoach;
	
	//Attributes
	private String name;
	private String [][] lockerRoomA;
	private String [][] lockerRoomB;
	
	//Builder
	public Team(String name) {
		this.name = name;
		players = new Player[25];
		hCoach = new HeadCoach[1];
		aCoach = new AssistantCoach[3];
		lineups = new ArrayList<Alignment>();
		lockerRoomA = new String[7][6];
		lockerRoomB = new String[7][7];
	}//End Builder
	
	//Getters and Setters
	public String getName(){
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}//End Getters and Setters
	
	public String addPlayer(Player player) {
		String message = "The player "+player.getName()+" has been successfully added to the team "+getName();
		boolean added = false;
		Player foundP = findPlayer(player.getId());
		if(foundP == null){
			for(int i=0; i<players.length && !added; i++){
				if(players[i] == null){
					player.setStatus("Active");
					players[i] = player;
					added = true;
				}
			}
			if (added == false){
				message = "Limit of players reached";
			}
		}
		else{
			message = "The player "+player.getName()+" is already part of the team"+getName();
		}
		return message;
	}
	
	public Player findPlayer(String id) {
		Player foundP = null;
		boolean found = false;
		for(int i=0; i<players.length && !found; i++){
			if(players[i] != null && players[i].getId().equalsIgnoreCase(id)){
				foundP = players[i];
				found = true;
			}
		}
		return foundP;
	}

	public String addHCoach(HeadCoach coach) {
		String message = "The head coach "+coach.getName()+" has been successfully added to the team "+getName();
		boolean added = false;
		HeadCoach foundC = findHCoach(coach.getId());
		if(foundC == null){
			for(int i=0; i<hCoach.length && !added; i++){
				if(hCoach[i] == null){
					coach.setStatus("Active");
					hCoach[i] = coach;
					added = true;
				}
			}
			if (added == false){
				message = "Limit of head coach reached";
			}
		}
		else{
			message = "The head coach "+coach.getName()+" is already part of the team"+getName();
		}
		return message;
	}
	
	public HeadCoach findHCoach(String id) {
		HeadCoach foundC = null;
		boolean found = false;
		for(int i=0; i<hCoach.length && !found; i++){
			if(hCoach[i] != null && hCoach[i].getId().equalsIgnoreCase(id)){
				foundC = hCoach[i];
				found = true;
			}
		}
		return foundC;
	}
	
	public String addACoach(AssistantCoach coach) {
		String message = "The assistant coach "+coach.getName()+" has been successfully added to the team "+getName();
		boolean added = false;
		AssistantCoach foundC = findACoach(coach.getId());
		if(foundC == null){
			for(int i=0; i<aCoach.length && !added; i++){
				if(aCoach[i] == null){
					coach.setStatus("Active");
					aCoach[i] = coach;
					added = true;
				}
			}
			if (added == false){
				message = "Limit of assistant coach reached";
			}
		}
		else{
			message = "The assistant coach "+coach.getName()+" is already part of the team"+getName();
		}
		return message;
	}
	
	public AssistantCoach findACoach(String id) {
		AssistantCoach foundC = null;
		boolean found = false;
		for(int i=0; i<aCoach.length && !found; i++){
			if(aCoach[i] != null && aCoach[i].getId().equalsIgnoreCase(id)){
				foundC = aCoach[i];
				found = true;
			}
		}
		return foundC;
	}
	
	public void fireEmployeeOfTeam(Employee employee) {
		if (employee instanceof Player) {
			Player found = findPlayer(employee.getId());
			if(found != null) {
				for(int i = 1; i < players.length; i++) {
					if(players[i] != null && players[i].getId().equalsIgnoreCase(found.getId())) {
						players[i] = null;
					}
				}
			}
		}
		else if (employee instanceof HeadCoach) {
			HeadCoach found = findHCoach(employee.getId());
			if(found != null) {
				hCoach[0] = null;
			}
		}
		else if (employee instanceof AssistantCoach) {
			AssistantCoach found = findACoach(employee.getId());
			if(found != null) {
				for(int i = 1; i < aCoach.length; i++) {
					if(aCoach[i] != null && aCoach[i].getId().equalsIgnoreCase(found.getId())) {
						aCoach[i] = null;
					}
				}
			}
		}
	}
	
	public String createLineup(String date, int tactic, int defenders, int midfielders, int forwards) {
		String message = "";
		Tactics tactics = null;
		switch(tactic){
	    case 1: tactics = Tactics.POSSESSION;
	        break;
	    case 2: tactics = Tactics.COUNTERATTACK;
	        break;
	    case 3: tactics = Tactics.HIGH_PRESSURE;
	    	break;
	    case 4: tactics = Tactics.DEFAULT;
	    	break;
	    default: message = "\nInvalid tactic option";
		}
		if(tactic > 0 && tactic < 5) {
			Alignment alignment = new Alignment(date, tactics);
			message = alignment.designFormation(defenders, midfielders, forwards);
			lineups.add(alignment);
		}
		return message;
	}
	
	public String assignLockerA() {
		String message = "", locker = "";
		for (int i = 0; i < lockerRoomA.length; i++) {
			for (int j = 0; j < lockerRoomA[i].length; j++) {
				lockerRoomA[i][j] = "[---]";
			}
		}
		
		
		
		for (int i = 0; i < lockerRoomA.length; i++) {
			for (int j = 0; j < lockerRoomA[i].length; j++) {
				for(int n = 0; n < players.length; n++) {
					if(players[n] != null) {
						lockerRoomA[i][j] = "["+players[n].getName()+"]";
					}
				}
			}
		}
		
		
		
		for (int i = 0; i < lockerRoomA.length; i++) {
	        for (int j = 0; j < lockerRoomA[i].length; j++) {
	            locker += lockerRoomA[i][j];
	        }
	        locker += "\n";
	    }
	    message = "\nLocker room A: \n"+locker;
		return message;
	}
	
	public String assignLockerB() {
		String message = "", locker = "";
		for (int i = 0; i < lockerRoomB.length; i++) {
			for (int j = 0; j < lockerRoomB[i].length; j++) {
				lockerRoomB[i][j] = "[---]";
			}
		}
		
		
		
		for (int i = 0; i < lockerRoomB.length; i++) {
			for (int j = 0; j < lockerRoomB[i].length; j++) {
				for(int n = 0; n < players.length; n++) {
					if(players[n] != null) {
						lockerRoomB[i][j] = "["+players[n].getName()+"]";
					}
				}
			}
		}
		
		
		
		for (int i = 0; i < lockerRoomB.length; i++) {
	        for (int j = 0; j < lockerRoomB[i].length; j++) {
	            locker += lockerRoomB[i][j];
	        }
	        locker += "\n";
	    }
	    message = "\nLocker room B: \n"+locker;
		return message;
	}
	
	public String toString() {
		String out = "\n*************** Team "+getName()+" **************\n ** Head Coach: "+hCoach[0].getName()+"\n ** Assistant Coaches: "+aCoaches()+"\n ** Players: "+players()+"\n*******************************************";
		return out;
	}
	
	public String aCoaches() {
		String send = "";
		if(aCoach[0] != null) {
			send = aCoach[0].getName();
			for(int i = 1; i < aCoach.length; i++) {
				if(aCoach[i] != null) {
					send = send+", "+aCoach[i].getName();
				}
			}
		}
		return send;
	}
	
	public String players() {
		String send = "";
		if(players[0] != null) {
			send = players[0].getName();
			for(int i = 1; i < players.length; i++) {
				if(players[i] != null) {
					send = send+", "+players[i].getName();
				}
			}
		}
		return send;
	}
}
