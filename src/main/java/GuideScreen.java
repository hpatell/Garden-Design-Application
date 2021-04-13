import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GuideScreen extends Screen {
	
	Image introScreenImage;
	Button forwardButton = new Button();
	Button backButton = new Button();
	boolean forwardBoolean = false;
	boolean backBoolean = false;
	View view;
	Stage Introstage;
	PagesEnum screen = PagesEnum.IntroScreen;
	
	public void createScreen() {
    	StackPane layout = new StackPane();
    	layout.getChildren().add(forwardButton);	
    	Scene scene = new Scene(layout, 300, 500);
    	forwardButton.setOnAction(e -> {});
	}
	
	public void nextButton() {
		
	}
	
	public void backButton() {
		
	}
}
