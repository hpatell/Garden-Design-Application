import java.util.Collection;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.TilePane;

public class ModifyPlotScreen extends Screen {
	
    Collection<Image> plantImages;
	Button summary = new Button("Test");
	
	Image im1 = new Image(getClass().getResourceAsStream("/commonMilkweed.png"));
	private ImageView iv1;
	
	TilePane tilePane = new TilePane();
	FlowPane flowPane = new FlowPane();
	BorderPane borderPane = new BorderPane();
	
	private Controller imc;
	
    public ModifyPlotScreen(View v) {
		super(v);
		imc = new Controller(this);
		iv1 = new ImageView();
		
		iv1.setImage(im1);
    	iv1.setPreserveRatio(true);
    	iv1.setFitHeight(100);
    	
    	DragAndDrop();
		
		Label label = new Label("Modify Plot Screen");
		
		//TilePane tilePane = new TilePane();
    	tilePane.setHgap(20);
    	tilePane.setMinWidth(200);
    	tilePane.setPrefColumns(4);
    	tilePane.getChildren().add(iv1);
    	tilePane.setStyle("-fx-background-color: #add8e6;");
		
    	//FlowPane flowPane = new FlowPane();
    	flowPane.setVgap(8);
    	flowPane.setHgap(4);
    	flowPane.setMinWidth(200);
    	flowPane.setStyle("-fx-background-color: #deb887;");
    	
    	//BorderPane borderPane = new BorderPane();
    	borderPane.setLeft(tilePane);
    	borderPane.setCenter(flowPane); 
    	borderPane.setTop(label);
    	
    	scene = new Scene(borderPane, 1000, 1000);
    	summary.setOnAction(e -> view.switchPage(PagesEnum.SummaryScreen));
    }

    public void DragAndDrop()
    {
    	iv1.setOnDragDetected(new EventHandler <MouseEvent>() {
    		public void handle(MouseEvent event) 
    		{		
    			Dragboard db = iv1.startDragAndDrop(TransferMode.ANY);
    			ClipboardContent content = new ClipboardContent();
    			content.putImage(iv1.getImage());
    			db.setContent(content);
    			event.consume();
    		}
    	});
    	
    	flowPane.setOnDragOver(new EventHandler<DragEvent>() {
    		public void handle(DragEvent event) 
    		{
    			if (event.getGestureSource() != flowPane &&
    					event.getDragboard().hasImage()) {
    				event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
    			}
    			event.consume();
    		}
    	});
    	
    	flowPane.setOnDragDropped(new EventHandler<DragEvent>() {
    		public void handle(DragEvent event) 
    		{
    			Dragboard db = event.getDragboard();
    			boolean success = false;
    			if(db.hasImage()) 
    			{
    				ImageView iv2 = new ImageView(db.getImage());
    				iv2.setFitHeight(100);
    				iv2.setPreserveRatio(true);
    				iv2.setOnMouseDragged((event1) -> imc.drag(event1));
    				flowPane.getChildren().add(iv2);
    				success = true;
    			}
    			event.setDropCompleted(success);
    			event.consume();
    		}
    	});
    }
    
    public void settingsbutton() {

    }

    public void presentationModeButton() {

    }
    
    public void budgetButton() {

    }

    public void faunabutton() {

    }

    public void searchTF() {

    }

    public void plantNameText() {
        
    }
    
}
