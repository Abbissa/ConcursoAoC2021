import java.util.Scanner;
import java.io.File;


public class Dia2 {

    public static void main(String[] args) {
        long init = System.nanoTime();
        Part1();

        Part2();
        System.out.println(Math.pow(10, -9) * (System.nanoTime() - init));
    }

    private static void Part1() {
        int x = 0;
        int y = 0;
        String direccion;
        int movimiento;

        try (Scanner sc = new Scanner(new File(".\\Dia2\\Dia2"))) {
            while (sc.hasNext()) {
                direccion = sc.next();
                movimiento = sc.nextInt();
                switch (direccion) {
                    case "forward":
                        x += movimiento;
                        break;
                    case "down":
                        y += movimiento;
                        break;
                    case "up":
                        y -= movimiento;
                        break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Parte 2: " + x * y);
    }

    private static void Part2() {
        int aim = 0;
        int x = 0;
        int y = 0;
        String direccion;
        int movimiento;

        try (Scanner sc = new Scanner(new File(".\\Dia2\\Dia2"))) {
            while (sc.hasNext()) {
                direccion = sc.next();
                movimiento = sc.nextInt();
                switch (direccion) {
                    case "forward":
                        x += movimiento;
                        y += aim * movimiento;
                        break;
                    case "down":
                        aim += movimiento;
                        break;
                    case "up":
                        aim -= movimiento;
                        break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Parte 1: " + x * y);
    }
}
