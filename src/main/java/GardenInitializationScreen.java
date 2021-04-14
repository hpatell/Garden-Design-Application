import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.ComboBox;

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
		Label name = new Label("Garden Name: ");
		TextField tf = new TextField();
		HBox hb = new HBox();
		hb.getChildren().addAll(name, tf);
		hb.setSpacing(10);
	}
	
	public void budgetTF() {
		Label budget = new Label("Budget: ");
		TextField tf2 = new TextField();
		HBox hb2 = new HBox();
		hb2.getChildren().addAll(budget, tf2);
		hb2.setSpacing(10);
	}
	
	public void WeatherDropDown() {
		ComboBox weather = new ComboBox();
		weather.getItems().add("Choice 1");
		weather.getItems().add("Choice 2");
		weather.getItems().add("Choice 3");
	}
	
	public void soilDropDown() {
		ComboBox soil = new ComboBox();
		soil.getItems().add("Choice 1");
		soil.getItems().add("Choice 2");
		soil.getItems().add("Choice 3");
	}
	
	public void moistureDropDown() {
		ComboBox moisture = new ComboBox();
		moisture.getItems().add("Choice 1");
		moisture.getItems().add("Choice 2");
		moisture.getItems().add("Choice 3");
	}
	
}