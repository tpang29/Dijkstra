package demo;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Graph {

	private HashMap<String, Vertex> adjList;
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
		adjList = new HashMap<>(maxSize);
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
			} else {
				adjList.get(v1).getAdjList().put(v2, weight);
				adjList.get(v2).getAdjList().put(v1, weight);
			}

		}
	}

	public HashMap<String, Vertex> getAdjList() {
		return adjList;
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
	// Simple: Just provide the start and calculate the distance from start to each node
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
			return;	// Early return
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
