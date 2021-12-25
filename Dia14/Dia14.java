import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Dia14 {

    public static void main(String[] args) {
        Part1();
        Part2();
    }

    private static void Part1() {
        HashMap<String,Character> insertions =new HashMap<>();
        try (Scanner sc = new Scanner(new File(".\\Dia14\\Dia14"))) {
            ArrayList<Character> template = new ArrayList<>();
            for (Character character : sc.next().toCharArray()) {
                template.add(character);
            }
            while (sc.hasNext()) {
                String key = sc.next();
                sc.next();
                Character value = sc.next().charAt(0);
                insertions.put(key, value);
            }

            for(int i=0;i<40;++i){
                ArrayList<Character> post = (ArrayList<Character>) template.clone();

                int n=0;
                for(int j=1;j<template.size();j++){
                    String aux=template.get(j-1).toString()+template.get(j).toString();
                    Character temp=insertions.get(aux);
                    if(temp!=null){
                        post.add(j+n, temp);
                        n++;
                    }
                }
                template=post;
                
            }
            HashMap<Character,Long> aparitions =new HashMap<>();
            for (Character character : template) {
                Long res= aparitions.get(character);
                if(res==null)
                    res=(long) 0;
                aparitions.put(character, ++res);

            }
            long max=Integer.MIN_VALUE;
            long min=Integer.MAX_VALUE;
            for (Long i : aparitions.values()) {
                if(i>max)
                    max=i;
                if(i<min)
                    min=i;
                
            }

            System.out.println("Parte 1: "+(max-min));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void Part2() {
        int cont = 0;
        try (Scanner sc = new Scanner(new File(".\\Dia14\\Dia14"))) {
            
           
            while (sc.hasNext()) {
               sc.nextLine();
            }
            System.out.println("Parte 2: ");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
