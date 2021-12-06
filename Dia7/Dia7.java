import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dia7 {

	public static void main(String[] args) {
		Part1();
		Part2();
	}
	private static void Part1() {
		
		int cont=0;

		try (Scanner sc = new Scanner(new File(".\\Dia1\\Dia1"))) {
			while(sc.hasNextInt()) {
				
                //leer
			}

			System.out.println("Parte 1: "+cont);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	private static void Part2() {
		
		try (Scanner sc = new Scanner(new File(".\\Dia1\\Dia1"))) {
			

			while(sc.hasNext()) {
				//leer	
			}
			System.out.println("Parte 2: "+cont);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}	
}
