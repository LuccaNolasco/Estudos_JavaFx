package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.DataSingleton;

public class Controller2 implements Initializable{
    @FXML
    Label label2;
    @FXML
    Button button2;
    @FXML
    Rectangle personagem;

    private int speed =5; //Quantos pixel anda por frame

    DataSingleton data = DataSingleton.getInstance();

    Stage stage;
    Scene scene;
    Parent root;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label2.setText(data.getChoice());
        
        switch (data.getChoice()) {
            case "Choice 1":
                personagem.setLayoutX(0);
                personagem.setLayoutY(0);
                break;
            case "Choice 2":
                personagem.setLayoutX(550);
                personagem.setLayoutY(0);
                break;
            case "Choice 3":
                personagem.setLayoutX(0);
                personagem.setLayoutY(350);
                break;
            default:
                break;
        }

        timer.start(); //inicia a nimação

    }

    AnimationTimer timer = new AnimationTimer() {

        @Override
        public void handle(long now) { // define a animação
            if (personagem.getLayoutY()<=350){
                personagem.setLayoutY(personagem.getLayoutY()+speed); 
            } 
            if(personagem.getLayoutY() >= 349){
                speed = -1*speed;
            }
        }
        
    };

    public void back(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/tela1.fxml"));
        root = loader.load();
        scene = new Scene(root);
        stage=(Stage) button2.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
    }
    
}
