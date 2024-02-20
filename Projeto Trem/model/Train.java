package model;

import javafx.scene.image.ImageView;

public class Train {
    private double velx=5; //Vel. Inicial do eixo x
    private double vely=5;// Vel. inicial no eixo y
    private ImageView imageView;
    private int opt; //Determina a posição inicial do trem


    public Train(ImageView imageView, int opt){
        this.opt = opt;
        this.imageView = imageView;
        switch (opt){
            case 0:
                imageView.setLayoutX(502);
                imageView.setLayoutY(795);
                break;
            case 1:
                imageView.setLayoutX(703);
                imageView.setLayoutY(796);
                break;
            case 2:
                imageView.setLayoutX(496);
                imageView.setLayoutY(-103);
                imageView.setRotate(180);
                break;
            case 3:
                imageView.setLayoutX(703);
                imageView.setLayoutY(-102);
                imageView.setRotate(180);        
            default:
                break;
        }
    }
    
    public int getOpt() {
        return opt;
    }

    public void setOpt(int opt) {
        this.opt = opt;
    }
    
    public ImageView getImageView() {
        return imageView;
    }
    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
   
    public double getVelx() {
        return velx;
    }
    public void setVelx(double velx) {
        this.velx = velx;
    }
   
    public double getVely() {
        return vely;
    }
    public void setVely(double vely) {
        this.vely = vely;
    }

    
}
