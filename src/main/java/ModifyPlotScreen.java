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
	
	double imgHeight = 100;
	double imgWidth = 100;
	
    //Collection<Image> plantImages;
	
	private Controller imc;
	
	TilePane tilePane = new TilePane();
	FlowPane flowPane = new FlowPane();
	BorderPane borderPane = new BorderPane();
	TilePane tilePaneTop = new TilePane();
	TilePane tilePaneBottom = new TilePane();
	
    public ModifyPlotScreen(View v) {
		super(v);
		imc = new Controller(this);
    	
		//ImageView iv1 = createImage("/commonMilkweed.png");
		ImageView iv1 = createImage("/FragariaStrawberry.png");
		ImageView iv2 = createImage("/HelianthusSunflower.png");
		ImageView iv3 = createImage("/SalixWillow.png");
		
		// TilePane
    	tilePane.setHgap(20);
    	tilePane.setMinWidth(200);
    	tilePane.setPrefColumns(4);
    	tilePane.getChildren().addAll(iv1, iv2, iv3);
    	tilePane.setStyle("-fx-background-color: #add8e6;");
		
    	// FlowPane
    	flowPane.setVgap(8);
    	flowPane.setHgap(4);
    	flowPane.setMinWidth(200);
    	flowPane.setStyle("-fx-background-color: #d2b48c;");
    	
    	// BorderPane
    	borderPane.setLeft(tilePane);
    	borderPane.setCenter(flowPane); 
    	borderPane.setTop(tilePaneTop);
    	borderPane.setBottom(tilePaneBottom);
    	tilePaneTop.setStyle("-fx-background-color: #8fbc8f;");
    	tilePaneBottom.setStyle("-fx-background-color: #8fbc8f;");
    	
    	label();
    	settingsbutton();
    	presentationModeButton();
    	budgetButton();
    	faunabutton();
    	
    	scene = new Scene(borderPane, canvasWidth, canvasHeight);
    }

    public void DragAndDrop(ImageView iv)
    {
    	iv.setOnDragDetected(new EventHandler <MouseEvent>() {
    		public void handle(MouseEvent event) 
    		{		
    			Dragboard db = iv.startDragAndDrop(TransferMode.ANY);
    			ClipboardContent content = new ClipboardContent();
    			content.putImage(iv.getImage());
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
    				ImageView newIV = new ImageView(db.getImage());
    				newIV.setFitHeight(imgHeight);
    				newIV.setFitWidth(imgWidth);
    				newIV.setPreserveRatio(true);
    				newIV.setOnMouseDragged((event1) -> imc.drag(event1));
    				flowPane.getChildren().add(newIV);
    				success = true;
    			}
    			event.setDropCompleted(success);
    			event.consume();
    		}
    	});
    }
    
    public void label()
    {
    	Label label = new Label("Modify Your Garden");
    	label.setTranslateX(450);
    	label.setTranslateY(0);
    	tilePaneTop.getChildren().add(label);
    }
    
    public void settingsbutton() 
    {
    	Button settings = new Button("Settings");
    	settings.setTranslateX(-125);
    	settings.setTranslateY(0);
    	settings.setOnAction(e -> view.switchPage(PagesEnum.SettingsScreen));
    	tilePaneTop.getChildren().add(settings);
    }

    public void presentationModeButton() 
    {	
    	Button fullscreen = new Button("Full Screen");
    	fullscreen.setTranslateX(680);
    	fullscreen.setTranslateY(0);
    	fullscreen.setOnAction(e -> view.switchPage(PagesEnum.PresentationModeScreen));
    	tilePaneTop.getChildren().add(fullscreen);
    }
    
    public void budgetButton() 
    {
    	Button budget = new Button("Budget");
    	budget.setTranslateX(5);
    	budget.setTranslateY(0);
    	budget.setOnAction(e -> view.switchPage(PagesEnum.BudgetScreen));
    	tilePaneBottom.getChildren().add(budget);
    }

    public void faunabutton() 
    {
    	Button fauna = new Button("Fauna");
    	fauna.setTranslateX(880);
    	fauna.setTranslateY(0);
    	fauna.setOnAction(e -> view.switchPage(PagesEnum.FaunaScreen));
    	tilePaneBottom.getChildren().add(fauna);
    }

    public void searchTF() {
    	
    }

    public void plantNameText() {
        
    }
    
    public ImageView createImage(String png) 
    {
    	Image image = new Image(getClass().getResourceAsStream(png));
    	ImageView imageV = new ImageView();
    	imageV.setImage(image);
    	imageV.setPreserveRatio(true);
    	imageV.setFitHeight(imgHeight);
    	imageV.setFitWidth(imgWidth);
    	DragAndDrop(imageV);
    	return imageV;
    }
    
}
