import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class BudgetScreen extends Screen {
	
	ProgressBar budgetbar = new ProgressBar(.40);
	
	Text budgettext = new Text("Budget");
	
	Button back = new Button("Return to Plot");
	
	Text plantstext = new Text("Plants In Garden");
	Text lepstext = new Text("Cost of Plant");
	Text plantsimgtext = new Text("Image of Plants In Garden");
	
	Text FragariaStrawberry = new Text("Fragaria (Strawberry)");
	Text HelianthusSunflower = new Text("Helianthus (Sunflower)");
	Text SalixWillow = new Text("Salix (Willow)");
	
	Text FragariaStrawberrycost = new Text("$6");
	Text HelianthusSunflowercost = new Text("$6");
	Text SalixWillowcost = new Text("$6");
	
	public BudgetScreen(View v) {
		super(v);
		
    	budgetbar.setTranslateX(0);
    	budgetbar.setTranslateY(-250);
    	
    	budgetbar.setMaxHeight(40);
    	budgetbar.setMaxWidth(600);
    	
    	budgettext.setTranslateX(0);
    	budgettext.setTranslateY(-300);
		
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
    	
    	FragariaStrawberrycost.setTranslateX(75);
    	FragariaStrawberrycost.setTranslateY(-50);
    	
    	HelianthusSunflower.setTranslateX(-150);
    	HelianthusSunflower.setTranslateY(0);
    	
    	HelianthusSunflowercost.setTranslateX(75);
    	HelianthusSunflowercost.setTranslateY(0);
    	
    	SalixWillow.setTranslateX(-150);
    	SalixWillow.setTranslateY(50);
    	
    	SalixWillowcost.setTranslateX(75);
    	SalixWillowcost.setTranslateY(50);
		
		StackPane layout = new StackPane();
    	layout.getChildren();	
    	layout.getChildren().addAll(back, budgetbar, plantstext, 
    			lepstext, budgettext, FragariaStrawberry, FragariaStrawberrycost, HelianthusSunflower, HelianthusSunflowercost, SalixWillowcost, SalixWillow);
    	layout.setStyle("-fx-background-color: #3cb371;");
       	scene = new Scene(layout, canvasWidth, canvasHeight);
		back.setOnAction(e -> view.switchPage(PagesEnum.ModifyPlotScreen));
	}
	
	public void budgetBar() {
		
	}
	
}
