package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

public class Controller {
    @FXML
    private Circle myCircle;
    private double x;
    private double y;

    public void up(ActionEvent e){
        //System.out.println("Cima");
        myCircle.setCenterY(y-=5);
    }
    public void down(ActionEvent e){
        //System.out.println("Baixo");
        myCircle.setCenterY(y+=5);
    }
    public void left(ActionEvent e){
        //System.out.println("Esquerda");
        myCircle.setCenterX(x-=5);
    }
    public void right(ActionEvent e){
        //System.out.println("Direita");
        myCircle.setCenterX(x+=5);
    }
}
