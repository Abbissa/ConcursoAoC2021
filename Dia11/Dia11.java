import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Dia11 {

	private static int[][] octopuses = new int[10][10];

	public static void main(String[] args) {
		Part1();
		Part2();
	}

	private static void Part1() {

		try (Scanner sc = new Scanner(new File(".\\Dia11\\Dia11"))) {
			int cont = 0;
			sc.useDelimiter("");
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					String aux = sc.next();
					octopuses[i][j] = Integer.parseInt(aux);
				}
				
				if (sc.hasNext())
					sc.nextLine();
			}
			for (int i = 0; i < 100; i++) {
				boolean changed = true;
				for (int j = 0; j < 10; j++) {
					for (int k = 0; k < 10; k++) {

						octopuses[j][k]++;
					}
				}
				while (changed) {
					changed = false;
					for (int j = 0; j < 10; j++) {
						for (int k = 0; k < 10; k++) {
							if (octopuses[j][k] > 9) {
								cont++;
								changed = true;
								addNeightbours(octopuses, j, k);
								octopuses[j][k] = Integer.MIN_VALUE;
							}

						}
					}
				}
				for (int j = 0; j < 10; j++) {
					for (int k = 0; k < 10; k++) {
						if (octopuses[j][k] < 0)
							octopuses[j][k] = 0;
					}
				}

			}

			System.out.println("Parte 1: " + cont);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static void addNeightbours(int[][] octopuses, int i, int j) {

		if (i > 0) {
			if (j > 0) {
				octopuses[i - 1][j - 1]++;
			}
			octopuses[i - 1][j]++;
			if (j < 9) {
				octopuses[i - 1][j + 1]++;
			}
		}
		if (j > 0)
			octopuses[i][j - 1]++;
		if (j < 9)
			octopuses[i][j + 1]++;
		if (i < 9) {
			if (j > 0) {
				octopuses[i + 1][j - 1]++;
			}
			octopuses[i + 1][j]++;
			if (j < 9) {
				octopuses[i + 1][j + 1]++;
			}
		}

	}

	private static void Part2() {
		boolean end = false;
		int res = 0;
		try (Scanner sc = new Scanner(new File(".\\Dia11\\Dia11"))) {
			int cont = 0;
			sc.useDelimiter("");
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					String aux = sc.next();
					octopuses[i][j] = Integer.parseInt(aux);
				}
				
				if (sc.hasNext())
					sc.nextLine();
			}
			for (int i = 0; !end; i++) {
				boolean changed = true;
				for (int j = 0; j < 10; j++) {
					for (int k = 0; k < 10; k++) {

						octopuses[j][k]++;
					}
				}
				while (changed) {
					changed = false;
					for (int j = 0; j < 10; j++) {
						for (int k = 0; k < 10; k++) {
							if (octopuses[j][k] > 9) {
								cont++;
								changed = true;
								addNeightbours(octopuses, j, k);
								octopuses[j][k] = Integer.MIN_VALUE;
							}

						}
					}
				}
				for (int j = 0; j < 10; j++) {
					for (int k = 0; k < 10; k++) {
						if (octopuses[j][k] < 0)
							octopuses[j][k] = 0;
					}
				}

				if (cont == 100) {
					end = true;
					res=i+1;
				} else
					cont = 0;

			}

			System.out.println("Parte 2: " + res);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
