import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage; 
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.event.EventHandler;

public class Screen {
	
	Pane layout;

    Image backgroundImage;
    View view;
    Scene scene;
    String theme; 
    
    double canvasWidth;
    double canvasHeight;
    
	String gardenname;
	double gardenbudget;
	
	Button settingsButton;
    Image gear;
    ImageView gearIV;
	Button createGardenButton;
	Button guideButton;
	Button importButton;
	Button returnToPlotButton;

    PagesEnum page;

    public Screen(View v, PagesEnum pe) {
    	page = pe;
        view = v;
        canvasWidth = 1000;
        canvasHeight = 790;
        theme = "-fx-background-color: #FFFFFF;";
        view.nameToScreenMap.put(pe, this);  
        settingsButton = new Button("Settings");
        gear = new Image(getClass().getResourceAsStream("/gear.png"));
        gearIV = new ImageView(gear);
        createGardenButton = new Button("Create Garden");
		guideButton = new Button("Guide");
		importButton = new Button("Import Garden");
		returnToPlotButton = new Button("Return to Plot");
    }
    
	public void createGardenButton() {
	     createGardenButton.setOnAction(e -> view.switchPage(PagesEnum.InitializationScreen));
	}  
	 
	public void createSettingsButton() {
	    gearIV.setPreserveRatio(true);
	    gearIV.setFitHeight(20);
	    gearIV.setFitWidth(20);
	    settingsButton.setGraphic(gearIV);
	    settingsButton.setOnAction(e -> view.switchPage(PagesEnum.SettingsScreen));
   }
	
	public void createGuideButton() {
	    guideButton.setOnAction(e -> view.switchPage(PagesEnum.GuideScreen));
	}
	
	public void createImportButton() {
		importButton.setOnAction(e -> view.switchPage(PagesEnum.ImportScreen));
	}
	
    public void createReturnToPlotButton() {
    	returnToPlotButton.setOnAction(e -> view.switchPage(PagesEnum.ModifyPlotScreen));
    }
    
    public void changeTheme(String s) {
    	if(s == "dark") {
    		theme = "-fx-background-color: #000000;";
    	} else if(s == "light") {
    		theme = "-fx-background-color: #FFFFFF;";
    	}
    	layout.setStyle(theme);
    }
    
    public void setGardenName(String s) {
    	gardenname = s;
    }

    public String getGardenName() {
    	return gardenname;
    }
    
    public PagesEnum getScreen() {
        return page;
    }

    public Scene getScene() {
        return scene;
    }
    
    public String getgardenname() {
    	return gardenname;
    }
    
    public double getgardenbudget() {
    	return gardenbudget;
    }
}