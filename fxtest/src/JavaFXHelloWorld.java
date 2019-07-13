import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JavaFXHelloWorld extends Application
{
    public void start(Stage primaryStage)
    {
		Label label1 = new Label();
		Label label2 = new Label();
		label1.setText("Hello");
		label2.setText(" World");

        HBox root = new HBox();
        root.getChildren().add(label1);
        root.getChildren().add(label2);

        Scene scene = new Scene(root, 300, 50);

        primaryStage.setTitle("JavaFX Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
