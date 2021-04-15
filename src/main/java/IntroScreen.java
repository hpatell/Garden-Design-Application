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
	
	Image backgroundIMG = new Image(getClass().getResourceAsStream("/introbackground.png"));
	ImageView backgroundIV = new ImageView(backgroundIMG);
	
	StackPane layout = new StackPane();
	
	public IntroScreen(View v) {
		super(v);
    	
		backgroundIV.setPreserveRatio(true);
		backgroundIV.setFitHeight(canvasHeight);
		backgroundIV.setFitWidth(canvasWidth);
		
		layout.getChildren().add(backgroundIV);
		
		startButton();
		guideButton();
		importButton();
		settingsButton();
		
    	layout.setMaxHeight(canvasHeight);
    	layout.setMaxWidth(canvasHeight);
    	
    	scene = new Scene(layout, canvasWidth, canvasHeight);
	}
	
	public void startButton()
	{
		 Button createGardenButton = new Button("Create Garden");
		 createGardenButton.setTranslateX(0);
	     createGardenButton.setTranslateY(50);
	     createGardenButton.setOnAction(e -> view.switchPage(PagesEnum.InitializationScreen));
	     layout.getChildren().add(createGardenButton);
	}
	
	public void guideButton()
	{
		Button guideButton = new Button("Create Garden");
		guideButton.setTranslateX(0);
	    guideButton.setTranslateY(150);
	    guideButton.setOnAction(e -> view.switchPage(PagesEnum.GuideScreen));
	    layout.getChildren().add(guideButton);
	}
	 
	public void importButton()
	{
		Button importbutton = new Button("Import Garden");
		importbutton.setTranslateX(0);
		importbutton.setTranslateY(100);
		importbutton.setOnAction(e -> view.switchPage(PagesEnum.ImportScreen));
		layout.getChildren().add(importbutton);
	}
	 
	public void settingsButton() 
	{
		Button settingsButton = new Button("Settings");
	    Image gear = new Image(getClass().getResourceAsStream("/gear.png"));
	    ImageView gearIV = new ImageView(gear);
	    gearIV.setPreserveRatio(true);
	    gearIV.setFitHeight(20);
	    gearIV.setFitWidth(20);
	    settingsButton.setGraphic(gearIV);
	    settingsButton.setTranslateX(450);
	    settingsButton.setTranslateY(-375);
	    settingsButton.setOnAction(e -> view.switchPage(PagesEnum.SettingsScreen));
	    layout.getChildren().add(settingsButton);
    }
	
}