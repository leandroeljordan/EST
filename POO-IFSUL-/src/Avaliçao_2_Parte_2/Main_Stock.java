package Avaliçao_2_Parte_2;

import java.util.Random;
import java.util.Scanner;

public class Main_Stock {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Sistema de Stock Almoxarifado...");
        Producto caneta = new Producto();
        Producto caderno = new Producto();
        Producto folhas = new Producto();

        Random ram = new Random();
        caneta.crear_producto("Canetas",ram.nextInt(100), ram.nextInt(500));
        caderno.crear_producto("Cadernos",ram.nextInt(100), ram.nextInt(500));
        folhas.crear_producto("Folhas",ram.nextInt(100), ram.nextInt(500));

        System.out.println("Ingrese cantidad de veces que quiera modificar el Stock...");
        int modificaciones=new Scanner(System.in).nextInt();
        long initialTime = System.currentTimeMillis();

       Thread_Mod_Stock Mod_Stock_1 = new Thread_Mod_Stock();
       Thread_Mod_Stock Mod_Stock_2 = new Thread_Mod_Stock();
       Thread_Mod_Stock Mod_Stock_3 = new Thread_Mod_Stock();


        Mod_Stock_1.instancia_thread(initialTime,caneta,ram.nextBoolean(),modificaciones);
        Mod_Stock_2.instancia_thread(initialTime,caderno,ram.nextBoolean(),modificaciones);
        Mod_Stock_3.instancia_thread(initialTime,folhas,ram.nextBoolean(),modificaciones);


        Mod_Stock_1.start();
        Mod_Stock_2.start();
        Mod_Stock_3.start();

        Thread.sleep(20000);
        System.out.println("\n\n\n\nID\t\tProducto\t\tStock");
        System.out.println(caneta.getId()+"\t\t"+caneta.getNombre()+" \t\t"+ caneta.getCantidiad());
        System.out.println(caderno.getId()+"\t\t"+caderno.getNombre()+"\t\t"+ caderno.getCantidiad());
        System.out.println(folhas.getId()+"\t\t"+folhas.getNombre()+"  \t\t"+ folhas.getCantidiad());

    }
}
