import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {  
       /* Se não tivesse um Stage, é assim que se inicia Stage nome = new Stage();*/

       Group root = new Group();
       Scene cena = new Scene(root, Color.BISQUE);// é preciso passar um parâmetro, um node
        
       Image icone = new Image("./assets/buzzTerno.jpg");//Para definir um arquivo de imagem
       primaryStage.getIcons().add(icone); // para definir a o icone como o objeto imagem "icone"
       
       primaryStage.setTitle("My Stage Demo");//coloca o título na janela   
       primaryStage.setWidth(1360);
       primaryStage.setHeight(720);
       primaryStage.setResizable(false);
       primaryStage.setFullScreen(true);
       primaryStage.setFullScreenExitHint("Não escapará, apenas que aperte q");
       primaryStage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));

       //primaryStage.setX(50); Define a posição na tela ao ser iniciado
       //primaryStage.setY(50);

       primaryStage.setScene(cena);//Para setar a scene no stage. Como se fosse adicionar os componentes da Peça de teatro.
      
       /* Deve ser sempre ao fim do Stage, para lançá-lo na tela. Iniciar a peça */
       primaryStage.show();
    }
    
}
