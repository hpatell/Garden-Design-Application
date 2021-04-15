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
	
	String weathers[] = {"Sunny","Rainny","Cloudy"};
	String moistures[] = {"Dry","Medium","Moist"};
	String soils[] = {"Dirt", "Clay", "Rock"};
	
	String gardenname;
	double gardenbudget;

	Button createGardenButton = new Button("Finished");
	Button settingsButton = new Button("Settings");
	Label name = new Label("Garden Name: ");
	TextField nametf = new TextField();
	Label budget = new Label("Budget:               ");
	TextField budgettf = new TextField();
	ComboBox<String> weather = new ComboBox<String>();
	ComboBox<String> soil = new ComboBox<String>();
	ComboBox<String> moisture = new ComboBox<String>();

	public GardenInitializationScreen(View v) {
		super(v);
		
		weather.getItems().add(weathers[0]);
		weather.getItems().add(weathers[1]);
		weather.getItems().add(weathers[2]);
		soil.getItems().add(moistures[0]);
		soil.getItems().add(moistures[1]);
		soil.getItems().add(moistures[2]);
		moisture.getItems().add(soils[0]);
		moisture.getItems().add(soils[1]);
		moisture.getItems().add(soils[2]);
		
		name.setTranslateX(-150);
		name.setTranslateY(-250);
    	
		nametf.setTranslateX(0);
		nametf.setTranslateY(-250);
    	
		nametf.setMaxWidth(100);
		
		budget.setTranslateX(-150);
		budget.setTranslateY(-200);
    	
		budgettf.setTranslateX(0);
		budgettf.setTranslateY(-200);
		
		budgettf.setMaxWidth(100);
		
    	createGardenButton.setTranslateX(0);
    	createGardenButton.setTranslateY(150);
    	
    	settingsButton.setTranslateX(350);
    	settingsButton.setTranslateY(-375);
		
		soil.setTranslateX(0);
		soil.setTranslateY(-50);
		
		soil.setMinWidth(100);
		
		weather.setTranslateX(0);
		weather.setTranslateY(0);
		
		weather.setMinWidth(100);
		
		moisture.setTranslateX(0);
		moisture.setTranslateY(50);
		
		moisture.setMinWidth(0);
		
		StackPane layout = new StackPane();
    	layout.getChildren().addAll(name, nametf, budget, budgettf, createGardenButton, weather, soil, moisture, settingsButton);	
    	scene = new Scene(layout, canvasWidth, canvasHeight);
    	
    	createGardenButton.setOnAction(e -> view.switchPage(PagesEnum.ModifyPlotScreen));
    	settingsButton.setOnAction(e -> view.switchPage(PagesEnum.SettingsScreen));
    	//gardenname = name.getText();
    	///gardenbudget = Integer.parseInt(budget.getText());
	}

} 