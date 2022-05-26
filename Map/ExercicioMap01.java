import java.util.*;


/*
Dada a população estimada de alguns estados do NE brasileiro, faça:

Estado = PE - População = 9.616.621

Estado = AL - População = 3.351.543

Estado = CE - População = 9.187.103

Estado = RN - População = 3.534.265
* */

public class ExercicioMap01 {

    public static void main(String[] args){
        // Crie um dicionário e relacione os estados e suas populações
        Map<String, Integer> populacao = new LinkedHashMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};

        for(Map.Entry<String, Integer> pop : populacao.entrySet())
            System.out.println(pop.getKey() + " - " + pop.getValue());
        System.out.println("Substitua a população do RN por 3534165");
        populacao.put("RN", 3534165);
        for(Map.Entry<String, Integer> pop : populacao.entrySet())
            System.out.println(pop.getKey() + " - " + pop.getValue());

        System.out.println("Confira se o estado PB está no dicionário caso não adicione: PB - 4039277");
        System.out.println("PB está no dicionário: " + populacao.containsKey("PB"));
        if(!populacao.containsKey("PB")) populacao.put("PB", 4039277);
        for(Map.Entry<String, Integer> pop : populacao.entrySet())
            System.out.println(pop.getKey() + " - " + pop.getValue());
        System.out.println("PB está no dicionário: " + populacao.containsKey("PB"));
        System.out.println("Exiba a população de PE: " + populacao.get("PE"));
        System.out.println("Exiba todos os estados e suas populações na ordem que foi informado");
        for(Map.Entry<String, Integer> pop : populacao.entrySet())
            System.out.println(pop.getKey() + " - " + pop.getValue());
        System.out.println("Exiba os estados e suas populacões em ordem alfabética");
        Map<String, Integer> populacao2 = new TreeMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
            put("PB", 4039277);
        }};

        for(Map.Entry<String, Integer> pop : populacao2.entrySet()){
            System.out.println(pop.getKey() + " - " + pop.getValue());
        }

        int menorpopulacao = Collections.min(populacao2.values());
        String menorEstado = "";
        for(Map.Entry<String, Integer> pop : populacao2.entrySet()){
            if(pop.getValue().equals(menorpopulacao)) {
                menorEstado = pop.getKey();
                System.out.println("Estado com menor populacao: " + menorEstado + " - " + menorpopulacao);
            }
        }

        int maiorPopulacao = Collections.max(populacao2.values());
        String maiorEstado = "";
        for(Map.Entry<String, Integer> pop : populacao2.entrySet()){
            if(pop.getValue().equals(maiorPopulacao)){
                maiorEstado = pop.getKey();
                System.out.println("Estado com maior população: " + maiorEstado + " - " + maiorPopulacao);
            }
        }

        long soma = 0;
        for(Map.Entry<String, Integer> pop : populacao.entrySet()){
            soma += pop.getValue();
        }
        System.out.println("Exiba a soma da população desses estados: " + soma);
        System.out.println("Exiba a média populacional desses estados: "  + (soma/populacao.size()));

        Iterator<Integer> ite = populacao2.values().iterator();
        while(ite.hasNext())
            if(ite.next() < 4000000) ite.remove();
        System.out.println(populacao2);
        populacao2.clear();
        System.out.println("O dicionário está vazio? " + populacao2.isEmpty());
        }
}




