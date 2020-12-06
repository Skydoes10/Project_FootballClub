package model;

public class Alignment {
	
	//Relationships

	//Attributes
	private String date;
	private Tactics tactics;
	private int [][] formation;
	
	//Builder
	public Alignment(String date, Tactics tactics) {
		this.date = date;
		this.tactics = tactics;
		formation = new int[10][7];

	}//End Builder
	
	//Getters and Setters
	public String getDate(){
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public Tactics getTactics(){
		return tactics;
	}
	
	public void setTactics(Tactics tactics) {
		this.tactics = tactics;
	}//End Getters and Setters
	
	public String designFormation(int defenders, int midfielders, int forwards) {
		String message = "", newFormation = "";
	    for (int i = 0; i < formation.length; i++) {
	        for (int j = 0; j < formation[i].length; j++) {
	            formation[i][j] = 0;
	        }
	    }
	    for (int a = 0; a < formation.length; a++) {
		    for (int b = 0; b < formation[a].length; b++) {
		    	if(a == 1) {
		    		if (forwards == 1) {
		    			formation[a][3] = 1;
		    		}
		    		else if (forwards == 2) {
		    			formation[a][2] = 1;
		    			formation[a][4] = 1;
		    		}
		    		else if (forwards == 3) {
		    			for (int f = 2; f < 5; f++) {
		    				formation[a][f] = 1;
			    		}
		    		}
		    		else if (forwards == 4) {
		    			formation[a][1] = 1;
		    			formation[a][2] = 1;
		    			formation[a][4] = 1;
		    			formation[a][5] = 1;
		    		}
		    		else if (forwards == 5) {
		    			for (int f = 1; f < 6; f++) {
		    				formation[a][f] = 1;
			    		}
		    		}
		    		else if (forwards == 6) {
		    			for (int f = 0; f < 3; f++) {
		    				formation[a][f] = 1;
			    		}
		    			for (int z = 4; z < 7; z++) {
		    				formation[a][z] = 1;
			    		}
		    		}
		    		else if (forwards == 7) {
		    			for (int f = 0; f < 7; f++) {
		    				formation[a][f] = 1;
			    		}
		    		}
		    	}
		    	if(a == 4) {
		    		if (midfielders == 1) {
		    			formation[a][3] = 1;
		    		}
		    		else if (midfielders == 2) {
		    			formation[a][2] = 1;
		    			formation[a][4] = 1;
		    		}
		    		else if (midfielders == 3) {
		    			for (int f = 2; f < 5; f++) {
		    				formation[a][f] = 1;
			    		}
		    		}
		    		else if (midfielders == 4) {
		    			formation[a][1] = 1;
		    			formation[a][2] = 1;
		    			formation[a][4] = 1;
		    			formation[a][5] = 1;
		    		}
		    		else if (midfielders == 5) {
		    			for (int f = 1; f < 6; f++) {
		    				formation[a][f] = 1;
			    		}
		    		}
		    		else if (midfielders == 6) {
		    			for (int f = 0; f < 3; f++) {
		    				formation[a][f] = 1;
			    		}
		    			for (int z = 4; z < 7; z++) {
		    				formation[a][z] = 1;
			    		}
		    		}
		    		else if (midfielders == 7) {
		    			for (int f = 0; f < 7; f++) {
		    				formation[a][f] = 1;
			    		}
		    		}
		    	}
		    	if(a == 7) {
		    		if (defenders == 1) {
		    			formation[a][3] = 1;
		    		}
		    		else if (defenders == 2) {
		    			formation[a][2] = 1;
		    			formation[a][4] = 1;
		    		}
		    		else if (defenders == 3) {
		    			for (int f = 2; f < 5; f++) {
		    				formation[a][f] = 1;
			    		}
		    		}
		    		else if (defenders == 4) {
		    			formation[a][1] = 1;
		    			formation[a][2] = 1;
		    			formation[a][4] = 1;
		    			formation[a][5] = 1;
		    		}
		    		else if (defenders == 5) {
		    			for (int f = 1; f < 6; f++) {
		    				formation[a][f] = 1;
			    		}
		    		}
		    		else if (defenders == 6) {
		    			for (int f = 0; f < 3; f++) {
		    				formation[a][f] = 1;
			    		}
		    			for (int z = 4; z < 7; z++) {
		    				formation[a][z] = 1;
			    		}
		    		}
		    		else if (defenders == 7) {
		    			for (int f = 0; f < 7; f++) {
		    				formation[a][f] = 1;
			    		}
		    		}
		    	}
		    }
	    }
	    for (int s = 0; s < formation.length; s++) {
	        for (int d = 0; d < formation[s].length; d++) {
	            newFormation += formation[s][d];
	        }
	        newFormation += "\n";
	    }
	    message = "\nAlignment: "+defenders+"-"+midfielders+"-"+forwards+"\n"+newFormation;
		return message;
	}
	
}
