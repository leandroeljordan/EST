package ERP_System;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.LinkedList;

public class Inicial {



        private static String [] LISTA_DE_DATOS;
            public  String[] getLISTA_DE_DATOS() {
                return LISTA_DE_DATOS;
            }
            public void setLISTA_DE_DATOS(String[] LISTA_DE_DATOS) {
                this.LISTA_DE_DATOS = LISTA_DE_DATOS;
            }

        protected static LinkedList<Productos> lista_productos = new LinkedList<Productos>();

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

        //**************************************************************************//
        Lista_modificacion();
        //Creamos la lista con los productos y la cantidad
        //**************************************************************************//
        boolean repetir = true;
        while(repetir == true) {

            //Presentacion Menu

            System.out.println("\t\t\tMenu Lectura Archivo CSV");
            System.out.println("Ingrese una de las opciones...");
            System.out.println("\t1: Buscar Por Código\n\t" +
                                       "2: Buscar Por Nombre\n\t" +
                                       "3: Agregar Producto al Stock\n\t"+
                                       "4: Eliminar Producto del Stock\n\t"+
                                       "5: Busca Binaria Productos\n\t"+
                                       "0: Salir");




            int menu = new Scanner(System.in).nextInt();
            if((menu == 1) ||( menu == 2) || (menu == 0) || (menu == 3) || (menu == 4)  || (menu == 5)){

                switch (menu) {
                    case 1://Buscar Producto por Código
                        B_P.B_P_C();
                        break;

                    case 2:B_P.B_P_N();
                        //Buscar Producto por Nombre
                        break;
                    case 3:agregar_a_lista_productos();

                        break;
                    case 4:eliminar_de_lista_productos();
                        break;

                    case 5:busca_binaria();
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

        /*
        for(int x =0 ; x < lista_productos.size(); x++) {
            System.out.println(lista_productos.get(x).getCantidad());

        }

            for(int x=0; x < LISTA_DE_DATOS.length;x++){
                System.out.println(LISTA_DE_DATOS[x]);
            }

             */




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



    public static void Lista_modificacion(){

            //Creamos una lista donde ejecutaremos para ingreso de productos...
        Random ram = new Random();
        LocalDate Fecha_ingreso = LocalDate.parse("1997-01-01");
        int cantidad_productos;                                                         //
        for(int x =1 ; x < LISTA_DE_DATOS.length; x++){
            String Parte_Datos [] = LISTA_DE_DATOS[x].split(",");
            Parte_Datos[0] = Parte_Datos[0].replace("[","");
            int id = Integer.parseInt(Parte_Datos[0]);
            Productos producto = new Productos();
            cantidad_productos = ram.nextInt(100);
            producto.crear_Producto(LISTA_DE_DATOS[x],id,cantidad_productos,Fecha_ingreso);
            Fecha_ingreso = Fecha_ingreso.plusDays(1);
            lista_productos.add(producto);
        }


    }


    public static void eliminar_de_lista_productos(){
        System.out.println("Apartado de eliminacion de productos...\n" +
                                   "Ingrese el id del Producto: ");
        int id = new Scanner(System.in).nextInt();
        String respuesta = (consultar_existencia_y_cantidad(id));

        String Partes_respuesta [] = respuesta.split(",");
        int index_de_lista = Integer.parseInt(Partes_respuesta[3]);

        if(Partes_respuesta[0].contains("True")){
            String respaldo = lista_productos.get(index_de_lista).getDatos();
            System.out.print("Ingrese la Cantidad de Productos que desea Eliminar de este Producto: ");
            int cantidad = new Scanner(System.in).nextInt();
            int ctp = lista_productos.get(index_de_lista).getCantidad();
            int salir = 9;
            if(cantidad > ctp) {
                System.out.println("Cantidad a retirar mayor a disponible en Stock\n" +
                                           "Desea asimismo eliminar todo el stock de este producto?\n" +
                                           "1: Si\t0: NO");


                        boolean continuar = false;
                        while (continuar == false){
                            try {
                                salir = new Scanner(System.in).nextInt();
                                if (!(salir == 1) && !(salir == 0)) {
                                    System.out.println("Ingreso Únicamente 1 o 0");
                                    continuar = false;
                                }
                                else {
                                    continuar = true;
                                }

                            } catch (InputMismatchException e) {
                                System.out.println("Error en el Tipo de opción\n Indique solo valores numericos");
                                continuar = false;
                            }
                        }//FIN WHILE

                if(salir == 1){
                    lista_productos.get(index_de_lista).setCantidad(0);
                }

            }//FIN IF CANT > CTP

        else if(cantidad < ctp){
            int cambio = ctp - cantidad;
            lista_productos.get(index_de_lista).setCantidad(cambio);
            System.out.println("\n\nElementos retirados de la Lista...\n" +
                                    respaldo+
                                "\nCantidad retirada: "+ cantidad
                                +"\nCantidad restante: "+cambio);
        }
    }

}

    public static void agregar_a_lista_productos(){
        System.out.println("Apartado de incremento de inventario...\n" +
                                   "Ingrese el id del Producto: ");
        int id = new Scanner(System.in).nextInt();
        String respuesta = (consultar_existencia_y_cantidad(id));

        String Partes_respuesta [] = respuesta.split(",");
        int index_de_lista = Integer.parseInt(Partes_respuesta[3]);

        if(Partes_respuesta[0].contains("True")){
            String respaldo = lista_productos.get(index_de_lista).getDatos();
            System.out.print("Ingrese la Cantidad de Productos que desea Agregar de este Producto: ");
            int cantidad = new Scanner(System.in).nextInt();
            int ctp = lista_productos.get(index_de_lista).getCantidad();
            boolean continuar = true;



            while (continuar == true) {
                if (cantidad > 20) {
                    System.out.println("No es posible agregar mas de 20 unidades del producto..." +
                                               "\n Favor ingrese una cantidad válidad, comprendida enter 1 y 20");
                    cantidad = new Scanner(System.in).nextInt();
                    continuar = true;
                }
                else if(ctp >= 100){
                    System.out.println("No es posible agregar más de 100 unidades de productos al stock");
                    cantidad = new Scanner(System.in).nextInt();

                }
                else if((ctp + cantidad) > 100){
                    System.out.println("Debido a que el aumento al stock llega al máximo permitido\n será incrementado el stock al máximo permitido descartando los excedentes...");
                    lista_productos.get(index_de_lista).setCantidad(ctp+cantidad);
                    continuar = false;
                }
                else{
                    int resultado = ctp + cantidad;
                    lista_productos.get(index_de_lista).setCantidad(resultado);
                    System.out.println("Producto: "+lista_productos.get(index_de_lista).getDatos()+
                            "\nCantidad Anterior: "+ctp+
                            "\nCantidad Agregada: "+cantidad+
                            "\nCantidad Total: "+lista_productos.get(index_de_lista).getCantidad());
                    continuar = false;
                }

            }



        }

    }

    public static String consultar_existencia_y_cantidad(int id){
        String retorno = "";
        int x =0;
        boolean continuar = true;
        while(x < lista_productos.size() && continuar == true){
            if(lista_productos.get(x).getId() == id){
                retorno = "True,"+lista_productos.get(x).getCantidad()+","+lista_productos.get(x).getFecha_ingreso()+","+x;
                continuar = false;
            }
            else {
                retorno = "False"+lista_productos.get(x).getId();
                x ++;
            }
        }


        return retorno;
    }


    public static void busca_binaria(){
        System.out.println("Ingrese el Id a buscar de forma binaria: ");
        int id= new Scanner(System.in).nextInt()-1;
        boolean encontrado = false;
        int busca_binaria[] = new int[lista_productos.size()];



        if(Arrays.binarySearch(busca_binaria,id) > 0) {
            System.out.println("Datos:  "+lista_productos.get(id).getDatos()+
                               "\nCantidad de Producto: "+lista_productos.get(id).getCantidad()+
                                "\nFecha Ingreso: "+lista_productos.get(id).getFecha_ingreso());
        }else{
            System.out.println("No Encontrado");
        }




    }

}
