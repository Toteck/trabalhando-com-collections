import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/*Dados as seguintes informações sobre minhas séries favoritas.
Crie um conjunto e ordene este conjunto exibindo: 
(nome - genero - tempo de episódio);

Série 1 = Nome: got, genêro: fantasia, tempoEpisódio: 60
Série 2 = Nome: dark, genêro: drama, tempoEpisódio: 60
Série 3 = Nome: thar '70s show, genêro: comédia, tempoEpisódio: 25
*/

public class ExemploOrdenação {
    
    public static void main(String[] args){
        System.out.println("--\tOrdem aleatória\t--");
        Set<Serie> minhaSeries = new HashSet<>(){{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that '70s show", "comédia", 25));
        }};
        for (Serie serie : minhaSeries) System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());

        System.out.println("--\tOrdem de Inserção\t--");
        Set<Serie> minhaSeries2 = new LinkedHashSet<>() {
            {
                add(new Serie("got", "fantasia", 60));
                add(new Serie("dark", "drama", 60));
                add(new Serie("that '70s show", "comédia", 25));
            }};

        for (Serie serie : minhaSeries2)
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());

        System.out. println("--\tOrdem natural (TempoEpisodio)\t--");
        Set<Serie> minhasSeries3 = new TreeSet<>(minhaSeries2);
        for (Serie serie : minhasSeries3)
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());

        System.out.println("--\tOrdem Nome/Gênero/TempoEpisodio\t--");
        Set<Serie> minhasSeriesNomeGeneroTempEp = new HashSet<>();
        minhasSeriesNomeGeneroTempEp.addAll(minhaSeries);
        minhasSeriesNomeGeneroTempEp.stream().sorted((s1, s2) -> {
            int nome = s1.getNome().compareToIgnoreCase(s2.getNome());
            if(nome != 0) return nome;

            int genero = s1.getGenero().compareToIgnoreCase(s2.getGenero());
            if (genero != 0) return genero;

            return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
        })
        .collect(Collectors.toList()).forEach(serie -> System.out.println(serie));
        
        
    }

}

class Serie implements Comparable<Serie>{

    private String nome;
    private String genero;
    private Integer tempoEpisodio;

    public Serie(String nome, String genero, Integer tempoEpisodio){
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }

    public String getNome(){
        return nome;
    }

    public String getGenero(){
        return genero;
    }

    public Integer getTempoEpisodio(){
        return tempoEpisodio;
    }

    @Override
    public String toString(){
        return "{" + 
                "nome='" + nome + '\'' + 
                ", genero='" + genero + '\'' + 
                ", tempoEpisodio=" + tempoEpisodio + 
                '}';
    }

    // É muito importante sobreescrever métodos equals e hashCode em implementações que no nome tenha a palavrinha hash.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return nome.equals(serie.nome) && genero.equals(serie.genero) && tempoEpisodio.equals(serie.tempoEpisodio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEpisodio);
    }

    @Override
    public int compareTo(Serie serie) {
        
        
        int tempoEpisodio = Integer.compare(this.getTempoEpisodio(), serie.getTempoEpisodio());
        if(tempoEpisodio != 0) return tempoEpisodio;
        return this.getGenero().compareTo(serie.getGenero());
    }

}

class ComparatorNomeGeneroTempoEpisodio1 implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
        int nome = s1.getNome().compareTo(s2.getNome());
        if (nome != 0) return nome;

        int genero = s1.getGenero().compareTo(s2.getGenero());
        if (genero != 0) return genero;

        return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
        
    }
    
}