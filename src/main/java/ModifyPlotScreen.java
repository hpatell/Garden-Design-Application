import java.util.Collection;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class ModifyPlotScreen extends Screen {
    Collection<Image> plantImages;
	Button summary = new Button("Test");
	
    
    public ModifyPlotScreen(View v) {
		super(v);
    	BorderPane layout = new BorderPane();
    	StackPane layout2 = new StackPane();
    	
    	Label label = new Label("modify");
    	layout.setCenter(layout2);
    	layout2.getChildren().addAll(summary, label);
    	
    	layout.setTop(label);
    	
    	scene = new Scene(layout, 500, 800);
    	summary.setOnAction(e -> view.switchPage(PagesEnum.SummaryScreen));
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
