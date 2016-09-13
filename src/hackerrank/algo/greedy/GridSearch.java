package hackerrank.algo.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class GridSearch {

	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		int numOfTests = in.nextInt();
		
		testCase:
		for (int testIndex = 0; testIndex < numOfTests; testIndex++) {
			int gridSize = in.nextInt();
			
			char[][] grid = new char[gridSize][gridSize];
			in.nextLine();
			for (int rowIndex = 0; rowIndex < gridSize; rowIndex++) {
				grid[rowIndex] = in.nextLine().toCharArray();
			}
			
			for (int rowIndex = 0; rowIndex < gridSize; rowIndex++) {
				Arrays.sort(grid[rowIndex]);
			}
			
			for (int colIndex = 0; colIndex < grid.length; colIndex++) {
				int rowIndex = 0;
				while(rowIndex<gridSize-1){
					if(((Character)grid[rowIndex+1][colIndex]).compareTo(grid[rowIndex][colIndex])<0){
						System.out.println("NO");
						continue testCase;
					}
					rowIndex++;
				}
			}
			
			System.out.println("YES");
		}
	}
}
