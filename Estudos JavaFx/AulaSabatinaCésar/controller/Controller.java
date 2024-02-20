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

public class Controller implements Initializable{

    Stage stage;
    Scene scene;
    Parent root;

    @FXML
    ChoiceBox<String> choiceBox;
    @FXML
    Button button;

    String[] choices = {"Choice 1","Choice 2", "Choice 3"};

    DataSingleton data = DataSingleton.getInstance();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBox.getItems().addAll(choices);
        choiceBox.setValue(data.getChoice());// Para manter a escolha ao ir e voltar
        //Porém ele sempre irá chamar o data.getChoice(), mesmo ao iniciar o programa e o Data não tiver choice. É bom deixar um padrão no dataChoice
    }
    
    public void start(ActionEvent event) throws IOException{
        data.setChoice(choiceBox.getSelectionModel().getSelectedItem());//Para pegar a escolha na choiceBox
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/tela2.fxml"));
        root = loader.load();
        scene = new Scene(root);
        stage = (Stage)button.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
