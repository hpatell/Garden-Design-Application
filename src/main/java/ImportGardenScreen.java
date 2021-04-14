import java.io.File;
import javax.swing.JFileChooser;
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

public class ImportGardenScreen extends Screen {
	
	Scene scene;
	IntroScreen intro;
	
	Button modifyPlotButton = new Button("Import Screen Test");
	
	PagesEnum screen = PagesEnum.IntroScreen; 
	
	JFileChooser chooser;
	File file;
	
	public ImportGardenScreen() {
		StackPane layout = new StackPane();
		layout.getChildren().add(modifyPlotButton);
		Scene scene = new Scene(layout, 500, 800);
		modifyPlotButton.setOnAction(e -> view.currentstage.setScene(intro.getScene()));
	}
	
	public Scene getScene() {
		return scene;
	}
	
	public void checkForm() {
		
	}
}
