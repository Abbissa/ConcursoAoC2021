import java.io.File;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Dia7 {

	public static void main(String[] args) {
		Part1();
		Part2();
	}

	private static void Part1() {

		PriorityQueue<Integer> nums = new PriorityQueue<Integer>();

		try (Scanner sc = new Scanner(new File(".\\Dia7\\Dia7"))) {
			sc.useDelimiter(",");
			while (sc.hasNextInt()) {
				int aux = sc.nextInt();
				nums.add(aux);

				// leer
			}
			Integer[] crabs = new Integer[nums.size()];
			int n = 0;
			while (nums.size() != 0) {
				crabs[n] = nums.poll();
				n++;
			}

			int pos = crabs.length / 2;

			int res = 0;

			int centro = (int) crabs[pos];

			for (int i = 0; i < crabs.length; i++) {
				if ((int) crabs[i] < centro) {
					res += centro - (int) crabs[i];

				} else if ((int) crabs[i] > centro) {
					res += (int) crabs[i] - centro;

				}

			}

			System.out.println("Parte 1: " + res);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static void Part2() {

		PriorityQueue<Integer> nums = new PriorityQueue<Integer>();

		try (Scanner sc = new Scanner(new File(".\\Dia7\\Dia7"))) {
			double cont = 0;
			sc.useDelimiter(",");
			while (sc.hasNextInt()) {
				int aux = sc.nextInt();
				nums.add(aux);
				cont += aux;
				// leer
			}
			Integer[] crabs = new Integer[nums.size()];
			int n = 0;
			while (nums.size() != 0) {
				crabs[n] = nums.poll();
				n++;
			}

			int res = Integer.MAX_VALUE;

			int centro = (int) Math.round(cont / crabs.length);

			for (int k = 0; k < 3; k++) {
				int aux = 0;
				for (int i = 0; i < crabs.length; i++) {

					if ((int) crabs[i] < centro - 1 + k) {
						aux += calcular((centro - 1 + k) - (int) crabs[i]);

					} else if ((int) crabs[i] > centro - 1 + k) {
						aux += calcular((int) crabs[i] - (centro - 1 + k));

					}
					
					// 92948968 466
					// 92949057 467
					// 92950147 468

				}
				if (res > aux) {
					res = aux;
				}
				System.out.println(centro - 1 + k + ": " + aux);
			}
			System.out.println("Parte 2: " + res);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static int calcular(int i) {
		int res = 0;
		for (int k = 0; k <= i; k++) {
			res += k;
		}

		return res;
	}

}
