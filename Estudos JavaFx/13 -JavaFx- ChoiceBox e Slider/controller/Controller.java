package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class Controller implements Initializable {
    @FXML
    private Label myLabel;
    @FXML
    private ChoiceBox<String> myChoiceBox;

    //Início ChoiceBox
    private String[] food = {"Hamburgão","Pizza Maluca","Queijo Minas Frescal","Pepino"};



    public void getFood(ActionEvent event){
        String myFood = myChoiceBox.getValue();
        myLabel.setText(myFood);
    }
    //Fim ChoiceBox

    //Início Slider
    @FXML
    private Slider mySlider;
    @FXML
    private Label myLabel1;
    double taxa;
    
    
    //Fim Slider


    @Override
    public void initialize(URL location, ResourceBundle resources) { //Initialize ocorre após o Root node ser instanciado e antes da tela surgir
        //Initialize para ChoiceBox
        myChoiceBox.getItems().addAll(food);//Para popular a Choice Box com Opções
        //myChoiceBox.setValue(food[0]); se eu quiser que esteja aparecendo um valor em específico
        myChoiceBox.setOnAction(this::getFood);

        //Initialize para o Slider
        mySlider.valueProperty().addListener(new ChangeListener<Number>(){

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                taxa=(Double)mySlider.getValue();
                myLabel1.setText("R$"+Double.toString(taxa));
            }
            
        });

    }

}
