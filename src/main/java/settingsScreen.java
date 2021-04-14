import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

public class settingsScreen extends Screen {
	
	public settingsScreen(View v) {
		super(v);
    	StackPane layout = new StackPane();
    	layout.getChildren().addAll();	
    	scene = new Scene(layout, 500, 800);
	}
	
    public void save() {
    	
    }
    
    public void adjBudgetTF(){
        
    }
    
    public void changeTheme(){

    }
    
    public void finish(){

    }
}