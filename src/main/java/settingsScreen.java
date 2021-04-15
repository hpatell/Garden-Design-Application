import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class settingsScreen extends Screen {
	
	StackPane layout = new StackPane();

    public settingsScreen(View v) {
        super(v);

        Label title = new Label("Settings");
        title.setMinWidth(100);
        title.setMinHeight(100);
        title.setTranslateX(0);
        title.setTranslateY(-200);
        title.setMaxSize(100, 100);
        layout.getChildren().add(title);
        
        exitButton();
        adjBudgetTF();
        changeTheme();
        saveButton();
        finish();
        
        //layout.getChildren().addAll(exitButton, saveButton, adjBudget, adjBudjgettf, theme, lightButton, darkButton);
        scene = new Scene(layout, canvasWidth, canvasHeight);
    }
    
    public void exitButton() 
    {
    	Button exitButton = new Button("Exit");
    	Image gear = new Image(getClass().getResourceAsStream("/gear.png"));
    	ImageView gearIV = new ImageView(gear);
    	gearIV.setPreserveRatio(true);
    	gearIV.setFitHeight(20);
    	gearIV.setFitWidth(20);
    	exitButton.setGraphic(gearIV);
    	exitButton.setTranslateX(450);
        exitButton.setTranslateY(-375);
        exitButton.setOnAction(e -> view.switchPage(PagesEnum.PreviousScreen));
        layout.getChildren().add(exitButton);
    }
    
    public void adjBudgetTF()
    {
    	Label adjBudget = new Label("Adjust Budget:");
    	adjBudget.setTranslateX(-150);
        adjBudget.setTranslateY(-50);
    	TextField adjBudjgettf = new TextField();
    	adjBudjgettf.setTranslateX(0);
        adjBudjgettf.setTranslateY(-50);
        adjBudjgettf.setMaxWidth(100);
        layout.getChildren().addAll(adjBudget, adjBudjgettf);
    }

    public void changeTheme()
    {
    	Label theme = new Label("Change Theme:");
    	theme.setTranslateX(-150);
        theme.setTranslateY(0);
        ComboBox<String> themeDL = new ComboBox<String>();
        themeDL.getItems().add("Dark Mode");
        themeDL.getItems().add("Light Mode");
        themeDL.setPromptText("Theme");
        themeDL.setMinWidth(100);
        themeDL.setTranslateX(0);
        themeDL.setTranslateY(0);
        layout.getChildren().addAll(theme, themeDL);
    }

    public void saveButton() 
    {
    	Button saveButton = new Button("Save Settings");
    	saveButton.setTranslateX(-125);
        saveButton.setTranslateY(150);
        layout.getChildren().add(saveButton);
    }
    
    public void finish()
    {
    	Button finishButton = new Button("Finish Garden");
    	finishButton.setTranslateX(125);
    	finishButton.setTranslateY(150);
        layout.getChildren().add(finishButton);
    }
    
}