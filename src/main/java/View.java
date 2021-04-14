import java.util.HashMap;
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

public class View extends Application {
	
    Image plant;
    Image importedImage;
    //Collection screens;
    //Image Collection<> plantImages;
    int canvasHeight, canvasWidth;
    double imgWidth, imgHeight;
    double x, y, xloc, yloc;
    int lepsSupported;
	Stage currentstage;
    //HashMap<String> Conditions;
	Screen screen;

    public View() {

    }

    public Image createImage() {
        return plant;
    }

    public Image importImage() {
        return importedImage;
    }

    public void update(Image plant, double x, double y) {

    }

    public void draw() {

    }

    public void drag() {

    }


    @Override
    public void start(Stage stage) {
    	
    	currentstage = stage;
    	
    	
    	StackPane layout = new StackPane();
    	layout.getChildren();	
    	
    	Scene scene = new Scene(layout, 1000, 1000);
    	
    	currentstage.setScene(scene);
    	currentstage.setTitle("Garden Application");
    	currentstage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}