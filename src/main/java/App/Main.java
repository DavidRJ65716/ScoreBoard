package App;
	
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		ScoreBoardStart start = new ScoreBoardStart(primaryStage);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}