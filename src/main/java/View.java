import java.util.HashMap;
import java.util.Map.Entry;

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
	
	HashMap<String, String> plantPNG = new HashMap<>();
	
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
	
	HashMap<PagesEnum, Screen> nameToScreenMap = new HashMap<>();
	
	PagesEnum firstPage = PagesEnum.IntroScreen;
	PagesEnum previouspage = PagesEnum.IntroScreen;
	PagesEnum currentPage = PagesEnum.IntroScreen;
	
	/**
	* Constructor for View. Creates an instance of every screen used.
	* @author Kush Patel
	*/
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
    
	/**
	* Takes the enum value of the page being switched to set the scene to that page.
	* Sets the previous page to current page to allow settings to know what page to return to 
	* after exiting the screen
	*
	* @param PE the enum value of the page being switched to
	* @author Kush Patel
	*/   
    public void switchPage(PagesEnum PE) {
    	//nameToScreenMap.get(PE).updatePage();
    	currentstage.setScene(nameToScreenMap.get(PE).getScene());
    	previouspage = currentPage;
    	currentPage = PE;
    }
    
	/**
	* Searches the HashMap taken in as an argument to create a new HashMap plantPNG
	* that has the same key, common names of the plants, and assigns the key as the
	* path to the PNG of the plant in the resources folder. 
	*
	* @param plants a HashMap of all the plant images as values and their common names as the key
	* @author Kush Patel
	*/    
    public void setPlantPNG(HashMap<String, Plant> plants) {
//    	plantPNG.put("Fragaria", "/FragariaStrawberry.png");
//    	plantPNG.put("Helianthus", "/HelianthusSunflower.png");
//    	plantPNG.put("Salix", "/SalixWillow.png");
//    	
//    	plantPNG.put("a", "/FragariaStrawberry.png");
//    	plantPNG.put("b", "/FragariaStrawberry.png");
//    	plantPNG.put("c", "/HelianthusSunflower.png");
//    	plantPNG.put("d", "/HelianthusSunflower.png");
//    	plantPNG.put("e", "/SalixWillow.png");
//    	plantPNG.put("f", "/plant_images/Willow.png");
    	
    	for (Entry<String, Plant> mapElement : plants.entrySet()) 
    	{
            String key = mapElement.getKey();
            
            System.out.println("/plant_images/" + key + ".png");
            
            String png = "/plant_images/" + key + ".png";
            
            //plantPNG.put(key, "/plant_images/" + key + ".png");
            plantPNG.put(key, png);
    	}
    	System.out.println(plantPNG.size());
    }
    
	/**
	* Sets the current scene of the program and displays it
	*
	* @param stage the stage displaying the scenes in the program
	* @author Kush Patel
	*/
    @Override
    public void start(Stage stage) {
    	currentstage = stage;
    	
    	switchPage(firstPage);
    	
    	currentstage.setScene(intro.scene);
    	currentstage.setTitle("Garden Application");
    	currentstage.show();
    }

	/**
	* Launches the program
	*
	* @param args main method args
	* @author Kush Patel
	*/
    public static void main(String[] args) {
        launch(args);
    }

}