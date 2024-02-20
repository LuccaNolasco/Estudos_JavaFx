import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
       launch(args); 
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
       /*
        * Scene é uma superfície de desenho para desenho gráfico e um container para nós de um gráfico.
        */
       
        Group root = new Group();
        Scene cena = new Scene(root,1200,1000,Color.BEIGE);
        Stage stage = new Stage();

        Text text = new Text();// Instanciar texto na tela
        text.setText("Testando");
        //Como estou usando um node root do tipo Group, é preciso manualmente colocar as coordenadas
        text.setX(50);
        text.setY(90);
        text.setFont(Font.font("Lucida Console",50));
        text.setFill(Color.CORAL);

        Line linha = new Line();
        linha.setStartX(57);
        linha.setStartY(12);
        linha.setEndX(591);
        linha.setEndY(98);
        linha.setStrokeWidth(4);
        linha.setStroke(Color.BLACK);
        linha.setOpacity(0.2);

        Rectangle retang = new Rectangle();
        retang.setX(70);
        retang.setY(100);
        retang.setWidth(100);
        retang.setHeight(100);
        retang.setFill(Color.CADETBLUE);
        retang.setStrokeWidth(1.8);
        retang.setStroke(Color.BLACK);
        
        Polygon tri = new Polygon ();
        tri.getPoints().setAll(200.0, 200.0,300.0,350.0,400.0,420.0);
        tri.setFill(Color.CHOCOLATE);

        Circle cir = new Circle();
        cir.setCenterX(123);
        cir.setCenterY(500);
        cir.setRadius(100);
        cir.setFill(Color.DARKGRAY);

        Image imagem = new Image("./assets/buzzTerno.jpg");// Cria um objeto imagem
        ImageView imageView = new ImageView(imagem); // mostra a imagem
        imageView.setX(400);
        imageView.setY(400);

        
        /*O nó root já está ligado à cena. É necessário ligar qualquer outro objeto (nodes) à root. Para isso,
        chamamos o arraylist de filhos do root e adicionamos o objeto
         */
        root.getChildren().add(text);
        root.getChildren().add(linha);
        root.getChildren().add(retang);
        root.getChildren().add(tri);
        root.getChildren().add(cir);
        root.getChildren().add(imageView);

        stage.setScene(cena);
        stage.show();
        
    }
    
}