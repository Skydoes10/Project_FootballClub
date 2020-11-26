package model;

import java.util.ArrayList;

public class Team {

	//Relationships
	private ArrayList<Alignment> lineups;
	private Player[] players;
	
	//Attributes
	private String name;
	private int [][] lockerRoomA;
	private int [][] lockerRoomB;
	
	//Builder
	public Team(String name) {
		this.name = name;
		players = new Player[25];
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
}
