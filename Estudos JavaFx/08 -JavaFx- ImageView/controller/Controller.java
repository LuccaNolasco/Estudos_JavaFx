package controller;

import java.util.ArrayList;

import javafx.fxml.FXML;
//import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {
    ArrayList <Image> imagens = new ArrayList<Image>();
    @FXML
    ImageView imageView;
    private int indiceAtual;
    
    public Controller(){
        imagens.add(new Image(getClass().getResourceAsStream("/assets/bone_helice.png")));
        imagens.add(new Image(getClass().getResourceAsStream("/assets/bone_helice.jpg")));
    }
   
    public void nextIndex(ArrayList <?> lista){
        indiceAtual=(indiceAtual+1)%lista.size();
    }
    
   public void changePic(){
        imageView.setImage(imagens.get(indiceAtual));
        nextIndex(imagens);
        System.out.println(indiceAtual);
     }
}
