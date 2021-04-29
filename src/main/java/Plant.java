import java.util.HashMap;

public class Plant {
	
    String scientificName, commonName, plantType, weatherType, moistureType, soilType;
    int lepsSupported;
    int cost;
    double x, y;
    double imgHeight, imgWidth;
    //HashMap<String, String[]> Conditions;
    
    public Plant(String scientificName, String commonName, String plantType, int lepsSupported, int cost, String weatherType, String moistureType, String soilType) 
    {
        this.scientificName = scientificName; 
        this.commonName = commonName;
        this.plantType = plantType;
        this.lepsSupported = lepsSupported;
        this.cost = cost;
        this.weatherType = weatherType;
        this.moistureType = moistureType;
        this.soilType = soilType;
    }
    
}
