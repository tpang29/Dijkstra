package demo;

import java.util.HashMap;

public class Vertex {

	private String label;
	private HashMap<String, Number> adjList;
	private boolean known;
	private int distance;
	private Vertex path;
	
	public Vertex(String label) {
		this.label = label;
		adjList = new HashMap<String, Number>();
		known = false;
		distance = 0;
		path = null;
	}

	public String getLabel() {
		return label;
	}

	public HashMap<String, Number> getAdjList() {
		return adjList;
	}

	public boolean isKnown() {
		return known;
	}

	public int getDistance() {
		return distance;
	}

	public Vertex getPath() {
		return path;
	}
	
	@Override
	public String toString() {
		return label;
	}

}
