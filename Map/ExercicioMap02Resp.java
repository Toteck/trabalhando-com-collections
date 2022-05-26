import java.util.*;

public class ExercicioMap02Resp {

    public static void main(String[] args){
        int quantLancamentos = 100;

        // Os números foram adicionados em um array
        // valores guarda todos os resultados do lançamento do dado
        List<Integer> valores = new ArrayList<>();
        Random geradorDeLancamento = new Random();
        for(int i = 0; i < quantLancamentos; i++){
            int number = geradorDeLancamento.nextInt(6)+1;
            valores.add(number);
        }

        Map<Integer, Integer> lancamentos = new HashMap<>();
        for (Integer resultado : valores) { // para cada resultado em valores
            if (lancamentos.containsKey(resultado)) // eu tenho uma key com o valor resultado?
                lancamentos.put(resultado, (lancamentos.get(resultado) + 1)); // Se sim, adicione a está chave o valor +1
            else lancamentos.put(resultado, 1); // Caso não exista uma chave com o valor "resultado" crie uma e adicione 1 ao valor dessa chave
        }

        System.out.println("Jogando");
        //conteúdo do for + try/cath - totalmente opcional
        // Não sei muito sobre try catch então não sei explicar o que tá acontecendo ainda
        for (int i =0; i < 3; i++) {
            try {
                Thread.sleep(3000); // Acho que é para atrasar a execução do código em 3 segundos
                System.out.println("."); // Ou seja a cada 3 segundos mostra um ponto
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nValor " + " Quant. de vezes");
        for (Map.Entry<Integer, Integer> entry : lancamentos.entrySet()){
            System.out.printf("%3d %10d\n", entry.getKey(), entry.getValue());
        }
    }
}
