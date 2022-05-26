import java.util.*;

/*
* Dadas as seguintes informações  de id e contato, crie um dicionário e
ordene este dicionário exibindo (Nome id - Nome contato);
id = 1 - Contato = nome: Simba, numero: 2222;
id = 4 - Contato = nome: Cami, numero: 5555;
id = 3 - Contato = nome: Jon, numero: 1111;
* */

public class Exercio03 {

    public static void main(String[] args) {

        Map<Integer, Contato> contatos = new LinkedHashMap<>(){{
            put(1, new Contato("Simba", 2222));
            put(4, new Contato("Cami", 5555));
            put(3, new Contato("Jhon", 1111));
        }};

        // Ordem de inserção
        System.out.println("---Ordem de Inserção---");
        for(Map.Entry<Integer, Contato> contato : contatos.entrySet())
            System.out.println(contato.getKey() + " - " + contato.getValue().getNome() + " - " + contato.getValue().getNumero());

        // Ordem Id
        System.out.println("---Ordem Id---");
        Map<Integer, Contato> contatos1 = new TreeMap<>(contatos);

        for(Map.Entry<Integer, Contato> contato : contatos1.entrySet()){
            System.out.println(contato.getKey() + " - " + contato.getValue().getNome() + " - " + contato.getValue().getNumero());
        }

        // Ordem número telefone
        System.out.println("---Ordem número de telefone---");
        Set<Map.Entry<Integer, Contato>> contatos2 = new TreeSet<>(new CompareNumTelefone());
        contatos2.addAll(contatos.entrySet()); // contatos.entrySet() retorna uma uma Coleção Set para contatos 2
        for(Map.Entry<Integer, Contato> contato : contatos2){
            System.out.println(contato.getKey() + " - " + contato.getValue().getNome() + " - " + contato.getValue().getNumero());
        }

        // Ordem nome contato
        System.out.println("---Ordem nome e depois contato---");
        Set<Map.Entry<Integer, Contato>> contatos3 = new TreeSet<>(new CompareNomeContato());
        contatos3.addAll(contatos.entrySet());
        for(Map.Entry<Integer, Contato> contato : contatos3){
            System.out.println(contato.getKey() + " - " + contato.getValue().getNome() + " - " + contato.getValue().getNumero());
        }

    }
}

class Contato {

    private String nome;
    private Integer numero;

    public Contato(String nome, Integer numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return nome.equals(contato.nome) && numero.equals(contato.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, numero);
    }

    @Override
    public String toString() {
        return "Contato{" +
                "nome='" + nome + '\'' +
                ", numero=" + numero +
                '}';
    }
}

class CompareNumTelefone implements Comparator<Map.Entry<Integer, Contato>>{

    @Override
    public int compare(Map.Entry<Integer, Contato> o1, Map.Entry<Integer, Contato> o2) {
        return Integer.compare(o1.getValue().getNumero(), o2.getValue().getNumero());
    }
}

class CompareNomeContato implements Comparator<Map.Entry<Integer, Contato>>{

    @Override
    public int compare(Map.Entry<Integer, Contato> o1, Map.Entry<Integer, Contato> o2) {
        int nome = o1.getValue().getNome().compareToIgnoreCase(o2.getValue().getNome());
        if (nome != 0) return nome;

        return Integer.compare(o1.getValue().getNumero(), o2.getValue().getNumero());
    }
}