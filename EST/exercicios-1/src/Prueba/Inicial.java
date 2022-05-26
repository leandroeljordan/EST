package Prueba;

public class Inicial implements Calcular{
    public static void main(String[] args) {
        Inicial obj1 = new Inicial();
        obj1.evetuaCalculo(4,3,"soma");
        obj1.evetuaCalculo(4,3,"resta");
        obj1.evetuaCalculo(4,3,"div");
        obj1.evetuaCalculo(4,3,"mult");
    }

    @Override
    public float evetuaCalculo(float a, float b, String Operacao) {
        if(Operacao.contains("soma")){
            float c = a + b;
            System.out.println("Soma "+c);
        }
        else if(Operacao.contains("resta")){
            float c = a - b;
            System.out.println("Resta "+c);
        }
        else if(Operacao.contains("div")){
            float c = a / b;
            System.out.println("Division "+c);
        }
        else if(Operacao.contains("mult")){
            float c = a * b;
            System.out.println("Multiplicacion" +c);
        }

        return 0;
    }
}
