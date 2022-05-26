package Avaliçao_2_Parte_2;

public class Producto {
    private int Id;
    private String nombre;
    private int Cantidiad;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidiad() {
        return Cantidiad;
    }

    public void setCantidiad(int cantidiad) {
        Cantidiad = cantidiad;
    }

    public void crear_producto(String Nombre,int id,int cantidad){
        this.nombre = Nombre;
        this.Id = id;
        this.Cantidiad = cantidad;
    }





}
