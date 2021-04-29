import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Model {

	private double x = 100;
	private double y = 200;
	HashMap<String, Plant> plants = new HashMap<>();
	
	public Model()
	{
		testPlants();
		//System.out.println(plants);
//		System.out.println(plants.get("Asteraceae-Helianthus").scientificName);
//		System.out.println(plants.get("Asteraceae-Helianthus").commonName);
//		System.out.println(plants.get("Asteraceae-Helianthus").plantType);
//		System.out.println(plants.get("Asteraceae-Helianthus").lepsSupported);
//		System.out.println(plants.get("Asteraceae-Helianthus").cost);
//		System.out.println(plants.get("Asteraceae-Helianthus").weatherType);
//		System.out.println(plants.get("Asteraceae-Helianthus").moistureType);
//		System.out.println(plants.get("Asteraceae-Helianthus").soilType);
	}
	
	public void testPlants()
	{
		//Plant strawberry = new Plant("Fragaria", "Strawberry", "herbaceous", 63, 6, "Sunny", "Dry", "Decent");
		//Plant sunflower = new Plant("Helianthus", "Sunflower", "herbaceous", 57, 6, "Rainy", "Medium", "Medium");
		//Plant willow = new Plant("Salix", "Willow", "woody", 292, 20, "Cloudy", "Moist", "Good");
		
		//plants.put("Fragaria", strawberry);
		//plants.put("Helianthus", sunflower);
		//plants.put("Salix", willow);
		
		try {makeHashSet();}
        catch(Exception ex) {System.out.println("Loading file error with: " + ex.toString());}
		
	}
	
	public void makeHashSet() throws FileNotFoundException
	{
		File file = new File("Plants.txt");
		Scanner scanner = new Scanner(file);
		while(scanner.hasNextLine())
		{
			String tempFullString = scanner.nextLine();
			String[] array = tempFullString.split(",");
			String plantType = "herbaceous";
			if(array[4].equals("w"))
			{
				plantType = "woody";
			}
			plants.put(array[1], new Plant(array[0], array[1], plantType, Integer.parseInt(array[2]), Integer.parseInt(array[3]), array[5], array[6], array[7]));
			
			//System.out.println(array[1]);
		}
	}
	
	
	
	public HashMap<String, Plant> getPlants() 
    {
		return plants;
    }
	
    public int calculateLeps(String plantname) 
    {
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
