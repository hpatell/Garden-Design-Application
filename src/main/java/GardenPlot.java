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
    static Collection<Plant> currentPlants;
    Plant[] plotGrid;

    public static void addPlant() {

    }
    public static void removePlant() {

    }
    public static Collection<Plant> getCurrentPlants() {
		return currentPlants;

    }
}
