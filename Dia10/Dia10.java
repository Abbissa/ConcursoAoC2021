import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dia10 {

    private static Deque<Character> stack;

    public static void main(String[] args) {
        Part1();

        Part2();

    }

    private static void Part1() {
        String aux = "";
        int res = 0;
        try (Scanner sc = new Scanner(new File(".\\Dia10\\Dia10"))) {

            while (sc.hasNext()) {
                stack = new ArrayDeque<Character>();
                aux = sc.nextLine();
                for (int i = 0; i < aux.length(); i++) {
                    Character c = aux.charAt(i);
                    Character c2;
                    if (c.equals('<') || c.equals('(') || c.equals('{') || c.equals('['))
                        stack.push(aux.charAt(i));
                    else {
                        c2 = stack.pop();
                        if (c2.equals('<') && !c.equals('>')) {
                            if (c.equals(')'))
                                res += 3;
                            else if (c.equals('}'))
                                res += 1197;
                            else if (c.equals(']'))
                                res += 57;
                        } else if (c2.equals('(') && !c.equals(')')) {
                            if (c.equals(']'))
                                res += 57;
                            else if (c.equals('}'))
                                res += 1197;
                            else if (c.equals('>'))
                                res += 25137;
                        } else if (c2.equals('[') && !c.equals(']')) {
                            if (c.equals(')'))
                                res += 3;
                            else if (c.equals('}'))
                                res += 1197;
                            else if (c.equals('>'))
                                res += 25137;
                        } else if (c2.equals('{') && !c.equals('}')) {
                            if (c.equals(')'))
                                res += 3;
                            else if (c.equals(']'))
                                res += 57;
                            else if (c.equals('>'))
                                res += 25137;
                        }
                    }
                }

            }

            System.out.println("Parte 1: " + res);

        } catch (

        Exception e) {
            System.out.println(e);
        }
    }

    private static void Part2() {
        int res = 0;
        String aux;
        PriorityQueue<Long> scores = new PriorityQueue<Long>();
        try (Scanner sc = new Scanner(new File(".\\Dia10\\Dia10"))) {
            while (sc.hasNext()) {
                stack = new ArrayDeque<Character>();
                aux = sc.nextLine();
                boolean fin = false;
                Long temp = (long) 0;
                for (int i = 0; i < aux.length() && !fin; i++) {
                    Character c = aux.charAt(i);
                    Character c2;
                    if (c.equals('<') || c.equals('(') || c.equals('{') || c.equals('['))
                        stack.push(aux.charAt(i));
                    else {
                        c2 = stack.pop();
                        if (c2.equals('<') && !c.equals('>')) {
                            fin = true;
                        } else if (c2.equals('(') && !c.equals(')')) {
                            fin = true;
                        } else if (c2.equals('[') && !c.equals(']')) {
                            fin = true;
                        } else if (c2.equals('{') && !c.equals('}')) {
                            fin = true;
                        }
                    }
                }
                if (!fin) {
                    while (!stack.isEmpty()) {
                        Character c = stack.poll();
                        if (c.equals('(')) {
                            temp = 5 * temp + 1;
                        } else if (c.equals('[')) {
                            temp = 5 * temp + 2;
                        } else if (c.equals('{')) {
                            temp = 5 * temp + 3;
                        } else if (c.equals('<')) {
                            temp = 5 * temp + 4;

                        }

                    }
                    System.out.println(temp);
                    scores.add(temp);

                }

            }
            int size = scores.size() / 2;
            while (size != 0) {
                scores.poll();
                size--;
            }
            System.out.println();

            System.out.println("Parte 2: " + scores.poll());
        } catch (

        Exception e) {
            System.out.println(e);
        }
    }
}
