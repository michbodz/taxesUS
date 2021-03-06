package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.File;
import java.net.URL;
import javafx.scene.image.Image;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
                    URL url = new File("src/main/java/application/view/Main.fxml").toURL();
                    Parent root = FXMLLoader.load(url);
                    Scene scene = new Scene(root, 600, 400);
                    primaryStage.setTitle("Sales taxes in the United States");
                    primaryStage.setMinHeight(400);
                    primaryStage.setMinWidth(400);
                    primaryStage.getIcons().add(new Image("file:src/main/java/application/view/logo.png"));
                    primaryStage.setScene(scene);
                    primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
