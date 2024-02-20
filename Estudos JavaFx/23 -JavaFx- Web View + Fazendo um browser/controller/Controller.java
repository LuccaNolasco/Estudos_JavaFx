package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class Controller implements Initializable{
    @FXML
    private WebView webView; // Mostra o que a WebEngine faz
    @FXML
    private TextField textField;

    private WebEngine engine; //É o motor da página web em sim


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        engine=webView.getEngine();
        loadPage();
    }
    
    public void loadPage(){
        engine.load("http://"+textField.getText()); //Carrega a página
        System.out.println("Teste");
    }
}
