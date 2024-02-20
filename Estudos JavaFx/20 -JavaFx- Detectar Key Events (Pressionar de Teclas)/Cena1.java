import controller.Controller;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Cena1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("./view/scene.fxml"));
        Parent root = loader.load();
        
        Controller controller = loader.getController(); //Criando instância do controller no main. É NECESSÁRIO QUE O CONTROLLER ESTEJA DEFINIDO NO FXML CORRESPONDENTE
        Scene cena = new Scene(root);
        
        //Criaremos agora um anonymous event handler para a scene
        cena.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                switch(event.getCode()){
                    case UP:
                        controller.moveUp();
                        break;
                    case DOWN:
                        controller.moveDown();
                        break;   
                    case LEFT:
                        controller.moveLeft();
                        break;    
                    case RIGHT:
                        controller.moveRight();
                        break;
                    default:
                        break;        
                }
            }
            
        });


        //Também podemos fazer isso numa função Lambda
        /*
         * cena.setOnKeyPressed(event-> {
         * 
                switch(event.getCode()){
                    case UP:
                        controller.moveUp();
                        break;
                    case DOWN:
                        controller.moveDown();
                        break;   
                    case LEFT:
                        controller.moveLeft();
                        break;    
                    case RIGHT:
                        controller.moveRight();
                        break;
                    default:
                        break;        
                }  
        });
         */
        
        primaryStage.setScene(cena);
        //primaryStage.setResizable(false);
        primaryStage.show();
    }
}