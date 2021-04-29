import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GardenPlot {
    int budget;
    String weatherCondition;
    Image PlotShape;
    String soilType;
    String moistureLevel;
    int totalnumberLeps;
    Plant[] plotGrid;
    
    HashMap<String, Plant> plantsInGarden = new HashMap<>();

    public void addPlant() 
    {
//    	Plant strawberry = new Plant("Fragaria", "Strawberry", "herbaceous", 63, 6, "Sunny", "Dry", "Decent");
//    	Plant sunflower = new Plant("Helianthus", "Sunflower", "herbaceous", 57, 6, "Rainy", "Medium", "Medium");
//    	Plant willow = new Plant("Salix", "Willow", "woody", 292, 20, "Cloudy", "Moist", "Good");
//    	
//    	plantsInGarden.put("Fragaria", strawberry);
//    	plantsInGarden.put("Helianthus", sunflower);
//    	plantsInGarden.put("Salix", willow);
    	
    	//plantsInGarden.put(, );
    	
    }
    
    public void removePlant() {

    }
    
    public HashMap<String, Plant> getPlantsInGarden() 
    {
		return plantsInGarden;
    }
    
}
