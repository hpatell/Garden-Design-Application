import java.util.Collection;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

public class ModifyPlotScreen extends Screen {
    Collection<Image> plantImages;
	Button test = new Button("Test");
	
    
    public ModifyPlotScreen(View v) {
		super(v);
    	StackPane layout = new StackPane();
    	layout.getChildren().addAll(test);	
    	scene = new Scene(layout, 500, 800);
    	test.setOnAction(e -> view.switchPage(PagesEnum.SummaryScreen));
    }

    public void settingsbutton() {

    }

    public void presentationModeButton() {

    }
    
    public void budgetButton() {

    }

    public void faunabutton() {

    }

    public void searchTF() {

    }

    public void plantNameText() {
        
    }
    
}
