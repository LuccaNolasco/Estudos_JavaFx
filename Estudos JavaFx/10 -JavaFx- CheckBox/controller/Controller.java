package controller;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {
    @FXML
    private CheckBox myCheck;
    @FXML
    private Label meuTexto;
    @FXML
    private ImageView minhaImagem;

    Image imagem1 = new Image(getClass().getResourceAsStream("/assets/bol.jpg"));
    Image imagem2 = new Image(getClass().getResourceAsStream("/assets/bolsonaro.jpg"));

    public void ligar(){
        minhaImagem.setImage(imagem1);
        meuTexto.setText("BOL");
    }
    public void troca(){
        if(myCheck.isSelected()){
            minhaImagem.setImage(imagem2);
            meuTexto.setText("SONARO");
        } else{
            minhaImagem.setImage(imagem1);
            meuTexto.setText("BOL");
        }
    }

}
