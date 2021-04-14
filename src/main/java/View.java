import java.util.HashMap;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage; 
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.event.EventHandler;

public class View extends Application {
	
    Image plant;
    Image importedImage;
    
    int canvasHeight, canvasWidth;
    double imgWidth, imgHeight;
    double x, y, xloc, yloc;
    int lepsSupported;
	Stage currentstage;
	int test = 0;
	
	IntroScreen intro;
	ImportGardenScreen importgarden;
	GuideScreen guide;
	GardenInitializationScreen gardeninit;
	ModifyPlotScreen modify;
	PresentationModeScreen present;
	faunaScreen fauna;
	SummaryScreen summary;
	BudgetScreen budget;
	settingsScreen settings;
	
	PagesEnum PE = PagesEnum.IntroScreen;
	
    public View() {
    	intro = new IntroScreen(this);
    	importgarden = new ImportGardenScreen(this);
    	guide = new GuideScreen(this);
    	gardeninit = new GardenInitializationScreen(this);
    	modify = new ModifyPlotScreen(this);
    	present = new PresentationModeScreen(this);
    	fauna = new faunaScreen(this);	
    	summary = new SummaryScreen(this);
    	budget = new BudgetScreen(this);
    	settings = new settingsScreen(this);
    }
    
    public void switchPage(PagesEnum PE) {
    	switch(PE) {
    	case IntroScreen:
    		currentstage.setScene(intro.getScene());
    		break;
    	case ImportScreen:
    		currentstage.setScene(importgarden.getScene());
    		break;
    	case GuideScreen:
    		currentstage.setScene(guide.getScene());
    		break;
    	case InitializationScreen:
    		currentstage.setScene(gardeninit.getScene());
    		break;
    	case ModifyPlotScreen:
    		currentstage.setScene(modify.getScene());
    		break;
    	case PresentationModeScreen:
    		currentstage.setScene(present.getScene());
    		break;
    	case FaunaScreen:
    		currentstage.setScene(fauna.getScene());
    		break;
    	case SummaryScreen:
    		currentstage.setScene(summary.getScene());
    		break;
    	case BudgetScreen:
    		currentstage.setScene(budget.getScene());
    		break;
    	case SettingsScreen:
    		currentstage.setScene(settings.getScene());
    		break;
    	default:
    		currentstage.setScene(intro.getScene());
    		break;
    	}
    }

    public Image createImage() {
        return plant;
    }

    public Image importImage() {
        return importedImage;
    }

    public void update(Image plant, double x, double y) {

    }

    public void draw() {

    }

    public void drag() {

    }


    @Override
    public void start(Stage stage) {
    	currentstage = stage;
    	
    	StackPane layout = new StackPane();
    	layout.getChildren();
    	Scene scene = new Scene(layout, 500, 800);
    	
    	if(test == 0) {
        	currentstage.setScene(intro.scene);
        	test++;
    	}
    	currentstage.setTitle("Garden Application");
    	currentstage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}