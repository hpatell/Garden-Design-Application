import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage; 
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.event.EventHandler;

public class Screen {

    Image backgroundImage;
    View view;
    Scene scene;
    double canvasWidth;
    double canvasHeight;
	String gardenname;
	double gardenbudget;

    PagesEnum page = PagesEnum.IntroScreen;

    public Screen(View v) {
        view = v;
        canvasWidth = 1000;
        canvasHeight = 790;
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