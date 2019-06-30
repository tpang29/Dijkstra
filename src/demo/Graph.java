package demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Graph {

	private HashMap<String, Vertex> vertexList;

	private boolean isMatrixInit = false;
	private int[][] matrix;
	private List<String> indexList;

	public Graph(String[] nodes) {
		indexList = Arrays.asList(nodes);
		isMatrixInit = true;
		int capacity = nodes.length;
		matrix = new int[capacity][capacity];
	}

	public Graph(int maxSize) {
		vertexList = new HashMap<>(maxSize);
	}

	public HashMap<String, Vertex> getAdjList() {
		return vertexList;
	}

	public void addEdgeBD(String v1, String v2, int weight) {
		addEdge(v1, v2);

		// append v1 vertexList with v2 and v2 adjList with v1
		vertexList.get(v1).getAdjList().put(v2, weight);
		vertexList.get(v2).getAdjList().put(v1, weight);
	}

	public void addEdgeUD(String v1, String v2, int weight) {
		addEdge(v1, v2);

		// append v1 vertexList with v2
		vertexList.get(v1).getAdjList().put(v2, weight);
	}

	public void addMatrixEgde(String v1, String v2, int weight) {
		if (!isMatrixInit) {
			return;
		}
		int i1 = indexList.indexOf(v1);
		int i2 = indexList.indexOf(v2);
		if (i1 != -1 && i2 != -1) {
			matrix[i1][i2] = weight;
			matrix[i2][i1] = weight;
		}
	}

	private void addEdge(String v1, String v2) {

		if (vertexList.containsKey(v1) && !vertexList.containsKey(v2)) { // list contains v1 but not v2
			Vertex vertex2 = new Vertex(v2);
			vertexList.put(v2, vertex2);
		} else if (!vertexList.containsKey(v1) && vertexList.containsKey(v2)) { // list contains v2 but not v1
			Vertex vertex1 = new Vertex(v1);
			vertexList.put(v1, vertex1);
		} else if (!vertexList.containsKey(v1) && !vertexList.containsKey(v2)) { // both vertices are new
			Vertex vertex1 = new Vertex(v1);
			Vertex vertex2 = new Vertex(v2);
			vertexList.put(v1, vertex1);
			vertexList.put(v2, vertex2);
		} else { // both vertices are present in list
			if (vertexList.get(v1).getAdjList().containsKey(v2) || vertexList.get(v2).getAdjList().containsKey(v1)) {
				final String DUPLICATE_MESSAGE = String.format("duplicates will not be inserted (%s, %s)", v1, v2);
				System.out.println(DUPLICATE_MESSAGE);
			}

		}
	}

	public void dijkstra(String source, String destination) {
		Queue<Vertex> unknownQueue = initializeGraph(source);

		Vertex vertex = null;
		int distance = 0;

		while (!unknownQueue.isEmpty()) {

			vertex = unknownQueue.remove(); // remove vertex of minimum distance
			vertex.setKnown(true); // mark known

			Iterator<String> iterator = vertex.getAdjList().keySet().iterator(); // get neighbors of vertex

			while (iterator.hasNext()) { // iterate through neighbors

				Vertex neighbor = vertexList.get(iterator.next());

				// only calculate the distance for an unknown neighbor
				if (!neighbor.isKnown()) {
					distance = vertex.getDistance() + (Integer) vertex.getAdjList().get(neighbor.getLabel());
				}

				// update distance
				if (neighbor.getDistance() == null || distance < neighbor.getDistance()) {
					unknownQueue.remove(neighbor);
					neighbor.setDistance(distance);
					neighbor.setPath(vertex);
					unknownQueue.add(neighbor);
				}

			}

		}

		printAllPaths(source);
		printResult(source, destination);
	}

	private Queue<Vertex> initializeGraph(String source) {
		Iterator<Vertex> vertexIterator = vertexList.values().iterator();
		Queue<Vertex> unknownQueue = new PriorityQueue<>(new VertexComparator());

		while (vertexIterator.hasNext()) {
			Vertex next = vertexIterator.next();

			if (!next.getLabel().equals(source)) { // skip source vertex
				next.setDistance(null); // null used as sentinel instead of infinity
				next.setPath(null);
				unknownQueue.add(next);
			}

		}

		// set distance on sourceVertex so it is properly ranked in unknownQueue
		Vertex sourceVertex = vertexList.get(source);
		sourceVertex.setDistance(0);
		sourceVertex.setPath(null);
		unknownQueue.add(sourceVertex);
		return unknownQueue;
	}

	private void printResult(String source, String destination) {
		int index = 0;
		String path = "";
		String newPath = "";
		Vertex v = vertexList.get(destination);
		;
		Vertex temp = v;

		while (temp.getPath() != null) {
			path = temp.getLabel() + path;
			temp = temp.getPath();
		}

		path = source + path;

		while (index < path.length() - 1) {
			newPath += path.charAt(index++) + " -> ";
		}

		newPath = newPath + path.charAt(index);

		System.out.printf("The path from '%s' to '%s' is: \n%s\n", source, destination, newPath);
		System.out.printf("\nTotal distance from '%s' to '%s' is %d\n", source, destination, v.getDistance());
		System.out.println("-----------------------------------------");
	}

	public void printAllPaths(String source) {
		System.out.println("Calculating Distance from node: " + source);
		Iterator<String> iterator = vertexList.keySet().iterator();

		Vertex v = null;

		while (iterator.hasNext()) {
			v = vertexList.get(iterator.next());
			System.out.printf("Node: %s, Distance: %d\n", v.getLabel(), v.getDistance());
		}
	}

	public void printMatrix() {
		if (!isMatrixInit) {
			System.out.println("The Graph is not a matrix");
			return;
		}
		int max = matrix.length;

		for (int i = 0; i < max; i++) {
			for (int j = 0; j < max; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}

	// A method to run the Dijkstra Algorithm against the matrix build
	public void dijkstraMatrix(String start) {
		dijkstraM(start, "", false);
	}

	// A method to run the Dijkstra Algorithm against the matrix build
	public void dijkstraMatrix(String start, String end) {
		dijkstraM(start, end, true);
	}

	// Dijkstra Algorithm
	// It has 2 modes,
	// Simple: Just provide the start and calculate the distance from start to each
	// node
	// Path based: Provide "start", "end" and specify whether to print the path.
	public void dijkstraM(String start, String end, boolean printPath) {
		// Check if the Graph is Hash based
		if (!isMatrixInit) {
			System.out.println("Matrix not Initialized!");
			return;
		}

		// Checking the start node
		int startI = indexList.indexOf(start);
		if (startI == -1) {
			System.out.println("Starting vertex not in graph");
			return;
		} else {
			System.out.println("Calculating Distance from node: " + start);
		}

		int size = matrix.length;

		int[] distance = new int[size];
		Arrays.fill(distance, Integer.MAX_VALUE);
		boolean[] shortest_path = new boolean[size];

		int[] prev = new int[size];

		distance[startI] = 0;

		for (int i = 0; i < size - 1; i++) {
			int min = Integer.MAX_VALUE;
			int min_dist = 0;

			for (int v = 0; v < size; v++) {
				if (!shortest_path[v] && distance[v] <= min) {
					min = distance[v];
					min_dist = v;
				}
			}

			shortest_path[min_dist] = true;

			for (int v = 0; v < size; v++) {
				if (!shortest_path[v] && matrix[min_dist][v] != 0 && distance[min_dist] != Integer.MAX_VALUE
						&& distance[min_dist] + matrix[min_dist][v] < distance[v]) {
					distance[v] = distance[min_dist] + matrix[min_dist][v];
					// PREV: Stored the index of the previous node through which to route
					prev[v] = min_dist;
				}
			}
		}

		// Displaying the distances to all nodes.
		for (int i = 0; i < size; i++) {
			String dist;
			if (distance[i] == Integer.MAX_VALUE) {
				dist = "INF";
			} else {
				dist = "" + distance[i];
			}
			System.out.println("Node: " + indexList.get(i) + ", Distance: " + dist);
		}

		// Check whether to find and print the path or not
		if (!printPath) {
			return; // Early return
		}

		int endI = indexList.indexOf(end);
		if (endI == -1) {
			System.out.println("End vertex not in graph");
			return;
		}
		List<Integer> path = new ArrayList<Integer>();
		int n = endI;
		while (n != startI) {
			path.add(0, n);
			n = prev[n];
		}
		path.add(0, startI);

		System.out.println("The path from '" + start + "' to '" + end + "' is: ");
		for (int i = 0; i < path.size(); i++) {
			int index = (Integer) path.get(i);
			if (i + 1 == path.size()) {
				System.out.println(indexList.get(index));
			} else {
				System.out.print(indexList.get(index) + " -> ");
			}
		}
		System.out.println("\nTotal distance from '" + start + "' to '" + end + "' is " + distance[endI]);

	}

}
