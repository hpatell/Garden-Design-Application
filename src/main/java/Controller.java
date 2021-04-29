import java.util.HashMap;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Controller {

	double imgHeight = 100;
	double imgWidth = 100;
	private final boolean DEBUG = true;
    Model model;
    View view;
    Scene theScene;
    //ModifyPlotScreen ModifyPlotScreen;

    public Controller(View view) {
    	this.view = view;
    	model = new Model();
    	if (DEBUG) System.out.println("ic created");
    }
    
    public void update() {
    	//view.modify.getWoody(model.checkWoody());
    	//view.modify.getHerb(model.checkWoody());
    	model.setCurrentBudget(Integer.parseInt(view.gardeninit.gardenbudgetlocal));
    	model.calculateLeps(view.modify.getCommonName());
    	model.calculateBudget(view.modify.getCommonName());
       	view.modify.setRemainingBudget(String.valueOf(model.remainingBudget));
    	view.modify.setTotalLeps(String.valueOf(model.leps));
    	view.modify.update();
    	model.setCommonName(view.modify.getCommonName());
    }

    public void drag(MouseEvent event) {   	
    	Node n = (Node)event.getSource();
		if (DEBUG) System.out.println("ic mouse drag tx: " + n.getTranslateX() + ", ex: " + event.getX() );
		model.setX(model.getX() + event.getX()); //event.getX() is the amount of horiz drag
		model.setY(model.getY() + event.getY());
		n.setTranslateX(n.getTranslateX() + event.getX() - imgWidth/2);
		n.setTranslateY(n.getTranslateY() + event.getY() - imgHeight/2);
    }

    public EventHandler<MouseEvent> getDragHandler()
    {
    	return event -> drag((MouseEvent) event);
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
    
    public EventHandler<ActionEvent> getCheckboxHandler(HashMap<String, ImageView> imageViews)
    {
    	return new EventHandler<ActionEvent>() {
    		public void handle(ActionEvent event)
    		{
    			view.modify.checkbox(event, imageViews);
    		}
    	};
    }

}
