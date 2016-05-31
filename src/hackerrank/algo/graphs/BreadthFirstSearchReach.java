package hackerrank.algo.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BreadthFirstSearchReach {
	
	private Set<Integer>[] graph;
	private boolean[] visited;
	private int[] pathTo;
	List<Integer> pseudoQueue;
	
	private BreadthFirstSearchReach(int indexCount){
		graph = new HashSet[indexCount];
		visited = new boolean[indexCount];
		pathTo = new int[indexCount];
		pseudoQueue = new ArrayList<Integer>();
		for (int index = 0; index < indexCount; index++) {
			graph[index] = new HashSet();
			pathTo[index] = -1;
		}
	}
	
	private boolean addEdge(int fromIndex, int toIndex){
		graph[fromIndex].add(toIndex);
		graph[toIndex].add(fromIndex);
		return true;
	}
	
	private void searchGraph(int startIndex){
		pseudoQueue.add(startIndex);
		while(!pseudoQueue.isEmpty()){
			int indexToSearch = pseudoQueue.get(0);
			visited[indexToSearch] = true;
			for (int neighbour : graph[indexToSearch]) {
				if(!visited[neighbour]){
					if(pathTo[neighbour]==-1){
						pathTo[neighbour] = indexToSearch;
					}
					if(!visited[neighbour]){
						pseudoQueue.add(neighbour);
					}
					visited[neighbour] = true;
				}
			}
			
			pseudoQueue.remove(0);
		}
	}
	
	public void printNodeSteps(int startIndex){
		for (int index = 0; index < graph.length; index++) {
			if(startIndex==index){
				continue;
			}else if(pathTo[index]==-1){ 
				System.out.print("-1 ");
			}
			else{
				int length = 0;
				int path = index;
				while(path!=startIndex){
					path = pathTo[path];
					length = length+6;
				}
				System.out.print(length);
				System.out.print(" ");
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int numOfTests = in.nextInt();
		for (int testIndex = 0; testIndex < numOfTests; testIndex++) {
			int graphLength = in.nextInt();
			BreadthFirstSearchReach graph = new BreadthFirstSearchReach(graphLength);
			int numOfEdges = in.nextInt();
			for (int edgeIndex = 0; edgeIndex < numOfEdges; edgeIndex++) {
				graph.addEdge(in.nextInt()-1, in.nextInt()-1);
			}
			int startIndex = in.nextInt();
			graph.searchGraph(startIndex-1);
			graph.printNodeSteps(startIndex-1);
		}
		in.close();
	}
}
