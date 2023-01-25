package App;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Model.ScessionHolder;
import ViewModel.TeamListView;


public class ScoreBoardStart {

	//Teaching: Facade
	//Starts the process with out cluttering up main
	public ScoreBoardStart(Stage stage) throws IOException {
		
		ScessionHolder scessions = new ScessionHolder(); 
		FXMLLoader loader = new FXMLLoader(ScoreBoardStart.class.getResource("Scoreboard.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Team Scoreboard");
		TeamListView listView = loader.getController();
		scessions.registerObserver(listView);
		listView.setObserverList(scessions);
		stage.show();
	}
}
