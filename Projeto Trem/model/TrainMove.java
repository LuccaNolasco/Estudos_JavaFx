package model;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;

public class TrainMove {
    //Trem trem;

    
    public void moveInstruct(Train train){
        switch(train.getOpt()){
            case 0:
                moveInstruct0(train);
                break;
            case 1:
                moveInstruct1(train);
                break; 
            case 2:
                moveInstruct2(train);
                break;
            case 3:
                moveInstruct3(train);
                break;
            default:
            break;              
        }
    }
    

    
    
    public void moveInstruct0(Train trem){
        if(trem.getImageView().getLayoutY()<=1000 && trem.getImageView().getLayoutY()>=601){
            trem.getImageView().setLayoutY(trem.getImageView().getLayoutY()-trem.getVely());
        } else if (trem.getImageView().getLayoutY()<=600 & trem.getImageView().getLayoutY()>=413){
            trem.getImageView().setRotate(45);
            trem.getImageView().setLayoutY(trem.getImageView().getLayoutY()-trem.getVely());
            trem.getImageView().setLayoutX(trem.getImageView().getLayoutX()+trem.getVelx());
        } else if (trem.getImageView().getLayoutY()<=413 && trem.getImageView().getLayoutY()>=256){
            trem.getImageView().setRotate(0);
            trem.getImageView().setLayoutY(trem.getImageView().getLayoutY()-trem.getVely());
        } else if (trem.getImageView().getLayoutY()<=255 && trem.getImageView().getLayoutY()>=65){
            trem.getImageView().setRotate(-45);
            trem.getImageView().setLayoutY(trem.getImageView().getLayoutY()-trem.getVely());
            trem.getImageView().setLayoutX(trem.getImageView().getLayoutX()-trem.getVelx());
        } else if(trem.getImageView().getLayoutY()<=65 && trem.getImageView().getLayoutY()>=-102 ){
            trem.getImageView().setRotate(0);
            trem.getImageView().setLayoutY(trem.getImageView().getLayoutY()-trem.getVely());
        } else{
            trem.getImageView().setLayoutY(795);
            trem.getImageView().setLayoutX(502);
        }
    }

    public void moveInstruct1(Train trem){
        if(trem.getImageView().getLayoutY()<=1000 && trem.getImageView().getLayoutY()>=601){
            trem.getImageView().setLayoutY(trem.getImageView().getLayoutY()-trem.getVely());
        } else if (trem.getImageView().getLayoutY()<=600 & trem.getImageView().getLayoutY()>=413){
            trem.getImageView().setRotate(-45);
            trem.getImageView().setLayoutY(trem.getImageView().getLayoutY()-trem.getVely());
            trem.getImageView().setLayoutX(trem.getImageView().getLayoutX()-trem.getVelx());
        } else if (trem.getImageView().getLayoutY()<=413 && trem.getImageView().getLayoutY()>=256){
            trem.getImageView().setRotate(0);
            trem.getImageView().setLayoutY(trem.getImageView().getLayoutY()-trem.getVely());
        } else if (trem.getImageView().getLayoutY()<=255 && trem.getImageView().getLayoutY()>=65){
            trem.getImageView().setRotate(+45);
            trem.getImageView().setLayoutY(trem.getImageView().getLayoutY()-trem.getVely());
            trem.getImageView().setLayoutX(trem.getImageView().getLayoutX()+trem.getVelx());
        } else if(trem.getImageView().getLayoutY()<=65 && trem.getImageView().getLayoutY()>=-102 ){
            trem.getImageView().setRotate(0);
            trem.getImageView().setLayoutY(trem.getImageView().getLayoutY()-trem.getVely());
        } else{
            trem.getImageView().setLayoutY(795);
            trem.getImageView().setLayoutX(703);
        }
    }

    public void moveInstruct2(Train trem){
        if(trem.getImageView().getLayoutY()>=-102 && trem.getImageView().getLayoutY()<60){
            trem.getImageView().setLayoutY(trem.getImageView().getLayoutY()+trem.getVely());
        } else if (trem.getImageView().getLayoutY()>=60 && trem.getImageView().getLayoutY()<=250){
            trem.getImageView().setRotate(135);
            trem.getImageView().setLayoutY(trem.getImageView().getLayoutY()+trem.getVely());
            trem.getImageView().setLayoutX(trem.getImageView().getLayoutX()+trem.getVelx());
        } else if(trem.getImageView().getLayoutY()>=253 && trem.getImageView().getLayoutY()<417){
            trem.getImageView().setRotate(180);
            trem.getImageView().setLayoutY(trem.getImageView().getLayoutY()+trem.getVely());
        } else if (trem.getImageView().getLayoutY()>=418 && trem.getImageView().getLayoutY()<600){
            trem.getImageView().setRotate(-135);
            trem.getImageView().setLayoutY(trem.getImageView().getLayoutY()+trem.getVely());
            trem.getImageView().setLayoutX(trem.getImageView().getLayoutX()-trem.getVelx());
        } else if (trem.getImageView().getLayoutY()>=603 && trem.getImageView().getLayoutY()<800){
            trem.getImageView().setRotate(180);
            trem.getImageView().setLayoutY(trem.getImageView().getLayoutY()+trem.getVely());
        } else{
            trem.getImageView().setLayoutY(-102);
            trem.getImageView().setLayoutX(496);
        }
    }

    public void moveInstruct3(Train trem){
        if(trem.getImageView().getLayoutY()>=-102 && trem.getImageView().getLayoutY()<60){
            trem.getImageView().setLayoutY(trem.getImageView().getLayoutY()+trem.getVely());
        } else if (trem.getImageView().getLayoutY()>=60 && trem.getImageView().getLayoutY()<=250){
            trem.getImageView().setRotate(-135);
            trem.getImageView().setLayoutY(trem.getImageView().getLayoutY()+trem.getVely());
            trem.getImageView().setLayoutX(trem.getImageView().getLayoutX()-trem.getVelx());
        } else if(trem.getImageView().getLayoutY()>=253 && trem.getImageView().getLayoutY()<417){
            trem.getImageView().setRotate(180);
            trem.getImageView().setLayoutY(trem.getImageView().getLayoutY()+trem.getVely());
        } else if (trem.getImageView().getLayoutY()>=418 && trem.getImageView().getLayoutY()<600){
            trem.getImageView().setRotate(135);
            trem.getImageView().setLayoutY(trem.getImageView().getLayoutY()+trem.getVely());
            trem.getImageView().setLayoutX(trem.getImageView().getLayoutX()+trem.getVelx());
        } else if (trem.getImageView().getLayoutY()>=603 && trem.getImageView().getLayoutY()<800){
            trem.getImageView().setRotate(180);
            trem.getImageView().setLayoutY(trem.getImageView().getLayoutY()+trem.getVely());
        } else{
            trem.getImageView().setLayoutY(-102);
            trem.getImageView().setLayoutX(703);
        }
    }

    public boolean isInDanger(Train trem, Circle danger){
       if(trem.getImageView().getBoundsInParent().intersects(danger.getBoundsInParent())){
        return true;
       }
        return false;
    }
  
}
