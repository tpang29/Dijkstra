This Graph class demonstrates a graph using two layers of maps. 

From *Discrete Mathematics with Applications* by Susanna Epp:
 >A graph G consists of two finite sets: a nonempty set V(G) of vertices and a set E(G) of edges, where each edge is associated with a set consisting of either one or two vertices called its endpoints.

# Layer 1
The first layer consists of a map in the form String:Vertex within the Graph class. String corresponds to the label of a vertex (name, number, etc.) and the corresponding vertex is an instance of a custom Vertex object.

## All Vertices
String | Vertex
-|-
"A"|A
"B"|B
"C"|C
"D"|D
...|...
"T"|T
|
 
# Layer 2
The second layer consists of a map in the form String:Number within each Vertex object. String represents a neighbor vertex, *n*, and Number represents the value of the edge between the source vertex, *v*, and its neighbor, *n*.

## Adjacency List for Vertex "A"
String | Number
-|-
"B"|75
"C"|118
"E"|65
"M"|100
|

# VertexComparator

Vertices are first checked for any **null** distances. If a null distance exists, the non-null vertex has a higher priority.

If both distances are **non-null** then higher priority is give to the smaller distance.