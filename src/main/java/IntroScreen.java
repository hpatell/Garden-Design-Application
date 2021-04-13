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
	
	Scene introscene;
	
	Image introScreenImage;
	Button forwardButton = new Button("Click Me!");
	Button backButton = new Button();
	boolean forwardBoolean = false;
	boolean backBoolean = false;
	View view;
	Stage Introstage;
	PagesEnum screen = PagesEnum.IntroScreen;
	
	
	
	public IntroScreen() {
    	StackPane layout = new StackPane();
    	layout.getChildren().add(forwardButton);	
    	Scene scene = new Scene(layout, 300, 500);
    	//use enum to fetch the new scene
    	//the button gets the scene from another screen and tells it change to this
    	forwardButton.setOnAction(e -> view.currentstage.setScene(scene));
    	introscene = scene;
	}
	
	public PagesEnum newScreen() {
		// returns enum indicating what screen it is
		return screen;
	}
	
	public void startButton() {
		
	}
	
	public void guideButton() {
		
	}
	
	public void importButton() {
		
	}
	
	public void settingsButton() {
		
	}
	
	public Scene getScene() {
		
		return introscene;
	}

}
