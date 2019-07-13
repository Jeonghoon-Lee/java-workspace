import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class JavaFXAppController implements Initializable
{
	// The @FXML annotation looks up the
	// corresponding ID in the FXML file so
	// these variables map to the controls in
	// the UI
    @FXML
    private Label lblNumber;
    @FXML
    private Button btnClick;
    @FXML
    private TextField txtNumber;

    @FXML
    private void handleButtonAction(ActionEvent event)
    {
    	int val = Integer.parseInt
            (txtNumber.getText());
        val++;
        lblNumber.setText
       	    (Integer.toString(val));
    }
    public void initialize(URL url, ResourceBundle rb)
    {
        // Required by Initializable interface
        // Called to initialize a controller after the
        // root element has been processed
    }
}