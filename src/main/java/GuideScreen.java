import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GuideScreen extends Screen {
	
	GardenInitializationScreen gardeninitSC;
	
	View view; 
	Scene scene;
	Image introScreenImage;
	
	Button importSCbutton = new Button("Import Garden");
	Button createGardenButton = new Button("Create Garden");
	
	PagesEnum screen = PagesEnum.IntroScreen; 
	
	public GuideScreen(View v) {
		super(v);
    	StackPane layout = new StackPane();
    	layout.getChildren().addAll(importSCbutton, createGardenButton);	
    	scene = new Scene(layout, 500, 800);
    	createGardenButton.setOnAction(e -> view.switchPage(PagesEnum.InitializationScreen));
    	importSCbutton.setOnAction(e -> view.switchPage(PagesEnum.ImportScreen));
	}
	
	public Scene getScene() {
		return scene;
	}
	
	public void nextButton() {
		
	}
	
	public void backButton() {
		
	}
}
//test2
