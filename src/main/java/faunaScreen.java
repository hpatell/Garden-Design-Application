import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.image.Image;

public class faunaScreen extends Screen {
		
	
	
	Label faunaname = new Label("Fauna");
	Label lepname = new Label("Leps");
	Label search = new Label("Search");

	Label leps1 = new Label("Fauna");
	Label leps2 = new Label("Leps");
	Label lep3 = new Label("Search");
	
	Image img1 = new Image("/FragariaStrawberry.png");
	Image img2 = new Image("/HelianthusSunflower.png");
	Image img3 = new Image("/SalixWillow.png");
	
	ImageView img11 = new ImageView(img1);
	ImageView img21 = new ImageView(img2);
	ImageView img31 = new ImageView(img3);
	
	public faunaScreen(View v) {
		super(v);
    	
				 
		 faunaname.setTranslateX(0);
		 faunaname.setTranslateY(-300);
		 
		 lepname.setTranslateX(200);
		 lepname.setTranslateY(-250);
		 
		 search.setTranslateX(-200);
		 search.setTranslateY(-250);
		 
		 	 
		 img11.setX(170);
		 img11.setY(10);
		 img11.setFitWidth(100);
		 img11.setPreserveRatio(true);
		 
		 img21.setX(200);
		 img21.setY(200);
		 img21.setFitWidth(100);
		 img21.setPreserveRatio(true);
		 
		 img31.setX(300);
		 img31.setY(-100);
		 img31.setFitWidth(100);
		 img31.setPreserveRatio(true);
		
		StackPane layout = new StackPane();
    	layout.getChildren().addAll(faunaname, lepname, img11, search, img21, img31);	
    	scene = new Scene(layout, canvasWidth, canvasHeight);
	}
}