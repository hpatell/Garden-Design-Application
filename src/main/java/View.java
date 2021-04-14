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
    		System.out.println("intro");
    		break;
    	case ImportScreen:
    		currentstage.setScene(importgarden.getScene());
    		System.out.println("import");
    		break;
    	case GuideScreen:
    		currentstage.setScene(guide.getScene());
    		System.out.println("guide");
    		break;
    	case InitializationScreen:
    		currentstage.setScene(gardeninit.getScene());
    		System.out.println("init");
    		break;
    	case ModifyPlotScreen:
    		currentstage.setScene(modify.getScene());
    		System.out.println("modify");
    		break;
    	case PresentationModeScreen:
    		currentstage.setScene(present.getScene());
    		System.out.println("present");
    		break;
    	case FaunaScreen:
    		currentstage.setScene(fauna.getScene());
    		System.out.println("fauna");
    		break;
    	case SummaryScreen:
    		currentstage.setScene(summary.getScene());
    		System.out.println("summary");
    		break;
    	case BudgetScreen:
    		currentstage.setScene(budget.getScene());
    		System.out.println("budget");
    		break;
    	case SettingsScreen:
    		currentstage.setScene(settings.getScene());
    		System.out.println("settings");
    		break;
    	default:
    		currentstage.setScene(intro.getScene());
    		System.out.println("intro");
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
    	
    	switchPage(PE);
    	
    	StackPane layout = new StackPane();
    	layout.getChildren();	
    	
    	currentstage.setScene(intro.scene);
    	currentstage.setTitle("Garden Application");
    	currentstage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}