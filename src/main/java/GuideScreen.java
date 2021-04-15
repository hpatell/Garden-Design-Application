import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GuideScreen extends Screen {
	
	GardenInitializationScreen gardeninitSC;
	
	View view; 
	Scene scene;
	Image introScreenImage;
	
	Button importSCbutton = new Button("Import Garden");
	Button createGardenButton = new Button("Create Garden");
	
	Image backgroundimg = new Image(getClass().getResourceAsStream("/HowToImage.png"));
	ImageView backgroundimgview = new ImageView(backgroundimg);
	
	PagesEnum screen = PagesEnum.IntroScreen; 
	
	public GuideScreen(View v) {
		super(v);
		
		backgroundimgview.setPreserveRatio(true);
		backgroundimgview.setFitHeight(1200);
		backgroundimgview.setFitWidth(1000);
		
    	StackPane layout = new StackPane();
    	layout.getChildren().addAll(backgroundimgview, importSCbutton, createGardenButton);	
    	scene = new Scene(layout, canvasWidth, canvasHeight);
    	createGardenButton.setOnAction(e -> view.switchPage(PagesEnum.InitializationScreen));
    	importSCbutton.setOnAction(e -> view.switchPage(PagesEnum.ImportScreen));
	}
	
	public Scene getScene() {
		return scene;
	}
	
	public void nextButton() {
		
	}
	
	public void backButton() {
		
	}
}
//test2
