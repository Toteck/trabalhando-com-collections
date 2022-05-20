import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
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
        System.out.println("\n\n\nOrdem inversa de inserção\n");
        LinkedHashSet<String> cores3 = new LinkedHashSet<>();
        //Set<Serie> minhaSeries2 = new LinkedHashSet<>()
        cores3.add("vermelha");
        cores3.add("laranha");
        cores3.add("amarela");
        cores3.add("verde");
        cores3.add("azul");
        cores3.add("azul-escuro");
        cores3.add("violeta");
       
        // Convertendo para um ArrayList
        ArrayList<String> allColors = new ArrayList<String> (cores3);

        // Para reverter o conteúdo do LinkedHashSet
        Collections.reverse(allColors);
        for(String cor : allColors){
            System.out.println(cor);
        }

        System.out.println("\n\n\nExiba todas as cores que começam com a letra 'V'\n");
        for(String cor : cores3){
            if(cor.startsWith("v")){
                System.out.println(cor);
            }

        }

        System.out.println("\n\n\nRemova todas as cores que não começam com a letra V");
        Iterator<String> itr = cores3.iterator();
        while(itr.hasNext()){
            String next = itr.next();
            if(next.startsWith("v"));
            else{
                itr.remove();
            }
        }
        for(String cor : cores3){
            System.out.println(cor);
        }

        System.out.println("\n\n\nLimpe o conjunto\n");
        cores3.clear();
        System.out.println(cores3);

        System.out.println("\n\n\nConfira se o conjunto etá vazio");
        System.out.println(cores3.isEmpty());
        

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