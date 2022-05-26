package ERP_System;

import java.time.LocalDate;

public class Productos {
    private String Datos;
    private int Id;
    private int cantidad;
    private LocalDate Fecha_ingreso = LocalDate.parse("2010-01-01");

    public String getDatos() {
        return Datos;
    }

    public void setDatos(String datos) {
        Datos = datos;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void crear_Producto(String Datos,int id,int cantidad,LocalDate fecha_ingreso){
        this.Datos = Datos;
        this.Id = id;
        this.cantidad = cantidad;
        this.Fecha_ingreso = fecha_ingreso;

    }

    public LocalDate getFecha_ingreso() {
        return Fecha_ingreso;
    }

    public void setFecha_ingreso(LocalDate fecha_ingreso) {
        Fecha_ingreso = fecha_ingreso;
    }
}
