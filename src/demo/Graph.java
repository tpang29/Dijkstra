package demo;

import java.util.HashMap;

public class Graph {

	private HashMap<String, Vertex> adjList;

	public Graph(int maxSize) {
		adjList = new HashMap<>(maxSize);
	}

	public void addEdge(String v1, String v2, int weight) {
		// list contains v1 but not v2
		if (adjList.containsKey(v1) && !adjList.containsKey(v2)) {
			Vertex vertex2 = new Vertex(v2);
			adjList.get(v1).getAdjList().put(v2, weight);
			adjList.put(v2, vertex2);
			adjList.get(v2).getAdjList().put(v1, weight);
		} else if (!adjList.containsKey(v1) && adjList.containsKey(v2)) {
			Vertex vertex1 = new Vertex(v1);
			adjList.get(v2).getAdjList().put(v1, weight);
			adjList.put(v1, vertex1);
			adjList.get(v1).getAdjList().put(v2, weight);
		} else if (!adjList.containsKey(v1) && !adjList.containsKey(v2)) {
			Vertex vertex1 = new Vertex(v1);
			Vertex vertex2 = new Vertex(v2);
			
			adjList.put(v1, vertex1);
			adjList.put(v2, vertex2);
			
			adjList.get(v1).getAdjList().put(v2, weight);
			adjList.get(v2).getAdjList().put(v1, weight);
		} else {
			if (adjList.get(v1).getAdjList().containsKey(v2) || adjList.get(v2).getAdjList().containsKey(v1)) {
				System.out.printf("duplicates will not be inserted (%s, %s)\n", v1, v2);	
			} 
			else {
				adjList.get(v1).getAdjList().put(v2, weight);
				adjList.get(v2).getAdjList().put(v1, weight);
			}
			
		}
	}

	public HashMap<String, Vertex> getAdjList() {
		return adjList;
	}

}
