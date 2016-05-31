package vault.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	private List<List<Edge>> graph;
	
	private Graph(int size){
		graph = new ArrayList<List<Edge>>(size);
		for (int index = 0; index < size; index++) {
			graph.add(index, new ArrayList<Edge>());
		}
	}
	
	public void addEdge(Edge edge){
		int vertex = edge.either();
		int otherVertex = edge.other(vertex);
		graph.get(vertex).add(edge);
		graph.get(otherVertex).add(edge);
	}
	
	public int getSize(){
		return graph.size();
	}
	
	public static Graph createGraph(int numOfVertices){
		return new Graph(numOfVertices);
	}
	
	public List<Edge> getEdges(int vertex){
		return graph.get(vertex);
	}
}
