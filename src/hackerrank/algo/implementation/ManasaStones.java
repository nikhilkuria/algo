package hackerrank.algo.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ManasaStones {

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int numTestCases = in.nextInt();
		
		for (int testIndex = 0; testIndex < numTestCases; testIndex++) {
			int numOfStones = in.nextInt();
			int offsetOne = in.nextInt();
			int offsetTwo = in.nextInt();

			Set<Integer> endPoints = getEndPoints(numOfStones-1, offsetOne, offsetTwo);
			List<Integer> endPointsList = new ArrayList<Integer>(endPoints);
			//Collections.sort(endPointsList);
			for (Integer integer : endPointsList) {
				System.out.print(integer);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	private static Set<Integer> getEndPoints(int numOfStones, int firstOffset, int secondOffset) {
		Set<Integer> endPoints = new HashSet<Integer>();
		
		for (int index = 0; index <= numOfStones; index++) {
			int endPoint = (firstOffset*(numOfStones-index)) + (secondOffset*index);
			endPoints.add(endPoint);
		}
		
		return endPoints;
	}

}
