import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.animation.AnimationTimer;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
//import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;

import java.util.ArrayList;

public class IntroScreen extends Application {
	final int canvasCount = 10;
    int picInd = 0;
    double xloc = 0;
    double yloc = 0;
    final double xIncr = 8;
    final double yIncr = 0;
    final static int canvasWidth = 500;
    final static int canvasHeight = 300;
    final static int imgWidth = 165;
    final static int imgHeight = 165;
    
    //Image introScreenImage;
	//stage.setTitle("Intro");
/*	
	public void startButton(){
		Button bs = new Button("Start"); //creates a button called Start
		
	}
	public void guideButton(){
		Button bg = new Button("Guide"); //creates a button called Guide
	}
	public void importButton(){
		Button bi = new Button("Import"); //creates a button called Import
	}
	public void settingsButton(){
		Button bset = new Button("Settings"); //creates a button called Settings
		//add gear image
	}
	
	public static void main(String[] args) {
        launch(args);
    }
}
*/

Image introScreenImage;


public static void main(String[] args) {
    launch(args);
    }


@Override
public void start(Stage theStage) {
	// set title for the stage
	theStage.setTitle("VBox");
	Button startButton  = new Button("Start"); //creates a Start Button
	Button guide = new Button ("Guide"); //create a Guide Button
	Button importButton = new Button("Import"); //create an import button
    // create a VBox
    VBox vbox = new VBox(10);

    // set alignment
    vbox.setAlignment(Pos.CENTER);
    
    vbox.getChildren().addAll(startButton, guide, importButton);
    
    // add buttons to VBox
    /*
    for (int i = 0; i < 5; i++)
    {
        vbox.getChildren().add(new Button("Button " + (int)(i + 1)));
    }
    */
    // create a scene
    Scene scene = new Scene(vbox, canvasWidth, canvasHeight);

    // set the scene
    theStage.setScene(scene);

    theStage.show();
}
}
