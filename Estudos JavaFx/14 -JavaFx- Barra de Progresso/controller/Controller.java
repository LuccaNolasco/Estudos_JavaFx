package controller;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class Controller implements Initializable{

    @FXML
    private ProgressBar myProgressBar;
    @FXML
    private Button myButton;
    @FXML
    private Label myLabel;
    
    BigDecimal progress = new BigDecimal(String.format("%.2f", 0.0).replace(",","."));//Um classe que permite escolher a quantidade de casas decimais e proporciona maior precisão nas somas
    //.replace(",",".") se faz necessário pois em String se usa "," enquanto que em double se usa "."

    @Override
    public void initialize(URL location, ResourceBundle resources) { //Para colocar as características da barra de progresso já ue não possui onAction no Scene Builder
        myProgressBar.setStyle("-fx-accent:red;");//colocando a cor vermelha usando uma propriedade de CSS
        
    }

    public void raiseProgress(){
        if(progress.doubleValue()<1){  //if(myProgressBar.getProgress()<1) Não funcionaria pois na perda de precisão, não resultaria em 1, mas em 0.99999999
            progress = new BigDecimal(String.format("%.2f", progress.doubleValue()+0.1).replace(",",".")); //É preciso instanciar novamente pois o BigDecimal é fixo
            myProgressBar.setProgress(progress.doubleValue());
            myLabel.setText(Double.toString((progress.doubleValue()  *100))+"%");
        }
    }
    
}
