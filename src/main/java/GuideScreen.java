import java.awt.TextArea;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.*;
import javafx.scene.text.Text;

public class GuideScreen extends Screen {
	
	public void updatePage(){}
	
	Image backgroundimg = new Image(getClass().getResourceAsStream("/NewHowTo.png"));
	ImageView backgroundimgview = new ImageView(backgroundimg);
	
	PagesEnum screen = PagesEnum.IntroScreen;
	
	public GuideScreen(View v) {
		super(v, PagesEnum.GuideScreen);
		
		backgroundimgview.setPreserveRatio(true);
		backgroundimgview.setFitHeight(1200);
		backgroundimgview.setFitWidth(1000);
		
		createSettingsButton();
		createGardenButton();
		createGuideButton();
		createImportButton();

		importButton.setTranslateX(75);
		importButton.setTranslateY(380);
    	
		createGardenButton.setTranslateX(-75);
		createGardenButton.setTranslateY(380);
		
    	layout = new StackPane();
    	layout.setMaxHeight(canvasHeight);
    	layout.setMaxWidth(canvasHeight);
    	layout.getChildren().addAll(backgroundimgview, createGardenButton, importButton);	
    	scene = new Scene(layout, canvasWidth, canvasHeight);
    	
	}
}
