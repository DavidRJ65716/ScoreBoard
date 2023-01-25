package ViewModel;

//Teaching: MVVM - Model View
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import Model.ScoreBoardEnginee;

public class TeamDetailView implements ScoreBoardObserver{

	private int scoreBoardIndex;
	private ScoreBoardEnginee teamInfo;
	@FXML Button mySave;
	@FXML TextField myName;
	@FXML TextField myScore;
	@FXML TextField myDate;
	
	public void setTeamDetailView(int index, ScoreBoardEnginee newTeamInfo) throws IOException {
		this.scoreBoardIndex = index;
		this.teamInfo = newTeamInfo;
		showDetailView();
	}
	
	public void actionOnClickButton(ActionEvent event) { 
		
		this.teamInfo.updateTeamInfo(scoreBoardIndex, myName.getText(), Integer.parseInt(myScore.getText()));
	}
	
	private void showDetailView() {
		
		this.myName.setText(this.teamInfo.getTeamName(scoreBoardIndex));
		this.myScore.setText(this.teamInfo.getTeamScore(scoreBoardIndex));
		this.myDate.setText(this.teamInfo.getTimeStamp(scoreBoardIndex));
		this.myDate.setEditable(false);
	}

	@Override
	public void update() {
		
		showDetailView();
	}
}
