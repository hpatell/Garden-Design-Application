import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class settingsScreen extends Screen {


    public settingsScreen(View v) {
        super(v, PagesEnum.SettingsScreen);
    	layout = new StackPane();

//        Label title = new Label("Settings");
//        title.setMinWidth(100);
//        title.setMinHeight(100);
//        title.setTranslateX(0);
//        title.setTranslateY(-200);
//        title.setMaxSize(100, 100);
//        layout.getChildren().add(title);
        
        exitButton();
        adjBudgetTF();
        changeTheme();
        saveButton();
        finish();
    	layout.setStyle(theme);
        //layout.getChildren().addAll(exitButton, saveButton, adjBudget, adjBudjgettf, theme, lightButton, darkButton);
        scene = new Scene(layout, canvasWidth, canvasHeight);
    }
    
    public void exitButton() 
    {
    	Button exitButton = new Button("Exit");
    	//Image gear = new Image(getClass().getResourceAsStream("/gear.png"));
    	//ImageView gearIV = new ImageView(gear);
    	//gearIV.setPreserveRatio(true);
    	//gearIV.setFitHeight(20);
    	//gearIV.setFitWidth(20);
    	//exitButton.setGraphic(gearIV);
    	exitButton.setTranslateX(450);
        exitButton.setTranslateY(-375);
        exitButton.setOnAction(e -> view.switchPage(view.previouspage));
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
    	Label themelbl = new Label("Change Theme:");
    	themelbl.setTranslateX(-150);
    	themelbl.setTranslateY(0);
        Button dchangeThemebutton = new Button("Dark");
        Button lchangeThemebutton = new Button("Light");
        dchangeThemebutton.setMinWidth(100);
        dchangeThemebutton.setTranslateX(0);
        dchangeThemebutton.setTranslateY(0);
        dchangeThemebutton.setOnAction(e -> applyTheme("dark"));
        
        lchangeThemebutton.setMinWidth(100);
        lchangeThemebutton.setTranslateX(75);
        lchangeThemebutton.setTranslateY(0);
        lchangeThemebutton.setOnAction(e -> applyTheme("light"));
        layout.getChildren().addAll(dchangeThemebutton, lchangeThemebutton, themelbl);
    }
    
    public void applyTheme(String s) {
    	System.out.println("apply theme");
    	view.nameToScreenMap.forEach((name, screen) -> {
        	System.out.println(name);
    		screen.changeTheme(s);
    	});
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
    	Button finishButton = new Button("Return To Menu");
    	finishButton.setTranslateX(125);
    	finishButton.setTranslateY(150);
    	finishButton.setOnAction(e -> view.switchPage(PagesEnum.IntroScreen));
        layout.getChildren().add(finishButton);
    }
    
}