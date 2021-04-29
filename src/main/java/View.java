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
    
    public void switchPage(PagesEnum PE) 
    {
    	//nameToScreenMap.get(PE).updatePage();
    	currentstage.setScene(nameToScreenMap.get(PE).getScene());
    	previouspage = currentPage;
    	currentPage = PE;
    }
    
    public void setPlantPNG(HashMap<String, Plant> plants)
    {
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
    	
    	switchPage(firstPage);
    	
    	currentstage.setScene(intro.scene);
    	currentstage.setTitle("Garden Application");
    	currentstage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}