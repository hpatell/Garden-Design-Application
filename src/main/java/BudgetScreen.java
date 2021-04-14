import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class BudgetScreen extends Screen {

	double budgetSpent;
	double budgetRemaining;
	double plantPrice;
	double subTotal;
	int quantity;
	String[] plantName;
	
	public BudgetScreen(View v) {
		super(v);
    	StackPane layout = new StackPane();
    	layout.getChildren();	
    	scene = new Scene(layout, 500, 800);
	}
	
	public void budgetBar() {
		
	}
	
}
