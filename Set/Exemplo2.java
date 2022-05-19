import java.util.HashSet;



public class Exemplo2 {
    
    public static void main(String args[]){
        // Criando um objeto HashSet chamado numbers
        HashSet<Integer> numbers = new HashSet<Integer>();
        
        // Adicionando valores ao set
        numbers.add(4);
        numbers.add(7);
        numbers.add(8);

        // Mostra quais numeros está entre 1 e 10 estão no set
        for(int i = 1; i <= 10; i++){
            if(numbers.contains(i)){
                System.out.println(i + " was found in the set.");
            } else {
                System.out.println(i + " was not found in the set");
            }
        }
    }
}
