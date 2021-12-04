import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Dia4 {
    public static void main(String[] args) {

        Part1();

        Part2();

    }

    private static void Part1() {

        try (Scanner sc = new Scanner(new File(".\\Dia4\\Dia4"))) {

            ArrayList<Bingo> bingos= new ArrayList<Bingo>();
            String aux = sc.nextLine();

            String[] aux2 = aux.split(",");
            int[] nums = new int[aux2.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(aux2[i]);
            }

            while (sc.hasNext()) {

                Bingo bingo = new Bingo();
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        int temp = sc.nextInt();
                        bingo.cols[j].add(temp);
                        bingo.rows[i].add(temp);
                        bingo.nums.add(temp);
                    }
                }
                bingos.add(bingo);
            }
            boolean fin = false;
            for (int i = 0; i < nums.length && !fin; i++) {
                for (int j = 0; j < bingos.size() && !fin; j++) {
                    Bingo bingo = bingos.get(j);
                    for (int k = 0; k < 5 && !fin; k++) {
                        int num = nums[i];
                        bingo.rows[k].remove(num);
                        bingo.cols[k].remove(num);
                        bingo.nums.remove(num);
                        if (bingo.rows[k].size() == 0 || bingo.cols[k].size() == 0) {
                            fin = true;
                            int res = calcularRes(bingo);
                           
                            System.out.println("Parte 1: " + res * num);
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int calcularRes(Bingo bingo) {
        int res = 0;
        for (Integer n : bingo.nums) {

            res += n;
        }
        return res;
    }

    private static void Part2() {
        try (Scanner sc = new Scanner(new File(".\\Dia4\\Dia4"))) {
            ArrayList<Bingo> bingos= new ArrayList<Bingo>();;
            String aux = sc.nextLine();

            String[] aux2 = aux.split(",");
            int[] nums = new int[aux2.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(aux2[i]);
            }
            while (sc.hasNext()) {

                Bingo bingo = new Bingo();
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        int temp = sc.nextInt();
                        bingo.cols[j].add(temp);
                        bingo.rows[i].add(temp);
                        bingo.nums.add(temp);
                    }
                    
                }
                
                bingos.add(bingo);
            }

            boolean fin = false;
            for (int i = 0; i < nums.length && !fin; i++) {
                int j=0;
                while(j<bingos.size()&&!fin){
                    Bingo bingo = bingos.get(j);
                    boolean borrado = false;
                    for (int k = 0; k < 5 && !fin && !borrado; k++) {
                        int num = nums[i];
                        bingo.rows[k].remove(num);
                        bingo.cols[k].remove(num);
                        bingo.nums.remove(num);
                            
                        if (bingo.rows[k].size() == 0 || bingo.cols[k].size() == 0) {
                            
                            bingos.remove(j);
                            borrado = true;
                        }
                            
                        if (bingos.size() == 0) {
                            fin = true;
                            int res = calcularRes(bingo);
                            
                            System.out.println("Parte 2: " + res * num);
                        }
                    }
                    if(!borrado)
                        j++;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
