package ERP_System;

import java.util.Scanner;

public class Prueba_main_arbol {
    public static void main(String[] args) {
        String producto_name;

        System.out.println("Ejecutando Programa");
        Arbol_Binario arbol = new Arbol_Binario();
        boolean salir = true;
        /*
        for(int x =0; x <100; x++) {
            int nodo =x;
            int izq = (nodo*2)+1;
            int der = (nodo*2)+2;
            int padre = (x-2)/2;
            arbol.prueba_agregar_nodo(nodo, "Prueba_Arbol: " + ( nodo));

        }//FIN FOR
            */
        for(int x=0;x <10; x++){
            System.out.println("Ingresa siguiente nodo....");
            arbol.prueba_agregar_nodo(new Scanner(System.in).nextInt(),"Nodo: "+arbol.raiz);
        }


        System.out.println("Guardado completo");

        arbol.inOrden(arbol.raiz);
    }
}
