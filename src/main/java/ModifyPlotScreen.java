import java.util.Collection;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
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
	
	Image im1 = new Image(getClass().getResourceAsStream("/commonMilkweed.png"));
	private ImageView iv1;
	
	TilePane tilePane = new TilePane();
	FlowPane flowPane = new FlowPane();
	BorderPane borderPane = new BorderPane();
	TilePane tilePane2 = new TilePane();
	TilePane tilePane3 = new TilePane();
	
	private Controller imc;
	
    public ModifyPlotScreen(View v) {
		super(v);
		imc = new Controller(this);
		iv1 = new ImageView();
		
		iv1.setImage(im1);
    	iv1.setPreserveRatio(true);
    	iv1.setFitHeight(100);
    	
    	DragAndDrop();
		
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
    	borderPane.setTop(tilePane2);
    	borderPane.setBottom(tilePane3);
    	
    	label();
    	settingsbutton();
    	presentationModeButton();
    	budgetButton();
    	faunabutton();
    	
    	scene = new Scene(borderPane, 1000, 1000);
    	//summary.setOnAction(e -> view.switchPage(PagesEnum.SummaryScreen));
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
    
    public void label()
    {
    	Label label = new Label("Modify Plot Screen");
    	label.setTranslateX(450);
    	label.setTranslateY(0);
    	tilePane2.getChildren().add(label);
    }
    
    public void settingsbutton() 
    {
    	Button settings = new Button("Settings");
    	settings.setTranslateX(-120);
    	settings.setTranslateY(0);
    	settings.setOnAction(e -> view.switchPage(PagesEnum.SettingsScreen));
    	tilePane2.getChildren().add(settings);
    }

    public void presentationModeButton() {
    	
    	Button fullscreen = new Button("Full Screen");
    	fullscreen.setTranslateX(700);
    	fullscreen.setTranslateY(0);
    	fullscreen.setOnAction(e -> view.switchPage(PagesEnum.PresentationModeScreen));
    	tilePane2.getChildren().add(fullscreen);
    }
    
    public void budgetButton() {
    	Button budget = new Button("Budget");
    	budget.setTranslateX(5);
    	budget.setTranslateY(0);
    	budget.setOnAction(e -> view.switchPage(PagesEnum.BudgetScreen));
    	tilePane3.getChildren().add(budget);
    }

    public void faunabutton() {
    	Button fauna = new Button("Fauna");
    	fauna.setTranslateX(880);
    	fauna.setTranslateY(0);
    	fauna.setOnAction(e -> view.switchPage(PagesEnum.FaunaScreen));
    	tilePane3.getChildren().add(fauna);
    }

    public void searchTF() {
    	
    }

    public void plantNameText() {
        
    }
    
}
