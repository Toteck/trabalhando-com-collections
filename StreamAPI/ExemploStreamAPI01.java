import java.util.*;
import java.util.function.Function;

public class ExemploStreamAPI01 {

    public static void main(String[] args){

        Map<Integer, Contato> contatos = new HashMap<>(){{
            put(1, new Contato("Simba", 2222));
            put(4, new Contato("Cami", 5555));
            put(3, new Contato("Jhon", 1111));
        }};

        // Ordenação por numero de telefone usando MAP
        // Ordem número telefone
        /*
        System.out.println("---Ordem número de telefone---");
        Set<Map.Entry<Integer, Contato>> contatos2 = new TreeSet<>(new CompareNumTelefone());
        contatos2.addAll(contatos.entrySet()); // contatos.entrySet() retorna uma uma Coleção Set para contatos 2
        for(Map.Entry<Integer, Contato> contato : contatos2){
            System.out.println(contato.getKey() + " - " + contato.getValue().getNome() + " - " + contato.getValue().getNumero());
        }*/

        System.out.println("Ordem número de telefone");
        // precisamos organizar os valores. Logo:
        // Comparação usando classe anônima
        /*
        Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {

            @Override
            public int compare(Map.Entry<Integer, Contato> o1, Map.Entry<Integer, Contato> o2) {
                return Integer.compare(o1.getValue().getNumero(), o2.getValue().getNumero());
            }
        });*/

        // precisamos organizar os valores. Logo:
        // Comparação usando Interface Funcional
        // Comparator.comparing me permite comparar quando eu passo uma interface funcional
        /*Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(Comparator.comparing(
                new Function<Map.Entry<Integer,Contato>, Integer>() {
                    @Override
                    public Integer apply(Map.Entry<Integer, Contato> cont) {
                        return cont.getValue().getNumero();
                    }
                }
        ));*/

        // precisamos organizar os valores. Logo:
        // Comparação usando Lamda
        Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(Comparator.comparing(cont -> cont.getValue().getNumero()));
        set.addAll(contatos.entrySet());
        set.forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue().getNumero() + ": " + entry.getValue().getNome()));
        /*
        for(Map.Entry<Integer, Contato> entry : set) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNumero() + ": " + entry.getValue().getNome());
        }*/

        System.out.println("\n\nOrdem nome\n");
        // CLASSE ANÔNIMA
        /*Set<Map.Entry<Integer, Contato>> set1 = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {
            @Override
            public int compare(Map.Entry<Integer, Contato> o1, Map.Entry<Integer, Contato> o2) {
                return o1.getValue().getNome().compareToIgnoreCase(o2.getValue().getNome());
            }
        });
        */

        // INTERFACE FUNCIONAL
        /*
        Set<Map.Entry<Integer, Contato>> set1 = new TreeSet<>(Comparator.comparing(new Function<Map.Entry<Integer,Contato>, String>(){
            @Override
            public String apply(Map.Entry<Integer, Contato> cont) {
                return cont.getValue().getNome();
            }
        }));
        */

        // LAMBDA
        Set<Map.Entry<Integer, Contato>> set1 = new TreeSet<>(Comparator.comparing(cont -> cont.getValue().getNome()));
        set1.addAll(contatos.entrySet());
        set1.forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue().getNome()));
        /*
        for(Map.Entry<Integer, Contato> entry : set1){
            System.out.println(entry.getKey() + " - " + entry.getValue().getNumero() + ": " + entry.getValue().getNome());
        }*/

    }
}
