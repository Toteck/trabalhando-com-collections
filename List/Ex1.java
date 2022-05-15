import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex1 {
    
    public static void main(String args[]){

        List<Int> tempMedia = new ArrayList<Double>();
        List<String> meses = new ArrayList<String>();
        meses.add("1 - Janeiro");
        meses.add("2 - Fevereiro");
        meses.add("3 - Março");
        meses.add("4 - Abril");
        meses.add("5 - Maio");
        meses.add("6 - Junho");
        System.out.println("--\tTemperatura Média do 1º Semestre---\t");
        Scanner input = new Scanner(System.in);
        int temperatura;
        for(int i=0; i<=5; i++){
            System.out.print(meses.get(i) + ": ");
            temperatura = input.nextInt();
            tempMedia.add(temperatura);
        }
        double tempSemestral;
        Iterator<Int> iterator = tempMedia.iterator();
        Double soma = 0d;
        while(iterator.hasNext){
            Double next = iterator.next;
            soma += next;
        }
        
        System.out.println("Exiba a média");
    }
}
