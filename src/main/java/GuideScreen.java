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
	
	Image backgroundimg;
	ImageView backgroundimgview;
	
	/**
	 * Constructor for GuideScreen. Used to create the scene for guide screen
	 * 
	 * @param v takes in the instance of View accessed in Screen
	 * @author Kush Patel
	 */
	public GuideScreen(View v) {
		super(v, PagesEnum.GuideScreen);
		
		backgroundimg = new Image(getClass().getResourceAsStream("/guideImg.png"));
		backgroundimgview = new ImageView(backgroundimg);
		
		backgroundimgview.setPreserveRatio(true);
		backgroundimgview.setFitHeight(800);
		backgroundimgview.setFitWidth(800);
		
		createSettingsButton();
		createGardenButton();
		createGuideButton();
		createImportButton();

		//importButton.setTranslateX(75);
		//importButton.setTranslateY(380);
    	
		createGardenButton.setTranslateX(0);
		createGardenButton.setTranslateY(360);
		
    	layout = new StackPane();
    	layout.setMaxHeight(canvasHeight);
    	layout.setMaxWidth(canvasWidth);
    	layout.getChildren().addAll(backgroundimgview, createGardenButton);
    	layout.setStyle(theme);
    	scene = new Scene(layout, canvasWidth, canvasHeight);   	
	}
}
