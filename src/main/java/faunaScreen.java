import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.image.Image;

public class faunaScreen extends Screen {
	
	public void updatePage(){}
	
	Text plantsText;
	Text lepsText;
	Text plantsImgText;
	
	TableView plantsDataTable;

	HBox hboxtop;
	HBox hboxbottom;
	BorderPane borderPane;
	GridPane gridPane;
	StackPane hstackPaneTop;
	StackPane hstackPaneBottom;
	
	//Model model;
	
	public faunaScreen(View v) {
		super(v, PagesEnum.FaunaScreen);
		
		//model = new Model();
		
		borderPane = new BorderPane();	
		gridPane = new GridPane();
		plantsDataTable = new TableView();
		hstackPaneTop = new StackPane();
		hstackPaneBottom = new StackPane();	

    	borderPane.setTop(hstackPaneTop);
    	borderPane.setCenter(plantsDataTable);
    	borderPane.setBottom(hstackPaneBottom);

    	hboxtop = new HBox();
    	hboxtop.setPadding(new Insets(10, 10, 0, 0));
    	hboxtop.setAlignment(Pos.TOP_RIGHT);
    	
    	hboxbottom = new HBox();
    	hboxbottom.setAlignment(Pos.TOP_CENTER);
    	
		createSettingsButton();
		createReturnToPlotButton();
		
		plantsText = new Text("Plants In Garden");
		lepsText = new Text("Leps");
		plantsImgText = new Text("Image of Plants In Garden");		
		
		gridPane.setGridLinesVisible(true);

		
		hboxtop.getChildren().addAll(settingsButton);
		hboxbottom.getChildren().addAll(returnToPlotButton);
		
		hstackPaneTop.getChildren().addAll(hboxtop);
		hstackPaneBottom.getChildren().addAll(hboxbottom);
		
		
		borderPane.setStyle(theme);	
		layout = borderPane;
		scene = new Scene(layout, canvasWidth, canvasHeight);
	}
}
	