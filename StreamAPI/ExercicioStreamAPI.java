import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class ExercicioStreamAPI {

    public static void main(String[] args){

        List<String> numAleatorios = Arrays.asList("6", "1", "1", "1", "2", "4", "8");

        System.out.println("Imprima todos os elementos dessa lista de String: ");
        numAleatorios.forEach(System.out::println);

        System.out.println("Pegue os 5 primeiros números e coloque dentro de um Set");
        // Para pegarmos os 5 primeiros números
        // usamos a operação limit(quantidade de elementos que você quer pegar)
        // Depois de limit usaremos collect que "coletar" esses números e jogar dentro de um set
        // Para gerar a varíável automaticamente usa-se ctrl+alt+v
        Set<String> collectSet = numAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet());
        collectSet.forEach(System.out::println);

        System.out.println("Transforme esta lista de String em uma lista de números inteiros");
        List<Integer> numerosAleatoriosInteger = numAleatorios.stream() // Stream não altera a minha List numAleatorios
                .map(Integer::parseInt) // Essa parte transforma cada elemento do meu stream (fluxo) em Integer
                .collect(Collectors.toList());

        System.out.println("Pegue os números pares e maiores do que 2 e coloque em uma lista");
        List<Integer> ListParesMaioresQue2 = numAleatorios.stream()
                .map(Integer::parseInt)
                .filter(i -> (i % 2 == 0 && i > 2))
                .collect(Collectors.toList());
        System.out.println(ListParesMaioresQue2);

        System.out.println("Mostre a média dos números");
        numAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);

        System.out.println("Remova os valores impares");
        numerosAleatoriosInteger.removeIf(integer -> (integer % 2 != 0));
        System.out.println(numerosAleatoriosInteger);

        System.out.println("Ignore os 3 primeiros elementos da lista e imprima o restante");
        Set<String> collectSet2 = numAleatorios.stream()
                .skip(3)
                .collect(Collectors.toSet());
        collectSet2.forEach(System.out::println);

        Set<Integer> collectSetInteger = numAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        System.out.println("Retirando os números repetidos da lista, quantos números ficam? " + collectSetInteger.size());


        System.out.print("Mostre o menor valor da lista: ");
        numAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .min()
                .ifPresent(System.out::println);
        System.out.print("Mostre o maior valor da lista: ");
        numAleatorios.stream()
                        .mapToInt(Integer::parseInt)
                                .max()
                                        .ifPresent(System.out::println);
        int sumNumerosImpares = numAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .filter(i -> (i % 2 != 0))
                .sum();
        System.out.println("Pegue apenas os números impares e some" + sumNumerosImpares);


        System.out.println("Mostre a lista na ordem númerica");
        System.out.println("Agrupe os valores impares múltiplos de 3 e de 5: ");
        // dica: collect(Collectors.groupingBy(new Function())
    }
}
