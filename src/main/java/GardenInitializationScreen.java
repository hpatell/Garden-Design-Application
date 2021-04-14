import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

public class GardenInitializationScreen extends Screen {
	
	View view; 
	Scene scene;
	Image introScreenImage;
	
	Button createGardenButton = new Button("Import Garden");
	
	public GardenInitializationScreen() {
    	StackPane layout = new StackPane();
    	layout.getChildren().add(createGardenButton);	
    	Scene scene = new Scene(layout, 500, 800);
    	createGardenButton.setOnAction(e -> view.currentstage.setScene(scene));
	}
	
	public Scene getScene() {
		return scene;
	}
	
	public void backButton() {
		
	}
	
	public void nextButton() {
		
	}
	
	public void submitButton() {
		
	}
	
	public void gardenNameTF() {
		
	}
	
	public void budgetTF() {
		
	}
	
	public void WeatherDropDown() {
		
	}
	
	public void soilDropDown() {
		
	}
	
	public void moistureDropDown() {
		
	}
	
}
