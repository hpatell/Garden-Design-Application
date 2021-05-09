import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.ComboBox;

public class GardenInitializationScreen extends Screen {
	
	private Controller imc;
	
	Button createGardenButton;
	
	Label name;
	TextField nametf;
	Label budget;
	TextField budgettf;

	ComboBox<String> plotSize;
	ComboBox<String> weather;
	ComboBox<String> soil;
	ComboBox<String> moisture;
	
	String gardenbudgetlocal;
	
	VBox vbox;
	HBox hbox;
	BorderPane borderPane;
	StackPane hstackPane;	
	StackPane vstackPane;
	
	View view;
	
	/**
	 * Constructor for GardenInitializationScreen. Used to create the scene for create garden screen
	 * 
	 * @param v takes in the instance of View accessed in Screen
	 * @author Kush Patel
	 */
	public GardenInitializationScreen(View v) {
		super(v, PagesEnum.InitializationScreen);
		
		view = v;
		
		imc = new Controller(v);
		
		borderPane = new BorderPane();
    	hstackPane = new StackPane();	
    	vstackPane = new StackPane();
    	
    	borderPane.setTop(hstackPane);
    	borderPane.setCenter(vstackPane);
    	
    	vbox = new VBox(10);
    	hbox = new HBox();
    	
		createSettingsButton();
	
		createGardenButton = new Button("Create Garden");
		name = new Label("Garden Name: ");
		nametf = new TextField();
		budget = new Label("Budget: ");
		budgettf = new TextField();

		plotSize = new ComboBox<String>();
		weather = new ComboBox<String>();
		soil = new ComboBox<String>();
		moisture = new ComboBox<String>();
		vbox = new VBox(20);
		
		plotSize.setPromptText("Plot Size");
		weather.setPromptText("Weather Type");
		moisture.setPromptText("Moisture Type");
		soil.setPromptText("Soil Type");
		
		plotSize.getItems().addAll("5x5 ft", "10x10 ft", "20x20 ft");
		weather.getItems().addAll("Full Sun", "Half Sun", "Shade");
		soil.getItems().addAll("Sand", "Silt", "Clay");
		moisture.getItems().addAll("Dry", "Moist", "Wet");
		
		nametf.setMaxWidth(canvasHeight/2);
		budgettf.setMaxWidth(canvasHeight/2);
			
    	createGardenButton.setOnAction(e -> {
    		if((budgettf.getText() != "") && (weather.getValue() != null) && (soil.getValue() != null) && (moisture.getValue() != null) && (plotSize.getValue() != null)) {
    			view.switchPage(PagesEnum.ModifyPlotScreen);
    			gardenname = nametf.getText();
    	    	gardenbudget = budgettf.getText();
    	    	gardenWeatherCondition = weather.getValue();
    	    	gardenSoilCondition = soil.getValue();
    	    	gardenMoistureCondition = moisture.getValue();
    	    	gardenDimensions = plotSize.getValue();
    	    	gardenbudgetlocal = gardenbudget;
    			updatePage();
    		}
    	});
    	
		hbox.setAlignment(Pos.TOP_RIGHT);
		hbox.setPadding(new Insets(10, 10, 0, 0));
		hbox.getChildren().addAll(settingsButton);
		
		vbox.getChildren().addAll(name, nametf, budget, budgettf, plotSize, weather, soil, moisture, createGardenButton);
		vbox.setAlignment(Pos.CENTER);
		
		hstackPane.getChildren().addAll(hbox);
		vstackPane.getChildren().addAll(vbox);

		borderPane.setMaxHeight(canvasHeight);
		borderPane.setMaxWidth(canvasHeight);
		borderPane.setStyle(theme); 
		layout = borderPane;
    	scene = new Scene(layout, canvasWidth, canvasHeight);
	}
	
	/**
	 * Used to update the user input based variables in the garden, such as name, budget, and conditions in modify plot
	 * @author Kush Patel
	 */
	public void updatePage() {
		view.modify.gardenNameLabel.setText(gardenname);
		view.modify.gardenBudgetLabel.setText("Total Budget: $" + gardenbudgetlocal);
		view.modify.gardenWeatherConditionLabel.setText("Weather Condition: " + gardenWeatherCondition);
		view.modify.gardenSoilConditionLabel.setText("Soil Condition: " + gardenSoilCondition);
		view.modify.gardenMoistureConditionLabel.setText("Moisture Condition: " + gardenMoistureCondition);
		view.modify.gardenDimensionsLabel.setText("Dimensions: " + gardenDimensions);
		view.modify.createImages(view.plantPNG, gardenWeatherCondition, gardenSoilCondition, gardenMoistureCondition, imc.getplants());
		view.modify.woody.setOnAction(imc.getCheckboxHandler(view.modify.plantIVs));
		view.modify.herbaceous.setOnAction(imc.getCheckboxHandler(view.modify.plantIVs));
	}	
} 