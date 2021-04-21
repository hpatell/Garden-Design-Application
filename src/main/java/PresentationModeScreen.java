import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class PresentationModeScreen extends Screen {
	
	public PresentationModeScreen(View v) {
		super(v, PagesEnum.PresentationModeScreen);
    	layout = new StackPane();
    	layout.getChildren();	
    	scene = new Scene(layout, 500, 800);
	}
	
    public void ModifyPlotScreen() {

    }
}
