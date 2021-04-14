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

public class IntroScreen extends Screen {
	
	Button importSCbutton = new Button("Import Garden");
	Button guideButton = new Button("Guide");
	Button createGardenButton = new Button("Create Garden");
	Button settingsButton = new Button("Create Garden");
	
	public IntroScreen(View v) {
		super(v);
    	StackPane layout = new StackPane();
    	layout.getChildren().addAll(importSCbutton, guideButton, createGardenButton, settingsButton);	
    	scene = new Scene(layout, 500, 800);
    	importSCbutton.setOnAction(e -> view.switchPage(PagesEnum.ImportScreen));
    	guideButton.setOnAction(e -> view.switchPage(PagesEnum.GuideScreen));
    	createGardenButton.setOnAction(e -> view.switchPage(PagesEnum.InitializationScreen));
    	settingsButton.setOnAction(e -> view.switchPage(PagesEnum.SettingsScreen));
	}
}
