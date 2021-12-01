import java.io.BufferedInputStream;
import java.io.File;
import java.util.Scanner;

public class Dia1 {

	public static void main(String[] args) {

		Part1();

		//Part2();
	}
	private static void Part1() {
		int prev=-1;
		int act=1;
		int cont=0;

		try (Scanner sc = new Scanner(new File(".\\Input.txt"))) {
			while(sc.hasNextInt()) {
				act=sc.nextInt();
				System.out.println(act);
				if(prev!=-1&&prev<act) {
					cont++;
				}
				prev=act;
			}
			System.out.println(cont);
		}catch(Exception e){}
	}

	private static void Part2() {
		int cont=0;
		try (Scanner sc = new Scanner(new BufferedInputStream(System.in, 2 * 1024))) {
			int n1=sc.nextInt();
			int n2=sc.nextInt();
			int n3=sc.nextInt();
			int sum=n1+n2+n3;
			while(sc.hasNext()) {
				n1=n2;
				n2=n3;
				n3=sc.nextInt();
				int aux=n1+n2+n3;
				if(sum<aux) {
					cont++;
				}
				sum=aux;	
			}
			System.out.println(cont);
		}
	}	
}
