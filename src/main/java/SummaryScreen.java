import java.awt.Font;
import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
	BorderPane borderPane;
	StackPane hstackPaneTop;	
	StackPane hstackPaneBottom;
	StackPane vstackPaneBottom;
	
	double ratio;
	
	ProgressBar budgetbar;
	
	Button save;
	
	Text budgettext;
	Text lepsandplantstext;
	Text newText;
	
	Boolean Unique;
	
	ArrayList<String> plantsInGardenName;
		
	public SummaryScreen(View v) {
		super(v, PagesEnum.SummaryScreen);
		
		borderPane = new BorderPane();
		hstackPaneTop = new StackPane();	
		vstackPaneBottom = new StackPane();
		hstackPaneBottom = new StackPane();	

    	borderPane.setTop(hstackPaneTop);
    	borderPane.setCenter(vstackPaneBottom);
    	borderPane.setBottom(hstackPaneBottom);
    	
    	hboxtop = new HBox();
    	hboxbottom = new HBox(50);
    	vbox = new VBox(10);
    	
		ratio = 100;
		
		budgetbar = new ProgressBar(100);
		budgetbar.setMinHeight(40);
		budgetbar.setMinWidth(500);
    	
		save = new Button("Save");
		
		Unique = true;
		
		plantsInGardenName = new ArrayList<String>();
    	
		lepsandplantstext = new Text("              Plants In Garden            Leps Supported            Cost of Plant");
		budgettext = new Text("Budget");
		
    	createReturnToPlotButton();
		createSettingsButton();
		
		hboxtop.setAlignment(Pos.TOP_RIGHT);
		hboxtop.setPadding(new Insets(10, 10, 0, 0));
		hboxtop.getChildren().addAll(settingsButton);
		
		vbox.setAlignment(Pos.TOP_CENTER);
		vbox.getChildren().addAll(budgettext, budgetbar, lepsandplantstext);
		
		hboxbottom.setAlignment(Pos.BOTTOM_CENTER);
		hboxbottom.setPadding(new Insets(0, 0, 10, 0));
		hboxbottom.getChildren().addAll(save, returnToPlotButton);
		
		hstackPaneTop.getChildren().addAll(hboxtop);
		vstackPaneBottom.getChildren().addAll(vbox);
		hstackPaneBottom.getChildren().addAll(hboxbottom);
		
		borderPane.setMaxHeight(canvasHeight);
		borderPane.setMaxWidth(canvasHeight);
		borderPane.setStyle(theme); 
		borderPane.setStyle(theme);
		
    	layout = borderPane;
    	scene = new Scene(layout, canvasWidth, canvasHeight);
	}
	
	public void update(double r, String commonname, String leps, String cost) {
		newText = new Text(commonname + "                         " + leps + "                         " + cost);
		budgetbar.setProgress(r);
		for(String name: plantsInGardenName) {
			if(commonname.equals(name) && plantsInGardenName != null) {
				Unique = false;
			}
		}		
		
		if(Unique) {
			vbox.getChildren().addAll(newText);
		}
		
		Unique = true;
		plantsInGardenName.add(commonname);
	}
	
	public void updatePage(){};
}