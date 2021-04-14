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

public abstract class Screen {
	
	Image backgroundImage;
	View view;
	Scene scene;
	
	PagesEnum page = PagesEnum.IntroScreen;
	
	public Screen(View v) {
		view = v;
	}

	
	public PagesEnum getScreen() {
		return page;
	}

	
	public Scene getScene() {
		return scene;
	}
	
}
