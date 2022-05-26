package Prueba;

public class Prova {
    public Prova(){
        System.out.println("ABC");
    }

    public Prova(String x){
        System.out.println(x);
    }

    public static void inicia(){
        Prova p = new Prova("123");
    }

    public static void main(String[] args) {
        inicia();
        Prova p = new Prova();

    }
}
