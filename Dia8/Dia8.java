import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

public class Dia8 {

    public static void main(String[] args) {
        Part1();
        Part2();
    }

    private static void Part1() {
        String act;
        int cont = 0;

        try (Scanner sc = new Scanner(new File(".\\Dia8\\Dia8"))) {
            while (sc.hasNext()) {
                for (int i = 0; i < 11; i++) {
                    sc.next();
                }

                for (int i = 0; i < 4; i++) {
                    act = sc.next();
                    int tam = act.length();
                    if (tam == 2 || tam == 3 || tam == 4 || tam == 7) {
                        cont++;
                    }
                }
            }
            System.out.println("Parte 1: " + cont);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void Part2() {
        String act;
        int cont = 0;
        int acum = 0;
        try (Scanner sc = new Scanner(new File(".\\Dia8\\Dia8"))) {
            while (sc.hasNext()) {
                String[] numeros = new String[10];
                for (int i = 0; i < 10; i++) {
                    numeros[i] = sc.next();
                }

                sc.next();
                Character[] letras = averiguarNumeros(numeros);
                int res = 0;
                for (int i = 0; i < 4; i++) {
                    act = sc.next();

                    int tam = act.length();
                    if (tam == 6)
                        if (!act.contains(letras[3] + "")) {
                            res = res * 10 + 0;
                        } else if (!act.contains(letras[4] + "")) {
                            res = res * 10 + 9;
                        } else
                            res = res * 10 + 6;

                    else if (tam == 7)
                        res = res * 10 + 8;
                    else if (tam == 2)
                        res = res * 10 + 1;
                    else if (tam == 4)
                        res = res * 10 + 4;
                    else if (tam == 3)
                        res = res * 10 + 7;
                    else {
                        if (!act.contains(letras[2] + "")) {
                            res = res * 10 + 5;

                        } else if (!act.contains(letras[4] + "")) {
                            res = res * 10 + 3;
                        } else
                            res = res * 10 + 2;
                    }
                }
                acum += res;
            }
            System.out.println("Parte 1: " + acum);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static Character[] averiguarNumeros(String[] numeros) {
        Character[] letras = new Character[7];
        HashSet<Character> aux = new HashSet<Character>();
        String aux1 = "";

        for (int i = 0; i < numeros.length; i++) {
            int tam = numeros[i].length();
            if (tam == 2 && i != 1) {

                aux1 = numeros[1];
                
                numeros[1] = numeros[i];
                numeros[i] = aux1;
                i = -1;
            } else if (tam == 3 && i != 7) {
                aux1 = numeros[7];
                
                numeros[7] = numeros[i];
                numeros[i] = aux1;
                i = Math.min(7, i-1);
            } else if (tam == 4 && i != 4) {

                aux1 = numeros[4];
                
                numeros[4] = numeros[i];
                numeros[i] = aux1;
                i = Math.min(4, i-1);
            } else if (tam == 7 && i != 8) {

                aux1 = numeros[8];
                
                numeros[8] = numeros[i];
                numeros[i] = aux1;
                i = Math.min(7, i-1);

            }
        }
        // System.out.println(Arrays.toString(numeros));
        // System.out.println("El 1 es: " + numeros[1]);
        // System.out.println("El 4 es: " + numeros[4]);
        // System.out.println("El 7 es: " + numeros[7]);
        // System.out.println("El 8 es: " + numeros[8]);

        for (int i = 0; i < numeros[7].length(); i++) {
            aux.add(numeros[7].charAt(i));
        }

        HashSet<Character> copy = (HashSet<Character>) aux.clone();
        for (int i = 0; i < numeros[1].length(); i++) {
            aux.remove(numeros[1].charAt(i));
        }
        // System.out.println(aux.toArray().length);

        letras[0] = (Character) aux.toArray()[0];
        // System.out.println("La a es :" + letras[0]);

        for (int i = 0; i < numeros.length; i++) {
            int tam = numeros[i].length();
            if (tam == 6) {
                aux = (HashSet<Character>) copy.clone();

                for (int j = 0; j < 6; j++) {
                    aux.remove(numeros[i].charAt(j));
                }
                if (aux.size() != 0) {
                    letras[2] = (Character) aux.toArray()[0];
                    // System.out.println("La c es :" + letras[2]);
                }

            }

        }

        if (numeros[1].charAt(0) != letras[2])
            letras[5] = numeros[1].charAt(0);
        else
            letras[5] = numeros[1].charAt(1);
        // System.out.println("La f es :" + letras[5]);
        aux = new HashSet<Character>();
        for (int i = 0; i < numeros.length; i++) {
            int tam = numeros[i].length();
            if (tam == 5 || tam == 4) {

                HashSet<Character> temp = new HashSet<Character>();
                for (int j = 0; j < numeros[i].length(); j++) {
                    temp.add(numeros[i].charAt(j));
                }
                if (aux.isEmpty())
                    aux = temp;
                else
                    aux.retainAll(temp);
            }

        }

        letras[3] = (Character) aux.toArray()[0];
        // System.out.println("La d es :" + letras[3]);
        HashSet<Character> temp = new HashSet<Character>();

        for (int j = 0; j < numeros[4].length(); j++) {
            temp.add(numeros[4].charAt(j));
        }
        temp.remove(letras[2]);
        temp.remove(letras[3]);
        temp.remove(letras[5]);

        letras[1] = (Character) temp.toArray()[0];
        // System.out.println("La b es :" + letras[1]);

        for (int i = 0; i < numeros.length; i++) {
            int tam = numeros[i].length();
            if (tam == 6) {
                temp = new HashSet<Character>();

                for (int j = 0; j < 6; j++) {
                    temp.add(numeros[i].charAt(j));
                }
                temp.remove(letras[0]);
                temp.remove(letras[1]);
                temp.remove(letras[2]);
                temp.remove(letras[3]);
                temp.remove(letras[5]);

                if (temp.size() == 1) {
                    letras[6] = (Character) temp.toArray()[0];
                    // System.out.println("La g es :" + letras[6]);
                }

            }

        }

        for (int i = 0; i < numeros.length; i++) {
            int tam = numeros[i].length();
            if (tam == 6) {
                temp = new HashSet<Character>();

                for (int j = 0; j < 6; j++) {
                    temp.add(numeros[i].charAt(j));
                }
                temp.remove(letras[0]);
                temp.remove(letras[1]);
                temp.remove(letras[2]);
                temp.remove(letras[3]);
                temp.remove(letras[5]);
                temp.remove(letras[6]);

                if (temp.size() == 1) {
                    letras[4] = (Character) temp.toArray()[0];
                    // System.out.println("La e es :" + letras[4]);
                }

            }

        }

        // System.out.println();
        return letras;
    }
}
