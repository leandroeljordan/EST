package ERP_System;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import scala.Console;

import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class Inicial {

        private static String [] LISTA_DE_DATOS;
            public  String[] getLISTA_DE_DATOS() {
                return LISTA_DE_DATOS;
            }
            public void setLISTA_DE_DATOS(String[] LISTA_DE_DATOS) {
                this.LISTA_DE_DATOS = LISTA_DE_DATOS;
            }



//********************************************************************************************************************//
//********************************************************************************************************************//
//****************************MENU INICIAL****************************************************************************//
//********************************************************************************************************************//
//********************************************************************************************************************//


    public static void main(String[] args) throws IOException {

                //CREAMOS UN OBJETO EN EL MAIN PARA OBTENER EL ACCESO A LOS DATOS ALMACENADOS EN LA CARGA
                Inicial Datos_guardados = new Inicial();
        try{
            Cargar_Datos();
        }catch (Exception e){
            System.out.println("Error Al cargar archivo.\nAsegurece que se encuentre el archivo 'Products.csv' en la carpeta raiz del programa");
        }


        boolean repetir = true;
        while(repetir == true) {

            //Presentacion Menu

            System.out.println("\t\t\tMenu Lectura Archivo CSV");
            System.out.println("Ingrese una de las opciones...");
            System.out.println("\t1: Buscar Por Código\n\t2: Buscar Por Nombre\n\t0: Salir");




            int menu = new Scanner(System.in).nextInt();
            if((menu == 1) ||( menu == 2) || (menu == 0) || (menu == 3)  ){

                switch (menu) {
                    case 1:
                        //Buscar Producto por Código
                        B_P.B_P_C();
                        break;
                    case 2:
                        B_P.B_P_N();
                        //Buscar Producto por Nombre
                        break;
                    case 3:
                        //B_P.Mostrar_Nombres();
                        break;
                        case 0:
                        repetir = false;
                        //Salir
                        break;
                    default:
                        break;

                }//FIN SWITCH
            }//FIN IF
            else{
                System.out.println("Ingrese un valor válido.");
                repetir = true;
            }
            System.out.println("\n\n\n\n\n\n");

        }


        String prueba [] = new String[Datos_guardados.LISTA_DE_DATOS.length];
        System.out.println("Comienza ejecución en el main de la info");
            for (int x = 0; x < prueba.length; x++){
                prueba[x] = Datos_guardados.getLISTA_DE_DATOS()[x];
            }
            for (int x = 0; x < 100; x++){
                System.out.println("Ejecucion en el main::::: "+prueba[x]);
            }




    }




//********************************************************************************************************************//
//********************************************************************************************************************//
//*************************CARGAMOS LOS DATOS DEL CSV*****************************************************************//
//**************************AGREGAMOS A UNA VARIABLE PRIVADA PARA ACCESO EN LA CLASE**********************************//
//********************************************************************************************************************//
//********************************************************************************************************************//



    public static void Cargar_Datos () throws IOException{

        String sCarpAct = System.getProperty("user.dir");            //OBTENEMOS LA UBICACION DE LA RAIZ DE PROGRAMA
        //System.out.println("Carpeta: "+sCarpAct+"\\Products.csv"); //VERIFICACIÓN PARA SABER SI ENCUENTRA BIEN LA RUTA
        String fileName = sCarpAct+"\\Products.csv";                 //GUARDAMOS LA RUTA DEL ARCHIVO EN UNA STRING
        ArrayList<String> Lista_Array_Datos = new ArrayList<>();     // SE CREA EL ARRAYLIST PARA FUTURO USO GUANDANDO
                                                                     // LOS DATOS DEL ARCHIVO
//***************************************************************************************************//
//***************************************************************************************************//
//**************************LEEMOS EL ARCHIVO CSV Y LO GUARDAMOS EN UNA ARRAYLIST********************//
//**************************AGREGANDO CADA LINEA DEL ARCHIVO AL ARRAY A MEDIDA QUE SE VAYA LEYENDO***//
//***************************************************************************************************//

        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            List<String[]> r = reader.readAll();
            r.forEach(x -> Lista_Array_Datos.add(Arrays.toString(x)));
        } catch (CsvException e) {
                e.printStackTrace();
            }



//***************************************************************************************************//
//***************************************************************************************************//
//***************************************************************************************************//

            String Lista_Datos_String[]= new String[Lista_Array_Datos.size()];
                    //CREAMOS UNA ARRAY STRING EN PARA UN MEJOR MANEJO
                    //DE LOS DATOS Y ASÍ PODER MODIFICAR Y BUSCAR MAS FACIL EN OPINION PERSONAL
                    //GUARDAMOS LOS DATOS DEL ARRAYLIST AL ARRAY DE STRING
            for(int x =0; x < Lista_Datos_String.length;x++){
            Lista_Datos_String[x] = Lista_Array_Datos.get(x);
            }
//***************************************************************************************************//
//***************************************************************************************************//
//***************************************************************************************************//
            //GUARDAMOS LA LISTA DE LOS DATOS EN UN ATRIBUTO DE LA CLASE
            //ASI TENEMOS ACCESO A ELLA DESDE TODOS LOS LADOS DEL PROGRAMA
            Inicial lista = new Inicial();              //SE CREA EL OBJETO LISTA DE ESTA CLASE
            lista.setLISTA_DE_DATOS(Lista_Datos_String);//ASIGNAMOS LA LISTA GUARDADA ANTERIORMENTE A LA LISTA DEL OBJETO




/*
        //Mostrar Datos Lista y estructura

        for(String Datos: Lista_Datos_String){
            System.out.println(Datos);
        }
        System.out.println("Lugar 0 Estructura Lista Datos:\n"+Lista_Datos_String[0]);
*/


    }




}
