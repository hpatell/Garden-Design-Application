import java.util.ArrayList;
import java.util.Collection;

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
    Collection<Plant> currentPlants = new ArrayList<Plant>();
    //HashMap<String, Plant> currentPlants = new HashMap<>();

    public void addPlant() 
    {
    	Plant strawberry = new Plant("Fragaria", "Strawberry", "herbaceous", 63, 6);
    	Plant sunflower = new Plant("Helianthus", "Sunflower", "herbaceous", 57, 6);
    	Plant willow = new Plant("Salix", "Willow", "woody", 292, 20);
    	
    	currentPlants.add(strawberry);
    	currentPlants.add(sunflower);
    	currentPlants.add(willow);
    }
    
    public void removePlant() {

    }
    
    public Collection<Plant> getCurrentPlants() 
    {
		return currentPlants;
    }
    
}
