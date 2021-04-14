import java.util.HashMap;
import javax.swing.*;
import java.awt.*;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage; 
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.event.EventHandler;

public class IntroScreen extends Screen {
	
	Button importSCbutton = new Button("Import Garden");
	Button guideButton = new Button("Guide");
	Button createGardenButton = new Button("Create Garden");
	Button settingsButton = new Button("Settings");
	Image backgroundimg = new Image(getClass().getResourceAsStream("/download.png"));
	ImageView backgroundimgview = new ImageView(backgroundimg);
	
	public IntroScreen(View v) {
		super(v);
    	
    	importSCbutton.setTranslateX(0);
    	importSCbutton.setTranslateY(100);
    	
    	createGardenButton.setTranslateX(0);
    	createGardenButton.setTranslateY(50);
    	
    	guideButton.setTranslateX(0);
    	guideButton.setTranslateY(150);
    	
    	settingsButton.setTranslateX(350);
    	settingsButton.setTranslateY(-375);
    	
    	
    	StackPane layout = new StackPane();
    	layout.setMaxHeight(canvasHeight);
    	layout.setMaxWidth(canvasHeight);
    	layout.getChildren().addAll(backgroundimgview, guideButton, importSCbutton, createGardenButton, settingsButton);
    	scene = new Scene(layout, canvasWidth, canvasHeight);
    	
    	importSCbutton.setOnAction(e -> view.switchPage(PagesEnum.ImportScreen));
    	guideButton.setOnAction(e -> view.switchPage(PagesEnum.GuideScreen));
    	createGardenButton.setOnAction(e -> view.switchPage(PagesEnum.InitializationScreen));
    	settingsButton.setOnAction(e -> view.switchPage(PagesEnum.SettingsScreen));
	}
}