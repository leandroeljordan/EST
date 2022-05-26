package ERP_System;

public class Nodo_Arbol {
    int numero;
    String producto;
    Nodo_Arbol Hijo_Izquierdo,Hijo_Derecho;
    int izq,der,Nodo_padre;

    public Nodo_Arbol(int id, String producto){
        this.numero = id;
        this.producto = producto;
        this.Hijo_Derecho = null;
        this.Hijo_Izquierdo = null;

    }



    public String toString(){
        return "Nodo: "+numero + "\nProducto: "+producto+"\nSus Hijos:\n\t IZQ: "+Hijo_Izquierdo+"\n\tDER: "+Hijo_Derecho;
    }
}
