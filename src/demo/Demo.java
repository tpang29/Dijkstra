package demo;

public class Demo {

	public static void main(String[] args) {
		bidirectionalDemo("a", "r");	
		unidirectionalDemo("a", "f");
	}
	
	private static void unidirectionalDemo(String start, String end) {
		Graph g = new Graph(11);
		
		g.addEdgeUD("a", "b", 2);
		g.addEdgeUD("a", "d", 1);
		g.addEdgeUD("b", "d", 3);
		g.addEdgeUD("b", "e", 10);
		g.addEdgeUD("c", "a", 4);
		g.addEdgeUD("c", "f", 5);
		g.addEdgeUD("d", "c", 2);
		g.addEdgeUD("d", "e", 2);
		g.addEdgeUD("d", "f", 8);
		g.addEdgeUD("d", "g", 4);
		g.addEdgeUD("e", "g", 6);
		g.addEdgeUD("g", "f", 1);
		
		g.dijkstra(start, end);
	}
	
	private static void bidirectionalDemo(String start, String end) {
		Graph g = new Graph(47);
		
		g.addEdgeBD("a", "b", 75);
		g.addEdgeBD("a", "c", 118);
		g.addEdgeBD("a", "e", 65);
		g.addEdgeBD("b", "f", 120);
		g.addEdgeBD("b", "j", 100);
		g.addEdgeBD("c", "d", 85);
		g.addEdgeBD("c", "e", 90);
		g.addEdgeBD("c", "n", 40);
		g.addEdgeBD("d", "g", 70);
		g.addEdgeBD("d", "o", 130);
		g.addEdgeBD("d", "p", 60);
		g.addEdgeBD("e", "f", 99);
		g.addEdgeBD("e", "g", 80);
		g.addEdgeBD("f", "j", 30);
		g.addEdgeBD("f", "k", 60);
		g.addEdgeBD("f", "i", 211);
		g.addEdgeBD("g", "h", 97);
		g.addEdgeBD("g", "i", 130);
		g.addEdgeBD("h", "t", 30);
		g.addEdgeBD("h", "r", 40);
		g.addEdgeBD("d", "h", 100);
		g.addEdgeBD("i", "l", 50);
		g.addEdgeBD("i", "t", 80);
		g.addEdgeBD("i", "h", 101);
		g.addEdgeBD("j", "k", 70);
		g.addEdgeBD("k", "l", 40);
		g.addEdgeBD("m", "a", 100);
		g.addEdgeBD("m", "n", 30);
		g.addEdgeBD("m", "o", 90);
		g.addEdgeBD("n", "o", 80);
		g.addEdgeBD("o", "p", 100);
		g.addEdgeBD("o", "q", 80);
		g.addEdgeBD("p", "q", 20);
		g.addEdgeBD("p", "r", 80);
		g.addEdgeBD("r", "q", 70);
		g.addEdgeBD("r", "s", 50);
		g.addEdgeBD("s", "q", 40);
		g.addEdgeBD("s", "t", 60);
		
		g.dijkstra(start, end);
	}

}
