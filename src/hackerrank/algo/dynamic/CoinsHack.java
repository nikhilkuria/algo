package hackerrank.algo.dynamic;

import java.util.Scanner;

public class CoinsHack {
	
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		
		int capitalAmount = in.nextInt();
		
		int numOfCoins = in.nextInt();
		
		int[] coins = new int[numOfCoins];
		long[][] coinsNeeded = new long[numOfCoins][capitalAmount+1];
 		
		for (int index = 0; index < numOfCoins; index++) {
			coins[index] = in.nextInt();
		}
		
		for (int index = 0; index < numOfCoins; index++) {
			coinsNeeded[index][0] = 1;
		}
		
		for (int index = 0; index < numOfCoins; index++) {
			for (int capitalIndex = 1; capitalIndex <= capitalAmount; capitalIndex++) {
				long previousCoins = 0;
				if(index>0){
					previousCoins = coinsNeeded[index-1][capitalIndex];
				}
				if(capitalIndex>=coins[index]){
					coinsNeeded[index][capitalIndex] = previousCoins + coinsNeeded[index][capitalIndex-coins[index]];
				}else{
					coinsNeeded[index][capitalIndex] = previousCoins;
				}
			}
		}
		
		System.out.println(coinsNeeded[numOfCoins-1][capitalAmount]);
	}
}
