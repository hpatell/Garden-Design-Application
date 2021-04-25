import java.awt.Font;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.ProgressBar;


public class SummaryScreen extends Screen {
	
	ProgressBar budgetbar = new ProgressBar(.40);
	
	Button save = new Button("Save");
	
	Text budgettext = new Text("Budget");
	Text plantstext = new Text("Plants In Garden");
	Text lepstext = new Text("Leps In Garden");
	
	Text FragariaStrawberry = new Text("Fragaria (Strawberry)");
	Text HelianthusSunflower = new Text("Helianthus (Sunflower)");
	Text SalixWillow = new Text("Salix (Willow)");
	
	Text FragariaStrawberrylep = new Text("63");
	Text HelianthusSunflowerlep = new Text("57");
	Text SalixWillowlep = new Text("292");
	
	public SummaryScreen(View v) {
		super(v, PagesEnum.SummaryScreen);
		
    	layout = new StackPane();
    	
    	alignText();
    	createReturnToPlotButton();
		createSettingsButton();
    	
    	layout.getChildren().addAll(save, settingsButton, returnToPlotButton, budgetbar, budgettext, plantstext, 
    			lepstext, FragariaStrawberry, FragariaStrawberrylep, HelianthusSunflower, HelianthusSunflowerlep, SalixWillowlep, SalixWillow);
    	
    	layout.setStyle(theme);
    	scene = new Scene(layout, canvasWidth, canvasHeight);
	}
	
	public void alignText() {
    	budgetbar.setTranslateX(0);
    	budgetbar.setTranslateY(-250);
    	
    	budgetbar.setMaxHeight(40);
    	budgetbar.setMaxWidth(600);
    	
    	budgettext.setTranslateX(0);
    	budgettext.setTranslateY(-300);
    	
    	save.setTranslateX(150);
    	save.setTranslateY(200);
    	
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
	}
}