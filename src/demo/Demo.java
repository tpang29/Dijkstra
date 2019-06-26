package demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class Demo {

	public static void main(String[] args) {
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

}
