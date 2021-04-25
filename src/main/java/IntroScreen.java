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
	
	Image backgroundIMG;
	ImageView backgroundIV;
	
	
	public IntroScreen(View v) {
		super(v, PagesEnum.IntroScreen);
    	layout = new StackPane();
    	
    	backgroundIMG = new Image(getClass().getResourceAsStream("/introbackground.png"));
    	backgroundIV = new ImageView(backgroundIMG);
    	
		backgroundIV.setPreserveRatio(true);
		backgroundIV.setFitHeight(canvasHeight);
		backgroundIV.setFitWidth(canvasWidth);
		
		layout.getChildren().addAll(backgroundIV, settingsButton, createGardenButton, guideButton, importButton);
		
		createSettingsButton();
		createGardenButton();
		createGuideButton();
		createImportButton();
		
    	layout.setMaxHeight(canvasHeight);
    	layout.setMaxWidth(canvasHeight);
    	layout.setStyle(theme);
    	scene = new Scene(layout, canvasWidth, canvasHeight);
	}	
}