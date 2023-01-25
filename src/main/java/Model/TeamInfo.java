package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

//Teaching: MVVM - Model
public class TeamInfo {

	private String Name;
	private int Score;
	private String timeStamp;
	
	public TeamInfo(String newTeamName, int newTeamScore, String newTimeStamp) {
		
		this.Name = newTeamName;
		this.Score = newTeamScore;
		this.timeStamp = newTimeStamp;
	}
	
	public void updateTeamName(String newName) {
		
		int nameMin = 5;
		int nameMax = 50;
		
		if(newName.length() >= nameMin && newName.length() <= nameMax 
				&& newName.matches("^[\\w\\d\\s]+$")) {
	
			this.Name = newName;			
		} else {
			this.Name = "No name provided";
		}
	}
		
	public void updateScore(int newScore) {
		
		int minScore = 0;
		int maxScore = 2000;
		
		if (newScore >= minScore && newScore <= maxScore) {
			this.Score = newScore;
		} else {
			this.Score = 0;
		}
	}
	
	public void updateTimeStamp() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.timeStamp = sdf.format(new Date());
	}
	
	public String getName() {
		return this.Name;
	}
	
	public String getScore() {
		return Integer.toString(this.Score);
	}
	
	public String getTimeStamp() {
		return this.timeStamp;
	}
	
	public String toString() {
		return this.Name + "\t\t\t\t" + this.Score;
	}
}
