import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.animation.FillTransition;
import javafx.animation.Timeline;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

public class JavaFXCircleAnimate extends Application
{
    public void start(Stage stage)
    {
       Circle c = new Circle(250,50,50);
       c.setFill(Color.GREEN);

       AnchorPane root = new AnchorPane();
       root.getChildren().add(c);

   	   FillTransition fill = new FillTransition(Duration.millis(500));
       fill.setToValue(Color.BLUE); // Transition to Blue

       TranslateTransition translate =
         new TranslateTransition(Duration.millis(500));
       translate.setToY(200);  // Move circle to Y=200

	   // Run the fill and translate transitions in parallel
       ParallelTransition transition = new ParallelTransition(c,
        	fill, translate);
       transition.setCycleCount(Timeline.INDEFINITE);
       transition.setAutoReverse(true);
       transition.play();

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