package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class Controller {
    @FXML
    private Label myLabel;
    @FXML
    private RadioButton rButton1, rButton2, rButton3, rButton4;

    public void getFood(ActionEvent event){ //Action event para que se saiba qual Node inicou esse método
        RadioButton rb = (RadioButton) event.getSource(); //Para que rb seja uma instância desse node
        if(rb.getId()!=rButton4.getId()){ 
            myLabel.setText(rb.getText()); //Assim podemos passar o texto de Rb, sem precisar digitar o nome de cada um
        } else{
            myLabel.setText("Escolha o sabor:");
        }
    }
}
