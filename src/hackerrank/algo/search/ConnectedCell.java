package hackerrank.algo.search;

import java.util.Arrays;
import java.util.Scanner;

public class ConnectedCell {

	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		int numOfRows = scanner.nextInt();
		int numOfCols = scanner.nextInt();
		int[][] grid = new int[numOfRows][numOfCols];
		for (int rowIndex = 0; rowIndex < numOfRows; rowIndex++) {
			for (int colIndex = 0; colIndex < numOfCols; colIndex++) {
				grid[rowIndex][colIndex] = scanner.nextInt();
			}
		}
		
		System.out.println(findConnectedCell(grid));
	}

	private static int findConnectedCell(int[][] grid) {
		int maxCells = 0;
		int cellCounter = getCells(grid[0]);
		for (int i = 1; i < grid.length; i++) {
			int[] row = grid[i];
			if(isOverlap(row, grid[i-1])){
				cellCounter = cellCounter + getCells(row);
			}else{
				if(cellCounter>maxCells){
					maxCells = cellCounter;
				}
				cellCounter=0;
			}
		}
		
		return maxCells;
	}

	private static boolean isOverlap(int[] row, int[] is) {
		int currentRow = getRowAsInt(row);
		int previousRow = getRowAsInt(is);
		
		int directOverlap = currentRow & previousRow;
		int leftOffsetOverlap = (currentRow >> 1) & previousRow;
		int rightOffsetOverlap = (currentRow << 1) & previousRow;
		
		return (directOverlap+leftOffsetOverlap+rightOffsetOverlap)>0;
	}

	private static int getRowAsInt(int[] row) {
		String currentRow = Arrays.toString(row).replaceAll(",", "")
				.replaceAll("]", "").replaceAll("\\[", "").replaceAll(" ", "");
		return Integer.parseInt(currentRow, 2); 
	}

	private static int getCells(int[] row) {
		int cellCount = 0;
		for (int i = 0; i < row.length; i++) {
			if(row[i]==1){
				cellCount++;
			}
		}
		return cellCount;
	}
	
}
