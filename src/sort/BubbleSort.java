package sort;

import java.util.Arrays;

public class BubbleSort {

	public void sort(int[] input){
		System.out.println(Arrays.toString(input));
		for (int theIndex = 0; theIndex < input.length; theIndex++) {
			for (int otherIndex = 0; otherIndex < input.length-theIndex-1; otherIndex++) {
				if(input[otherIndex]>input[otherIndex+1]){
					swap(input,otherIndex,otherIndex+1);
					System.out.println(Arrays.toString(input));
				}
			}
		}
	}
	
	public void swap(int[] input, int swapIndexOne, int swapIndexTwo){
		int temp = input[swapIndexOne];
		input[swapIndexOne] = input[swapIndexTwo];
		input[swapIndexTwo] = temp;
	}
	
	public static void main(String args[]){
		BubbleSort sort = new BubbleSort();
		sort.sort(new int[]{5,4,3,2,1});
	}
}
