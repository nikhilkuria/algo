package vault.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrimsLazyMST {

	private List<Edge> edgePriorityQueue;
	private boolean[] visited;
	private Set<Edge> mst;
	
	Graph graph;
	int startIndex;
	
	public PrimsLazyMST(Graph graph,int startIndex){
		edgePriorityQueue = new ArrayList<Edge>();
		visited = new boolean[graph.getSize()];
		mst = new HashSet<Edge>();
		
		this.graph = graph;
		this.startIndex = startIndex;
		
		createPrimsMST();
	}

	private void createPrimsMST() {
		//Begin at the start point
		visit(startIndex);
		while(edgePriorityQueue.isEmpty()){
			Collections.sort(edgePriorityQueue);
			Edge minimalEdge = edgePriorityQueue.get(0);
			edgePriorityQueue.remove(minimalEdge);
			
			mst.add(minimalEdge);
			
			int vertex = minimalEdge.either();
			int otherVertex = minimalEdge.other(vertex);
			
			if(visited[vertex] && visited[otherVertex]){
				continue;
			}
			if(!visited[vertex]){
				visit(vertex);
			}
			if(!visited[otherVertex]){
				visit(vertex);
			}
			
		}
	}
	
	private void visit(int vertex){
		if(!visited[vertex]){
			for (Edge edge : graph.getEdges(vertex)) {
				if(!visited[edge.other(vertex)]){
					edgePriorityQueue.add(edge);
				}
			}
		}
	}
	
}
