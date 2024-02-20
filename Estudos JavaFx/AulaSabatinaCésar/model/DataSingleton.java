package model;

public class DataSingleton {
    public static final DataSingleton instance = new DataSingleton();
    //É uma instância única para todas as telas

    public static DataSingleton getInstance(){
        return instance;
    }
    DataSingleton(){}

    private String choice = "Choice 1"; // A escolha que passaremos no singleton

    public String getChoice() {
        return choice;
    }
    public void setChoice(String choice) {
        this.choice = choice;
    }

}
