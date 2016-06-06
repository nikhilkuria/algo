package hackerrank.algo.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SnakesAndLadders {

	Set<Integer>[] boardGraph;
	boolean[] visited;
	int[] pathTo;
	List<Integer> pseudoQueue;
	
	public SnakesAndLadders(int size){
		//initialize the graph
		boardGraph = new HashSet[size];
		visited = new boolean[size];
		pathTo = new int[size];
		pseudoQueue = new ArrayList();
		
		for (int index = 0; index < size; index++) {
			boardGraph[index] = new HashSet<Integer>();
			pathTo[index] = -1;
			for (int step = 1; step < 7; step++) {
				int stepIndex = index+step;
				if(stepIndex<size){
					boardGraph[index].add(stepIndex);
				}else{
					continue;
				}
			}
		}
	}
	
	public void addLadder(int from, int to){
		addShortCircuitEdge(from, to);
	}
	
	public void addSnake(int from, int to){
		boardGraph[from].clear();
		addShortCircuitEdge(from, to);
	}
	
	private void addShortCircuitEdge(int from, int to) {
		for (int step = 1; step < 7; step++) {
			int stepIndex = from-step;
			if(stepIndex>=0){
				boardGraph[stepIndex].add(to);
			}else{
				return;
			}
		}
	}
	
	public void solve(int startIndex){
		pseudoQueue.add(startIndex);
		while(!pseudoQueue.isEmpty()){
			int indexToSearch = pseudoQueue.get(0);
			visited[indexToSearch] = true;
			for (int neighbour : boardGraph[indexToSearch]) {
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

	public void printOut() {
		int stepCount = 1;
		int currentPosition = 99;
		while(pathTo[currentPosition]!=0){
			currentPosition = pathTo[currentPosition];
			stepCount++;
			if(currentPosition==-1){
				stepCount = -1;
				break;
			}
		}
		System.out.println(stepCount);
	}
	
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		
		int numOfTestCases = in.nextInt();
		
		
		for (int testIndex = 0; testIndex < numOfTestCases; testIndex++) {
			SnakesAndLadders snakes = new SnakesAndLadders(100);
			int ladderCount = in.nextInt();
			for (int index = 0; index < ladderCount; index++) {
				int from = in.nextInt();
				int to = in.nextInt();
				snakes.addLadder(from-1, to-1);
			}
			int snakeCount = in.nextInt();
			for (int index = 0; index < snakeCount; index++) {
				int from = in.nextInt();
				int to = in.nextInt();
				snakes.addSnake(from-1, to-1);
			}
			snakes.solve(0);
			snakes.printOut();
		}
		in.close();
	}
}
