package sort;

import java.util.Scanner;

public class SherlockWatson {

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int length = in.nextInt();
		int rotations = in.nextInt();
		int queries = in.nextInt();
		int[] inputArray = new int[length];
		for (int index = 0; index < length; index++) {
			int position = (index+rotations)%length;
			int input = in.nextInt();
			inputArray[position] = input;
		}
		for (int index = 0; index < queries; index++) {
			int result = inputArray[in.nextInt()];
			System.out.println(result);
		}
	}
	
}
