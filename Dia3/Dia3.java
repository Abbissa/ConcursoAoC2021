import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

public class Dia3 {

    public static void main(String[] args) {
        
        Part1();

        Part2();
       
    }

    private static void Part1() {

        try (Scanner sc = new Scanner(new File(".\\Dia3\\Dia3"))) {
            int cont = 0;
            String aux = sc.next();
            cont++;
            int[] veces = new int[aux.length()];
            for (int i = 0; i < aux.length(); i++) {
                if (aux.charAt(i) == '1') {
                    veces[i]++;
                }
            }
            while (sc.hasNext()) {

                aux = sc.next();
                cont++;
                for (int i = 0; i < aux.length(); i++) {
                    if (aux.charAt(i) == '1') {
                        veces[i]++;
                    }
                }
            }
            int gamma = 0;
            int epsilon = 0;
            for (int i = 0; i < aux.length(); i++) {
                epsilon = epsilon * 2;
                gamma = gamma * 2;
                if (cont - veces[i] > veces[i])
                    epsilon++;
                else
                    gamma++;

            }
            System.out.println("Part 1: " + gamma * epsilon);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void Part2() {
        try (Scanner sc = new Scanner(new File(".\\Dia3\\Dia3"))) {
            ArrayList<String> O2 = new ArrayList<String>();

            while (sc.hasNext()) {
                O2.add(sc.next());
            }
            ArrayList<String> CO2 = (ArrayList<String>) O2.clone();
            int cont = 0;
            int veces = 0;
            int tam = O2.get(0).length();
            while (O2.size() > 1 ) {
                for (int i = 0; i < tam; i++) {
                    cont = 0;
                    veces = 0;

                   
                    String aux;
                    for(int j=0;j<O2.size();j++){
                        cont++;
                        aux = O2.get(j);
                        if (aux.charAt(i) == '1') {
                            veces++;
                        }
                    }
                

                    Character menor = '0';
                    if (cont - veces > veces)
                        menor = '1';

                    int j=0;
                    while(j<O2.size()){
                        aux = O2.get(j);
                        if (menor.equals(aux.charAt(i))) {
                            O2.remove(j);
                        }else
                            j++;
                    }
                    
                }

            }
            while (CO2.size() > 1) {
                for (int i = 0; i < tam&&CO2.size() > 1; i++) {
                    cont = 0;
                    veces = 0;

                   
                    String aux;
                    for(int j=0;j<CO2.size();j++){
                        cont++;
                        aux = CO2.get(j);
                        if (aux.charAt(i) == '0') {
                            veces++;
                        }
                    }
                

                    Character menor = '1';
                    if (veces > cont - veces )
                        menor = '0';

                    int j=0;
                    while(j<CO2.size()){
                        aux = CO2.get(j);
                        if (menor.equals(aux.charAt(i))) {
                            CO2.remove(j);
                        }else
                            j++;
                    }
                    
                }
                

            }
            System.out.println(CO2.toString());
            System.out.println(O2.toString());
            int co2=Integer.parseInt(CO2.get(0),2);
            int o2=Integer.parseInt(O2.get(0),2);
           System.out.println("Parte 2: "+co2*o2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }}