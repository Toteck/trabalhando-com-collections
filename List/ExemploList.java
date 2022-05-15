import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
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

        System.out.println("Exiba a terceira nota adicionada: " + notas.get(2));
        System.out.println(notas.toString());

        System.out.println("Exiba a menor nota: " + Collections.min(notas));

        System.out.println("Exiba a maior nota: " + Collections.max(notas));
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d;
        while(iterator.hasNext()){
            Double next = iterator.next();
            soma += next;
        }
        System.out.println("Exiba a soma dos valores: " + soma);

        System.out.println("Exiba a média das notas: " + (soma/notas.size()));

        System.out.println("Remova a nota 0: ");
        notas.remove(0d); // Se colocar apenas o 0 ele vai remover o elemento da posição 0
        System.out.println(notas);

        System.out.println("Remova as notas menores que 7 e exiba a lista: ");
        Iterator<Double> iterator1 = notas.iterator();
        while(iterator1.hasNext()){
            Double next = iterator1.next();
            if(next < 7) iterator1.remove();

        }
        System.out.println(notas); 

        System.out.println("Apague toda a lista");
        notas.clear();
        System.out.println(notas);

        System.out.println("Confira se a lista está vazia: " + notas.isEmpty());

        /* Resolva esses exercícios utilizando os métodos do implementação LinkedList:*/
        System.out.println("Crie uma lista chamada notas2 ");
        // E coloque todos os elementos da list ArrayList nessa nova lista: 
        LinkedList<Double> notas2 = new LinkedList<Double>();
        notas2.add(7d);
        notas2.add(8.5);
        notas2.add(9.3);
        notas2.add(5d);
        notas2.add(9d);
        notas2.add(4.5);
        notas2.add(3.5);
        System.out.println(notas2);
        System.out.println("Mostre o primeira nota da noa lista sem removê-lo: " + notas2.getFirst());
        System.out.println("Mostre a primeira nota da nova lista removendo-o: " + notas2.removeFirst());
        System.out.println(notas2);

        }

}
