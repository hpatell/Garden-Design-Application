import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class settingsScreen extends Screen {

    Button exitButton = new Button("Exit");
    
	Image backgroundimg = new Image(getClass().getResourceAsStream("/gear.png"));
	ImageView backgroundimgview = new ImageView(backgroundimg);

    public settingsScreen(View v) {
        super(v);

        exitButton.setTranslateX(0);
        exitButton.setTranslateY(50);


        StackPane layout = new StackPane();
        layout.getChildren().addAll(backgroundimgview, exitButton);
        scene = new Scene(layout, canvasWidth, canvasHeight);

        exitButton.setOnAction(e -> view.switchPage(PagesEnum.PreviousScreen));
    }

    public void save() {

    }

    public void adjBudgetTF(){

    }

    public void changeTheme(){

    }

    public void finish(){

    }
}