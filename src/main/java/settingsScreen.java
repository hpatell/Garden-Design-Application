import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

public class settingsScreen extends Screen {

    Button exitButton = new Button("Exit");

    public settingsScreen(View v) {
        super(v);

        exitButton.setTranslateX(0);
        exitButton.setTranslateY(100);


        StackPane layout = new StackPane();
        layout.getChildren().addAll(exitButton);
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