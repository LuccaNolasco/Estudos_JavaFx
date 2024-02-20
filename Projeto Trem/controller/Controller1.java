package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import model.DataSingleton;

public class Controller1 implements Initializable {

    @FXML
    ChoiceBox<String> choiceMenu;
    @FXML
    Button buttonStart;

    String[] choices= {" 0 e 1", "0 e 3", "1 e 2", "2 e 3"};
    DataSingleton data = DataSingleton.getInstance();
    Stage stage;
    Scene scene;
    Parent root;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceMenu.getItems().addAll(choices);
        choiceMenu.setValue(choiceMenu.getItems().get(data.getOpt()));
    }
    
    public  void iniciar(ActionEvent event) throws IOException{
        data.setOpt(choiceMenu.getSelectionModel().getSelectedIndex());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/tela2.fxml"));
        root = loader.load();
        scene = new Scene(root);
        stage= (Stage)buttonStart.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
