package ERP_System;

import java.util.Scanner;

public class B_P {
    //Estructura Datos:  [  Id,                                 00
    //                      prices.amountMax,                   01
    //                      prices.amountMin,                   02
    //                      prices.availability,                03
    //                      prices.condition,                   04
    //                      prices.currency,                    05
    //                      prices.dateSeen,                    06
    //                      prices.isSale,                      07
    //                      prices.merchant,                    08
    //                      prices.shipping,                    09
    //                      prices.sourceURLs,                  10
    //                      asins,                              11
    //                      brand,                              12
    //                      categories,                         13
    //                      dateAdded,                          14
    //                      dateUpdated,                        15
    //                      ean,                                16
    //                      imageURLs,                          17
    //                      keys,                               18
    //                      manufacturer,                       19
    //                      manufacturerNumber,                 20
    //                      name,                               21
    //                      primaryCategories,                  22
    //                      sourceURLs,                         23
    //                      upc,                                24
    //                      weight,                             25
    //                      Column1,                            26
    //                      _1,                                 27
    //                      _2,                                 28
    //                      _3,                                 29
    //                      _4]                                 30

    //***********************************************************************************//
    //***********************************************************************************//
    //***********************************************************************************//
    //***********************************************************************************//
    //**************BUSCA POR CODIGO (B_P_C)*********************************************//


    public static void B_P_C(){
        Inicial productos = new Inicial();                  //Accedemos al objeto
        System.out.print("Ingrese el Código a buscar: ");
        int codigo = new Scanner(System.in).nextInt();      //Código del producto
        boolean encontrado = false;                         //Limitador de búsqueda
        String lista_productos [] = productos.getLISTA_DE_DATOS();
        int x =1;

        while((encontrado == false) && codigo < lista_productos.length) {
            String Split_lista_productos[] = lista_productos[x].split(",");
            Split_lista_productos[0] = Split_lista_productos[0].replace("[", "");


            if (Integer.parseInt(Split_lista_productos[0]) == codigo) {
                encontrado = true;

            } else {
                x++;
            }
        }

            if(encontrado == true){
                System.out.println(lista_productos[x]);
            }else{
                System.out.println("Producto no encontrado... informe un nuevo id");
            }




    }


    //***********************************************************************************//
    //***********************************************************************************//
    //***********************************************************************************//
    //***************BUSCA POR NOMBRE (B_P_N)***************************************************//
    //***********************************************************************************//
    public static void B_P_N(){
        Inicial productos = new Inicial();
        String lista_productos [] = new String[productos.getLISTA_DE_DATOS().length];
        boolean encontrado = false;

        for(int x =0; x < lista_productos.length;x++){
            lista_productos[x]= productos.getLISTA_DE_DATOS()[x];
        }

        System.out.print("Ingrese el Nombre a Buscar: ");
        String name = new Scanner(System.in).nextLine();
        Mostrar_Nombres(name);


        /*
        int y =1;

        while ((encontrado == false)&& y < lista_productos.length){
            String Split_lista_productos [] = lista_productos[y].split(",");
            if(Split_lista_productos[21].contains(name)){
                System.out.println(lista_productos[y]);
                encontrado = true;
            }
            y++;
        }
        if (encontrado = false){
            System.out.println("Producto no encontrado...");
        }
*/
        
    }

    //***********************************************************************************//
    //***********************************************************************************//
    //***********************************************************************************//
    //***********************************************************************************//

    public static void Mostrar_Nombres(String Nombre) {
        Inicial productos = new Inicial();
        String lista_productos[] = productos.getLISTA_DE_DATOS();
        String Lista_links[] = new String [lista_productos.length];
        boolean producto_encontrado = false;

        for (int x = 1; x < productos.getLISTA_DE_DATOS().length; x++) {
            String Split_nombres[] = lista_productos[x].split(",");
            Split_nombres[0] = Split_nombres[0].replace("[", "");
            boolean url_producto = false;
            int posicion_producto =0;
            String nombre = "";


            for(int y =0; y < Split_nombres.length; y++){
                if((Split_nombres[y].contains("http://"))||(Split_nombres[y].contains("https://"))){
                 url_producto = true;
                 if(posicion_producto <1) {
                     String Split_urls[] = Split_nombres[y].split("/");
                     for (int op = 0; op < Split_urls.length; op++) {
                         if (Split_urls[op].contains("-")) {
                             if(Split_urls[op].contains(Nombre)){
                              System.out.println(lista_productos[x]);
                              producto_encontrado = true;
                             }
                             //System.out.println("Nombre Productos: " + Split_urls[op].replace("-"," ") + "\tCodigo Producto: " + Split_nombres[0]);
                             posicion_producto++;
                         }

                     }
                 }
                }
            }
        }

        if(producto_encontrado == false){
            System.out.println("Producto No Encontrado.");
        }


    }
}
