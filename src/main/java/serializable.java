//import javafx.scene.Scene;
import java.util.HashMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class serializable {
	Model model;
	View view;
	HashMap<String, Object> objects = null;

	public serializable() {
		// NO parameters
		objects = new HashMap<String, Object>();
		this.model = null;
		this.view = null;
	}
	
	public void saveData(Model model, View view) {
		// Important!!! You must put in the current instance of model and view as parameters

//		String savedGardenName = view.gardeninit.gardenname;
		String savedGardenName = "hardCodedFileName";
		this.objects.put("model", model);
		this.objects.put("view", view);

		try 
		{
			FileOutputStream fos = new FileOutputStream(savedGardenName + ".ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(objects);
			oos.close();
		}
		catch (Exception ex)
		{
			System.out.println("Exception thrown while trying to save the garden:" + ex.toString());
		}
	}

	public void loadData() {
		// TODO: user selects file
		String selectedFile = "hardCodedFileName";
		try 
		{
			FileInputStream fis = new FileInputStream(selectedFile + ".ser");	
			ObjectInputStream ois = new ObjectInputStream(fis);
			this.objects = (HashMap<String, Object>) ois.readObject(); 
			//warning: "unchecked cast" but should still work

			// loading data from saved file into serializable.java class' fields
			this.model = (Model) this.objects.get("model");
			this.view = (View) this.objects.get("view");
//			this.theScene = (Scene) this.objects.get("theScene");
		}
		catch(Exception ex) 
		{
			System.out.println("Exception thrown while loading " + selectedFile + ": " + ex.toString());
		}

		// testing if everything is loaded properly into serializable's fields/properties
		// if they are loaded successfully, the field should not be null
		if(this.model != null) {
			System.out.println("SUCCESS! model is not null");
		}
		if(this.view != null) {
			System.out.println("SUCCESS! view is not null");
		}
//		if(this.theScene != null) {
//			System.out.println("SUCCESS! theScene is not null");
//		}

		// if everything is successful, you can just do set the view in controller to serializable.model
		// do the same for view and theScene

		// you will need to change how people will select the file to import
		// also, the garden initialization should not show if they've imported a file
	}

}
