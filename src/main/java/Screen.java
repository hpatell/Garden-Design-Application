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

    PagesEnum page;

    public Screen(View v, PagesEnum pe) {
    	page = pe;
        view = v;
        canvasWidth = 1000;
        canvasHeight = 790;
        theme = "-fx-background-color: #FFFFFF;";
        view.nameToScreenMap.put(pe, this);
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