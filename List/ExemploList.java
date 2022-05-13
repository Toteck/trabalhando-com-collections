import java.util.ArrayList;
import java.util.List;

public class ExemploList {
    
    public static void main(String args[]){
        System.out.println("Crie uma lista e adicione as sete notas");

        List<Double> notas = new ArrayList<Double>();
        notas.add(7d);
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5d);
        notas.add(7d);
        notas.add(8.3);
        notas.add(3.6);
        //System.out.println(notas);
        System.out.println(notas.toString());

        System.out.println("Exiba a posição da nota 5.0: " + notas.indexOf(5d)); // IndexOf mostra a posição de determinado elemento

        System.out.println("Adicione na lista a nota 8.0 na posição 4: ");
        notas.add(4, 8d);
        System.out.println(notas);

        System.out.println("Substitua a nota 5.0 pela nota 6.0");
        notas.set(notas.indexOf(5d), 6.0);
        System.out.println(notas);

        System.out.println("Confira se a nota 5.0 está na lista: " + notas.contains(5d));

        System.out.println("Exibir todos as notas na ordem em que foram informados");
        for (Double nota : notas) System.out.println(nota);
    }
}
