package Avaliçao_2;
import java.util.*;

public class Simulador_corridas {
    public static void main(String[] args) throws InterruptedException {
        Random ram = new Random();
        int vueltas1 [] = new int[5];
        int vueltas2[] = new int[5];

        for(int x =0; x<5;x++){
            vueltas1[x] = ram.nextInt(5000);
            vueltas2[x] = ram.nextInt(5000);
        }
        Corredor Hamilton = new Corredor();
        Corredor Alonso = new Corredor();
        Hamilton.crear_corredor("Hamilton",vueltas1);
        Alonso.crear_corredor("Fernando Alonso",vueltas2);


        long initialTime = System.currentTimeMillis();
         Carrera current_race1 = new Carrera(5,initialTime,Hamilton);
         Carrera current_race2 = new Carrera(5,initialTime,Alonso);

         current_race1.start();
         current_race2.start();
         Thread.sleep(20000);
         if(Hamilton.tiepo_total < Alonso.tiepo_total){
             System.out.println("\n\n\t\tEl Piloto "+Hamilton.getNombre()+" Es el Vencedor con un tiempo total de: "+(Hamilton.tiepo_total/1000));
         }
         else{
             System.out.println("El Piloto "+Alonso.getNombre()+" Es el Vencedor con un tiempo total de: "+(Alonso.tiepo_total/1000));
         }


    }


}
