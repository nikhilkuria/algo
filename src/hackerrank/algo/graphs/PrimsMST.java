package hackerrank.algo.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PrimsMST {

	Set<Edge>[] graph;
	boolean[] visited;
	Set<Edge> minimalTree;
	Edge[] minimumPathTo;
	int minimalTreeLength;
	List<Edge> edgesBag;
	
	public static void main(String args[]){
		PrimsMST primsMst = new PrimsMST();
		primsMst.roll();
	}
	
	@SuppressWarnings("unchecked")
	private void roll() {
		Scanner in = new Scanner(System.in);
		
		int numOfVertices = in.nextInt();
		visited = new boolean[numOfVertices];
		minimumPathTo = new Edge[numOfVertices];
		graph = new HashSet[numOfVertices];
		
		for (int index = 0; index < numOfVertices; index++) {
			minimumPathTo[index] = new Edge(0, 0, Integer.MAX_VALUE);
			graph[index] = new HashSet<Edge>();
		}
		
		edgesBag = new ArrayList<Edge>();
		minimalTree = new HashSet<Edge>();
		int numOfEdges = in.nextInt();
		
		for (int index = 0; index < numOfEdges; index++) {
			int vertex = in.nextInt();
			int otherVertex = in.nextInt();
			int weight = in.nextInt();
			Edge edge = new Edge(vertex-1, otherVertex-1, weight);
			graph[vertex-1].add(edge);
			graph[otherVertex-1].add(edge);
		}
		int startIndex = in.nextInt();
		populateMST(startIndex-1);
		System.out.println(minimalTreeLength);
	}

	private void populateMST(int startIndex) {
		edgesBag.addAll(graph[startIndex]);
		visited[startIndex] = true;
		while(!edgesBag.isEmpty()){
			Collections.sort(edgesBag);
			Edge edge = edgesBag.get(0);
			edgesBag.remove(edge);
			int newVertex = getNewVertex(edge);
			if(!visited[newVertex]){
				visited[newVertex] = true;
				minimalTree.add(edge);
				minimalTreeLength+=edge.getWeight();
				int vertex = edge.getOtherVertex(startIndex);
				minimumPathTo[vertex]=edge;
				for (Edge nextEdge : graph[vertex]) {
					int nextVertex = nextEdge.getOtherVertex(vertex);
					if(!visited[nextVertex]){
						visited[vertex]=true;
						int nextWeight = nextEdge.getWeight();
						Edge existingMinEdge = minimumPathTo[nextVertex];
						if(existingMinEdge.getWeight()>nextWeight){
							minimumPathTo[nextVertex] = nextEdge;
							edgesBag.add(nextEdge);
							edgesBag.remove(existingMinEdge);
						}
					}
				}
			}
		}
	}

	private int getNewVertex(Edge edge) {
		int vertex = edge.getVertex();
		if(visited[vertex]){
			return edge.getOtherVertex(vertex);
		}
		return vertex;
	}

	private class Edge implements Comparable<Edge>{
		private int vertex;
		private int otherVertex;
		private int weight;
		
		public Edge(int vertex, int otherVertex, int weight){
			this.vertex = vertex;
			this.otherVertex = otherVertex;
			this.weight = weight;
		}
		
		public int getVertex(){
			return vertex;
		}
		
		public int getOtherVertex(int vertex){
			return vertex==this.vertex? otherVertex : this.vertex;
		}
		
		private int getWeight(){
			return weight;
		}

		@Override
		public int compareTo(Edge otherEdge) {
			return this.getWeight() - otherEdge.getWeight();
		}
		
		public String toString(){
			return vertex+"-"+otherVertex+"("+weight+")";
		}
	}
	
}
