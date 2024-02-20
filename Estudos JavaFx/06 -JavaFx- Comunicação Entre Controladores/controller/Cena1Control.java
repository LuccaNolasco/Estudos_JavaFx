package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Cena1Control {
    @FXML
    TextField userTextField;
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void login(ActionEvent event) throws IOException{
        String username = userTextField.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/cena2.fxml"));
        root = loader.load();

        Cena2Control cena2Control = loader.getController();
        cena2Control.displayName(username);

        //root = FXMLLoader.load(getClass().getResource("/view/cena2.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
    }
}
