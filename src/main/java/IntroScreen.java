import java.util.HashMap;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage; 
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.event.EventHandler;

public class IntroScreen extends Screen {
	
	GuideScreen guideSC;
	ImportGardenScreen importSC;
	GardenInitializationScreen gardeninitSC;
	settingsScreen settingsSC;
	
	View view; 
	Scene scene;
	Image introScreenImage;
	
	Button importSCbutton = new Button("Import Garden");
	Button guideButton = new Button("Guide");
	Button createGardenButton = new Button("Create Garden");
	Button settingsButton = new Button("Create Garden");
	
	PagesEnum screen = PagesEnum.IntroScreen;
	
	public IntroScreen() {
    	StackPane layout = new StackPane();
    	layout.getChildren().addAll(importSCbutton, guideButton, createGardenButton, settingsButton);	
    	Scene scene = new Scene(layout, 500, 800);
    	importSCbutton.setOnAction(e -> view.currentstage.setScene(importSC.getScene()));
    	guideButton.setOnAction(e -> view.currentstage.setScene(guideSC.getScene()));
    	createGardenButton.setOnAction(e -> view.currentstage.setScene(gardeninitSC.getScene()));
    	settingsButton.setOnAction(e -> view.currentstage.setScene(settingsSC.getScene()));
	}
	
	public PagesEnum getScreen() {
		// returns enum indicating what screen it is
		return screen;
	}

	
	public Scene getScene() {
		return scene;
	}

}
