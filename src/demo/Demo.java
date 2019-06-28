package demo;

import java.util.Iterator;

public class Demo {

	public static void main(String[] args) {
		System.out.println("HashMap based Example \n");
		HashExample();
		System.out.println("\n-------------------------------------\n");
		
		System.out.println("Matrix based Example \n");
		MatrixExample();
		System.out.println("\n-------------------------------------\n");
	}

	public static void HashExample() {
		Graph g = new Graph(47); // initialize graph with prime number
		g.addEdge("A", "B", 75);
		g.addEdge("A", "C", 118);
		g.addEdge("A", "E", 65);
		g.addEdge("B", "F", 120);
		g.addEdge("B", "J", 100);
		g.addEdge("C", "D", 85);
		g.addEdge("C", "E", 90);
		g.addEdge("C", "N", 40);
		g.addEdge("D", "G", 70);
		g.addEdge("D", "0", 130);
		g.addEdge("D", "P", 60);
		g.addEdge("E", "F", 99);
		g.addEdge("E", "G", 80);

		System.out.println(g.getAdjList().size());

		Iterator<String> gki = g.getAdjList().keySet().iterator();

		while (gki.hasNext()) {
			String next = gki.next();
			System.out.println("Key is " + next);

			Iterator<String> valIter = g.getAdjList().get(next).getAdjList().keySet().iterator();

			while (valIter.hasNext()) {
				String v = valIter.next();
				System.out.print(v + "[" + g.getAdjList().get(next).getAdjList().get(v) + "] ");

			}
			System.out.println("\n-------------------------------------");
		}
	}

	public static void MatrixExample() {
		Graph g = new Graph(new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
				"p", "q", "r", "s", "t" });

		g.addMatrixEgde("a", "b", 75);
		g.addMatrixEgde("a", "e", 65);
		g.addMatrixEgde("a", "c", 118);
		g.addMatrixEgde("a", "m", 100);

		g.addMatrixEgde("b", "f", 120);
		g.addMatrixEgde("b", "j", 100);

		g.addMatrixEgde("j", "f", 30);
		g.addMatrixEgde("j", "k", 70);

		g.addMatrixEgde("k", "l", 40);
		g.addMatrixEgde("k", "f", 60);

		g.addMatrixEgde("l", "i", 50);

		g.addMatrixEgde("i", "f", 211);
		g.addMatrixEgde("i", "g", 130);
		g.addMatrixEgde("i", "h", 101);
		g.addMatrixEgde("i", "t", 80);

		g.addMatrixEgde("f", "e", 99);

		g.addMatrixEgde("e", "g", 80);
		g.addMatrixEgde("e", "c", 90);

		g.addMatrixEgde("g", "h", 97);
		g.addMatrixEgde("g", "d", 70);

		g.addMatrixEgde("h", "d", 100);
		g.addMatrixEgde("h", "r", 40);
		g.addMatrixEgde("h", "t", 30);

		g.addMatrixEgde("c", "d", 85);
		g.addMatrixEgde("c", "n", 40);

		g.addMatrixEgde("d", "o", 130);
		g.addMatrixEgde("d", "p", 60);

		g.addMatrixEgde("m", "n", 30);
		g.addMatrixEgde("m", "o", 90);

		g.addMatrixEgde("n", "o", 80);

		g.addMatrixEgde("p", "o", 100);
		g.addMatrixEgde("p", "q", 20);
		g.addMatrixEgde("p", "r", 80);

		g.addMatrixEgde("r", "q", 70);
		g.addMatrixEgde("r", "s", 50);

		g.addMatrixEgde("t", "s", 60);

		g.addMatrixEgde("s", "q", 40);

		g.addMatrixEgde("o", "q", 80);

//		g.printMatrix();	// Display the initial matrix

		g.dijkstraMatrix("a", "i");

	}

}
