import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;

public class Model {

	private double x = 100;
	private double y = 200;
	int leps;
	double currentBudget;
	double remainingBudget;
	boolean initialbudget;
	HashMap<String, Plant> plants = new HashMap<>();
	
	Collection<String> Woody;
	Collection<String> Herbaceous;
	
	String commonname;
	
	/**
	 * Constructor for Model
	 * 
	 * @author Himanshu Patel
	 */
	public Model()
	{
		testPlants();
		leps = 0;
		currentBudget = 0;
		remainingBudget = currentBudget;
		initialbudget = true;
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
	
	/**
	 * Reads a text file containing the plants and their info and creates objects with that info to add to a HashMap
	 * 
	 * @author Himanshu Patel
	 */
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
	
	
	/**
	 * Getter for the HashMap of all plants
	 * 
	 * @author Himanshu Patel
	 */
	public HashMap<String, Plant> getPlants() 
    {
		return plants;
    }	
	
	/**
	 * Updates the lep count when a plant is added or removed from the garden
	 * 
	 * @param plantname takes in commonname of a plant, remove takes in a boolean identify if plant is being added/removed
	 * @author Kush Patel
	 */
    public int calculateLeps(String plantname, Boolean remove) {
    	if(remove) {
    		leps = leps - plants.get(plantname).lepsSupported;
    		System.out.println(leps);
    	} else {
    		leps = leps + plants.get(plantname).lepsSupported;
    	}
    	return leps;
    }

	/**
	 * Updates the budget when a plant is added or removed from the garden
	 * 
	 * @param plantname takes in commonname of a plant, remove takes in a boolean identify if plant is being added/removed
	 * @author Kush Patel
	 */
    public double calculateBudget(String plantname, Boolean remove) {
    	if(initialbudget) {
    		remainingBudget = currentBudget;
    		initialbudget = false;
    	}
    	
    	if(remove) {
    		System.out.println(remainingBudget);
    		remainingBudget = remainingBudget + plants.get(plantname).cost;
    	} else {
    		remainingBudget = remainingBudget - plants.get(plantname).cost;
    	}
    	return remainingBudget;
    }
    /*
    public Collection<String> checkWoody() {
    	for(Entry<String, Plant> mapElement : plants.entrySet()) {
            String key = mapElement.getKey();           
            Plant value = mapElement.getValue();
            if(plants.get(key).plantType == "woody") {
            	Woody.add(plants.get(key).commonName);
            }          
    	}
    	return Woody;
    }
    
    public Collection<String> checkHerbaceous() {
    	for(Entry<String, Plant> mapElement : plants.entrySet()) {
            String key = mapElement.getKey();           
            Plant value = mapElement.getValue();
            if(plants.get(key).plantType == "herbaceous") {
            	Herbaceous.add(plants.get(key).commonName);
            }          
    	}
    	return Herbaceous;
    }
    */
    
	/**
	 * Sets the current budget
	 * 
	 * @param budget, takes in an int value of the currentbudget for the garden
	 * @author Kush Patel
	 */
    public void setCurrentBudget(int budget) {
    	currentBudget = budget;
    }
    
    public static boolean checkCompatability(String name) {
        return false;
    }
    
	/**
	 * Calculates the ratio of remaining budget over total budget
	 * 
	 * @param budget, takes in an int value of the currentbudget for the garden
	 * @author Kush Patel
	 */
    public double calculateRemainOverTotalBudget() {
    	return remainingBudget/currentBudget;
    }
    
	/**
	 * Calculates the ratio of remaining budget over total budget
	 * 
	 * @param budget, takes in an int value of the currentbudget for the garden
	 * @author Kush Patel
	 */
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
    
	/**
	 * Sets commonname of the current/latest plant edited in the garden
	 * 
	 * @param budget, takes in an int value of the currentbudget for the garden
	 * @author Kush Patel
	 */
    public void setCommonName(String s) {
    	commonname = s;
    }
    
	/**
	 * Gets the x of the current/latest plant edited in the garden
	 * 
	 */
    public double getX() {
		return x;
	}

	/**
	 * Sets the x of the current/latest plant edited in the garden
	 * 
	 * @param double x, x location of a plant
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * Gets the y location of the current/latest plant edited in the garden
	 * 
	 */
	public double getY() {
		return y;
	}

	/**
	 * Sets the y location of the current/latest plant edited in the garden
	 * 
	 * @param y, y location 
	 */
	public void setY(double y) {
		this.y = y;
	}

}
