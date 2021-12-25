import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Dia13 {

    public static void main(String[] args) {
        Part1();
    }

    private static void Part1() {

        int cont = 0;

        boolean[][] paper = new boolean[2000][2000];
        try (Scanner sc = new Scanner(new File(".\\Dia13\\Dia13"))) {
            String aux;
            boolean fin = false;
            while (!fin) {
                aux = sc.nextLine();
                if (!aux.equals("")) {
                    int x = Integer.parseInt(aux.split(",")[0]);
                    int y = Integer.parseInt(aux.split(",")[1]);
                    paper[y][x] = true;

                    
                } else {
                    fin = true;
                }
            }
            while (sc.hasNext()) {
                aux = sc.nextLine();
                String[] fold = aux.split(" ");

                if (fold[2].charAt(0) == 'x') {
                    int x = Integer.parseInt(fold[2].split("=")[1]);
                    boolean[][] nuevo = new boolean[paper.length][x];
                    for (int i = 0; i < paper.length; i++) {
                        for (int j = 1; j <= x; j++) {
                            nuevo[i][x - j] = paper[i][x - j] || paper[i][j + x];
                        }
                    }
                    paper = nuevo;
                } else {

                    int y = Integer.parseInt(fold[2].split("=")[1]);
                    boolean[][] nuevo = new boolean[y][paper[0].length];
                    for (int i = 1; i <= y; i++) {
                        for (int j = 0; j < paper[0].length; j++) {
                            nuevo[y - i][j] = paper[y - i][j] || paper[i + y][j];
                        }
                    }
                    paper = nuevo;
                }
            }

            for (int i = 0; i < paper.length; i++) {
            for (int j = 0; j < paper[0].length; j++) {
            if (paper[i][j]) {
            System.out.print("#");
            // System.out.print("█");
            } else
            System.out.print("·");
            }
            System.out.println();
            }

            for (int i = 0; i < paper.length; i++) {
                for (int j = 0; j < paper[0].length; j++) {
                    if (paper[i][j]) {
                        cont++;
                    }
                }
            }
            System.out.println("Parte 1: " + cont);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
