package controller;

//import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Label label;
    @FXML
    private TextField textNome;
    @FXML
    private TextField textIdade;

    public void validar(){
        try{
            if(Integer.parseInt(textIdade.getText())<18){
                label.setText("Você é menor de idade");
            } else {
                label.setText("Cadastro realizado, "+textNome.getText()+"!");
            }
        }
        catch(NumberFormatException e){
            textIdade.setPromptText("Insira apenas números");
            textIdade.setText("");
            
        }   
    }
    
}
