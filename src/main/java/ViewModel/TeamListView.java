package ViewModel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import Model.ScessionHolder;
import Model.ScoreBoardEnginee;

//Teaching: MVVM - View Model
public class TeamListView implements ScoreBoardObserver, Initializable{

	@FXML ListView<String> myListView;
	private ScoreBoardEnginee teamInfo;
	private ScessionHolder scessions;
	private boolean update;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1){
		
		this.update = false;
		this.teamInfo = new ScoreBoardEnginee();
		this.myListView.getItems().addAll(this.teamInfo.createTeamList());

		this.myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				
				try {//initialize() is not compatible with throws IOException
					OpenEditWindow(myListView.getSelectionModel().getSelectedIndex());
				} catch (IOException e) {
					e.printStackTrace();
				}				
			}
		});
	}
		
	private void OpenEditWindow(int index) throws IOException{
		
		if (!update) {
			
			FXMLLoader loader = new FXMLLoader(TeamListView.class.getResource("/App/Editor.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Team Editor");
			TeamDetailView editView = loader.getController();
			this.scessions.registerObserver(editView);
			editView.setTeamDetailView(index, this.teamInfo);
			stage.setOnCloseRequest(event -> {
				this.scessions.removeObserver(editView);
			});
			stage.show();
		}
		this.update = false;
	}
	
	@Override
	public void update() {
		
		this.update = true;
		String[] listReplacment = this.teamInfo.createTeamList();
		for(int i = 0; i < listReplacment.length; i++) {
			myListView.getItems().set(i, listReplacment[i]);;
		}
	}
	
	public void setObserverList(ScessionHolder newScessions) {
		this.scessions = newScessions;
		this.teamInfo.setScession(this.scessions);
	}
}
