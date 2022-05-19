import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

public class Exemplo {
    
    public static void main(String args[]){

        HashSet<String> cars = new HashSet<String>();

        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("BMW"); // BMW foi adicionado novamente, mas só vai aparecer só uma vez por que HashSet não permite elementos duplicados
        cars.add("Mazda");
        System.out.println(cars);

        // Checando se um elemento existe
        System.out.println(cars.contains("Mazda"));

        // Remover um item
        cars.remove("Volvo");
        System.out.println(cars);

        //Removendo todos os items
        cars.clear();
        System.out.println(cars);

        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("BMW");
        // Encontrar quantos items há
        System.out.println(cars.size());

        // Atravessando o HashSet
        //for (String i : cars) System.out.println(i);

        // Ordenando um Set
        TreeSet<String> carros2 = new TreeSet<>(new MeuComparator());
        carros2.addAll(cars);
        for( String car : carros2){
            System.out.println(car);
        }
    }
}

class MeuComparator implements Comparator<String>{
    
    @Override
    public int compare(String o1, String o2){
       
        return o1.compareTo(o2);
    }
}
