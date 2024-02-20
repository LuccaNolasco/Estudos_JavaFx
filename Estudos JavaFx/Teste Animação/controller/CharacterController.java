package controller;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

public class CharacterController {

    @FXML
    private ImageView bite;

    // Método para tratar a entrada de teclas
    public void handleKeyPress(KeyCode keyCode, ImageView bite) {
        // Define o deslocamento com base na tecla pressionada
        double deltaX = 0, deltaY = 0;

        switch (keyCode) {
            case UP:
                deltaY = -50;
                break;
            case DOWN:
                deltaY = 50;
                break;
            case LEFT:
                deltaX = -50;
                break;
            case RIGHT:
                deltaX = 50;
                break;
            default:
                // Outras teclas não fazem nada
                break;
        }

        // Cria uma nova transição de tradução com a duração desejada
        TranslateTransition translate = new TranslateTransition(Duration.seconds(0.2), bite);

        // Define o deslocamento na transição e inicia
        translate.setByX(deltaX);
        translate.setByY(deltaY);
        translate.play();
    }


}


