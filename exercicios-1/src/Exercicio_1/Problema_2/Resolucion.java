package Exercicio_1.Problema_2;

import java.util.Scanner;

public class Resolucion {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int cant_estudiantes = read.nextInt();
        read.nextLine();
        String estudiantes[] = new String[cant_estudiantes];
        for (int x = 0; x < estudiantes.length; x++) {
            String dato_completo = read.nextLine();
            estudiantes[x] = dato_completo;
        }


        for (int x = 0; x < estudiantes.length; x++) {
            estudiantes[x] = estudiantes[x].replace(" ", "-");
        }


        double posicion[] = new double[cant_estudiantes];
        for (int x = 0; x < cant_estudiantes; x++) {
            String Split_dato_completo[] = estudiantes[x].split("-");
            posicion[x] = Double.parseDouble(Split_dato_completo[2]);
        }
        for (int x = 0; x < posicion.length; x++) {
            for (int y = x; y < posicion.length; y++) {
                if (posicion[x] < posicion[y]) {
                    double aux;
                    aux = posicion[y];
                    posicion[y] = posicion[x];
                    posicion[x] = aux;
                }
            }
        }

        for (int x = 0; x < posicion.length; x++) {
            for (int y = x; y < posicion.length; y++) {
                String Split_estudiantes[] = estudiantes[y].split("-");
                double media_estudiante = Double.parseDouble(Split_estudiantes[2]);
                if (posicion[x] == media_estudiante) {
                    String auxiliar_estudiante = estudiantes[y];
                    estudiantes[y] = estudiantes[x];
                    estudiantes[x] = auxiliar_estudiante;
                }
            }
        }


        for (int x = 0; x < cant_estudiantes; x++) {
            System.out.println(estudiantes[x]);
        }


    }


}
