package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class Controller implements Initializable {
    @FXML
    private ListView<String> myListView;
    @FXML
    private Label myLabel;

    String[] foods = {"Pizza", "pork", "pepino", "manjericão"};

    //String currentFood; caso quisesse uma variável. Útil se for usar muito, para poupar chamadas

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        myListView.getItems().addAll(foods); // Para popular com escolhas
        myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                //currentFood= myListView.getSelectionModel().getSelectedItem(); Se quisesse uma variável específica
                myLabel.setText("Deseja comer: "+myListView.getSelectionModel().getSelectedItem());
            }
            
        });
        
        // A add.Listener serve para adicionar uma ação (listener) para quando algo ocorre. Nesse caso, para quando alguma opção é selecionada (selectedProperty).
        // O ChangeListener serve para isso, para mostrar que algo foi alterado no node por meio da mudança de valores


    }
    
}
