package hackerrank.algo.sort;

import java.util.Scanner;

public class QuickSort2 {

	static void sort(int[] masterArray, int[] tempArray, int startIndex, int endIndex) {
		if(startIndex>=endIndex){
			return;
		}
		int pivotElement = masterArray[startIndex];
		int pivotIndex = 0;
		int newArrayIndex = startIndex;
		for (int index = startIndex; index <= endIndex; index++) {
			int element = tempArray[index];
			if (element < pivotElement) {
				masterArray[newArrayIndex++] = element;
			}
		}
		for (int index = startIndex; index <= endIndex; index++) {
			int element = tempArray[index];
			if (element == pivotElement) {
				masterArray[newArrayIndex++] = element;
				pivotIndex = newArrayIndex-1;
				break;
			}
		}
		for (int index = startIndex; index <= endIndex; index++) {
			int element = tempArray[index];
			if (element > pivotElement) {
				masterArray[newArrayIndex++] = element;
			}
		}
		sort(masterArray,masterArray.clone(),startIndex,pivotIndex-1);
		if(pivotIndex-1-startIndex>1){
			printArray(masterArray, startIndex, pivotIndex-1);
		}
		sort(masterArray,masterArray.clone(),pivotIndex+1,endIndex);
		if(endIndex-(pivotIndex+1)>0){
			printArray(masterArray, pivotIndex+1, endIndex);
		}
	}

	static void printArray(int[] ar, int startIndex, int endIndex) {
		for (int index = startIndex; index <= endIndex ; index++) {
			System.out.print(ar[index]);
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
		}
		sort(ar, ar.clone(), 0, ar.length-1);
		printArray(ar, 0, ar.length-1);
	}
}
