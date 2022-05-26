package Exercicios_Aula_4;
import java.util.*;
public class FabricaLampada {

    public static class Incandescente implements Lampada{
        @Override
        public void ligar_lampada() {
            System.out.println("Lampada Incandescente...");
            ligar();
        }

        @Override
        public void desligar_lampada() {
            System.out.println("Lampada Incandescente...");
            desligar();
        }



    }

    public static class Fluorescente implements Lampada{
        @Override
        public void ligar_lampada() {
            System.out.println("Lampada Fluorescente...");
            ligar();
        }

        @Override
        public void desligar_lampada() {
            System.out.println("Lampada Fluorescente...");
            desligar();
        }
    }

    private static void ligar(){
        System.out.println("Lampada Ligada...");
    }
    private static void desligar(){
        System.out.println("Lampada Desligada....");

    }


}
