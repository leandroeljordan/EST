public class Cadastro_Conductores {
    private String Nombre;
    private String Tipo_Habilitacion;
    private String fecha_nacimiento;




    //**************************************************************//
    //**************************************************************//
    //******************     SETTERS    ****************************//
    //**************************************************************//
    //**************************************************************//

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setTipo_Habilitacion(int tipo_habilitacion) {
        if(tipo_habilitacion == 1){
            this.Tipo_Habilitacion = "MOTO";
        }
        else if (tipo_habilitacion == 2){
            this.Tipo_Habilitacion = "AUTO";
        }
        else if (tipo_habilitacion == 3) {
            this.Tipo_Habilitacion = "CAMION";
        }
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    //**************************************************************//
    //**************************************************************//
    //******************    GETTERS     ****************************//
    //**************************************************************//
    //**************************************************************//

    public String getNombre() {
        return Nombre;
    }

    public String getTipo_Habilitacion() {
        return Tipo_Habilitacion;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }


    //**************************************************************//
    //**************************************************************//
    //***************  CONSTRUCTORES  ******************************//
    //**************************************************************//
    //**************************************************************//

    public void crear_conductor (String nombre,int tipo_habilitacion,String fecha_nacimiento){
        this.Nombre = nombre;
        setTipo_Habilitacion(tipo_habilitacion);
        this.fecha_nacimiento = fecha_nacimiento;
    }
}




public class Cadastro_Vehiculos {
    private String Placa;
    private String Color;
    private int ano;




    //**************************************************************//
    //**************************************************************//
    //**************** SETTERS  ************************************//
    //**************************************************************//
    //**************************************************************//

    public void setPlaca(String placa) {
        Placa = placa;
    }

    public void setColor(String color) {
        Color = color;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }


    //**************************************************************//
    //**************************************************************//
    //************** GETTERS   *************************************//
    //**************************************************************//
    //**************************************************************//


    public String getPlaca() {
        return Placa;
    }

    public String getColor() {
        return Color;
    }

    public int getAno() {
        return ano;
    }


    //**************************************************************//
    //**************************************************************//
    //************** CONSTRUCTORS **********************************//
    //**************************************************************//
    //**************************************************************//

    public void consultar_multa_por_placa(){

    }

}



import java.util.ArrayList;
import java.util.Scanner;
public class Cadastro_Propietarios {
    private String Tipo;
    private String Nombre;
    private String Documento;
    private ArrayList<String> Vehiculos_que_es_dueno;



    //**************************************************************//
    //**************************************************************//
    //**************************************************************//
    //**************************************************************//
    //**************************************************************//

    public void setTipo(int tipo_documento) {
        if(tipo_documento == 1){
            this.Tipo = "CPF";
        }
        else if(tipo_documento == 2){
            this.Tipo = "CNPJ";
        }
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setDocumento(String documento) {
        Documento = documento;
    }

    public void setVehiculos_que_es_dueno(String vehiculos_que_es_dueno) {
        this.Vehiculos_que_es_dueno.add(vehiculos_que_es_dueno);
    }

    //**************************************************************//
    //**************************************************************//
    //**************************************************************//
    //**************************************************************//
    //**************************************************************//


    public String getTipo() {
        return Tipo;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getDocumento() {
        return Documento;
    }

    public void  getVehiculos_que_es_dueno() {
        for (String Datos : Vehiculos_que_es_dueno) {
            System.out.println(Datos);
        }
    }



    //**************************************************************//
    //**************************************************************//
    //**************************************************************//
    //**************************************************************//
    //**************************************************************//


}




public class Cadastro_Multa {

    private class comprobante_multa_para_vehiculo extends Cadastro_Vehiculos{

    }
    private class comprobante_multa_para_conductor extends Cadastro_Conductores{

    }
    private String Fecha_multa;
    private String Placa_Vehiculo;

}


