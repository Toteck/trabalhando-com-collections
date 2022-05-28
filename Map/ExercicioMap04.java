import java.util.*;
/*Crie uma classe Aluno que possua os atributos: nome, matricula.
Crie uma classe Curso que possua os atributos: nome, disciplina.
Em seguida, instancie 3 objetos alunos e 3 cursos, fazendo a relação entre eles dentro de um dicionário.
Feito isso, ordene esse dicionário por:
A) Nome da disciplina
a) Duração do curso;
b) Nome do aluno;
d) Matricula do aluno;
*/

public class ExercicioMap04 {

    public static void main(String[] args){
        Aluno aluno1 = new Aluno("Jon", 123);
        Aluno aluno2 = new Aluno("Simba", 125);
        Aluno aluno3 = new Aluno("Camila", 124);

        Disciplina disc1 = new Disciplina("Python", 9);
        Disciplina disc2 = new Disciplina("Java", 10);
        Disciplina disc3 = new Disciplina("Javascript", 12);

        Map<Disciplina, Aluno> cursos = new HashMap<>(){{
           put(disc1, aluno1);
           put(disc2, aluno2);
           put(disc3, aluno3);
        }};

        System.out.println("Exibindo o Dicionário");
        for (Map.Entry<Disciplina, Aluno> entry : cursos.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        // Ordem Alfabética (Nome da Disciplina)
        System.out.println("-------\n" + "Nome Disciplina:");
        Map<Disciplina, Aluno> cursos2 = new TreeMap<Disciplina, Aluno>(cursos);

        for (Map.Entry<Disciplina, Aluno> entry : cursos2.entrySet()) {
            System.out.println(entry.getKey().getNome());
        }

        System.out.println("-------\n" + "Duração Disciplina:");
        Map<Disciplina, Aluno> cursos3 = new TreeMap<Disciplina, Aluno>(new CompareDuracaoDisciplina());
        cursos3.putAll(cursos);

        for(Map.Entry<Disciplina, Aluno> entry : cursos3.entrySet()){
            System.out.println(entry.getKey().getNome() + " - " + entry.getKey().getDuracao());
        }

        System.out.println("-------\n" + "Nome do Aluno:");
        Set <Map.Entry<Disciplina, Aluno>> cursos4 = new TreeSet<Map.Entry<Disciplina, Aluno>>(new CompareNomeAluno());
        cursos4.addAll(cursos.entrySet());
        for(Map.Entry<Disciplina, Aluno> entry : cursos4){
            System.out.println(entry.getValue().getNome());
        }

        System.out.println("-------\n" + "Matricula do aluno:");
        Set <Map.Entry<Disciplina, Aluno>> cursos5 = new TreeSet<Map.Entry<Disciplina, Aluno>>(new CompareMatriculaAluno());
        cursos5.addAll(cursos.entrySet());
        for(Map.Entry<Disciplina, Aluno> entry : cursos5){
            System.out.println(entry.getValue().getNome() + " - " + entry.getValue().getMatricula());
        }

        /*Crie uma classe Aluno que possua os atributos: nome, matricula.
        Crie uma classe Curso que possua os atributos: nome, disciplina.
        Em seguida, instancie 3 objetos alunos e para cada aluno uma lista contendo 2 cursos
        fazendo a relação entre eles dentro de um dicionário.
        Feito isso, exiba o dicionário com o seguintes requisito:
        Key: Nome do aluno e matrícula - Value: Nome das disciplinas na qual estão matriculados
        */

        Aluno aluno4 = new Aluno("Mateus", 400);
        Aluno aluno5 = new Aluno("Simba", 405);
        Aluno aluno6 = new Aluno("Camila", 406);

        Set<Disciplina> disciplinas1 = new HashSet<Disciplina>(Arrays.asList(disc1, disc2)); // Passou como uma lista os dois objetos disc1 e disc2
        Set<Disciplina> disciplinas2 = new HashSet<Disciplina>(Arrays.asList(disc2, disc3));
        Set<Disciplina> disciplinas3 = new HashSet<Disciplina>(Arrays.asList(disc1, disc3));

        Map<Aluno, Set<Disciplina>> alunosEDisciplinas = new HashMap<Aluno, Set<Disciplina>>(){{
           put(aluno4, disciplinas1);
           put(aluno5, disciplinas2);
           put(aluno6, disciplinas3);
        }};
        System.out.println();
        System.out.println("Exibindo Dicionário: ");
        for(Map.Entry<Aluno, Set<Disciplina>> entry : alunosEDisciplinas.entrySet()){
            System.out.println(entry.getKey().getNome() + " - " + entry.getKey().getMatricula() + ": ");
            for (Disciplina entry1 : entry.getValue()){
                System.out.print(entry1.getNome() + " ");
            }
            System.out.println();
        }



    }
}

class Aluno {

    private String nome;
    private Integer matricula;

    public Aluno(String nome, Integer matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return nome.equals(aluno.nome) && matricula.equals(aluno.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, matricula);
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", matricula=" + matricula +
                '}';
    }
}

class Disciplina implements Comparable<Disciplina>{

    private String nome;
    private Integer duracao;

    public Disciplina(String nome, Integer duracao) {
        this.nome = nome;
        this.duracao = duracao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return nome.equals(that.nome) && duracao.equals(that.duracao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, duracao);
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "nome='" + nome + '\'' +
                ", duracao=" + duracao +
                '}';
    }

    @Override
    public int compareTo(Disciplina o) {
        return this.getNome().compareToIgnoreCase(o.getNome());
    }
}

class CompareDuracaoDisciplina implements Comparator<Disciplina>{

    @Override
    public int compare(Disciplina o1, Disciplina o2) {
        return Integer.compare(o1.getDuracao(), o2.getDuracao());
    }
}

class CompareNomeAluno implements Comparator<Map.Entry<Disciplina, Aluno>> {

    @Override
    public int compare(Map.Entry<Disciplina, Aluno> o1, Map.Entry<Disciplina, Aluno> o2) {
        return o1.getValue().getNome().compareToIgnoreCase(o2.getValue().getNome());
    }
}

class CompareMatriculaAluno implements Comparator<Map.Entry<Disciplina, Aluno>> {

    @Override
    public int compare(Map.Entry<Disciplina, Aluno> o1, Map.Entry<Disciplina, Aluno> o2) {
        return Integer.compare(o1.getValue().getMatricula(), o2.getValue().getMatricula());
    }
}