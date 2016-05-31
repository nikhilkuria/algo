package sort;

import java.util.Arrays;
import java.util.Scanner;

public class Median {

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int[] input = new int[in.nextInt()];
		for (int index = 0; index < input.length; index++) {
			input[index] = in.nextInt();
		}
		Arrays.sort(input);
		int midIndex = input.length/2;
		if(input.length%2==0){
			System.out.print(((float)input[midIndex]+input[midIndex-1])/2);
		}else{
			System.out.println(input[midIndex]);
		}
				
	}
	
}
