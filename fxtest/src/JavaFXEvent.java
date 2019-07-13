import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class JavaFXEvent extends Application
{
    public void start(Stage primaryStage)
    {
        TextField txt = new TextField();
        txt.setText("0");
        txt.setFont(new Font(20));

        Label lbl = new Label();
        lbl.setFont(new Font(25));

        Button btn = new Button();
        btn.setFont(new Font(20));
        btn.setText("Click to add one");

        /*  Alternate Java 8 functional programming syntax */
        /*
        btn.setOnAction(e ->
		{
                int val = Integer.parseInt(txt.getText());
                val++;
                lbl.setText(Integer.toString(val));;
        });
        */
        btn.setOnAction(new EventHandler<ActionEvent>()
        {
            public void handle(ActionEvent event)
            {
                int val = Integer.parseInt(txt.getText());
                val++;
                lbl.setText(Integer.toString(val));
            }
        });

        VBox root = new VBox(); // Vertical layout
        root.getChildren().add(txt);
        root.getChildren().add(btn);
        root.getChildren().add(lbl);

        Scene scene = new Scene(root, 350, 200);
        primaryStage.setTitle("JavaFX Event Handler Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
