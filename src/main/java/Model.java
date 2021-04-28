import java.util.HashMap;

public class Model {

	private double x = 100;
	private double y = 200;
	HashMap<String, Plant> plants = new HashMap<>();
	
	public Model() {
		
	}
	
	public void setPlants()
	{
		Plant strawberry = new Plant("Fragaria", "Strawberry", "herbaceous", 63, 6, "Sunny", "Dry", "Decent");
		Plant sunflower = new Plant("Helianthus", "Sunflower", "herbaceous", 57, 6, "Rainy", "Medium", "Medium");
		Plant willow = new Plant("Salix", "Willow", "woody", 292, 20, "Cloudy", "Moist", "Good");
		
		plants.put("Fragaria", strawberry);
		plants.put("Helianthus", sunflower);
		plants.put("Salix", willow);
	}
	
	public HashMap<String, Plant> getPlants() 
    {
		return plants;
    }
	
    public static int calculateLeps(String plantname) {
        return 0;
    }

    public static int calculateBudget(int currentBudget) {
        return 0;
    }

    public static boolean checkCompatability(String name) {
        return false;
    }

    public static int calcUniqueplants() {
    	return 0;
    }

    public static void readSettings() {

    }

    public static void writeSettings() {

    }

    public static void readGradenFile() {

    }

    public static void writeGardenFile() {
        
    }
    
    public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

}
