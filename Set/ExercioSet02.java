import java.util.*;

/* Ordene esse conjunto
Ordem de inserção
Ordem natural
IDE
Ano de criação e nome
Nome, ano de criação e IDE
Ao final. exiba as linguaagens no console, um abaixo da outra. */

public class ExercioSet02 {

    public static void main(String args[]){
        Set<LinguagemFavorita> minhasLinguagensFav = new HashSet<>(){{
            add(new LinguagemFavorita("Dart", "IntellJ", 2011));
            add(new LinguagemFavorita("Clojure", "Cursive", 2007));
            add(new LinguagemFavorita("Elixir", "Atom", 2013));
            add(new LinguagemFavorita("Ruby", "RubyMine IDE", 1995));
        }};

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

            
        


    }
    
}


class LinguagemFavorita {

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


}