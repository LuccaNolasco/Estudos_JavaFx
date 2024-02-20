package controller;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    // Referência ao controlador do personagem
    private CharacterController characterController;
    @FXML
    private ImageView bite;
    TranslateTransition translate = new TranslateTransition(Duration.seconds(0.2), bite);
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Cria uma instância do controlador do personagem
        characterController = new CharacterController();
        
    }

    
    public void onKeyPressed(KeyEvent event) {
        characterController.handleKeyPress(event.getCode(),bite);
    }

    //public void setOnKeyReleased (KeyEvent event){
        //translate.stop();
    //}
}