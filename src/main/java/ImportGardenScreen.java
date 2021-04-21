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
	
	
	Button exit = new Button("Exit");
	
	JFileChooser chooser;
	File file;
	
	public ImportGardenScreen(View v) {
		super(v, PagesEnum.ImportScreen);
    	layout = new StackPane();
    	layout.setStyle("-fx-background-color: #3cb371;");
    	layout.getChildren().addAll(exit);	
    	scene = new Scene(layout, canvasWidth, canvasHeight);
    	exit.setOnAction(e -> view.switchPage(PagesEnum.IntroScreen));
	}
	
	public void checkForm() {
		
	}
}
