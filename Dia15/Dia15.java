import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dia15 {

	public static void main(String[] args) {
		Part1();
		Part2();
	}

	private static void Part1() {
		ArrayList<Integer[]> mapa = new ArrayList<Integer[]>();
		try (Scanner sc = new Scanner(new File(".\\Dia15\\Dia15"))) {
			while (sc.hasNext()) {
				String aux = sc.next();
				Integer[] fila = new Integer[aux.length()];
				for (int i = 0; i < aux.length(); i++) {
					fila[i] = Integer.parseInt(aux.charAt(i) + "");
				}
				mapa.add(fila);
			}

			PriorityQueue<Pos> colaAbierta = new PriorityQueue<Pos>();
			HashMap<Integer, Pos> visitados = new HashMap<Integer, Pos>();

			Pos temp = new Pos(0, 0, 0);
			colaAbierta.add(temp);
			visitados.put(0, temp);
			boolean fin = false;
			int res = 0;
			while (!fin && !colaAbierta.isEmpty()) {

				Pos actual = colaAbierta.poll();

				// System.out.println(actual.i + " " + actual.j + " " + actual.peso + ";");
				if (actual.i == mapa.size() - 1 && actual.j == mapa.get(actual.i).length - 1) {
					fin = true;
					res = actual.peso;

				} else {
					boolean abajo = actual.i > 0;
					boolean arriba = actual.i < mapa.size() - 1;
					boolean izquierda = actual.j > 0;
					boolean derecha = actual.j < mapa.get(actual.i).length - 1;
					if (abajo) {
						// comprobar que cada sitio a visitar no esta contenido en visitados
						// visitar abajo izqierda

						if (!visitados.containsKey((actual.i - 1) * mapa.get(actual.i).length + actual.j)) {
							temp = new Pos(actual.i - 1, actual.j,
									actual.peso + mapa.get(actual.i - 1)[actual.j]);
							colaAbierta.add(temp);

						}

						// Explorar hacia abajo
					}

					if (arriba) {

						if (!visitados.containsKey((actual.i + 1) * mapa.get(actual.i).length + actual.j)) {
							temp = new Pos(actual.i + 1, actual.j,
									actual.peso + mapa.get(actual.i + 1)[actual.j]);
							colaAbierta.add(temp);

						}

					}

					if (izquierda) {
						if (!visitados.containsKey((actual.i) * mapa.get(actual.i).length + actual.j - 1)) {
							temp = new Pos(actual.i, actual.j - 1, actual.peso + mapa.get(actual.i)[actual.j - 1]);
							colaAbierta.add(temp);

						}
					}

					if (derecha) {
						if (!visitados.containsKey((actual.i) * mapa.get(actual.i).length + actual.j + 1)) {
							temp = new Pos(actual.i, actual.j + 1, actual.peso + mapa.get(actual.i)[actual.j + 1]);
							colaAbierta.add(temp);

						}
					}
					visitados.put(actual.i * mapa.get(actual.i).length + actual.j, actual);
				}
			}
			System.out.println("Parte 1: " + res);
			// while (!colaAbierta.isEmpty()) {
			// temp = colaAbierta.poll();
			// System.out.println(temp.i + " " + temp.j + " " + temp.peso);
			// }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void Part2() {

		ArrayList<ArrayList<Integer>> mapa = new ArrayList<ArrayList<Integer>>();
		try (Scanner sc = new Scanner(new File(".\\Dia15\\Dia15"))) {
			while (sc.hasNext()) {
				String aux = sc.next();
				ArrayList<Integer> fila = new ArrayList<Integer>();
				for (int i = 0; i < aux.length(); i++) {
					fila.add(Integer.parseInt(aux.charAt(i) + ""));
				}
				mapa.add(fila);
			}
			int filas = mapa.size();
			int columnas = mapa.get(0).size();

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < filas; j++) {
					for (int k = 0; k < columnas; k++) {
						int temp = mapa.get(j).get(k) + 1 + i;
						if (temp > 9)
							temp -= 9;
						mapa.get(j).add(temp);
					}

				}

			}
			filas = mapa.size();
			columnas = mapa.get(0).size();

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < filas; j++) {
					ArrayList<Integer> fila = new ArrayList<Integer>();
					for (int k = 0; k < columnas; k++) {
						int temp = mapa.get(j).get(k) + 1 + i;
						if (temp > 9)
							temp -= 9;
						fila.add(temp);
					}
					mapa.add(fila);
				}

			}

			// for (ArrayList<Integer> arrayList : mapa) {

			// for (int i = 0; i < arrayList.size(); i++) {
			// System.out.print(arrayList.get(i) + " ");
			// }
			// System.out.println();

			// }

			PriorityQueue<Pos> colaAbierta = new PriorityQueue<Pos>();
			HashMap<Integer, Pos> visitados = new HashMap<Integer, Pos>();
			HashMap<Integer, Pos> añadidos = new HashMap<Integer, Pos>();

			Pos temp = new Pos(0, 0, 0);
			colaAbierta.add(temp);
			visitados.put(0, temp);
			boolean fin = false;
			int res = 0;
			while (!fin && !colaAbierta.isEmpty()) {

				Pos actual = colaAbierta.poll();

				// System.out.println(actual.i + " " + actual.j + " " + actual.peso + ";");
				if (actual.i == mapa.size() - 1 && actual.j == mapa.get(actual.i).size() - 1) {
					fin = true;
					res = actual.peso;

				} else {
					boolean abajo = actual.i > 0;
					boolean arriba = actual.i < mapa.size() - 1;
					boolean izquierda = actual.j > 0;
					boolean derecha = actual.j < mapa.get(actual.i).size() - 1;
					if (abajo) {
						// comprobar que cada sitio a visitar no esta contenido en visitados
						// visitar abajo izqierda
						int key = (actual.i - 1) * mapa.get(actual.i).size() + actual.j;
						if (!visitados.containsKey(key)) {
							if (añadidos.containsKey(key)) {
								Pos prev = añadidos.get(key);
								if (prev.peso > actual.peso + mapa.get(actual.i - 1).get(actual.j)) {
									prev.peso = actual.peso + mapa.get(actual.i - 1).get(actual.j);
								}
							} else {
								temp = new Pos(actual.i - 1, actual.j,
										actual.peso + mapa.get(actual.i - 1).get(actual.j));
								colaAbierta.add(temp);
								añadidos.put(key, temp);
							}
						}

						// Explorar hacia abajo
					}

					if (arriba) {
						int key = (actual.i + 1) * mapa.get(actual.i).size() + actual.j;
						if (!visitados.containsKey(key)) {
							if (añadidos.containsKey(key)) {
								Pos prev = añadidos.get(key);
								if (prev.peso > actual.peso + mapa.get(actual.i + 1).get(actual.j)) {
									prev.peso = actual.peso + mapa.get(actual.i + 1).get(actual.j);
								}
							} else {
								temp = new Pos(actual.i + 1, actual.j,
										actual.peso + mapa.get(actual.i + 1).get(actual.j));
								colaAbierta.add(temp);
								añadidos.put(key, temp);
							}
						}

					}

					if (izquierda) {

						int key = (actual.i) * mapa.get(actual.i).size() + actual.j - 1;
						if (!visitados.containsKey(key)) {
							if (añadidos.containsKey(key)) {
								Pos prev = añadidos.get(key);
								if (prev.peso > actual.peso + mapa.get(actual.i).get(actual.j - 1)) {
									prev.peso = actual.peso + mapa.get(actual.i).get(actual.j - 1);
								}
							} else {
								temp = new Pos(actual.i, actual.j - 1,
										actual.peso + mapa.get(actual.i).get(actual.j - 1));
								colaAbierta.add(temp);
								añadidos.put(key, temp);
							}
						}
					}

					if (derecha) {
						int key = (actual.i) * mapa.get(actual.i).size() + actual.j + 1;

						if (!visitados.containsKey(key)) {
							if (añadidos.containsKey(key)) {
								Pos prev = añadidos.get(key);
								if (prev.peso > actual.peso + mapa.get(actual.i).get(actual.j + 1)) {
									prev.peso = actual.peso + mapa.get(actual.i).get(actual.j + 1);
								}
							} else {
								temp = new Pos(actual.i, actual.j + 1,
										actual.peso + mapa.get(actual.i).get(actual.j + 1));
								colaAbierta.add(temp);
							}
						}
					}
					visitados.put(actual.i * mapa.get(actual.i).size() + actual.j, actual);
				}
			}
			System.out.println("Parte 2: " + res);
			// while (!colaAbierta.isEmpty()) {
			// temp = colaAbierta.poll();
			// System.out.println(temp.i + " " + temp.j + " " + temp.peso);
			// }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static class Pos implements Comparable<Pos> {
		public int i;
		public int j;
		public int peso;

		public Pos(int i, int j, int peso) {
			this.i = i;
			this.j = j;
			this.peso = peso;
		}

		@Override
		public int compareTo(Pos o) {

			return this.peso - o.peso;
		}
	}
}
