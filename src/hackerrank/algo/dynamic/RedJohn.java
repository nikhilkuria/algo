package hackerrank.algo.dynamic;

import java.util.Scanner;

public class RedJohn {

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		
		int numOfTestCases = in.nextInt();
		
		for (int index = 0; index < numOfTestCases; index++) {
			int lengthOfWall = in.nextInt();	
			int numOfCombinations = findNumberOfCombinations(new int[lengthOfWall+1]);
			int primeCount = 0;
			for (int comboIndex = 2; comboIndex <= numOfCombinations; comboIndex++) {
				if(isPrime(comboIndex)){
					primeCount++;
				}
			}
			System.out.println(primeCount);
		}
	}

	
	private static int findNumberOfCombinations(int[] combinations) {

		for (int wallIndex = 0; wallIndex < combinations.length; wallIndex++) {
			if(wallIndex>=4){
				combinations[wallIndex] = combinations[wallIndex-1] + combinations[wallIndex-4];
			}else{
				combinations[wallIndex] = 1;
			}
		}
		
		return combinations[combinations.length-1];
	}


	private static boolean isPrime(int n) {
	    //check if n is a multiple of 2
		if(n==2){
			return true;
		}
	    if (n%2==0) return false;
	    //if not, then just check the odds
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
	
}
