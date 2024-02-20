import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("./view/main.fxml"));
        Scene cena = new Scene (root,Color.RED);
        cena.getStylesheets().add(getClass().getResource("./view/application.css").toExternalForm());
        String css= this.getClass().getResource("./view/application.css").toExternalForm();
        cena.getStylesheets().add(css);
        primaryStage.setScene(cena);
        primaryStage.show();
    }

}