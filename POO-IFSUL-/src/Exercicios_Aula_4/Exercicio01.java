package Exercicios_Aula_4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args) {
        boolean continuar = false;
        int tipo_lampara = 0;
        boolean tip_lampara;

        System.out.println("Ingrese el tipo de lámpara que desea crear..."
                            +"\n1: Crear Lámpara Incandescente\n2: Crear Lámpara Fluorescente");



        while(continuar == false) {
            try {
                tipo_lampara = new Scanner(System.in).nextInt();
                continuar = true;
            } catch (InputMismatchException e) {
                System.out.println("Ingrese un tipo Numerico Entero...");
                continuar = false;
            }
        }


        switch (tipo_lampara){
            case 1: tip_lampara = true;
                    construir(tip_lampara);
                break;
            case 2: tip_lampara = false;
                    construir(tip_lampara);
                break;
            default:
                break;

        }



    }


    private static void construir(boolean tipo_lampada){

            if(tipo_lampada == true){
                FabricaLampada.Incandescente Lampara = new FabricaLampada.Incandescente();
                Lampara.ligar_lampada();
                Lampara.desligar_lampada();
            }
            else{
                FabricaLampada.Fluorescente Lampara = new FabricaLampada.Fluorescente();
                Lampara.ligar_lampada();
                Lampara.desligar_lampada();
            }
    }

}
