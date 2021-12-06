import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Dia6 {
    static int N = 80;
    static int N2 = 256;

    public static void main(String[] args) {

        Parte1();

        Parte2();
    }

    private static void Parte2() {
        long[][] lanternfishes = new long[2][9];
        int edad;
        try (

                Scanner sc = new Scanner(new File(".\\Dia6\\Dia6"))) {
            sc.useDelimiter(",");
            while (sc.hasNextInt()) {
                edad = sc.nextInt();
                lanternfishes[0][edad] += 1;

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        int n = 0;
        int nM1 = 1;

        for (int i = 0; i < N2; ++i) {
            for (int j = 0; j < lanternfishes[n].length; j++) {
                if (j == 6) {
                    lanternfishes[nM1][j] = lanternfishes[n][j + 1] + lanternfishes[n][0];

                } else if (j == 8) {
                    lanternfishes[nM1][j] = lanternfishes[n][0];
                } else {

                    lanternfishes[nM1][j] = lanternfishes[n][j + 1];
                }
            }
            
            int aux = n;
            n = nM1;
            nM1 = aux;

        }

        long cont = 0;
        for (int i = 0; i < lanternfishes[n].length; i++) {

            cont += lanternfishes[n][i];
        }
        System.out.println("Parte 2: " + cont);

    }

    public static void Parte1() {
        ArrayList<Integer> lanternfishes = new ArrayList<Integer>();
        int edad;
        try (

                Scanner sc = new Scanner(new File(".\\Dia6\\Dia6"))) {
            sc.useDelimiter(",");
            while (sc.hasNextInt()) {
                edad = sc.nextInt();
                lanternfishes.add(edad);

            }

            for (int i = 0; i < N; i++) {
                int cont = 0;
                for (int j = 0; j < lanternfishes.size(); j++) {
                    edad = lanternfishes.get(j);

                    if (edad == 0) {
                        lanternfishes.set(j, 6);
                        cont++;
                    } else {
                        edad--;
                        lanternfishes.set(j, edad);
                    }

                }
                for (int j = 0; j < cont; j++) {
                    lanternfishes.add(8);
                }
                System.out.println(i);

            }
            System.out.println("Parte 1: " + lanternfishes.size());

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
