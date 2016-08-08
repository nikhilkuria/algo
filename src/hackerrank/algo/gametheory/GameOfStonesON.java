package hackerrank.algo.gametheory;

import java.util.Scanner;

public class GameOfStonesON {

	static int[] dp = new int[101];
	
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int totalCases = in.nextInt();
		buildDp();
		for (int i = 0; i < totalCases; i++) {
			System.out.println(dp[in.nextInt()]==1?"First" : "Second");
		}
	}

	private static void buildDp() {
		//statics
		dp[0] = 0;
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 1;
		
		for (int i = 5; i < 101; i++) {
			if((dp[i-2]==0) || (dp[i-3]==0) || (dp[i-5]==0)){
				dp[i] = 1;
			}else{
				dp[i] = 0;
			}
		}
	}
	
}
