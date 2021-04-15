import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class settingsScreen extends Screen {

    Button exitButton = new Button("Exit");
    Button saveButton = new Button("Save");
    Label adjBudget = new Label("Adj Budget");
	TextField adjBudjgettf = new TextField();
	Label theme = new Label("Theme: ");
	Button lightButton = new Button("Light");
	Button darkButton = new Button("Dark");
	
	Image backgroundimg = new Image(getClass().getResourceAsStream("/gear.png"));
	ImageView backgroundimgview = new ImageView(backgroundimg);

    public settingsScreen(View v) {
        super(v);

        exitButton.setTranslateX(0);
        exitButton.setTranslateY(50);
        
        saveButton.setTranslateX(100);
        saveButton.setTranslateY(50);
        
        adjBudget.setTranslateX(-100);
        adjBudget.setTranslateY(-100);
                
        adjBudjgettf.setTranslateX(0);
        adjBudjgettf.setTranslateY(-100);
        
        adjBudjgettf.setMaxWidth(100);
        
        theme.setTranslateX(-50);
        theme.setTranslateY(-200);
        
        lightButton.setTranslateX(0);
        lightButton.setTranslateY(-200);
        
        darkButton.setTranslateX(50);
        darkButton.setTranslateY(-200);


        StackPane layout = new StackPane();
        layout.getChildren().addAll(backgroundimgview, exitButton, saveButton, adjBudget, adjBudjgettf, theme, lightButton, darkButton);
        scene = new Scene(layout, canvasWidth, canvasHeight);

        exitButton.setOnAction(e -> view.switchPage(PagesEnum.PreviousScreen));
    }

    public void save() {
    }
}