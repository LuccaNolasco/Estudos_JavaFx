package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

public class Controller implements Initializable {
    @FXML
    private Spinner<Integer> mySpinner;
    @FXML
    private Label myLabel;

    int currentV;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
        valueFactory.setValue(1);
        mySpinner.setValueFactory(valueFactory);
       // myLabel.setText(Integer.toString(mySpinner.getValue())); Só funciona para o primeiro valor, é necessário um Change listener

        mySpinner.valueProperty().addListener(new ChangeListener<Integer>() {

            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                myLabel.setText(Integer.toString(mySpinner.getValue()));
            }
            
        });
    }
    
}
