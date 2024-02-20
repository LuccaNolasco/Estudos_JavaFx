import controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Carrega o arquivo FXML da cena
        FXMLLoader loader = new FXMLLoader(getClass().getResource("./view/scene.fxml"));
        Parent root = loader.load();

        // Obtém a referência para o controlador da cena
        Controller controller = loader.getController();

        // Cria a cena com o root carregado do FXML
        Scene cena = new Scene(root, 1360, 720);

        // Configura o handler de eventos de tecla na cena
        cena.setOnKeyPressed(event -> controller.onKeyPressed(event));
        //cena.setOnKeyReleased(event ->controller.setOnKeyReleased(event));
        // Define a cena no palco e exibe o palco
        primaryStage.setScene(cena);
        primaryStage.show();
    }
}
