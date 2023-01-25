package Model;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

//Teaches: MVVM - Model
//Creates and Stores all information
public class ScoreBoardEnginee {
	
	private ArrayList<TeamInfo> teamList;
	private ScessionHolder scessions;
	
	public ScoreBoardEnginee() {
		this.teamList = new ArrayList<TeamInfo>();
		fillTeam();
	}
	
	public void fillTeam() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timestamp = sdf.format(new Date());

		TeamInfo newTeam = new TeamInfo("Highly Irresistable Lions", 45, timestamp);
		this.teamList.add(newTeam);
		TeamInfo newTeam1 = new TeamInfo("Immovable Tigers", 75, timestamp);
		this.teamList.add(newTeam1);
		TeamInfo newTeam2 = new TeamInfo("Super Duper Bears", 100, timestamp);
		this.teamList.add(newTeam2);
		TeamInfo newTeam3 = new TeamInfo("Incomparable Otters", 30, timestamp);
		this.teamList.add(newTeam3);
		TeamInfo newTeam4 = new TeamInfo("Resplendent Ocelots", 8, timestamp);
		this.teamList.add(newTeam4);
	}
	
	public String[] createTeamList() {
		String[] teamViewList = new String[5];
		int i = 0;
		
		for(TeamInfo team: teamList) {
			
			teamViewList[i] = team.toString();
			i += 1;
		}
		return teamViewList;
	}
		
	public void updateTeamInfo(int Index, String Team, int score) {
		teamList.get(Index).updateTeamName(Team);
		teamList.get(Index).updateScore(score);
		teamList.get(Index).updateTimeStamp();
		this.scessions.notifyObservers();
	}
		
	public String getTeamName(int Index) {
		return teamList.get(Index).getName();
	}
	
	public String getTeamScore(int Index) {
		return teamList.get(Index).getScore();
	}
	
	public String getTimeStamp(int Index) {
		return teamList.get(Index).getTimeStamp();
	}

	public void setScession(ScessionHolder newScessions) {
		this.scessions = newScessions;
	}
}
