package Avaliçao_2;

public class Carrera extends Thread{
    private int vueltas;
    private long initialTime;
    private Corredor corredor;

    public Corredor getCorredor() {
        return corredor;
    }

    public void setCorredor(Corredor corredor) {
        this.corredor = corredor;
    }

    public int getVueltas() {
        return vueltas;
    }

    public void setVueltas(int vueltas) {
        this.vueltas = vueltas;
    }

    public long getInitialTime() {
        return initialTime;
    }

    public void setInitialTime(long initialTime) {
        this.initialTime = initialTime;
    }

    public Carrera(int cant_vueltas, long initialTime,Corredor corredor){
        this.vueltas = cant_vueltas;
        this.initialTime = initialTime;
        this.corredor = corredor;
    }

    @Override
    public void run(){
        for(int num_vuelta = 0; num_vuelta < 5; num_vuelta++) {
            this.esperar_tiempo(corredor.getTiempo_vueltas()[num_vuelta]);
            System.out.println("El Corredor " + corredor.getNombre() + " Realiza la vuelta :"
                                       + (num_vuelta+1) + " en : " + (corredor.getTiempo_vueltas()[num_vuelta])+"s");
            corredor.tiepo_total+=corredor.getTiempo_vueltas()[num_vuelta];
        }
        System.out.println("\n\t\tEl piloto "+corredor.getNombre()+" Finalazó la carrera en "+corredor.tiepo_total);


    }
    private void esperar_tiempo(int tiempo){
        try{
            Thread.sleep(tiempo);
        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }
}
