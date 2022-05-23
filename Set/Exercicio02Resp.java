import java.util.*;

public class Exercicio02Resp {

    public static void main(String[] args) {

        Set<FavoriteLanguage> minhasLinguagensFavoritas = new HashSet<>();
        minhasLinguagensFavoritas.add(new FavoriteLanguage("Python", 1991, "Pycharm"));
        minhasLinguagensFavoritas.add(new FavoriteLanguage("JavaScript", 1995, "IntelliJ"));
        minhasLinguagensFavoritas.add(new FavoriteLanguage("Java", 1991, "Visual Studio Code"));

        System.out.println("------\tOrdem de Inserção\t------");
        Set<FavoriteLanguage> minhasLinguagensFavoritas1 = new LinkedHashSet<>(Arrays.asList(
                new FavoriteLanguage("Python", 1991, "Pycharm"),
                new FavoriteLanguage("JavaScript", 1995, "IntelliJ"),
                new FavoriteLanguage("Java", 1991, "IntelliJ")
        ));

        for (FavoriteLanguage lingua : minhasLinguagensFavoritas1)
            System.out.println(lingua.getNome() + " - " + lingua.getAnoDeCriacao() + " - " + lingua.getIde());

        System.out.println("------\tOrdem Natural: Nome\t------");
        Set<FavoriteLanguage> minhasLinguagensFavoritas2 = new TreeSet<>(minhasLinguagensFavoritas);
        for (FavoriteLanguage lingua : minhasLinguagensFavoritas2)
            System.out.println(lingua.getNome() + " - " + lingua.getAnoDeCriacao() + " - " + lingua.getIde());

        System.out.println("------\tOrdem Natural: IDE\t------");
        Set<FavoriteLanguage> minhasLinguagensFavoritas3 = new TreeSet<>(new CompareIDE());
        minhasLinguagensFavoritas3.addAll(minhasLinguagensFavoritas);
        for (FavoriteLanguage lingua : minhasLinguagensFavoritas3)
            System.out.println(lingua.getNome() + " - " + lingua.getAnoDeCriacao() + " - " + lingua.getIde());

        System.out.println("------\tOrdem Natural: Ano de Criação e Nome\t------");
        Set<FavoriteLanguage> minhasLinguagensFavoritas4 = new TreeSet<>(new CompareAnoDeCriacaoENome());
        minhasLinguagensFavoritas4.addAll(minhasLinguagensFavoritas);
        for (FavoriteLanguage lingua : minhasLinguagensFavoritas4)
            System.out.println(lingua.getNome() + " - " + lingua.getAnoDeCriacao() + " - " + lingua.getIde());

        System.out.println("------\tOrdem Nome - Criação - IDE\t------");
        Set<FavoriteLanguage> minhasLinguagensFavoritas5 = new TreeSet<>(new CompareNomeAnoDeCriacaoIde());
        minhasLinguagensFavoritas5.addAll(minhasLinguagensFavoritas);
        for (FavoriteLanguage lingua : minhasLinguagensFavoritas5)
            System.out.println(lingua.getNome() + " - " + lingua.getAnoDeCriacao() + " - " + lingua.getIde());






    }
}

class FavoriteLanguage implements Comparable<FavoriteLanguage> {
    
    private String nome;
    private Integer anoDeCriacao;
    private String ide;

    public FavoriteLanguage(String nome, Integer anoDeCriacao, String ide) {
        this.nome = nome;
        this.anoDeCriacao = anoDeCriacao;
        this.ide = ide;
    }


    @Override
    public int compareTo(FavoriteLanguage o) {
        return this.nome.compareTo(o.nome);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavoriteLanguage that = (FavoriteLanguage) o;
        return Objects.equals(nome, that.nome) && Objects.equals(anoDeCriacao, that.anoDeCriacao) && Objects.equals(ide, that.ide);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, anoDeCriacao, ide);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoDeCriacao() {
        return anoDeCriacao;
    }

    public void setAnoDeCriacao(Integer anoDeCriacao) {
        this.anoDeCriacao = anoDeCriacao;
    }

    public String getIde() {
        return ide;
    }

    public void setIde(String ide) {
        this.ide = ide;
    }
}

class CompareIDE implements Comparator<FavoriteLanguage>{


    @Override
    public int compare(FavoriteLanguage o1, FavoriteLanguage o2) {
        return o1.getIde().compareToIgnoreCase(o2.getIde());
    }
}

class CompareAnoDeCriacaoENome implements Comparator<FavoriteLanguage>{

    @Override
    public int compare(FavoriteLanguage o1, FavoriteLanguage o2){
        int anoDeCriacao = Integer.compare(o1.getAnoDeCriacao(), o2.getAnoDeCriacao());
        if (anoDeCriacao != 0) return anoDeCriacao;
        return o1.getNome().compareToIgnoreCase(o2.getNome());
    }
}

class CompareNomeAnoDeCriacaoIde implements Comparator<FavoriteLanguage>{


    @Override
    public int compare(FavoriteLanguage o1, FavoriteLanguage o2) {
        int nome = o1.getNome().compareTo(o2.getNome());
        if (nome != 0) return nome;

        int anoDeCriacao = Integer.compare(o1.getAnoDeCriacao(), o2.getAnoDeCriacao());
        if (anoDeCriacao != 0) return anoDeCriacao;

        return o1.getIde().compareToIgnoreCase(o2.getIde());
    }
}

