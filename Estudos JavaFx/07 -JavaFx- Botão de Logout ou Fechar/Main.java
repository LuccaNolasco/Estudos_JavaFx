import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("./view/cena1.fxml"));
        Scene cena = new Scene(root);
        primaryStage.setScene(cena);
        primaryStage.show();

        
        //Para caso a pessoa queira fechar clicando no X ou dando Alt F4
        primaryStage.setOnCloseRequest(event -> { //Função lambda
            event.consume();                //Para consumir o Alt F4 ou o X. Se não houvesse, mesmo clicando em Cancelar, a janela ainda seria fechada
            logout(primaryStage);
        });
    }
    
    
    public void logout (Stage stage){   //Função logout para ser clicada no x
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Desligar");
        alert.setHeaderText("Deseja mesmo sair?");
        alert.setContentText("Deseja salvar antes de sair? ");
       
        if (alert.showAndWait().get() ==ButtonType.OK){
            System.out.println("Desligou com sucesso"); //Aqui não é necessário definir o stage. Ele será recebido por parâmetro
            stage.close();
        }
    }
}