package hackerrank.algo.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class RichieRich {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);

		int numLength = in.nextInt();
		int changesAllowed = in.nextInt();

		String inputNum = in.next();

		int[] input = new int[numLength];
		int diffCount = 0;

		for (int index = 0; index < numLength; index++) {
			input[index] = Character.getNumericValue(inputNum.charAt(index));
		}

		boolean oddPalindrome = numLength%2==1;
		int iterationScope = oddPalindrome ? (numLength / 2)+1 : (numLength / 2);
		int[] diff = new int[iterationScope];

		for (int index = 0; index < iterationScope; index++) {
			if (input[index] == input[numLength - index - 1]) {
				diff[index] = 0;
			} else {
				diff[index] = 1;
				diffCount++;
			}
		}

		if(oddPalindrome){
			diff[iterationScope-1] = 1;
		}
		
		if (diffCount > changesAllowed) {
			System.out.println(-1);
			return;
		}

		for (int index = 0; index < diff.length; index++) {
			if(diff[index] == 1){
				if(changesAllowed>diffCount){
					if(input[index]!=9){
						input[index] = 9;
						changesAllowed--;
					}
					if(input[numLength-index-1]!=9){
						input[numLength-index-1] = 9;
						changesAllowed--;
					}
				}else{
					if(input[index]>input[numLength-index-1]){
						input[numLength-index-1] = input[index];
					}else{
						input[index] = input[numLength-index-1];
					}
					changesAllowed--;
				}
				diffCount--;
			}else{
				if(changesAllowed>diffCount+1){
					if(input[index]!=9){
						input[index] = 9;
						changesAllowed--;
					}
					if(input[numLength-index-1]!=9){
						input[numLength-index-1] = 9;
						changesAllowed--;
					}
				}
			}
		}

		printOutput(input);

	}

	private static void printOutput(int[] input) {
		System.out.println(Arrays.toString(input).replace(",", "")  //remove the commas
			    .replace("[", "")  //remove the right bracket
			    .replace("]", "")  //remove the left bracket
			    .replace(" ", "")
			    .trim());
	}

}
