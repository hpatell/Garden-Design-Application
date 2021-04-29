import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
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
	
	Model model;
	
	Collection<String> wPlantNames;
	Collection<String> hPlantNames;
	
	public void updatePage(){}
	
	private Controller imc;
	
	BorderPane borderPane = new BorderPane();
	AnchorPane anchorPane = new AnchorPane();
	StackPane stackPaneTop = new StackPane();
	StackPane stackPaneBottom = new StackPane();
	ScrollPane scrollPane = new ScrollPane();
	VBox vBoxImages = new VBox();
	VBox vBoxNames = new VBox();
	VBox vBox = new VBox();
	VBox vBoxRight;
	HBox hBoxBottom = new HBox();
	
	Label plantNames;
	
	CheckBox woody;
	CheckBox herbaceous;
	
	Label gardenNameLabel;
	Label gardenBudgetLabel;
	Label gardenWeatherConditionLabel;
	Label gardenSoilConditionLabel;
	Label gardenMoistureConditionLabel;
	Label gardenDimensionsLabel;
	
	Label gardenBudgetRemainingLabel;
	Label gardenTotalLeps;
	
	String commonname;
	String totalLeps;
	String remainingBudget;
	
	HashMap<String, ImageView> plantIVs;
	
	ImageView currentIV; 
	
    public ModifyPlotScreen(View v) {
		super(v, PagesEnum.ModifyPlotScreen);
		imc = new Controller(v);
		
		model = new Model();
    	
		//System.out.print(model.getPlants());
		
		v.setPlantPNG(model.getPlants());
		//System.out.println(v.plantPNG);
		
		
		//plantIVs = createImages(v.plantPNG);
		createImages(v.plantPNG);
		//System.out.println(plantIVs);
		
		totalLeps = "0";
		
		
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
        woody = new CheckBox("Woody");
        herbaceous = new CheckBox("Herbaceous");
        woody.setSelected(true);
        herbaceous.setSelected(true);
        
        woody.setOnAction(imc.getCheckboxHandler(plantIVs));
        herbaceous.setOnAction(imc.getCheckboxHandler(plantIVs));
        
        HBox hbox = new HBox(24);
        //hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(woody, herbaceous);
        
    	// VBoxImages
    	//vBox.setMinWidth(200);
        //vBoxImages.getChildren().addAll(iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, iv9, iv10);
        vBoxImages.setStyle("-fx-background-color: #add8e6;");
        vBoxImages.setAlignment(Pos.CENTER);
        
        // VBoxNames
        //vBoxNames.getChildren().addAll(v.plantPNG.key);
    	
    	// ScrollPane
    	scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
    	scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
    	scrollPane.setMinWidth(200);
    	scrollPane.setContent(vBoxImages);
    	//scrollPane.setContent(vBoxNames);
    	
    	// VBox
    	vBox.getChildren().addAll(hbox, scrollPane);
    	
    	// AnchorPane
    	anchorPane.setMinWidth(200);
    	anchorPane.setStyle("-fx-background-color: #d2b48c;");
    	//anchorPane.setTopAnchor(, 0.0);
    	//anchorPane.setLeftAnchor(, 0.0);
    	
    	// HboxBottom
    	hBoxBottom.setAlignment(Pos.CENTER);
    	hBoxBottom.setSpacing(50);
    	
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
    	summarybutton();
    	faunabutton();
    	
    	scene = new Scene(borderPane, canvasWidth, canvasHeight);
    }
    
    public void update() {
    	gardenTotalLeps.setText("Total Leps: " + totalLeps);
       	gardenBudgetRemainingLabel.setText("Budget Remaining: " + remainingBudget);
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
		setCurrentPlantImage(iv);
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
	    	if(currentIV != null && plantIVs != null) {
	    		commonname = findCommomName(currentIV);
	    		gardenTotalLeps.setText("Total Leps: " + model.leps);
	    	}
		}
		event.setDropCompleted(success);
		
		event.consume();
    }
    
    public void setCurrentPlantImage(ImageView iv) {
    	currentIV = iv;
    }
    
    public void checkbox(ActionEvent event, HashMap<String, ImageView> imageViews)
    {  	
    	vBoxImages.getChildren().clear();
    	
    	for (Entry<String, ImageView> mapElement : imageViews.entrySet()) 
    	{
            String key = mapElement.getKey();
            
            plantNames = new Label(key);
            plantNames.setFont(new Font("Arial", 22));
            
            ImageView value = mapElement.getValue();
            
            if(woody.isSelected() && herbaceous.isSelected())
    		{
    			vBoxImages.getChildren().addAll(plantNames, value);
    		}
            else if(woody.isSelected() == false && herbaceous.isSelected() == false)
            {
            	vBoxImages.getChildren().remove(value);
            }
            else if(woody.isSelected() && herbaceous.isSelected() == false)
            {
            	if(model.plants.get(key).plantType == "woody")
            	{
            		vBoxImages.getChildren().addAll(plantNames, value);
            	}
            }
            else if(herbaceous.isSelected() && woody.isSelected() == false)
            {
            	if(model.plants.get(key).plantType == "herbaceous")
            	{
            		vBoxImages.getChildren().addAll(plantNames, value);
            	}
            }
            
        	//woody.setOnAction(imc.getCheckboxHandler(plantIVs));
            //herbaceous.setOnAction(imc.getCheckboxHandler(plantIVs));
    	}
    }
    
    
    
    public void label()
    {
    	
    	gardenNameLabel = new Label(gardenname);
    	gardenNameLabel.setFont(new Font("Arial", 30));
    	HBox hBoxLabel = new HBox();
    	hBoxLabel.setAlignment(Pos.CENTER);
    	//hBoxLabel.setPadding(new Insets(5, 0, 5, 0));
    	hBoxLabel.getChildren().add(gardenNameLabel);
    	stackPaneTop.getChildren().add(hBoxLabel);
    	
    	gardenBudgetLabel = new Label(gardenbudget);
    	gardenBudgetLabel.setFont(new Font("Arial", 16));
    	
    	gardenBudgetRemainingLabel = new Label("Budget Remaining: ");
    	gardenBudgetRemainingLabel.setFont(new Font("Arial", 16));
    	
    	gardenTotalLeps = new Label();
    	gardenTotalLeps.setText("Total Leps: " + totalLeps);
    	gardenTotalLeps.setFont(new Font("Arial", 16));
    	
    	gardenDimensionsLabel = new Label("Dimensions: ");
    	gardenDimensionsLabel.setFont(new Font("Arial", 16));
    	
    	vBoxRight = new VBox();
    	vBoxRight.getChildren().remove(gardenTotalLeps);
    	vBoxRight.setAlignment(Pos.CENTER_RIGHT);
    	vBoxRight.setPadding(new Insets(0, 20, 0, 0));
    	vBoxRight.getChildren().addAll(gardenBudgetLabel, gardenBudgetRemainingLabel, gardenTotalLeps);
    	stackPaneTop.getChildren().add(vBoxRight);
    
    	
    	gardenWeatherConditionLabel = new Label(gardenWeatherCondition);
    	gardenWeatherConditionLabel.setFont(new Font("Arial", 16));
    	
    	gardenSoilConditionLabel = new Label(gardenSoilCondition);
    	gardenSoilConditionLabel.setFont(new Font("Arial", 16));
    	
    	gardenMoistureConditionLabel = new Label(gardenMoistureCondition);
    	gardenMoistureConditionLabel.setFont(new Font("Arial", 16));
    	
    	VBox vBoxLeft = new VBox();
    	vBoxLeft.setAlignment(Pos.CENTER_LEFT);
    	vBoxLeft.setPadding(new Insets(0, 0, 0, 20));
    	vBoxLeft.getChildren().addAll(gardenWeatherConditionLabel, gardenSoilConditionLabel, gardenMoistureConditionLabel, gardenDimensionsLabel);
    	stackPaneTop.getChildren().add(vBoxLeft);
    }
    
    public void settingsbutton() 
    {
    	Button settings = new Button("Settings");
    	settings.setOnAction(e -> view.switchPage(PagesEnum.SettingsScreen));
    	//HBox hBoxSettings = new HBox();
    	//hBoxSettings.setAlignment(Pos.CENTER_LEFT);
    	//hBoxSettings.setPadding(new Insets(0, 0, 0, 10));
    	hBoxBottom.getChildren().add(settings);
    	//stackPaneTop.getChildren().add(hBoxSettings);
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
    
    public String findCommomName(ImageView iv) {
    	commonname = "";
		for (Entry<String, ImageView> mapElement : plantIVs.entrySet()) 
    	{          
            if(mapElement.getValue() == iv) {
                System.out.println("The key for value " + iv + " is " + mapElement.getKey());
                commonname = mapElement.getKey();
                break;
              }
    	}
		return commonname;
    }
    
    public String getGardenBudget() {
    	return gardenbudget;
    }
    
    public String getCommonName() {
    	return commonname;
    }
    
    public void setTotalLeps(String t) {
    	totalLeps = t;
    }
    
    public void setRemainingBudget(String b) {
    	remainingBudget = b;
    }
    
    public void getWoody(Collection<String> wplants) {
    	wPlantNames = wplants;
    }
    
    public void getHerb(Collection<String> hplants) {
    	hPlantNames = hplants;
    }
    
    public void createImages(HashMap<String, String> imagePNGs)
    {
    	HashMap<String, ImageView> plantIVsCopy = new HashMap<>();
    	
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
        	
        	plantNames = new Label(key);
        	plantNames.setFont(new Font("Arial", 22));
        	
        	vBoxImages.getChildren().addAll(plantNames, imageV);
        	
        	//vBoxNames.getChildren().addAll(plantNames);
        	
        	plantIVsCopy.put(key, imageV);
    	}
    	plantIVs = plantIVsCopy;
    }
    
}
