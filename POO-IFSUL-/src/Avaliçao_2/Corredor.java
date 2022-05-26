package Avaliçao_2;

public class Corredor {
    private String nombre;
    private int tiempo_vueltas[];
    int tiepo_total;




    public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int[] getTiempo_vueltas() {
            return tiempo_vueltas;
        }

        public void setTiempo_vueltas(int[] tiempo_vueltas) {
            this.tiempo_vueltas = tiempo_vueltas;
        }
        public void crear_corredor(String nombre, int vueltas[]){
            this.nombre = nombre;
            this.tiempo_vueltas  = vueltas;
        }
}