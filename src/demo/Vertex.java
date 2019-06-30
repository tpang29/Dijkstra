package demo;

import java.util.HashMap;

public class Vertex {

	private String label;
	private HashMap<String, Number> adjList;
	private boolean known;
	private Integer distance;
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

	public void setLabel(String label) {
		this.label = label;
	}

	public HashMap<String, Number> getAdjList() {
		return adjList;
	}

	public void setAdjList(HashMap<String, Number> adjList) {
		this.adjList = adjList;
	}

	public boolean isKnown() {
		return known;
	}

	public void setKnown(boolean known) {
		this.known = known;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public Vertex getPath() {
		return path;
	}

	public void setPath(Vertex path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return String.format("Vertex: %s", label);
	}

}
