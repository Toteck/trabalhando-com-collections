import java.util.*;

public class ExemploMap {

    public static void main(String[] args){
        /*
         Dado os modelos dos carros e seus respectivos consumos na estrada, faça:
         * modelo = gol - consumo = 14,4 km/l
         * modelo = uno - consumo = 15,6 km/l
         * modelo = mobi - consumo = 16,1 km/l
         * modelo = hb20 - consumo = 14,5 km/l
         * modelo = kwid - consumo = 15,6 km/l
         */

        // HashMap<String, Double> carrosPopulares = new HashMap<>();
        // Map<String, Double> carrosPopulares2020 = Map.of("gol", 14.4, "uno", 15.6, "mobi", 16.1 "hb20", 14.5, "kwid", 15.6)

        System.out.println("Crie um dicionário que relacione os modelos e seus respectivos consumos: ");

        Map<String, Double> carrosPopulares = new HashMap<>() {{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares.toString());

        System.out.println("Substitua o consumo do gol por 15,2 km/l: ");
        carrosPopulares.put("gol", 15.2);
        System.out.println(carrosPopulares);

        System.out.println("Confira se o modelo tucson está no dicionário: " + carrosPopulares.containsKey("tucson"));

        System.out.println("Exiba o consumo do uno: " + carrosPopulares.get("uno"));

        // Não da para saber o 3 modelo adicionado porque a ordem tá aleatória dentro.

        System.out.println("Exiba os modelos");
        Set<String> modelos = carrosPopulares.keySet(); // o keySet retorna uma collection
        System.out.println(modelos);

        System.out.println("Exiba os consumos dos carros");
        Collection<Double> consumos = carrosPopulares.values(); // values retorna uma collection
        System.out.println(consumos);

        System.out.println("Exiba o modelo menos econômico e seu consumo: ");

        Double consumoMenosEficiente = Collections.max(carrosPopulares.values());
        String modeloMenosEficiente = "";
        for(Map.Entry<String, Double> entry : carrosPopulares.entrySet()){
            if(entry.getValue().equals(consumoMenosEficiente)) {
                modeloMenosEficiente = entry.getKey();
                System.out.println("Modelo menos eficiente: " + modeloMenosEficiente + " - " + consumoMenosEficiente);
            }
        }

        Iterator<Double> ite = carrosPopulares.values().iterator();
        Double soma = 0d;
        while(ite.hasNext()){
            soma += ite.next();
        }
        System.out.println("Exiba a soma dos consumos" + soma);
        System.out.println("Exiba a média de consumo deste dicionário de carros: " + (soma/carrosPopulares.size()));

        System.out.println(carrosPopulares);
        System.out.println("Remova os modelos com consumo igual a 15,6 km/l");
        Iterator<Double> ite1 = carrosPopulares.values().iterator();
        System.out.println(carrosPopulares );
        while(ite1.hasNext()){
            if (ite1.next().equals(15.6)) ite1.remove();
        }
        System.out.println(carrosPopulares);

        System.out.println("Exiba todos os carros na ordem em que foram informados");
        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>() {{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares1.toString());

        System.out.println("Exiba o dicionário ordenado pelo modelo");
        Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
        System.out.println(carrosPopulares2.toString());

        System.out.println("Apague o dicionário de carros");
        carrosPopulares.clear();

        System.out.println("Confira se o dicionário está vazio " + carrosPopulares.isEmpty());



    }
}
