import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
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
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;

public class ModifyPlotScreen extends Screen {
	
	double imgHeight = 100;
	double imgWidth = 100;
	int gardenSize;
	double scaledImgHeight;
	double scaledImgWidth;
	
	Collection<String> wPlantNames;
	Collection<String> hPlantNames;
	
	public void updatePage(){}
	
	private Controller imc;
	
	BorderPane borderPane = new BorderPane();
	AnchorPane anchorPane;
	StackPane stackPaneTop = new StackPane();
	StackPane stackPaneBottom = new StackPane();
	ScrollPane scrollPane = new ScrollPane();
	VBox vBoxImages = new VBox();
	VBox vBox = new VBox();
	VBox vBoxRight;
	HBox hBoxBottom = new HBox();
	
	Label plantName;
	VBox plantBox;
	
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
	
	String commonnameRemove;
	
	HashMap<String, ImageView> plantIVs;
	
	ArrayList<Circle> plantsInGarden = new ArrayList<Circle>();
	HashMap<Circle, String> plantsToName = new HashMap<Circle, String>();
	
	ImageView currentIV; 
	
	Image gardenIMG;
	ImageView gardenIV;
	
    public ModifyPlotScreen(View v) {
		super(v, PagesEnum.ModifyPlotScreen);
		imc = new Controller(v);

		v.setPlantPNG(imc.getplants());
		//System.out.println(v.plantPNG);
		
		//createImages(v.plantPNG);
		//System.out.println(plantIVs);
		
		totalLeps = "0";
		
		
		
		// Search Bar
    	TextField textField = new TextField();
        textField.setPromptText("Search:");
    	
        // Check Boxes
        woody = new CheckBox("Woody");
        herbaceous = new CheckBox("Herbaceous");
        woody.setSelected(true);
        herbaceous.setSelected(true);
        
        //woody.setOnAction(imc.getCheckboxHandler(plantIVs));
        //herbaceous.setOnAction(imc.getCheckboxHandler(plantIVs));
        
        HBox hbox = new HBox(24);
        //hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(woody, herbaceous);
        
    	// VBoxImages
        vBoxImages.setStyle("-fx-background-color: #add8e6;");
        vBoxImages.setAlignment(Pos.CENTER);
        vBoxImages.setMinWidth(182);
        vBoxImages.setSpacing(25);
    	
    	// ScrollPane
    	scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
    	scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
    	scrollPane.setMinWidth(200);
    	scrollPane.setContent(vBoxImages);
    	
    	// VBox
    	vBox.getChildren().addAll(hbox, scrollPane);
    	vBox.setStyle("-fx-background-color: #add8e6;");
    	
    	// AnchorPane
    	anchorPane = new AnchorPane();
    	//anchorPane.setStyle("-fx-background-color: #d2b48c;");
    	gardenIMG = new Image(getClass().getResourceAsStream("/gardenIMG.png"));
    	anchorPane.setBackground(new Background(new BackgroundImage(
    			gardenIMG,  
                BackgroundRepeat.NO_REPEAT,  
                BackgroundRepeat.NO_REPEAT,  
                BackgroundPosition.CENTER,  
                new BackgroundSize(1.0, 1.0, true, true, false, false))));
    	
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
       	gardenBudgetRemainingLabel.setText("Budget Remaining: $" + remainingBudget);
       	
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
			//ImageView newIV = new ImageView(db.getImage());
			Circle newIV = new Circle(scaledImgHeight/2, scaledImgWidth/2, scaledImgHeight/2);
			//newIV.setClip(clip);
			newIV.setFill(new ImagePattern(db.getImage()));
			//newIV.setFitHeight(imgHeight);
			//newIV.setFitWidth(imgWidth);
			//newIV.setPreserveRatio(true);
			newIV.setOnMouseDragged(imc.getDragHandler(newIV));
			newIV.setTranslateX(newIV.getTranslateX() + event.getX() - scaledImgWidth/2);
			newIV.setTranslateY(newIV.getTranslateY() + event.getY() - scaledImgHeight/2);
			
	    	if(currentIV != null && plantIVs != null) 
	    	{
	    		commonname = findCommomName(currentIV);
	    	}
			
			newIV.setOnMouseClicked(imc.removePlant(newIV));
			
			anchorPane.getChildren().add(newIV);
			success = true;
			
			plantsInGarden.add(newIV);
			plantsToName.put(newIV, commonname);
			
			checkDragDropCollision(newIV);
			
		}
		event.setDropCompleted(success);
		event.consume();
    }
    
    public void removePlant(MouseEvent event, Circle iv)
    {
    		anchorPane.getChildren().remove(iv);
    		System.out.println(plantsToName.get(iv));
    		commonnameRemove = plantsToName.get(iv);
    		plantsToName.remove(iv);
    }
    
    public void checkDragDropCollision(Circle iv)
    {
    	for (Circle static_bloc : plantsInGarden)
    	{
    		if (static_bloc != iv)
    		{
    			Shape intersect = Shape.intersect(iv, static_bloc);
    			if (intersect.getBoundsInLocal().getWidth() != -1)
    			{
    				System.out.println("COLLISION!!!");
    				//iv.setTranslateX(0);
    				//iv.setTranslateY(0);
    				if(iv.getTranslateX() > static_bloc.getTranslateX() - imgWidth && iv.getTranslateX() < static_bloc.getTranslateX())
        			{
        				iv.setTranslateX(static_bloc.getTranslateX() - imgWidth);
        			}
    				if(iv.getTranslateX() < static_bloc.getTranslateX() + imgWidth && iv.getTranslateX() > static_bloc.getTranslateX())
        			{
        				iv.setTranslateX(static_bloc.getTranslateX() + imgWidth);
        			}
    			}
    		}
    	}
    }
    
    public boolean checkCollision(Circle iv)
    {
    	for (Circle static_bloc : plantsInGarden)
    	{
    		if (static_bloc != iv)
    		{
    			Shape intersect = Shape.intersect(iv, static_bloc);
    			if (intersect.getBoundsInLocal().getWidth() != -1)
    			{
    				System.out.println("COLLISION!!!");
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    public void setCurrentPlantImage(ImageView iv) {
    	currentIV = iv;
    }
    
    public void checkbox(ActionEvent event, HashMap<String, ImageView> imageViews, HashMap<String, Plant> plants)
    {  	
    	vBoxImages.getChildren().clear();
    	
    	for (Entry<String, ImageView> mapElement : imageViews.entrySet()) 
    	{
            String key = mapElement.getKey();
            ImageView value = mapElement.getValue();
            
            plantName = new Label(key);
            plantName.setFont(new Font("Arial", 22));
        	
        	plantBox = new VBox();
        	plantBox.setAlignment(Pos.CENTER);
        	plantBox.getChildren().addAll(value, plantName);
        	
        	if(woody.isSelected() && plants.get(key).plantType == "woody")
        	{
        		vBoxImages.getChildren().addAll(plantBox);
        	}
            if(herbaceous.isSelected() && plants.get(key).plantType == "herbaceous")
            {
            	vBoxImages.getChildren().addAll(plantBox);
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
    	//hBoxBottom.getChildren().add(fauna);
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
                //System.out.println("The key for value " + iv + " is " + mapElement.getKey());
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
    
    public String getCommonNameRemove() {
    	return commonnameRemove;
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
    
    public void createImages(HashMap<String, String> imagePNGs, String Weather, String Soil, String Moisture, HashMap<String, Plant> plants)
    {
    	vBoxImages.getChildren().clear();
    	HashMap<String, ImageView> plantIVsCopy = new HashMap<>();
    	
    	for (Entry<String, String> mapElement : imagePNGs.entrySet()) 
    	{
            String key = (String)mapElement.getKey();
            
            String value = (String)mapElement.getValue();
            
            Image image = new Image(getClass().getResourceAsStream(value));
        	ImageView imageV = new ImageView();
        	
        	Circle clip = new Circle(imgWidth/2, imgHeight/2, imgWidth/2);
        	imageV.setClip(clip);
        	
        	imageV.setImage(image);
        	//imageV.setPreserveRatio(true);
        	imageV.setFitHeight(imgHeight);
        	imageV.setFitWidth(imgWidth);
        	DragAndDrop(imageV);
        	
        	plantName = new Label(key);
        	plantName.setFont(new Font("Arial", 22));
        	
        	plantBox = new VBox();
        	plantBox.setAlignment(Pos.CENTER);
        	plantBox.getChildren().addAll(imageV, plantName);
        	
        	//vBoxImages.getChildren().addAll(plantBox);
        	
        	//filterConditions(key, imageV, Weather, Soil, Moisture, imc.getplants(), plantIVsCopy);
        	
        	if(plants.get(key).weatherType.equals(Weather) && plants.get(key).soilType.equals(Soil) && plants.get(key).moistureType.equals(Moisture))
    		{	
    			vBoxImages.getChildren().addAll(plantBox);
    			plantIVsCopy.put(key, imageV);
    		}
        	
        	//plantIVsCopy.put(key, imageV);
    	}
    	plantIVs = plantIVsCopy;
    }
    
    public void scaleGarden(String dim) 
    {
        gardenSize = Integer.parseInt(dim);
        scaledImgHeight = (imgHeight/gardenSize)*10;
        scaledImgWidth = (imgWidth/gardenSize)*10;
    }
    
//    public void filterConditions(String key, ImageView imageV, String Weather, String Soil, String Moisture, HashMap<String, Plant> plants, HashMap<String, ImageView> plantIVsCopy)
//    {
//        plantName = new Label(key);
//        plantName.setFont(new Font("Arial", 22));
//    	
//    	plantBox = new VBox();
//    	plantBox.setAlignment(Pos.CENTER);
//    	plantBox.getChildren().addAll(imageV, plantName);
//		
//    	//vBoxImages.getChildren().addAll(plantBox);
//    	
//		if(plants.get(key).weatherType.equals(Weather) && plants.get(key).soilType.equals(Soil) && plants.get(key).moistureType.equals(Moisture))
//		{	
//			vBoxImages.getChildren().addAll(plantBox);
//			plantIVsCopy.put(key, imageV);
//		}
//    }
    
}
