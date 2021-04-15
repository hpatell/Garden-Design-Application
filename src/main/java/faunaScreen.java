import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.scene.image.Image;

public class faunaScreen extends Screen {
	
	Button back = new Button("Return to Plot");
	
	Text plantstext = new Text("Plants In Garden");
	Text lepstext = new Text("Leps In Garden");
	Text plantsimgtext = new Text("Image of Plants In Garden");
	
	Text FragariaStrawberry = new Text("Fragaria (Strawberry)");
	Text HelianthusSunflower = new Text("Helianthus (Sunflower)");
	Text SalixWillow = new Text("Salix (Willow)");
	
	Text FragariaStrawberrylep = new Text("63");
	Text HelianthusSunflowerlep = new Text("57");
	Text SalixWillowlep = new Text("292");
	
	Image img1 = new Image("/FragariaStrawberry.png");
	Image img2 = new Image("/HelianthusSunflower.png");
	Image img3 = new Image("/SalixWillow.png");
	
	ImageView FragariaStrawberryimg = new ImageView(img1);
	ImageView HelianthusSunflowerimg = new ImageView(img2);
	ImageView SalixWillowimg = new ImageView(img3);
	
	public faunaScreen(View v) {
		super(v);
		
		FragariaStrawberryimg.setPreserveRatio(true);
		HelianthusSunflowerimg.setPreserveRatio(true);
		SalixWillowimg.setPreserveRatio(true);
		
		FragariaStrawberryimg.setFitHeight(50);
		FragariaStrawberryimg.setFitWidth(50);
		
		HelianthusSunflowerimg.setFitHeight(50);
		HelianthusSunflowerimg.setFitWidth(50);
		
		SalixWillowimg.setFitHeight(50);
		SalixWillowimg.setFitWidth(50);
		
		FragariaStrawberryimg.setTranslateX(-250);
		FragariaStrawberryimg.setTranslateY(-50);
		
		HelianthusSunflowerimg.setTranslateX(-250);
		HelianthusSunflowerimg.setTranslateY(0);
		
		SalixWillowimg.setTranslateX(-250);
		SalixWillowimg.setTranslateY(50);
		
    	back.setTranslateX(-50);
    	back.setTranslateY(200);
    	
    	plantsimgtext.setTranslateX(-200);
    	plantsimgtext.setTranslateY(-100);
    	
    	plantstext.setTranslateX(-150);
    	plantstext.setTranslateY(-100);
    	
    	lepstext.setTranslateX(75);
    	lepstext.setTranslateY(-100);
    	
    	FragariaStrawberry.setTranslateX(-150);
    	FragariaStrawberry.setTranslateY(-50);
    	
    	FragariaStrawberrylep.setTranslateX(75);
    	FragariaStrawberrylep.setTranslateY(-50);
    	
    	HelianthusSunflower.setTranslateX(-150);
    	HelianthusSunflower.setTranslateY(0);
    	
    	HelianthusSunflowerlep.setTranslateX(75);
    	HelianthusSunflowerlep.setTranslateY(0);
    	
    	SalixWillow.setTranslateX(-150);
    	SalixWillow.setTranslateY(50);
    	
    	SalixWillowlep.setTranslateX(75);
    	SalixWillowlep.setTranslateY(50);
		
		StackPane layout = new StackPane();	
		layout.getChildren().addAll(back, HelianthusSunflowerimg, SalixWillowimg, FragariaStrawberryimg, plantstext, 
    			lepstext, FragariaStrawberry, FragariaStrawberrylep, HelianthusSunflower, HelianthusSunflowerlep, SalixWillowlep, SalixWillow);
		scene = new Scene(layout, canvasWidth, canvasHeight);
		
		back.setOnAction(e -> view.switchPage(PagesEnum.ModifyPlotScreen));
	}
}