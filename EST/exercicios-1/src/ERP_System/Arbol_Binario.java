package ERP_System;

public class Arbol_Binario {
    Nodo_Arbol raiz;

    public Arbol_Binario(){
        this.raiz = null;
    }

    //Agregando Nodos en Árbol...


    public void prueba_agregar_nodo(int num, String producto){
        Nodo_Arbol nuevo = new Nodo_Arbol(num,producto);
        if(raiz == null){
            raiz = nuevo;
        }else{
            Nodo_Arbol aux = raiz;
            Nodo_Arbol padre;
            while(true){
                padre = aux;
                if((num%2)!=0) {
                    aux = aux.Hijo_Izquierdo;
                    padre.Hijo_Izquierdo = nuevo;
                    return;
                }
                    else if(num%2==0){
                        aux=aux.Hijo_Derecho;
                        padre.Hijo_Derecho=nuevo;
                        return;

                    }
                }
            }



    }



    public boolean vacio(){
        return raiz==null;
    }

    public void inOrden(Nodo_Arbol r){
        if(r!=null){
            inOrden(r.Hijo_Izquierdo);
            System.out.println(r.numero);
            inOrden(r.Hijo_Derecho);
        }
    }




}
