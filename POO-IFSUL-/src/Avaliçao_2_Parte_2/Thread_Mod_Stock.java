package Avaliçao_2_Parte_2;
import java.util.*;

public class Thread_Mod_Stock extends Thread{
    private long initialTime;
    private Producto producto;
    private boolean agregar;
    private int cant_mod;

    public boolean isAgregar() {
        return agregar;
    }

    public void setAgregar(boolean agregar) {
        this.agregar = agregar;
    }

    public int getCant_mod() {
        return cant_mod;
    }

    public void setCant_mod(int cant_mod) {
        this.cant_mod = cant_mod;
    }


    public long getInitialTime() {
        return initialTime;
    }

    public void setInitialTime(long initialTime) {
        this.initialTime = initialTime;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void instancia_thread(long inicialTime,Producto productto,boolean agregarr,int modificacion){
        this.initialTime = inicialTime;
        this.producto = productto;
        this.agregar = agregarr;
        this.cant_mod = modificacion;

    }

    @Override
    public void run(){
        if(isAgregar() == true){
            agregar_Stock();
        }
        if(isAgregar() == false){
            eliminar_Stock();
        }
        System.out.println("\n\n\nFin Modificacion Stock de "+producto.getNombre());
    }



    private void agregar_Stock(){
        Random ram = new Random();
        for(int y=0; y < getCant_mod(); y++){
            this.ejecutar_tiempo();
            int stock = producto.getCantidiad();
            int new_stock = ram.nextInt(100);
            System.out.println("\n\n\nCantidad del Producto modificada"
                                       +"\n\tCantidad anterior: "+stock
                                       +"\n\tCantidad a agregar: "+new_stock);
            stock = stock + new_stock;
            producto.setCantidiad(stock);
            System.out.println("\tNuevo Stock de Producto "+producto.getNombre()
                                       +"\n\tCantidad: "+producto.getCantidiad());
        }
    }

    private void eliminar_Stock(){
        Random ram = new Random();
        for(int y=0; y < getCant_mod(); y++){
            this.ejecutar_tiempo();
            int stock = producto.getCantidiad();
            int new_stock = ram.nextInt(100);
            System.out.println("\n\n\nCantidad del Producto modificada"
                                       +"\n\tCantidad anterior: "+stock
                                       +"\n\tCantidad a eliminar: "+new_stock);
            stock = stock - new_stock;
            producto.setCantidiad(stock);
            System.out.println("\tNuevo Stock de Producto "+producto.getNombre()
                                       +"\n\tCantidad: "+producto.getCantidiad());
        }
    }
    private void ejecutar_tiempo(){
        Random ram = new Random();
        try{
            Thread.sleep(ram.nextInt(5000));
        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }
}
