package controller;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Controller implements Initializable{
    @FXML
    private Pane pane;
    @FXML
    private Label songLabel;
    @FXML
    private Button playButton, pauseButton, resetButton, previousButton, nexButton;
    @FXML
    private ComboBox<String> speedBox;
    @FXML
    private Slider volumeSlider;
    @FXML
    private ProgressBar songProgressBar;

    private Media media;
    private MediaPlayer mediaPlayer;
    
    private File directory; //Essa variável File irá receber a pasta com as músicas
    private File[] files; 
    private ArrayList<File> songs; //Esse arraylist será a "Playlist"
    private int songNumber; //Para saber em que música estamos
    private int[] speeds = {25,50,75,100};
    private Timer timer; //É o que contabilizará a duração da música e atualizará a Barra de Progresso
    private TimerTask task;
    private boolean running; //True ou False para ver se está tocando música ou não


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        songs = new ArrayList<File>();
        directory= new File("assets");
        files = directory.listFiles();
        //List Files irá guardar cada um dos arquivos numa posição do array files
        
        //E esse for each irá adicionar cada um do array para o ArrayList, que é mais dinâmico
        if (files!=null){
            for(File file: files){
                songs.add(file);
                System.out.println(file);
            }
        }
        //Carrega a mídia do arraylist, com o índice songNumber. Depois pega o endereço (URI) e transforma em String
        media = new Media(songs.get(songNumber).toURI().toString());
        mediaPlayer = new MediaPlayer(media); //Toca a mídia
        songLabel.setText(songs.get(songNumber).getName());

       
        for(int i =0; i<speeds.length;i++){ // Par popular a combobox de speeds
            speedBox.getItems().add(Integer.toString(speeds[i])+"%");
        }
        speedBox.setOnAction(this::changeSpeed); //Passando uma referência ao método changeSpeed, pois ComboBox não possui On Action
        //Ao fazer setOnAction, é preciso que o método tenha um parâmetro ActionEvent event


        //Para configurar o Slider de Volume
        volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                mediaPlayer.setVolume(volumeSlider.getValue()*0.01);
            }
            
        });

        //Mudar a cor da barra de progresso
        songProgressBar.setStyle("-fx-accent: #5ad0c0;");
    }

   
   
    public void playMedia(){
        changeSpeed(null);//Para que a velocidade escolhida no ComboBox se mantenha entre as músicas
        mediaPlayer.setVolume(volumeSlider.getValue()*0.01);
        beginTimer();
        mediaPlayer.play();
    }
    public void pauseMedia(){
        cancelTimer();
        mediaPlayer.pause();
    }
    public void resetMedia(){
        songProgressBar.setProgress(0);//Para resetar a barra de progresso
        mediaPlayer.seek(Duration.seconds(0.0));
    }
    public void previousMedia(){
        if(songNumber>0){
            songNumber--;
            mediaPlayer.stop();

            if(running){ //Para resetar o timer
                cancelTimer();
            }
            
            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            songLabel.setText(songs.get(songNumber).getName());
            playMedia(); //se quiser que a música toque automaticamente após clicar em Next

        } else{
            songNumber=songs.size()-1;
            mediaPlayer.stop();
            if(running){ //Para resetar o timer
                cancelTimer();
            }
            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            songLabel.setText(songs.get(songNumber).getName());
            playMedia();; //se quiser que a música toque automaticamente após clicar em Next

        }
    }
    public void nextMedia(){
        if(songNumber<songs.size()-1){
            songNumber++;
            mediaPlayer.stop();
            if(running){ //Para resetar o timer
                cancelTimer();
            }
            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            songLabel.setText(songs.get(songNumber).getName());
            playMedia(); //se quiser que a música toque automaticamente após clicar em Next

        } else{
            songNumber=0;
            mediaPlayer.stop();
            if(running){ //Para resetar o timer
                cancelTimer();
            }
            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            songLabel.setText(songs.get(songNumber).getName());
            playMedia(); //se quiser que a música toque automaticamente após clicar em Next

        }

    }
    public void changeSpeed(ActionEvent event){
        
        if(speedBox.getValue()==null){//Para que não toque com o valor padrão null
            mediaPlayer.setRate(1);//100% de velocidade
        } else{
            //mediaPlayer.setRate(Integer.parseInt(speedBox.getValue())*0.01); Comentada pois estamos transformando uma string num double
            //Porém nossa string possui uma "%"
            mediaPlayer.setRate(Integer.parseInt(speedBox.getValue().substring(0,speedBox.getValue().length()-1))*0.01);
        }
        
        
    }
    public void beginTimer(){
        timer=new Timer();
        task = new TimerTask() {

            @Override
            public void run() {
                running=true;
                double current=mediaPlayer.getCurrentTime().toSeconds();//O tempo atual em segundos
                double end = media.getDuration().toSeconds();//O tempo final do arquivo de mídia (a duração máxima)
                songProgressBar.setProgress(current/end);//Com essa divisão, o máximo será 100%

                if(current/end==1){ //Para ver se a música acabou
                    cancelTimer(); 
                }
            }
            
        };

        timer.schedule(task, 0,1000);
    }
    public void cancelTimer(){
        running= false;
        timer.cancel();
        songProgressBar.setProgress(0);
    }
}
