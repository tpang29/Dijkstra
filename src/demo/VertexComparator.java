package demo;

import java.util.Comparator;

public class VertexComparator implements Comparator<Vertex> {

	@Override
	public int compare(Vertex o1, Vertex o2) {
		if (o1.getDistance() == null || o2.getDistance() == null) {
			if (o1.getDistance() == null && o2.getDistance() != null) {
				return 1; // o1 is lower priority (higher #)
			} else {
				return -1; // o1 is higher priority (lower #)
			} 
		} else {

			if (o1.getDistance().compareTo(o2.getDistance()) < 0) {		
				return -1; // o1 is higher priority 
			} else if (o1.getDistance().compareTo(o2.getDistance()) > 0) {
				return 1; // o2 is lower priority
			} else {
				return 0; // equal priority
			}	
		}
	}



}
