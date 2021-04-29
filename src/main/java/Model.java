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
	
	//View view;
	
	String commonname;
	
	
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
	
    public int calculateLeps(String plantname) {
    	System.out.println("Model has the name" + commonname);
    	leps = plants.get(plantname).lepsSupported + leps;
    	String lepsString = String.valueOf(leps);
        return leps;
    }

    public double calculateBudget(String plantname) {
    	if(initialbudget) {
    		remainingBudget = currentBudget;
    		initialbudget = false;
    	}
    	remainingBudget = remainingBudget - plants.get(plantname).cost;
    	System.out.println(remainingBudget);
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

    public void setCurrentBudget(int budget) {
    	currentBudget = budget;
    }
    
    public static boolean checkCompatability(String name) {
        return false;
    }
    
    public double calculateRemainOverTotalBudget() {
    	return remainingBudget/currentBudget;
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
    
    
    public void setCommonName(String s) {
    	commonname = s;
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
