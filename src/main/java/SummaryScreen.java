import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.control.ProgressBar;


public class SummaryScreen extends Screen {
	
	ProgressBar budgetbar = new ProgressBar(.40);
	
	Button back = new Button("Return to Plot");
	Button save = new Button("Save");
	
	public SummaryScreen(View v) {
		super(v);
		
    	StackPane layout = new StackPane();
    	
    	budgetbar.setTranslateX(0);
    	budgetbar.setTranslateY(-250);
    	
    	budgetbar.setMaxHeight(40);
    	budgetbar.setMaxWidth(600);
    	
    	save.setTranslateX(50);
    	save.setTranslateY(200);
    	
    	back.setTranslateX(-50);
    	back.setTranslateY(200);
    	
    	layout.getChildren().addAll(back, save, budgetbar);
    	
    	scene = new Scene(layout, canvasWidth, canvasHeight);
	}

	public void budgetBar() {
		
	}
	
	public void exitButton() {
		
	}
	
	public void saveFileButton() {
		
	}
}
