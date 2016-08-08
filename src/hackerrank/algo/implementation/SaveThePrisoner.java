package hackerrank.algo.implementation;

import java.util.Scanner;

public class SaveThePrisoner {

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		
		int tests = in.nextInt();
		
		for (int testIndex = 0; testIndex < tests; testIndex++) {
			int prisonerCount = in.nextInt();
			int candyCount = in.nextInt();
			int startIndex = in.nextInt();
			int index = (candyCount%prisonerCount)+startIndex-1;
			if(index==0){
				System.out.println(prisonerCount);
			}else{
				System.out.println(index%prisonerCount);
			}
		}
	}
	
}
