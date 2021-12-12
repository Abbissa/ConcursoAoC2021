import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Dia12 {

	public static void main(String[] args) {
		Part1();
		Part2();
	}

	private static void Part1() {

		HashMap<String, Nodo> nodos = new HashMap<String, Nodo>();
		try (Scanner sc = new Scanner(new File(".\\Dia12\\Dia12"))) {
			sc.useDelimiter("[-\\p{javaWhitespace}]+");
			while (sc.hasNext()) {

				String aux1 = sc.next();
				String aux2 = sc.next();
				Nodo nodo1 = nodos.get(aux1);
				Nodo nodo2 = nodos.get(aux2);
				if (nodo1 == null) {
					nodo1 = new Nodo(aux1, aux1.equals(aux1.toUpperCase()));

					nodos.put(aux1, nodo1);
				}
				if (nodo2 == null) {
					nodo2 = new Nodo(aux2, aux2.equals(aux2.toUpperCase()));
					nodos.put(aux2, nodo2);
				}
				nodo1.conexiones.add(nodo2);
				nodo2.conexiones.add(nodo1);

			}
			HashSet<Nodo> visited = new HashSet<Nodo>();
			visited.add(nodos.get("start"));
			int res = explorar(visited, nodos.get("start"));

			System.out.println("Parte 1: " + res);
		} catch (

		Exception e) {
			System.out.println(e);
		}
	}

	private static int explorar(HashSet<Nodo> visited, Nodo nodo) {
		int res = 0;
		if (nodo.label.equals("end"))
			res++;
		else
			for (Nodo hijo : nodo.conexiones) {
				if (!visited.contains(hijo)) {

					if (!hijo.grande)
						visited.add(hijo);
					res += explorar(visited, hijo);
				}
			}

		visited.remove(nodo);
		return res;

	}

	private static void Part2() {

		HashMap<String, Nodo> nodos = new HashMap<String, Nodo>();
		try (Scanner sc = new Scanner(new File(".\\Dia12\\Dia12"))) {
			sc.useDelimiter("[-\\p{javaWhitespace}]+");
			while (sc.hasNext()) {

				String aux1 = sc.next();
				String aux2 = sc.next();
				Nodo nodo1 = nodos.get(aux1);
				Nodo nodo2 = nodos.get(aux2);
				if (nodo1 == null) {
					nodo1 = new Nodo(aux1, aux1.equals(aux1.toUpperCase()));

					nodos.put(aux1, nodo1);
				}
				if (nodo2 == null) {
					nodo2 = new Nodo(aux2, aux2.equals(aux2.toUpperCase()));
					nodos.put(aux2, nodo2);
				}
				nodo1.conexiones.add(nodo2);
				nodo2.conexiones.add(nodo1);

			}
			HashSet<Nodo> visited = new HashSet<Nodo>();
			visited.add(nodos.get("start"));
			int res = explorar2(visited, nodos.get("start"), 0);
			System.out.println("Parte 2: " + res);
		} catch (

		Exception e) {
			System.out.println(e);
		}

	}

	private static int explorar2(HashSet<Nodo> visited, Nodo nodo, int cont) {
		int res = 0;
		if (nodo.label.equals("end")) {
			//System.out.println();
			res++;
		} else
			for (Nodo hijo : nodo.conexiones) {
				if (!visited.contains(hijo)) {

					if (!hijo.grande)
						visited.add(hijo);
					//System.out.print(hijo.label + " ");
					res += explorar2(visited, hijo, cont);
				} else if (visited.contains(hijo) && cont == 0 && !hijo.label.equals("end")
						&& !hijo.label.equals("start")) {
					cont = 1;
					hijo.cont++;
					//System.out.print(hijo.label + " ");
					res += explorar2(visited, hijo, cont);
					cont = 0;
				}
			}
		//System.out.print("-");
		if (nodo.cont == 0)
			visited.remove(nodo);
		else
			nodo.cont--;
		return res;

	}
}
