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

    public void changePage() {
    }

    @Override
    public void start(Stage stage) {
    	
    	currentstage = stage;
    	/*
    	Button button = new Button();
    	button.setText("Click me!");
    	Button button2 = new Button();
    	button.setText("next screen");
    	*/
    	StackPane layout = new StackPane();
    	layout.getChildren();	
    	//StackPane layout2 = new StackPane();
    	//layout2.getChildren().add(button2);
    	
    	//Scene scene2 = new Scene(layout2, 300, 500);
    	Scene scene = new Scene(layout, 1000, 1000);
    	
    	//button.setOnAction(e -> currentstage.setScene(scene2));
    	//button2.setOnAction(e -> currentstage.setScene(scene));
    
    	
    	currentstage.setScene(scene);
    	currentstage.setTitle("Garden Application");
    	currentstage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}