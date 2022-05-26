import java.util.*;

public class ExercicioMap02 {

    public static void main(String[] args){
        int quantLancamentos = 100;
        Random random = new Random();

        int numero = random.nextInt(6) + 1;
        List<Integer> values = new ArrayList<>();
        Random geradorDeLancamentos = new Random();
        for(int i = 0; i < quantLancamentos; i++){
            int number = geradorDeLancamentos.nextInt(6)+1;
            values.add(number);
        }

        Map<Integer, Integer> lancamentos = new HashMap<>();
        for(Integer resultado : values) {
            if (lancamentos.containsKey(resultado))
                lancamentos.put(resultado, (lancamentos.get(resultado) + 1));
            else lancamentos.put(resultado, 1);
        }

        for(int i=0; i<3; i++){
            try {
                Thread.sleep(3000);
                System.out.println(".");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nValor " + " Quant. de vezes");
        for (Map.Entry<Integer, Integer> entry : lancamentos.entrySet()){
            System.out.printf("%3d %10d\n", entry.getKey(), entry.getValue());
        }




    }
}
