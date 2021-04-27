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
import javafx.event.EventHandler;

public class Controller {

	double imgHeight = 100;
	double imgWidth = 100;
	private final boolean DEBUG = true;
    Model model;
    View view;
    Scene theScene;
    ModifyPlotScreen ModifyPlotScreen;

    public Controller(ModifyPlotScreen ModifyPlotScreen) {
    	
    	this.ModifyPlotScreen = ModifyPlotScreen;
    	model = new Model();
    	if (DEBUG) System.out.println("ic created");
    }
    
    public void getOnPageHander() {

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
    			ModifyPlotScreen.onGardenDragDetected(event, iv);
    		}
    	};
    }
    
    public EventHandler<DragEvent> getOnGardenDragOver()
    {
    	return new EventHandler<DragEvent>() {
    		public void handle(DragEvent event)
    		{
    			ModifyPlotScreen.onGardenDragOver(event);
    		}
    	};
    }
    
    public EventHandler<DragEvent> getOnGardenDragDropped()
    {
    	return new EventHandler<DragEvent>() {
    		public void handle(DragEvent event) 
    		{
    			ModifyPlotScreen.onGardenDragDropped(event);
    		}
    	};
    }

}
