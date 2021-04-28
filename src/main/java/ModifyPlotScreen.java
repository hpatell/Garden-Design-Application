import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ModifyPlotScreen extends Screen {
	
	double imgHeight = 100;
	double imgWidth = 100;
	
    //Collection<Image> plantImages;
	
	private Controller imc;
	
	BorderPane borderPane = new BorderPane();
	AnchorPane anchorPane = new AnchorPane();
	StackPane stackPaneTop = new StackPane();
	StackPane stackPaneBottom = new StackPane();
	ScrollPane scrollPane = new ScrollPane();
	VBox vBoxImages = new VBox();
	VBox vBox = new VBox();
	HBox hBoxBottom = new HBox();
	
	CheckBox woody = new CheckBox("Woody");
	CheckBox herbaceous = new CheckBox("Herbaceous");
	
    public ModifyPlotScreen(View v) {
		super(v, PagesEnum.ModifyPlotScreen);
		imc = new Controller(v);
    	
		
		v.setPlantPNG();
		System.out.println(v.plantPNG);
		
		HashMap<String, ImageView> plantIVs = createImages(v.plantPNG);
		System.out.println(plantIVs);
		
		
		//ImageView iv1 = createImage("/commonMilkweed.png");
//		ImageView iv1 = createImage("/FragariaStrawberry.png");
//		ImageView iv2 = createImage("/HelianthusSunflower.png");
//		ImageView iv3 = createImage("/SalixWillow.png");
//		ImageView iv4 = createImage("/SalixWillow.png");
//		ImageView iv5 = createImage("/SalixWillow.png");
//		ImageView iv6 = createImage("/SalixWillow.png");
//		ImageView iv7 = createImage("/SalixWillow.png");
//		ImageView iv8 = createImage("/SalixWillow.png");
//		ImageView iv9 = createImage("/SalixWillow.png");
//		ImageView iv10 = createImage("/SalixWillow.png");
    	
		
		// Search Bar
    	TextField textField = new TextField();
        textField.setPromptText("Search:");
    	
        // Check Boxes
        CheckBox woody = new CheckBox("Woody");
        CheckBox herbaceous = new CheckBox("Herbaceous");
        //woody.setSelected(true);
        //herbaceous.setSelected(true);
        
        woody.setOnAction(imc.getCheckboxHandler(plantIVs));
        herbaceous.setOnAction(imc.getCheckboxHandler(plantIVs));
        
        HBox hbox = new HBox(24);
        hbox.getChildren().addAll(woody, herbaceous);
        
    	// VBoxImages
    	//vBox.setMinWidth(200);
        //vBoxImages.getChildren().addAll(iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, iv9, iv10);
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
    	
    	// HboxBottom
    	hBoxBottom.setAlignment(Pos.CENTER);
    	hBoxBottom.setSpacing(850);
    	
    	layout = borderPane;
    	
    	// BorderPane
    	borderPane.setLeft(vBox);
    	borderPane.setCenter(anchorPane); 
    	borderPane.setTop(stackPaneTop);
    	borderPane.setBottom(stackPaneBottom);
    	stackPaneTop.setStyle("-fx-background-color: #8fbc8f;");
    	stackPaneTop.setMinHeight(45);
    	stackPaneBottom.setStyle("-fx-background-color: #8fbc8f;");
    	stackPaneBottom.setMinHeight(45);
    	stackPaneBottom.getChildren().add(hBoxBottom);
    	
    	label();
    	settingsbutton();
    	budgetButton();
    	summarybutton();
    	faunabutton();
    	
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
    
    public void checkbox(ActionEvent event, HashMap<String, ImageView> imageViews)
    {  	
    	for (Entry<String, ImageView> mapElement : imageViews.entrySet()) 
    	{
            String key = (String)mapElement.getKey();
            
            ImageView value = (ImageView)mapElement.getValue();
            
            if(woody.isSelected() && herbaceous.isSelected())
    		{
            	//vBoxImages.getChildren().clear();
            	vBoxImages.getChildren().remove(value);
    			vBoxImages.getChildren().add(value);
    		}
            else if(woody.isSelected() == false && herbaceous.isSelected() == false)
            {
            	vBoxImages.getChildren().remove(value);
            }
            else if(woody.isSelected() == true && herbaceous.isSelected() == false)
            {
            	if(key == "Salix")
            	{
            		//vBoxImages.getChildren().clear();
            		vBoxImages.getChildren().remove(value);
            		vBoxImages.getChildren().add(value);
            	}
            }
            else if(herbaceous.isSelected() == true && woody.isSelected() == false)
            {
            	if(key == "Fragaria" || key == "Helianthus")
            	{
            		//vBoxImages.getChildren().clear();
            		vBoxImages.getChildren().remove(value);
            		vBoxImages.getChildren().add(value);
            	}
            }
            
        	//vBoxImages.getChildren().add(value);
        	//plantIVs.put(key, value);
        	
        	//woody.setOnAction(imc.getCheckboxHandler(plantIVs));
            //herbaceous.setOnAction(imc.getCheckboxHandler(plantIVs));
    	}
    }
    
    
    
    public void label()
    {
    	Label label = new Label("Modify Your Garden");
    	label.setFont(new Font("Arial", 30));
    	HBox hBoxLabel = new HBox();
    	hBoxLabel.setAlignment(Pos.CENTER);
    	//hBoxLabel.setPadding(new Insets(5, 0, 5, 0));
    	hBoxLabel.getChildren().add(label);
    	stackPaneTop.getChildren().add(hBoxLabel);
    }
    
    public void settingsbutton() 
    {
    	Button settings = new Button("Settings");
    	settings.setOnAction(e -> view.switchPage(PagesEnum.SettingsScreen));
    	HBox hBoxSettings = new HBox();
    	hBoxSettings.setAlignment(Pos.CENTER_LEFT);
    	hBoxSettings.setPadding(new Insets(0, 0, 0, 10));
    	hBoxSettings.getChildren().add(settings);
    	stackPaneTop.getChildren().add(hBoxSettings);
    }

    public void presentationModeButton() 
    {	
    	Button fullscreen = new Button("Full Screen");
    	//fullscreen.setTranslateX(680);
    	//fullscreen.setTranslateY(0);
    	fullscreen.setOnAction(e -> view.switchPage(PagesEnum.PresentationModeScreen));
    	//hBoxTop.getChildren().add(fullscreen);
    }
    
    public void budgetButton() 
    {
    	Button budget = new Button("Budget");
    	budget.setOnAction(e -> view.switchPage(PagesEnum.BudgetScreen));
    	//HBox hBoxBudget = new HBox();
    	//hBoxBudget.setAlignment(Pos.CENTER_LEFT);
    	//hBoxBudget.setPadding(new Insets(0, 0, 0, 10));
    	//hBoxBottom.getChildren().add(budget);
    	//stackPaneBottom.getChildren().add(hBoxBudget);
    }

    public void faunabutton() 
    {
    	Button fauna = new Button("Fauna");
    	fauna.setOnAction(e -> view.switchPage(PagesEnum.FaunaScreen));
    	//HBox hBoxFauna = new HBox();
    	//hBoxFauna.setAlignment(Pos.CENTER_RIGHT);
    	//hBoxFauna.setPadding(new Insets(0, 10, 0, 0));
    	hBoxBottom.getChildren().add(fauna);
    	//stackPaneBottom.getChildren().add(hBoxFauna);
    }
    
    public void summarybutton() {
    	Button summary = new Button("Summary");
    	summary.setOnAction(e -> view.switchPage(PagesEnum.SummaryScreen));
    	//HBox hBoxSummary = new HBox();
    	//hBoxSummary.setAlignment(Pos.CENTER);
    	hBoxBottom.getChildren().add(summary);
    	//stackPaneBottom.getChildren().add(hBoxSummary);
    }
    
    public void searchTF() {
    	
    }

    public void plantNameText() {
        
    }
    
//    public ImageView createImage(String png) 
//    {
//    	Image image = new Image(getClass().getResourceAsStream(png));
//    	ImageView imageV = new ImageView();
//    	imageV.setImage(image);
//    	imageV.setPreserveRatio(true);
//    	imageV.setFitHeight(imgHeight);
//    	imageV.setFitWidth(imgWidth);
//    	DragAndDrop(imageV);
//    	return imageV;
//    }
    
    public HashMap<String, ImageView> createImages(HashMap<String, String> imagePNGs)
    {
    	HashMap<String, ImageView> plantIVs = new HashMap<>();
    	
    	for (Entry<String, String> mapElement : imagePNGs.entrySet()) 
    	{
            String key = (String)mapElement.getKey();
            
            String value = (String)mapElement.getValue();
            
            Image image = new Image(getClass().getResourceAsStream(value));
        	ImageView imageV = new ImageView();
        	imageV.setImage(image);
        	imageV.setPreserveRatio(true);
        	imageV.setFitHeight(imgHeight);
        	imageV.setFitWidth(imgWidth);
        	DragAndDrop(imageV);
        	
        	vBoxImages.getChildren().add(imageV);
        	
        	plantIVs.put(key, imageV);
    	}
    	//woody.setOnAction(imc.getCheckboxHandler(plantIVs));
        //herbaceous.setOnAction(imc.getCheckboxHandler(plantIVs));
    	return plantIVs;
    }
    
}
