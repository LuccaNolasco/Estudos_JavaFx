package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Controller implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Translate. -> Serve para mover o node pela scene
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(myImage); //Indica o que quer ser animado
        translate.setDuration(Duration.millis(1000));// Indica quanto tempo demora a transição. Útil se quer que seja mais rápida ou mais lenta
        translate.setCycleCount(4); //indica quantas vezes a animação ocorrerá (se não tiver, o padrão é 1)
        //Também é possível usar setCycleCount(TranslateTransition.INDEFINITE), para repetir sempre

        translate.setAutoReverse(true); //indica se deseja que retorne ou não (uma espécie de boomerang)

        translate.setByX(250); //Move o objeto no eixo determinado por tantos pixels
        translate.setByY(20);
        translate.play(); //Inicia a transição
        
        //Rotate
        RotateTransition rotate = new RotateTransition();
        rotate.setNode(myImage); 
        rotate.setDuration(Duration.millis(5000));
        rotate.setCycleCount(RotateTransition.INDEFINITE); 
        rotate.setByAngle(360);
        rotate.setInterpolator(Interpolator.LINEAR);//Para que não desacelere ao fim do giro
        rotate.setAxis(Rotate.Z_AXIS);// Escolhe o eixo de giro
        rotate.play();

        //Fade
        FadeTransition fade = new FadeTransition();
        fade.setNode(myImage); 
        fade.setDuration(Duration.millis(500));
        fade.setCycleCount(FadeTransition.INDEFINITE); 
        fade.setInterpolator(Interpolator.LINEAR);
        fade.setFromValue(1);//Opacidade inicial
        fade.setToValue(0);//Opacidade Final
        fade.setAutoReverse(true);
        fade.play();

        //Scale
        ScaleTransition scale = new ScaleTransition();
        scale.setNode(myImage); 
        scale.setDuration(Duration.millis(1250));
        scale.setCycleCount(FadeTransition.INDEFINITE); 
        scale.setInterpolator(Interpolator.LINEAR);
        scale.setByX(2.0);//Crescer no sentido x
        scale.setByY(2.0);
        scale.setAutoReverse(true);
        scale.play();
    }

    @FXML
    private ImageView myImage;
    
}
