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
	Button settingsButton = new Button("Create Garden");
	Button modifySC = new Button("modify shortcut");

	
	public IntroScreen(View v) {
		super(v);
    	BorderPane layout = new BorderPane();
    	StackPane layout2 = new StackPane();
    	
    	Label label = new Label("intro");
    	layout.setCenter(layout2);
    	layout2.getChildren().addAll(guideButton, importSCbutton, createGardenButton, settingsButton, modifySC, label);
    	
    	layout.setTop(label);
    	
    	scene = new Scene(layout, 500, 800);
    	importSCbutton.setOnAction(e -> view.switchPage(PagesEnum.ImportScreen));
    	guideButton.setOnAction(e -> view.switchPage(PagesEnum.GuideScreen));
    	createGardenButton.setOnAction(e -> view.switchPage(PagesEnum.InitializationScreen));
    	settingsButton.setOnAction(e -> view.switchPage(PagesEnum.SettingsScreen));
    	modifySC.setOnAction(e -> view.switchPage(PagesEnum.ModifyPlotScreen));
	}
}
