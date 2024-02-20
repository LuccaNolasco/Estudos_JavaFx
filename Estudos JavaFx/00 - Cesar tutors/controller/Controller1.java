package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller1 {
    @FXML
    Button button;

    public void func(){
        System.out.println("Hello");
        button.setText("Fui clicado");
    }
}
