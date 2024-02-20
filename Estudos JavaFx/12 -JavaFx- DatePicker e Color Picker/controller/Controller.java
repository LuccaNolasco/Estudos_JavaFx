package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class Controller {
    @FXML
    private DatePicker myDatePicker;
    @FXML
    private Label myLabel;
    @FXML
    private ColorPicker myColorPicker;

    public void setDate(){
        LocalDate myDate = myDatePicker.getValue();
        String myFormattedDate =myDate.format(DateTimeFormatter.ofPattern("dd/MMM/yyyy")); //MM para o número do mês e MMM para o nome
        myLabel.setText(myFormattedDate);
    }

    public void trocaCor(){
        Color myColor = myColorPicker.getValue();
        myLabel.setTextFill(myColor);
    }
    
}
