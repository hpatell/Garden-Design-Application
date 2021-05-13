import java.awt.Font;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import java.util.ArrayList;
import java.util.Map.Entry;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;


public class SummaryScreen extends Screen {
	
	HBox hboxtop;
	HBox hboxbottom;
	VBox vbox;
	VBox vboxMiddle;
	HBox plantBox;
	HBox descripHBox;
	
	BorderPane borderPane;
	StackPane hstackPaneTop;	
	StackPane hstackPaneBottom;
	ScrollPane scrollPanePlants;
	
	double ratio;
	
	ProgressBar budgetbar;
	
	Button save;
	
	Label budgettext;
	Label costText;
	Label nameText;
	Label lepsText;
	Label plantText;
	Label newTextName;
	Label newTextCost;
	Label newTextLeps;
	
	Boolean Unique;
	
	View view;
	
	ArrayList<String> plantsInGardenName;
		
	public SummaryScreen(View v) {
		super(v, PagesEnum.SummaryScreen);
		
		view = v;
		
		borderPane = new BorderPane();
		hstackPaneTop = new StackPane();	
		hstackPaneBottom = new StackPane();
		scrollPanePlants = new ScrollPane();
    	vboxMiddle = new VBox(10);
    	descripHBox = new HBox();

    	borderPane.setTop(hstackPaneTop);
    	borderPane.setCenter(vboxMiddle);
    	borderPane.setBottom(hstackPaneBottom);
    	
    	hboxtop = new HBox();
    	hboxbottom = new HBox(50);
    	vbox = new VBox(10);
    	
    	scrollPanePlants.setHbarPolicy(ScrollBarPolicy.NEVER);
    	scrollPanePlants.setVbarPolicy(ScrollBarPolicy.ALWAYS);
    	
		ratio = 100;
		
		budgetbar = new ProgressBar(100);
		budgetbar.setMinHeight(40);
		budgetbar.setMinWidth(500);
    	
		save = new Button("Save");
		
		Unique = true;
		
		plantsInGardenName = new ArrayList<String>();
		
    	
		nameText = new Label("Plant Name");
		lepsText = new Label("Leps Supported");
		costText = new Label("Cost");
		budgettext = new Label("Budget");
		
		nameText.setMaxWidth(100);
		nameText.setMaxWidth(100);
		nameText.setMaxWidth(100);
		nameText.setMinWidth(100);
		nameText.setMinWidth(100);
		nameText.setMinWidth(100);
		
		lepsText.setMaxWidth(100);
		lepsText.setMaxWidth(100);
		lepsText.setMaxWidth(100);
		lepsText.setMinWidth(100);
		lepsText.setMinWidth(100);
		lepsText.setMinWidth(100);
		
		costText.setMaxWidth(100);
		costText.setMaxWidth(100);
		costText.setMaxWidth(100);
		costText.setMinWidth(100);
		costText.setMinWidth(100);
		costText.setMinWidth(100);
		
		budgettext.setMaxWidth(100);
		budgettext.setMaxWidth(100);
		budgettext.setMaxWidth(100);
		budgettext.setMinWidth(100);
		budgettext.setMinWidth(100);
		budgettext.setMinWidth(100);
		
    	createReturnToPlotButton();
		createSettingsButton();
		
		descripHBox.setAlignment(Pos.CENTER);
		descripHBox.setSpacing(25);
		
		descripHBox.getChildren().addAll(nameText, lepsText, costText);
		
		hboxtop.setAlignment(Pos.TOP_RIGHT);
		hboxtop.setPadding(new Insets(10, 10, 0, 0));
		hboxtop.getChildren().addAll(settingsButton);
		
		vbox.setAlignment(Pos.TOP_CENTER);
		vbox.setSpacing(15);
		vbox.getChildren().addAll(descripHBox, scrollPanePlants);
		scrollPanePlants.setContent(vbox);
		scrollPanePlants.setFitToWidth(true);
		scrollPanePlants.setFitToHeight(true);
		
		vboxMiddle.setAlignment(Pos.TOP_CENTER);
		vboxMiddle.getChildren().addAll(budgettext, budgetbar, scrollPanePlants);
		
		hboxbottom.setAlignment(Pos.BOTTOM_CENTER);
		hboxbottom.setPadding(new Insets(0, 0, 10, 0));
		hboxbottom.getChildren().addAll(save, returnToPlotButton);
		
		hstackPaneTop.getChildren().addAll(hboxtop);
		hstackPaneBottom.getChildren().addAll(hboxbottom);
		
		borderPane.setMaxHeight(canvasHeight);
		borderPane.setMaxWidth(canvasHeight);
		borderPane.setStyle(theme); 
		borderPane.setStyle(theme);
		
    	layout = borderPane;
    	scene = new Scene(layout, canvasWidth, canvasHeight);
	}
	
	public void update(double r, String commonname, String leps, String cost) {
		//vbox.getChildren().clear();
		//scrollPanePlants.setContent(vbox);
		//scrollPanePlants.setMinHeight(500);
		//vbox.getChildren().addAll(descripHBox, scrollPanePlants);
		/*
    	for (Entry<Circle, String> mapElement : view.modify.plantsToName.entrySet()) 
    	{
    	*/
            //Circle key = mapElement.getKey();
            //String value = mapElement.getValue();
            //if(value.equals(commonname)) {
    			newTextName = new Label(commonname);
    			newTextCost = new Label(cost);
    			newTextLeps = new Label(leps);
    			newTextName.setMaxWidth(100);
    			newTextCost.setMaxWidth(100);
    			newTextLeps.setMaxWidth(100);
    			newTextName.setMinWidth(100);
    			newTextCost.setMinWidth(100);
    			newTextLeps.setMinWidth(100);
    	    	plantBox = new HBox();
    	    	plantBox.setAlignment(Pos.CENTER);
    	    	plantBox.setSpacing(25);
    	    	plantBox.getChildren().addAll(newTextName, newTextCost, newTextLeps);
    			budgetbar.setProgress(r);
    			vbox.getChildren().addAll(plantBox);
           }
            /*
    	}
    	*/
		//vboxMiddle.getChildren().addAll(scrollPanePlants);
			/*
			for(String name: plantsInGardenName) {
				if(commonname.equals(name) && plantsInGardenName != null) {
					Unique = false;
				}
			}		
			
			if(Unique) {
				scrollPanePlants.getChildren().addAll(newText);
			}
			*/
			//Unique = true;
			//plantsInGardenName.add(commonname);
		//}
	
	public void updatePage(){};
}