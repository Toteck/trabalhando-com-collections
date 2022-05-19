import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;



public class Exercicio01 {
    
    public static void main(String args[]){
        
        HashSet<String> arcoIris = new HashSet<>();
        arcoIris.add("vermelha");
        arcoIris.add("laranha");
        arcoIris.add("amarela");
        arcoIris.add("verde");
        arcoIris.add("azul");
        arcoIris.add("azul-escuro");
        arcoIris.add("violeta");

        // Exiba todas as cores uma abaixo da outra
        System.out.println("Exiba todas as cores uma abaixo da outra");
        for(String cor : arcoIris){
            System.out.println(cor);
        }

        // A quantidade de cores que o arco-íris tem
        System.out.println("A quantidade de cores que o arco-íris tem");
        System.out.println(arcoIris.size());

        // Exiba as cores em ordem alfabética
        System.out.println("Exiba as cores em ordem alfabética");
        TreeSet<String> coresOrdenadosAlfabeticamente = new TreeSet<>(new CompararAlfabeticamente());
        coresOrdenadosAlfabeticamente.addAll(arcoIris);
        for(String carro : coresOrdenadosAlfabeticamente) System.out.println(carro);
        

        // Exiba as cores na ordem inversa da que foi informada
        /*TreeSet<String> carrosOrdemInversa = new TreeSet<>(new OrdemInversa());*/
        System.out.println("");
        LinkedHashSet<String> cores3 = new LinkedHashSet<>();
        cores3.add("vermelha");
        cores3.add("laranha");
        cores3.add("amarela");
        cores3.add("verde");
        cores3.add("azul");
        cores3.add("azul-escuro");
        cores3.add("violeta");
        System.out.println(cores3);


        
        
    }
}

class CompararAlfabeticamente implements Comparator<String>{

    @Override
    public int compare(String o1, String o2){
        return o1.compareTo(o2);
    }
}
/*
class OrdemInversa implements Comparator<String>{

    @Override
    public int compare(String 01, String 02);
}

*/