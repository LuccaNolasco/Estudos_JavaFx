package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private Button offButton;
    @FXML
    private AnchorPane painelCena;

    Stage stage;

    //Ao clicar no botã ode desligar
    public void logout (ActionEvent event){
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Desligar");
        alert.setHeaderText("Deseja mesmo sair?");
        alert.setContentText("Deseja salvar antes de sair? ");
       
        if (alert.showAndWait().get() == ButtonType.OK){
            stage = (Stage) painelCena.getScene().getWindow(); //É necessário definir o stage
            System.out.println("Desligou com sucesso");
            stage.close();
        }
    }
}
