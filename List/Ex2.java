import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/* Telefonou para a vítima?
   Esteve no local do crime?
   Mora perto da vítima?
   Devia para a vítima?
   Já trabalhou com a vítima?*/

public class Ex2 {
    
    public static void main(String args[]){
        List<String> questions = new ArrayList<String>();
        Scanner input = new Scanner(System.in);
        String resposta;
        System.out.print("Telefonou para a vítima? SIM - S / NÃO - N: ");
        resposta = input.nextLine();
        questions.add(resposta);
        System.out.print("Esteve no local do crime? SIM - S / NÃO - N: ");
        resposta = input.nextLine();
        questions.add(resposta);
        System.out.print("Mora perto da vítima? SIM - S / NÃO - N: ");
        resposta = input.nextLine();
        questions.add(resposta);
        System.out.print("Devia para a vítima? SIM - S / NÃO - N: ");
        resposta = input.nextLine();
        questions.add(resposta);
        System.out.print("Já trabalhou com a vítima? SIM - S / NÃO - N: ");
        resposta = input.nextLine();
        questions.add(resposta);
        Iterator<String> iterator = questions.iterator();
        int suspeito=0;
        while(iterator.hasNext()){
            String resp = iterator.next();
            if(resp.equalsIgnoreCase("s"))
                suspeito++;
        }
        if(suspeito==2)
            System.out.println("Suspeita");
        else if (suspeito==3 || suspeito==4)
            System.out.println("Cúmplice");
        else if (suspeito==5)
            System.out.println("Assassina");
        else{
            System.out.println("Inocente");
        }
        input.close();
        
    }
}
