import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

public class GardenInitializationScreen extends Screen {
	
	Button createGardenButton = new Button("Import Garden");
	
	public GardenInitializationScreen(View v) {
		super(v);
    	StackPane layout = new StackPane();
    	layout.getChildren().add(createGardenButton);	
    	scene = new Scene(layout, 500, 800);
    	createGardenButton.setOnAction(e -> view.switchPage(PagesEnum.ModifyPlotScreen));
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
