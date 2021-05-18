import java.util.HashMap;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Controller {

	private final boolean DEBUG = true;
    Model model;
    View view;
    Scene theScene;

	/**
	 * Constructor for Controller
	 * 
	 * @param view takes in the instance of View accessed in Screen
	 * @author Kush Patel
	 */
    public Controller(View view) {
    	this.view = view;
    	model = new Model();
    	if (DEBUG) System.out.println("ic created");
    }
    
	/**
	 * Updates the dynamic asepcts of every screen such as remaining budget and lep count
	 * 
	 * @author Kush Patel
	 */ 
    public void update() {
    	model.setCurrentBudget(Integer.parseInt(view.gardeninit.gardenbudgetlocal));
    	model.calculateLeps(view.modify.getCommonName(), false);
    	model.calculateBudget(view.modify.getCommonName(), false);
       	view.modify.setRemainingBudget(String.valueOf(model.remainingBudget));
    	view.modify.setTotalLeps(String.valueOf(model.leps));
    	view.summary.update(model.calculateRemainOverTotalBudget(), model.plants.get(view.modify.getCommonName()).scientificName, 
    			String.valueOf(model.plants.get(view.modify.getCommonName()).lepsSupported), String.valueOf(model.plants.get(view.modify.getCommonName()).cost));
    	view.modify.update(model.plants.get(view.modify.getCommonName()).plantType, String.valueOf(model.plants.get(view.modify.getCommonName()).lepsSupported), String.valueOf(model.plants.get(view.modify.getCommonName()).cost), model.plants.get(view.modify.getCommonName()).scientificName);
    	model.setCommonName(view.modify.getCommonName());
    }

	/**
	 * Drag logic, updates the x and y location as the image is being dragged and sets drag boundaries.
	 * 
	 * @param event takes in mouse drag and iv takes in the image being dragged as a circle
	 * @author Himanshu Patel
	 */ 
    public void drag(MouseEvent event, Circle iv) {   	
    	Node n = (Node)event.getSource();
		if (DEBUG) System.out.println("ic mouse drag tx: " + n.getTranslateX() + ", ex: " + event.getX() );
		model.setX(model.getX() + event.getX()); //event.getX() is the amount of horiz drag
		model.setY(model.getY() + event.getY());
		
		double oldX = n.getTranslateX();
		double oldY = n.getTranslateY();
		
		n.setTranslateX(n.getTranslateX() + event.getX() - view.modify.scaledImgWidth/2);
		n.setTranslateY(n.getTranslateY() + event.getY() - view.modify.scaledImgHeight/2);
		
		if(view.modify.checkCollision(iv))
		{
			n.setTranslateX(oldX);
			n.setTranslateY(oldY);
		}
		
		// Check Garden Bounds
		if(n.getTranslateX() > view.modify.anchorPane.getWidth() - view.modify.scaledImgWidth)
		{
			n.setTranslateX(view.modify.anchorPane.getWidth() - view.modify.scaledImgWidth);
		}
		if(n.getTranslateX() < 0)
		{
			n.setTranslateX(0);
		}
		if(n.getTranslateY() < 0)
		{
			n.setTranslateY(0);
		}
		if(n.getTranslateY() > view.modify.anchorPane.getHeight() - view.modify.scaledImgHeight)
		{
			n.setTranslateY(view.modify.anchorPane.getHeight() - view.modify.scaledImgHeight);
		}
		
		//view.modify.checkCollsion(iv);
    }

	/**
	 * Handler for drag, used in modifyPlotScreen for when image is dragged
	 * 
	 * @param iv takes in the image being dragged as a circle
	 * @author Himanshu Patel
	 */ 
    public EventHandler<MouseEvent> getDragHandler(Circle iv)
    {
    	return event -> drag((MouseEvent) event, iv);
    }

    public EventHandler<MouseEvent> getOnGardenDragDetected(ImageView iv)
    {
    	return new EventHandler<MouseEvent>() {
    		public void handle(MouseEvent event)
    		{
    			view.modify.onGardenDragDetected(event, iv);
    		}
    	};
    }
    
    public EventHandler<DragEvent> getOnGardenDragOver()
    {
    	return new EventHandler<DragEvent>() {
    		public void handle(DragEvent event)
    		{
    			view.modify.onGardenDragOver(event);
    		}
    	};
    }
    
	/**
	 * Handler for drop, used in modifyPlotScreen for when image is dropped
	 * 
	 * @author Himanshu Patel
	 */ 
    public EventHandler<DragEvent> getOnGardenDragDropped()
    {
    	return new EventHandler<DragEvent>() {
    		public void handle(DragEvent event) 
    		{
    			view.modify.onGardenDragDropped(event);
    			update();
    		}
    	};
    }
    
	/**
	 * Handler for checkbox filtering, used in modifyPlotScreen
	 * 
	 * @param imageViews takes the set of all images that are avaible in a certain set of conditions, made in modifyPlotScreen
	 * @author Himanshu Patel
	 */ 
    public EventHandler<ActionEvent> getCheckboxHandler(HashMap<String, ImageView> imageViews)
    {
    	return new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent event)
    		{
    			view.modify.checkbox(event, imageViews, model.plants);
    		}
    	};
    }
    
	/**
	 * Handler for remove plant on mouse click and updates the dymanic aspects of relevant screens
	 * 
	 * @param iv takes in the image of the plant being removed from the garden
	 * @author Himanshu Patel
	 */ 
    public EventHandler<MouseEvent> removePlant(Circle iv)
    {
       	return new EventHandler<MouseEvent>() {
       		public void handle(MouseEvent event) {
       			if(event.getButton() == MouseButton.SECONDARY) {
	       			view.modify.removePlant(event, iv);
	       	    	model.calculateLeps(view.modify.getCommonNameRemove(), true);
	       	    	model.calculateBudget(view.modify.getCommonNameRemove(), true);
	       	       	view.modify.setRemainingBudget(String.valueOf(model.remainingBudget));
	       	    	view.modify.setTotalLeps(String.valueOf(model.leps));
	       	    	view.modify.update(model.plants.get(view.modify.getCommonName()).plantType, String.valueOf(model.plants.get(view.modify.getCommonName()).lepsSupported), String.valueOf(model.plants.get(view.modify.getCommonName()).cost), model.plants.get(view.modify.getCommonName()).scientificName);
       			}
       		}
       	};
     }
    
	/**
	 * Getter method to get the hashmap of plants in model
	 * 
	 * @author Himanshu Patel
	 */ 
    public HashMap<String, Plant> getplants()
    {
    	return model.plants;
    }

}
