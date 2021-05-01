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

public abstract class Screen {
	
	Pane layout;

    Image backgroundImage;
    View view;
    Scene scene;
    String theme; 
    
    double canvasWidth;
    double canvasHeight;
    
	String gardenname;
	String gardenbudget;
	String gardenDimensions;
	String gardenWeatherCondition;
	String gardenSoilCondition;
	String gardenMoistureCondition;
	
	Button settingsButton;
    Image gear;
    ImageView gearIV;
	Button createGardenButton;
	Button guideButton;
	Button importButton;
	Button returnToPlotButton;

    PagesEnum page;
    
	/**
	* Constructor for Screen. Assigns all attributes an appropriate value.
	* 
	* @param v allows screen to access methods and attributes in View
	* @param pe utilizes the enum to help in changing screens
	* @author Kush Patel
	*/
    public Screen(View v, PagesEnum pe) {
    	page = pe;
        view = v;
        canvasWidth = 1000;
        canvasHeight = 790;
        theme = "-fx-background-color: #87CEFA;";
        view.nameToScreenMap.put(pe, this);  
        settingsButton = new Button("Settings");
        gear = new Image(getClass().getResourceAsStream("/gear.png"));
        gearIV = new ImageView(gear);
        createGardenButton = new Button("Create Garden");
		guideButton = new Button("Guide");
		importButton = new Button("Import Garden");
		returnToPlotButton = new Button("Return to Plot");
    }
    
	/**
	* Abstract method used by every screen to update dynamic aspects of the screen
	*
	* @author Kush Patel
	*/
    
    public abstract void updatePage();
    
	/**
	* Sets the screen to switch to when createGardenButton is called
	* 
	* @author Kush Patel
	*/
	public void createGardenButton() {
	     createGardenButton.setOnAction(e -> view.switchPage(PagesEnum.InitializationScreen));
	}  
	 
	/**
	* Sets the screen to switch to when settingsButton is called and gives the button a background image
	* 
	* @author Kush Patel
	*/
	public void createSettingsButton() {
	    gearIV.setPreserveRatio(true);
	    gearIV.setFitHeight(20);
	    gearIV.setFitWidth(20);
	    settingsButton.setGraphic(gearIV);
	    settingsButton.setOnAction(e -> view.switchPage(PagesEnum.SettingsScreen));
    }
	
	/**
	* Sets the screen to switch to when GuideButton is called
	* 
	* @author Kush Patel
	*/
	public void createGuideButton() {
	    guideButton.setOnAction(e -> view.switchPage(PagesEnum.GuideScreen));
	}
	
	/**
	* Sets the screen to switch to when importButton is called
	* 
	* @author Kush Patel
	*/
	public void createImportButton() {
		importButton.setOnAction(e -> view.switchPage(PagesEnum.ImportScreen));
	}
	
	/**
	* Sets the screen to switch to when returnToPlotButton is called
	* 
	* @author Kush Patel
	*/
    public void createReturnToPlotButton() {
    	returnToPlotButton.setOnAction(e -> view.switchPage(PagesEnum.ModifyPlotScreen));
    }
    
	/**
	* Sets the theme of the program light mode or dark mode based on the string taken in
	* 
	* @param s takes in the string "dark" or "light" to set the theme of the program
	* @author Kush Patel
	*/   
    public void changeTheme(String s) {
    	if(s == "dark") {
    		theme = "-fx-background-color: #808080;";
    	} else if(s == "light") {
    		theme = "-fx-background-color: #87CEFA;";
    	}
    	layout.setStyle(theme);
    }
    
	/**
	* Setter used to set name of garden
	* 
	* @param s sets the name of the garden
	* @author Kush Patel
	*/   
    public void setGardenName(String s) {
    	gardenname = s;
    }
    
	/**
	* Getter used to get name of garden
	* 
	* @return returns the name of the garden
	* @author Kush Patel
	*/ 
    public String getGardenName() {
    	return gardenname;
    }
    
	/**
	* Setter used to set budget of garden as a string
	* 
	* @param s sets the budget of the garden as a string
	* @author Kush Patel
	*/ 
    public void setGardenBudget(String s) {
    	gardenbudget = s;
    }
    
	/**
	* Getter used to get the enum associated with the the current screen
	* 
	* @return returns the enum associated with the current screen of the garden 
	* @author Kush Patel
	*/ 
    public PagesEnum getScreen() {
        return page;
    }

	/**
	* Getter used to get the current scene
	* 
	* @return returns the current screen of the garden 
	* @author Kush Patel
	*/ 
    public Scene getScene() {
        return scene;
    }
    
	/**
	* Getter used to get budget of garden as a string
	* 
	* @return returns the budget of the garden as a string
	* @author Kush Patel
	*/ 
    public String getgardenbudget() {
    	return gardenbudget;
    }
}