package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller implements Initializable {
    
    @FXML
    private TreeView<String> treeView;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TreeItem<String> rootItem = new TreeItem<>("Files", new ImageView(new Image("/assets/cacimbinha.jpeg",20,20,false,false))); // Um item raiz seria o primeiro da árvore. TreeItem é a classe que popula a Tree View
        //Tudo isso depois é para colocar o ícone. Após o endereço, tem o tamanho;
        
        TreeItem<String> branchItem1 = new TreeItem<>("Images");
        TreeItem<String> branchItem2 = new TreeItem<>("Videos");
        TreeItem<String> branchItem3 = new TreeItem<>("Music");

        TreeItem<String> leafItem1 = new TreeItem<>("image1");
        TreeItem<String> leafItem2 = new TreeItem<>("image2");
        TreeItem<String> leafItem3 = new TreeItem<>("video1");
        TreeItem<String> leafItem4 = new TreeItem<>("video2");
        TreeItem<String> leafItem5 = new TreeItem<>("music1");
        TreeItem<String> leafItem6 = new TreeItem<>("music2");

        branchItem1.getChildren().addAll(leafItem1,leafItem2);
        branchItem2.getChildren().addAll(leafItem3,leafItem4);
        branchItem3.getChildren().addAll(leafItem5,leafItem6);


        rootItem.getChildren().addAll(branchItem1,branchItem2,branchItem3); //Para adicionar os filhos a rootItem

        //treeView.setShowRoot(false); //para caso queira que o root comece invisível
        treeView.setRoot(rootItem);
    }
    
    
    public void selectItem(){
         TreeItem<String> item= treeView.getSelectionModel().getSelectedItem();
         if(item!= null){ //Se clicar nas setinhas antes de nada, o item será null
            System.out.println(item.getValue());
         }
     }

    
    
    
}
