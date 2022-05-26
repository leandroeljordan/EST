package Pruebas_Thread;

public class Cliente {
    private String nombre;
    private int[] carroCompra;

    public Cliente(String s, int[] ints) {
        this.nombre = s;
        this.carroCompra = ints;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        
    }

    public int[] getCarroCompra() {
        return carroCompra;
    }

    public void setCarroCompra(int[] carroCompra) {
        this.carroCompra = carroCompra;
    }

    // Constructor, getter y setter

}
