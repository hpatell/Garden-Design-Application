import java.util.HashMap;

public class Plant {
	
    String scientificName, commonName, plantType;
    int lepsSupported;
    int cost;
    double x, y;
    double imgHeight, imgWidth;
    HashMap<String, String[]> Conditions;
    

    Plant(String scientificName, String commonName, String plantType, int lepsSupported, int cost) {
        this.scientificName = scientificName; 
        this.commonName = commonName;
        this.plantType = plantType;
        this.lepsSupported = lepsSupported;
        this.cost = cost;
    }
    
}
