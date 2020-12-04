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
	private int [][] lockerRoomA;
	private int [][] lockerRoomB;
	
	//Builder
	public Team(String name) {
		this.name = name;
		players = new Player[25];
		hCoach = new HeadCoach[1];
		aCoach = new AssistantCoach[3];
		lineups = new ArrayList<Alignment>();
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
}
