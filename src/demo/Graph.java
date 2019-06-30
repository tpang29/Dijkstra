package demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graph {

	private HashMap<String, Vertex> vertexList;

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

}
