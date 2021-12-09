import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dia9 {
    private static ArrayList<Pair<Integer, Integer>> minimos;
    private static ArrayList<Integer[]> filas;
    private static PriorityQueue priorityQueue;

    public static void main(String[] args) {
        minimos = new ArrayList<Pair<Integer, Integer>>();

        Part1();
        Part2();
    }

    private static void Part1() {
        filas = new ArrayList<Integer[]>();
        try (Scanner sc = new Scanner(new File(".\\Dia9\\Dia9"))) {
            String aux = sc.nextLine();

            int tam = aux.length();
            Integer[] fila = new Integer[tam];

            int res = 0;
            for (int i = 0; i < aux.length(); i++) {
                fila[i] = Integer.parseInt(aux.charAt(i) + "");
            }
            filas.add(fila);

            while (sc.hasNext()) {
                aux = sc.nextLine();
                fila = new Integer[tam];
                for (int i = 0; i < aux.length(); i++) {
                    fila[i] = Integer.parseInt(aux.charAt(i) + "");
                }
                filas.add(fila);
            }
            for (int i = 0; i < filas.size(); i++) {
                Integer[] temp = filas.get(i);
                boolean menor = true;
                for (int j = 0; j < temp.length; j++) {
                    if (i > 0 && temp[j] >= filas.get(i - 1)[j]) {

                        menor = false;
                    } else if (j > 0 && temp[j] >= filas.get(i)[j - 1]) {

                        menor = false;
                    } else if (i < filas.size() - 1 && temp[j] >= filas.get(i + 1)[j]) {

                        menor = false;
                    } else if (j < temp.length - 1 && temp[j] >= filas.get(i)[j + 1]) {

                        menor = false;
                    }
                    if (menor) {

                        minimos.add(new Pair<Integer, Integer>(i, j));
                        res += temp[j] + 1;
                    }
                    menor = true;
                }

            }
            System.out.println("Parte 1: " + res);
        } catch (

        Exception e) {
            System.out.println(e);
        }
    }

    private static void Part2() {
        ArrayList<HashSet<Integer>> añadidos = new ArrayList<HashSet<Integer>>();
        PriorityQueue<Integer> basins = new PriorityQueue<Integer>(minimos.size(),new Comparador());
       priorityQueue = new  PriorityQueue(2);
        for (int i = 0; i < filas.size(); i++) {
            añadidos.add(new HashSet<Integer>());
        }
        for (Pair<Integer, Integer> pair : minimos) {
            HashSet<Integer> temp;

            temp = añadidos.get(pair.getLeft());
            temp.add(pair.getRight());
            System.out.println(pair.getLeft()+" "+pair.getRight());
            int aux = findBasins(pair.getLeft(), pair.getRight(), añadidos);

            System.out.println("----");
            System.out.println(aux);
            System.out.println("----");

            basins.add(aux);
        }
        
        int aux1=basins.poll();
        int aux2=basins.poll();
        int aux3=basins.poll();
        System.out.println(aux1+" "+aux2+" "+aux3);
        System.out.println("Parte 2: " + aux1 * aux2 * aux3);

    }

    static int findBasins(int i, int j, ArrayList<HashSet<Integer>> añadidos) {
        int count = 1;
        HashSet<Integer> temp;
        
        if (i > 0 && filas.get(i)[j] + 1 == filas.get(i - 1)[j] && filas.get(i - 1)[j] != 9
                && !añadidos.get(i - 1).contains(j)){
            temp = añadidos.get(i - 1);
            if (temp == null) {
                temp = new HashSet<Integer>();
                añadidos.add(i - 1, temp);
            }
            temp.add(j);
            // System.out.println(1);
            // System.out.println();
            // System.out.println(i-1+" "+j);
            // System.out.println();
            count += findBasins(i - 1, j, añadidos);

        }

        if (j > 0 && filas.get(i)[j] + 1 == filas.get(i)[j - 1] && filas.get(i)[j - 1] != 9
                && !añadidos.get(i).contains(j - 1)) {
            temp = añadidos.get(i);
            temp.add(j - 1);
            // System.out.println(2);
            // System.out.println();
            // System.out.println(i+" "+(j-1));
            // System.out.println();
            count += findBasins(i, j - 1, añadidos);

        }

        if (i < filas.size() - 1 && filas.get(i + 1)[j].equals(filas.get(i)[j] + 1) && filas.get(i + 1)[j] != 9
                &&  !añadidos.get(i + 1).contains(j)){
            temp = añadidos.get(i + 1);
            temp.add(j);
            // System.out.println(3);
            // System.out.println();
            // System.out.println(i + 1 + " " + j);
            // System.out.println();
            count += findBasins(i + 1, j, añadidos);

        }
        if (j < filas.get(i).length - 1 && filas.get(i)[j] + 1 == filas.get(i)[j + 1] && filas.get(i)[j + 1] != 9
                && !añadidos.get(i).contains(j + 1)) {
            temp = añadidos.get(i);
            temp.add(j + 1);
            // System.out.println(4);
            // System.out.println();
            // System.out.println(i+" "+j+1);
            // System.out.println();
            count += findBasins(i, j + 1, añadidos);

        }
        return count;

    }
    public static class Comparador implements Comparator{

        @Override
        public int compare(Object o1, Object o2) {
            
            return (int)o2-(int)o1;
        }

    }
}