import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Dia5 {

    public static void main(String[] args) {

        Part1();

        Part2();
    }

    private static void Part1() {
        try (Scanner sc = new Scanner(new File(".\\Dia5\\Dia5"))) {
            HashMap<Integer, HashMap<Integer, Integer>> posiciones = new HashMap<Integer, HashMap<Integer, Integer>>();
            while (sc.hasNext()) {

                String aux = sc.nextLine();
                String[] aux2 = aux.split("->");
                String[] aux3 = aux2[0].split(",");
                int x1 = Integer.parseInt(aux3[0]);
                int y1 = Integer.parseInt(aux3[1].trim());
                aux3 = aux2[1].split(",");
                int x2 = Integer.parseInt(aux3[0].trim());
                int y2 = Integer.parseInt(aux3[1]);

                if (x1 == x2) {
                    Vertical(x1, y1, y2, posiciones);

                } else if (y1 == y2) {
                    Horizontal(y1, x1, x2, posiciones);
                }
            }
            int cont = 0;
            for (HashMap<Integer, Integer> pos : posiciones.values()) {
                for (Integer i : pos.values()) {
                    if (i >= 2)
                        cont++;
                }
            }
            System.out.println("Parte 1: " + cont);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void Part2() {
        try (Scanner sc = new Scanner(new File(".\\Dia5\\Dia5"))) {
            HashMap<Integer, HashMap<Integer, Integer>> posiciones = new HashMap<Integer, HashMap<Integer, Integer>>();
            while (sc.hasNext()) {

                String aux = sc.nextLine();
                String[] aux2 = aux.split("->");
                String[] aux3 = aux2[0].split(",");
                int x1 = Integer.parseInt(aux3[0]);
                int y1 = Integer.parseInt(aux3[1].trim());
                aux3 = aux2[1].split(",");
                int x2 = Integer.parseInt(aux3[0].trim());
                int y2 = Integer.parseInt(aux3[1]);

                if (x1 == x2) {
                    Vertical(x1, y1, y2, posiciones);

                } else if (y1 == y2) {
                    Horizontal(y1, x1, x2, posiciones);
                } else
                    Diagonal(x1, x2, y1, y2, posiciones);
            }
            int cont = 0;
            for (HashMap<Integer, Integer> pos : posiciones.values()) {
                for (Integer i : pos.values()) {
                    if (i >= 2)
                        cont++;
                }
            }
            System.out.println("Parte 2: " + cont);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void Diagonal(int x1, int x2, int y1, int y2,
            HashMap<Integer, HashMap<Integer, Integer>> posiciones) {

        int aux1 = x1;
        int aux2 = x2;
        int aux3 = 1;
        int aux4 = 1;
        if (aux1 > aux2) {
            int aux = aux1;
            aux1 = aux2;
            aux2 = aux;
            aux3 = -1;
        }
        if (y1 > y2)
            aux4 = -1;
        for (int i = 0; i <= aux2 - aux1; i++) {
            int x=x1+i*aux3;
            int y=y1+i*aux4;
            HashMap<Integer, Integer> res = posiciones.get(x);

            if (res == null) {
                res = new HashMap<Integer, Integer>();
                posiciones.put(x, res);
            }
            Integer value = res.get(y);
            if (value == null) {
                value = 0;
            }
            res.put(y, value + 1);
        }
    }

    private static void Vertical(int x1, int i1, int i2, HashMap<Integer, HashMap<Integer, Integer>> posiciones) {
        if (i1 > i2) {
            int aux = i1;
            i1 = i2;
            i2 = aux;
        }
        for (int i = 0; i <= i2 - i1; i++) {

            HashMap<Integer, Integer> res = posiciones.get(x1);

            if (res == null) {
                res = new HashMap<Integer, Integer>();
                posiciones.put(x1, res);
            }
            Integer value = res.get(i1 + i);
            if (value == null) {
                value = 0;
            }
            res.put(i1 + i, value + 1);
        }

    }

    private static void Horizontal(int y1, int x1, int x2, HashMap<Integer, HashMap<Integer, Integer>> posiciones) {
        if (x1 > x2) {
            int aux = x1;
            x1 = x2;
            x2 = aux;
        }
        for (int i = 0; i <= x2 - x1; i++) {

            HashMap<Integer, Integer> res = posiciones.get(x1 + i);

            if (res == null) {
                res = new HashMap<Integer, Integer>();
                posiciones.put(x1 + i, res);
            }
            Integer value = res.get(y1);
            if (value == null) {
                value = 0;
            }
            res.put(y1, value + 1);
        }
    }
}
