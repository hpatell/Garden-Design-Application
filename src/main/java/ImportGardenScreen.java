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
	
	
	Button modifyPlotButton = new Button("Import Screen Test");
	
	JFileChooser chooser;
	File file;
	
	public ImportGardenScreen(View v) {
		super(v);
    	StackPane layout = new StackPane();
    	layout.getChildren().addAll(modifyPlotButton);	
    	scene = new Scene(layout, 500, 800);
    	modifyPlotButton.setOnAction(e -> view.switchPage(PagesEnum.ModifyPlotScreen));
	}
	
	
	public void checkForm() {
		
	}
}
