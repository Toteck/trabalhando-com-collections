import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



/*Dados as seguintes informações sobre meus gatos, crie uma lista e ordene esta lista exibindo:

Gato 1 = nome: Jon, idade: 18, cor: preto,
Gato 2 = nome: Simba, idade: 6, cor: tigrado
Gato 3 = nome: Jon, idade 12, cor: amarelo
*/

public class ExemploOrdenacaoList {
    
    public static void main(String[] args){

        List<Gato> meusGatos = new ArrayList<>(){{
            add(new Gato("Jon", 18, "preto"));
            add(new Gato("Simba", 6, "tigrado"));
            add(new Gato("Jon", 12, "amarelo"));
        }};

        System.out.println(meusGatos);

        System.out.println("--\tOrdem de Inserção\t---");
        System.out.println(meusGatos);

        System.out.println("--\tOrdem aleatória\t---");
        Collections.shuffle(meusGatos); // Bagunça a minha lista ligada
        System.out.println(meusGatos);

        System.out.println("--\tOrdem Natural (Nome)\t---");

        Collections.sort(meusGatos);
        System.out.println(meusGatos);

        System.out.println("--\tOrdem Idade\t---");
        //Collections.sort(meusGatos, new ComparatorIdade());
        meusGatos.sort(new ComparatorIdade());
        System.out.println(meusGatos);

        System.out.println("---\tOrdem cor\t---");
        // Collections.sort(meusGatos, new ComparatorIdade());
        meusGatos.sort(new ComparatorCor());
        System.out.println(meusGatos);

        System.out.println("--\tOrdem Nome/Cor/Idade\t---");
        // Collections.sort(meusGatos, new ComparatorIdade());
        meusGatos.sort(new ComparatorNomeCorIdade());
        // Primeiro compare por nomes, se os nomes forem iguais
        // Compare pelas cores dos gatos, se as cores dos gatos forem iguais
        // Compare por idade.
        // Se tudo é igual não precisa ordenar
        System.out.println(meusGatos);
        

    }
}

class Gato implements Comparable<Gato>{

    private String nome;
    private Integer idade;
    private String cor;

    public Gato(String nome, Integer idade, String cor){
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome(){
        return nome;
    }

    public Integer getIdade(){
        return idade;
    }

    public String getCor(){
        return cor;
    }

    @Override
    public String toString() {
        return "{" +
                "nome=" + nome + '\'' + 
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }

    @Override
    public int compareTo(Gato gato) {
        return this.getNome().compareToIgnoreCase(gato.getNome());
        // Quando der 0 os gatos tem nomes iguais
        // Quando der 1 o nome do gato ao qual eu estou comparando é maior.
        // Quando der -1 o gato ao qual estou comparando é menor que o outro
        
    }
}

class ComparatorIdade implements Comparator<Gato> {
    @Override
    public int compare(Gato g1, Gato g2){
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}

class ComparatorCor implements Comparator<Gato> {
    @Override
    public int compare(Gato g1, Gato g2){
        return g1.getCor().compareToIgnoreCase(g2.getCor());
        // Se as cores forem iguais vai retornar o numero 0. 
        //Se o meu gato 1 for maior do que o gato 2 vai retornar 1.
        //Se o meu gato 1 for menor que o meu gato 2 vai retornar um número negativo
    }
}

class ComparatorNomeCorIdade implements Comparator<Gato> {
    @Override
    public int compare(Gato g1, Gato g2){
        int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
        if(nome != 0) return nome;

        int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
        if(cor != 0) return cor;

        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}