package model;

public class DataSingleton {
    public static final DataSingleton instance = new DataSingleton();

    DataSingleton(){}

    public static DataSingleton getInstance(){
        return instance;
    }

    private int opt = 0;

    public int getOpt() {
        return opt;
    }

    public void setOpt(int escolha) {
        this.opt = escolha;
    }
}
