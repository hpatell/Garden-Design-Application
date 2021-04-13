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

public class Screen {
	
	Button forwardButton;
	Button backwardButton;
	View view;
	PagesEnum currentscreen = PagesEnum.IntroScreen;
	IntroScreen intro;
	
	public Screen() {
		
	}
	
	public void SwitchScreen() {
		view.currentstage.setScene(intro.introscene);
	}
	
	public void performAction() {
		
	}
	
	
}
