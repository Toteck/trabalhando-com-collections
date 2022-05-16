public class ExemploSet {
    
    public static void main (String args[]){

        /*Dada uma lista com 7 notas de um aluno [7, 8.5, 9.3, 5, 7, 0, 3.6] faça: 
        Set notas = new HashSet(); // antes do java 8
        HashSet<Double> notas = new HashSet<>();
        Set<Double> notas = new HashSet<>() // Generics(jdk 5) - Diamont Operator(Jdk7)
        Set<Double> notas = Set.of(7d, 8.5, 9.3, 5d, 7d, 8d, 3.6);
        notas.add(1d);
        notas.remove(5d);
        System.out.println(notas);
        */

        System.out.println("Crie um conjunto e adicione as notas: ");
        Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        
    }
}
