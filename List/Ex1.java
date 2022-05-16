import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Ex1 {
    
    public static void main(String args[]){

        List<Double> tempMedia = new ArrayList<Double>();
        List<String> meses = new ArrayList<String>();
        meses.add("1 - Janeiro");
        meses.add("2 - Fevereiro");
        meses.add("3 - Março");
        meses.add("4 - Abril");
        meses.add("5 - Maio");
        meses.add("6 - Junho");
        Scanner input = new Scanner(System.in);
        double temperatura;
        for(int i=0; i<=5; i++){
            System.out.print(meses.get(i) + ": ");
            temperatura = input.nextInt();
            tempMedia.add(temperatura);
        }
        Iterator<Double> iterator = tempMedia.iterator();
        Double soma = 0d;
        while(iterator.hasNext()){
            Double next = iterator.next();
            soma += next;
        }
        double mediaSemestral= soma / tempMedia.size();
        System.out.println("Media Semestral: " + mediaSemestral);
        for (int i = 0; i <= 5; i++) {
            if(tempMedia.get(i) > mediaSemestral){
                System.out.println(String.format("%s %.0f", meses.get(i), tempMedia.get(i)));
            }
        }
        input.close();
        
    }
}
