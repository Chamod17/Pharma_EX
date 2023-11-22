package pharma_ex;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Cus_4Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void back(ActionEvent event) throws IOException {
        Parent table = FXMLLoader.load(getClass().getResource("Cus_3.fxml"));
        Scene tableview = new Scene(table);
        
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableview);
        window.show();
    }

    @FXML
    void initialize() {

    }

}
