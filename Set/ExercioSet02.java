import java.util.*;

/* Ordene esse conjunto
Ordem de inserção
Ordem natural (nome)
IDE
Ano de criação e nome
Nome, ano de criação e IDE
Ao final. exiba as linguaagens no console, um abaixo da outra. */

public class ExercioSet02 {

    public static void main(String[] args){

        // Ordem de Inserção
        System.out.println("---\tOrdem de Inserção\t---");
        Set<LinguagemFavorita> ling2 = new LinkedHashSet<>(){{
                add(new LinguagemFavorita("Dart", "IntellJ", 2011));
                add(new LinguagemFavorita("Clojure", "Cursive", 2007));
                add(new LinguagemFavorita("Elixir", "Atom", 2013));
                add(new LinguagemFavorita("Ruby", "RubyMine IDE", 1995));
        }};

        for (LinguagemFavorita ling : ling2)
            System.out.println(ling.getNome() + " - " + ling.getIde() + " - " + ling.getAnoDeCriacao());

        
        System.out.println("\n\n---\tOrdem Natural (Nome)---");
        Set<LinguagemFavorita> ling3 = new TreeSet<>(ling2);
        for(LinguagemFavorita ling : ling3){
            System.out.println(ling.getNome() + " - " + ling.getIde() + " - " + ling.getAnoDeCriacao());
        }

        System.out.println("\n\n---\tOrdem Natural (IDE)---");

        Set<LinguagemFavorita> ling4 = new TreeSet<>(new ComparatorIDE());
        ling4.addAll(ling3);
        for (LinguagemFavorita ling : ling4)
            System.out.println(ling.getNome() + " - " + ling.getIde() + " - " + ling.getAnoDeCriacao()); 

        System.out.println("\n\n---\tOrdem Natural (Ano de Criação)---");
        Set<LinguagemFavorita> ling5 = new TreeSet<>(new ComparatorAnoDeCriacao());
        ling5.addAll(ling4);
        for (LinguagemFavorita ling : ling5)
            System.out.println(ling.getNome() + " - " + ling.getIde() + " - " + ling.getAnoDeCriacao());

        System.out.println("\n\n---\tOrdem Natural (Ano de criação/Nome)---");
        Set<LinguagemFavorita> ling6 = new TreeSet<>(new ComparatorAnoDeCriacao());
        ling6.addAll(ling5);
        for (LinguagemFavorita ling : ling6)
            System.out.println(ling.getNome() + " - " + ling.getIde() + " - " + ling.getAnoDeCriacao());

            System.out.println("\n\n--- Ordem Nome/Ano de criacao/IDE---");
            Set<LinguagemFavorita> ling7 = new TreeSet<>(new ComparatorNomeAnoDeCriacaoIDE());
            
            ling7.add(new LinguagemFavorita("Dart", "IntellJ", 2011));
            ling7.add(new LinguagemFavorita("Clojure", "Cursive", 2007));
            ling7.add(new LinguagemFavorita("Elixir", "Atom", 2013));
            ling7.add(new LinguagemFavorita("Ruby", "RubyMine IDE", 1995));
            for (LinguagemFavorita ling : ling6)
                System.out.println(ling.getNome() + " - " + ling.getIde() + " - " + ling.getAnoDeCriacao());




    }
    
}


class LinguagemFavorita implements Comparable<LinguagemFavorita>{

    /*nome, anoDeCriancao e IDE*/
    private String nome;
    private String ide;
    private Integer anoDeCriacao;

    public LinguagemFavorita(String nome, String ide, Integer anodeCriacao){
        this.nome = nome;
        this.ide = ide;
        this.anoDeCriacao = anodeCriacao;
    }
    
    public LinguagemFavorita(){

    }

    public String getNome(){
        return nome;
    }

    public String getIde(){
        return ide;
    }

    public Integer getAnoDeCriacao(){
        return anoDeCriacao;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", genero='" + ide + '\'' +
                ", tempoEpisodio=" + anoDeCriacao +
                '}';
    }

    @Override
    public int hashCode(){
        return Objects.hash(nome, ide, anoDeCriacao);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinguagemFavorita lingfav = (LinguagemFavorita) o;
        return nome.equals(lingfav.nome) && ide.equals(lingfav.ide) && anoDeCriacao.equals(lingfav.anoDeCriacao);
    }

    @Override
    public int compareTo(LinguagemFavorita o) {
        return this.getNome().compareTo(o.getNome());
    }
}

class ComparatorIDE implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2){
        return o1.getIde().compareTo(o2.getIde());
    }
}

class ComparatorAnoDeCriacao implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2){
        return Integer.compare(o1.getAnoDeCriacao(), o2.getAnoDeCriacao());
    }
}


class CompartorAnoDeCriacaoNome  implements Comparator<LinguagemFavorita>{

    @Override 
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2){
        int anoDeCriacao = Integer.compare(o1.getAnoDeCriacao(), o2.getAnoDeCriacao());
        if(anoDeCriacao != 0) return anoDeCriacao;

        return o1.getNome().compareTo(o2.getNome());

    }
}

class ComparatorNomeAnoDeCriacaoIDE implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2){
        int nome = o1.getNome().compareToIgnoreCase(o2.getNome());
        if(nome != 0) return nome;

        int anoDeCriacao = Integer.compare(o1.getAnoDeCriacao(), o2.getAnoDeCriacao());
        if(nome != 0) return anoDeCriacao;

        return o1.getIde().compareToIgnoreCase(o2.getIde());
    }
}
