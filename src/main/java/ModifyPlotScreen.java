import java.util.Collection;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class ModifyPlotScreen extends Screen {
	
	double imgHeight = 100;
	double imgWidth = 100;
	
    //Collection<Image> plantImages;
	
	private Controller imc;
	
	BorderPane borderPane = new BorderPane();
	TilePane tilePane = new TilePane();
	AnchorPane anchorPane = new AnchorPane();
	TilePane tilePaneTop = new TilePane();
	TilePane tilePaneBottom = new TilePane();
	ScrollPane scrollPane = new ScrollPane();
	VBox vBoxImages = new VBox();
	VBox vBox = new VBox();
	
    public ModifyPlotScreen(View v) {
		super(v, PagesEnum.ModifyPlotScreen);
		imc = new Controller(this);
    	
		//ImageView iv1 = createImage("/commonMilkweed.png");
		ImageView iv1 = createImage("/FragariaStrawberry.png");
		ImageView iv2 = createImage("/HelianthusSunflower.png");
		ImageView iv3 = createImage("/SalixWillow.png");
		ImageView iv4 = createImage("/SalixWillow.png");
		ImageView iv5 = createImage("/SalixWillow.png");
		ImageView iv6 = createImage("/SalixWillow.png");
		ImageView iv7 = createImage("/SalixWillow.png");
		ImageView iv8 = createImage("/SalixWillow.png");
		ImageView iv9 = createImage("/SalixWillow.png");
		ImageView iv10 = createImage("/SalixWillow.png");
		
		// TilePane
//    	tilePane.setHgap(20);
//    	tilePane.setMinWidth(200);
//    	tilePane.setPrefColumns(4);
//    	tilePane.getChildren().addAll(iv1, iv2, iv3);
//    	tilePane.setStyle("-fx-background-color: #add8e6;");
    	
		// Search Bar
    	TextField textField = new TextField();
        textField.setPromptText("Search:");
    	
        // Check Boxes
        CheckBox woody = new CheckBox("Woody");
        CheckBox herbaceous = new CheckBox("Herbaceous");
        
        HBox hbox = new HBox(24);
        hbox.getChildren().addAll(woody, herbaceous);
        
    	// VBoxImages
    	//vBox.setMinWidth(200);
        vBoxImages.getChildren().addAll(iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, iv9, iv10);
        vBoxImages.setStyle("-fx-background-color: #add8e6;");
    	
    	// ScrollPane
    	scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
    	scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
    	scrollPane.setMinWidth(200);
    	scrollPane.setContent(vBoxImages);
    	
    	// VBox
    	vBox.getChildren().addAll(textField, hbox, scrollPane);
    	
    	// AnchorPane
    	anchorPane.setMinWidth(200);
    	anchorPane.setStyle("-fx-background-color: #d2b48c;");
    	//anchorPane.setTopAnchor(, 0.0);
    	//anchorPane.setLeftAnchor(, 0.0);
    	
    	layout = borderPane;
    	
    	// BorderPane
    	borderPane.setLeft(vBox);
    	borderPane.setCenter(anchorPane); 
    	borderPane.setTop(tilePaneTop);
    	borderPane.setBottom(tilePaneBottom);
    	tilePaneTop.setStyle("-fx-background-color: #8fbc8f;");
    	tilePaneBottom.setStyle("-fx-background-color: #8fbc8f;");
    	
    	label();
    	settingsbutton();
    	budgetButton();
    	faunabutton();
    	summarybutton();
    	
    	scene = new Scene(borderPane, canvasWidth, canvasHeight);
    }

    public void DragAndDrop(ImageView iv)
    {
		iv.setOnDragDetected(imc.getOnGardenDragDetected(iv));
    	anchorPane.setOnDragOver(imc.getOnGardenDragOver());
    	anchorPane.setOnDragDropped(imc.getOnGardenDragDropped());
    }
    
    public void onGardenDragDetected(MouseEvent event, ImageView iv)
    {
    	Dragboard db = iv.startDragAndDrop(TransferMode.ANY);
		ClipboardContent content = new ClipboardContent();
		content.putImage(iv.getImage());
		db.setContent(content);
		event.consume();
    }
    
    public void onGardenDragOver(DragEvent event)
    {
    	if (event.getGestureSource() != anchorPane &&
				event.getDragboard().hasImage()) {
			event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
		}
		event.consume();
    }
    
    public void onGardenDragDropped(DragEvent event)
    {
    	Dragboard db = event.getDragboard();
		boolean success = false;
		if(db.hasImage()) 
		{
			ImageView newIV = new ImageView(db.getImage());
			newIV.setFitHeight(imgHeight);
			newIV.setFitWidth(imgWidth);
			newIV.setPreserveRatio(true);
			newIV.setOnMouseDragged(imc.getDragHandler());
			newIV.setTranslateX(newIV.getTranslateX() + event.getX() - imgWidth/2);
			newIV.setTranslateY(newIV.getTranslateY() + event.getY() - imgHeight/2);
			anchorPane.getChildren().add(newIV);
			success = true;
		}
		event.setDropCompleted(success);
		event.consume();
    }
    
    
    
    public void label()
    {
    	Label label = new Label("Modify Your Garden");
    	//Label label = new Label(gardenname);
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
    	fauna.setTranslateX(855);
    	fauna.setTranslateY(0);
    	fauna.setOnAction(e -> view.switchPage(PagesEnum.FaunaScreen));
    	tilePaneBottom.getChildren().add(fauna);
    }

    public void searchTF() {
    	
    }

    public void plantNameText() {
        
    }
    
    public void summarybutton() {
    	Button summary = new Button("Summary");
    	summary.setTranslateX(340);
    	summary.setTranslateY(0);
    	summary.setOnAction(e -> view.switchPage(PagesEnum.SummaryScreen));
    	tilePaneBottom.getChildren().add(summary);
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
