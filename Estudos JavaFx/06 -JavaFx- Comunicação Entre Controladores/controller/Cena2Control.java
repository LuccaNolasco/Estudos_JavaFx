package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Cena2Control {
    @FXML
    Label userLabel;

    public void displayName(String username){
        userLabel.setText(userLabel.getText()+" "+username);
    }
}
