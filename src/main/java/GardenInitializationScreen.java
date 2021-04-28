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

	public void updatePage(){}
	
	Button createGardenButton;
	
	Label name;
	TextField nametf;
	Label budget;
	TextField budgettf;
	ComboBox<String> weather;
	ComboBox<String> soil;
	ComboBox<String> moisture;
	
	VBox vbox;
	HBox hbox;
	BorderPane borderPane;
	StackPane hstackPane;	
	StackPane vstackPane;
	
	ModifyPlotScreen MPS;
	View view;
	
	public GardenInitializationScreen(View v) {
		super(v, PagesEnum.InitializationScreen);
		
		MPS = new ModifyPlotScreen(v);
		view = v;
		
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
		budget = new Label("Budget:               ");
		budgettf = new TextField();
		weather = new ComboBox<String>();
		soil = new ComboBox<String>();
		moisture = new ComboBox<String>();
		vbox = new VBox(20);
		
		weather.setPromptText("Weather Type");
		moisture.setPromptText("Moisture Type");
		soil.setPromptText("Soil Type");
		
		weather.getItems().addAll("Sunny", "Rainy", "Cloudy");
		soil.getItems().addAll("Dry", "Medium", "Moist");		
		moisture.getItems().addAll("Decent", "Medium", "Good");
		
		nametf.setMaxWidth(canvasHeight/2);
		budgettf.setMaxWidth(canvasHeight/2);
			
    	createGardenButton.setOnAction(e -> {
    		if((budgettf.getText() != "") && (weather.getValue() != null) && (soil.getValue() != null) && (moisture.getValue() != null)) {
    			view.switchPage(PagesEnum.ModifyPlotScreen);
    			gardenname = nametf.getText();
    			
    			view.modify.label.setText(gardenname);
    			//System.out.print(gardenname);
    		}
    	});
    	
    	
		hbox.setAlignment(Pos.TOP_RIGHT);
		hbox.setPadding(new Insets(10, 10, 0, 0));
		hbox.getChildren().addAll(settingsButton);
		
		vbox.getChildren().addAll(name, nametf, budget, budgettf, weather, soil, moisture, createGardenButton);
		vbox.setAlignment(Pos.CENTER);
		
		hstackPane.getChildren().addAll(hbox);
		vstackPane.getChildren().addAll(vbox);
    	
    	//gardenbudget = Integer.parseInt(budget.getText());

		borderPane.setMaxHeight(canvasHeight);
		borderPane.setMaxWidth(canvasHeight);
		borderPane.setStyle(theme); 
		layout = borderPane;
    	scene = new Scene(layout, canvasWidth, canvasHeight);
	}
	
} 