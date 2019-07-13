import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

public class JavaFXCircle extends Application
{
    public void start(Stage stage)
    {
       Circle c = new Circle(250,50,50);
       c.setFill(Color.GREEN);

       AnchorPane root = new AnchorPane();
       root.getChildren().add(c);

       Scene scene = new Scene(root, 500, 300, Color.BLACK);

       stage.setTitle("JavaFX Circle Demo");
       stage.setScene(scene);
       stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}