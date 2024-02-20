package controller;

import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.net.URL;
import java.util.ResourceBundle;
import model.DataSingleton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import model.Train;
import model.TrainMove;

public class Controller2 implements Initializable {
    
    private Train train1,train2;//Os trens
    private TrainMove trainMove;//O que moverá os trens
    private Boolean train1InDanger1F = false;
    private Boolean train1InDanger2F = false;
    private Boolean train2InDanger1F = false;
    private Boolean train2InDanger2F = false;
    private Boolean danger1;
    private Boolean danger2;

    DataSingleton data = DataSingleton.getInstance();

    @FXML
    ImageView imageTrem1, imageTrem2;
    @FXML
    Circle dangerZone1, dangerZone2;
    @FXML
    Slider speedTrem1, speedTrem2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        switch(data.getOpt()){
            case 0:
                train1 = new Train(imageTrem1, 0);
                train2 = new Train(imageTrem2, 1);
                break;
            case 1:
                train1 = new Train(imageTrem1, 0);
                train2 = new Train(imageTrem2, 3);
                break;
            case 2:
                train1 = new Train(imageTrem1, 1);
                train2 = new Train(imageTrem2, 2);
                break;
            case 3:
                train1 = new Train(imageTrem1, 2);
                train2 = new Train(imageTrem2, 3);
                break; 
            default:
                break;       
        }

        trainMove= new TrainMove(); //Estabelece movimento do Trem 1

        speedTrem1.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                train1.setVelx(speedTrem1.getValue());
                train1.setVely(speedTrem1.getValue());
            }
            
        });

        speedTrem2.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                train2.setVelx(speedTrem2.getValue());
                train2.setVely(speedTrem2.getValue());
            }
            
        });
    
        startInitial.start();
    }
    
    
    AnimationTimer startInitial = new AnimationTimer() {

        @Override
        public void handle(long now) {
            dangerZoneDetecter();
        }
        
    };
    
    AnimationTimer trainStarter1 = new AnimationTimer() {

        @Override
        public void handle(long now) {
            train1.setVelx(speedTrem1.getValue());
            train1.setVely(speedTrem1.getValue());
            trainMove.moveInstruct(train1);
        }
        
    };

    AnimationTimer trainStarter2 = new AnimationTimer() {

        @Override
        public void handle(long now) {
            train2.setVelx(speedTrem2.getValue());
            train2.setVely(speedTrem2.getValue());
            trainMove.moveInstruct(train2);
        }
        
    };

    public void dangerZoneDetecter(){
        
        //pra ver que trem entrou primeiro em qual zona
        Boolean train1InDanger1 = trainMove.isInDanger(train1, dangerZone1);
        Boolean train2InDanger1 = trainMove.isInDanger(train2, dangerZone1);

        Boolean train1InDanger2 = trainMove.isInDanger(train1, dangerZone2);
        Boolean train2InDanger2 = trainMove.isInDanger(train2, dangerZone2);

        if (train1InDanger1 && train2InDanger1){ // Ambos na Danger Zone 1
            if(train1InDanger1F && !train2InDanger1F){ //Trem 1 entrou primeiro
                trainStarter2.stop();
            } else if (train2InDanger1F && !train1InDanger1F){// Trem 2 entrou primeiro
                trainStarter1.stop();
            }
            danger1 = true;
        }else{
            if(train1InDanger1){
                train1InDanger1F = true;
                train2InDanger1 = false;
            } else{
                train1InDanger1F = false;
            }
            if(train2InDanger1){
                train2InDanger1F = true;
                train1InDanger1 = false;
            } else{
                train2InDanger1F = false;
            }
            danger1 = false;
        }

        if(train1InDanger2 && train2InDanger2){ // Ambos na Danger Zone 2
            if(train1InDanger2F && !train2InDanger2F){
                trainStarter2.stop();
            } else if(train2InDanger2F && !train1InDanger2F){
                trainStarter1.stop();
            }
            danger2=true;
        }else{
            if(train1InDanger2){
                train1InDanger2F = true;
                train2InDanger2 = false;
            } else{
                train1InDanger2F = false;
            }
            if(train2InDanger2){
                train2InDanger2F = true;
                train1InDanger2 = false;
            } else{
                train2InDanger2F = false;
            }
            danger2 = false;
        }
        if(!danger1 && !danger2){
            trainStarter1.start();
            trainStarter2.start();
        }
    }
    
    
}
