import java.util.HashMap;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class View extends Application{
    Image plant;
    Image importedimage;
    //Collection screens;
    //Image Collection<> plantImages;
    int canvasHeight, canvasWidth;
    double imgWidth, imgHeight;
    double x, y, xloc, ylco;
    int lepsSupported;
    //HashMap<String> Conditions;

    public View() {

    }

    public Image createImage() {
        return plant;
    }

    public Image importImage() {
        return importedimage;
    }

    public void update(Image plant, double x, double y) {

    }

    public void draw() {

    }

    public void drag() {

    }

    public void changePage() {

    }

    @Override
    public void start(Stage stage) {

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}