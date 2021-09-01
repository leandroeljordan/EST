package Problema_1;

import java.util.*;

public class Resolucion {
    public static void main(String []args){
        Scanner read = new Scanner(System.in);
        int x =read.nextInt();
        read.nextLine();
        String [] nombres = new String[x];
        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////INGRESO DE NOMBRES EN STRING NOMBRES///////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        for(int y =0; y < x; y++){
            String nombre = read.nextLine();
            nombre.toLowerCase();
            int telefono = read.nextInt();
            read.nextLine();
            nombre = nombre +"="+Integer.toString(telefono);
            nombres[y] = nombre;
            nombres[y]=nombres[y].replace(" ","-");
        }//FIN FOR GUARDADO DE NOMBRES
        read.reset();

        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////BUSCA DE NOMBRES EN STRING NOMBRES/////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////

        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////RELLENAMOS UN ARRAYLIST CON LOS NOMBRES QUE SE REALIZARAN LA BUSQUEDA/////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////

        boolean continuar = true;
        ArrayList<String> busca_nombres = new ArrayList<String>();
        while((read.hasNextLine()) && (continuar == true)){
            String delimitador= read.nextLine();
            if(delimitador.contentEquals("salir")){
                continuar = false;
            }
            else{
                busca_nombres.add(delimitador);
            }
        }
        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        //GUARDAMOS EL ARRAYLIST DE BUSCA EN UNA STRING CON TAMAÑO LIMITADO POR LA CANTIDAD DE INGRESOS EN EL ARRAYLIST
        //////////////////////////////////////////////////////////////////////////////////////////////////////////

        String buscar_nombre [] = new String[busca_nombres.size()];
        int cant_busca = 0;
        for(String muestra: busca_nombres){
           buscar_nombre[cant_busca] = muestra;
           buscar_nombre[cant_busca] = buscar_nombre[cant_busca].replace(" ","-");
            cant_busca ++;
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////PADRONIZAMOS EL STRING PARA BUSCAR POR NOMBRE Y APELLIDO SEPARADO///////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////

        for(int o = 0; o < buscar_nombre.length;o++){
            buscar_nombre[o]= buscar_nombre[o].replace(" ","-");
        }
        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////COMENZAMOS BUSCA SEPARANDO LOS STRING POR NOMBRE Y APELLIDO//////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////

        for(int tamano_busca = 0; tamano_busca < buscar_nombre.length; tamano_busca ++){
            boolean no_existe = true;
            boolean continuar_busca = true;
            boolean confirmacion = false;
            String Split_buscar_nombre [] = buscar_nombre[tamano_busca].split("-");
                        //AQui tomamos el String con los nombres de entrada para la busca

             int string_nombre_completo = 0;

                        //Comenzamos la busca en donde el While se cierra caso se encuentre el nombre de busca
            while((continuar_busca  == true)&& (string_nombre_completo < nombres.length)){
                String Split_original_name[] = nombres[string_nombre_completo].split("-");

                        /////////////////////////////////////////////////
                        ///VERIFICAMOS EL NOMBRE EN LOS DOS LUGARES//////
                        ///TANDO POR NOMBRE EN EL LUGAR DEL APELLIDO////
                        ///COMO DE APELLIDO EN EL LUGAR DEL NOMBRE///////
                        ///////////////////////////////////////////////

                if(Split_original_name[0].contains(Split_buscar_nombre[0])){
                        no_existe = false;
                    }
                    else if(Split_original_name[0].contains(Split_buscar_nombre[1])){
                        no_existe = false;
                    }
                    else if(Split_original_name[1].contains(Split_buscar_nombre[0])){
                        no_existe = false;
                    }
                    else if(Split_original_name[1].contains(Split_buscar_nombre[1])) {
                        no_existe = false;
                    }
                    if(no_existe == true){
                        confirmacion = true;
                    }
                    else {
                        System.out.println(nombres[string_nombre_completo]);
                        continuar_busca = false;
                        confirmacion = false;
                    }
                    string_nombre_completo ++;

            }//FIN WHILE
            if(confirmacion == true){
                System.out.println("No Encontrado");
            }

        } //FIN FOR DE BUSCA

    }
}
