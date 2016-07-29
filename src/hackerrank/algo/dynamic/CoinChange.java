package hackerrank.algo.dynamic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CoinChange {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		
		int capitalAmount = in.nextInt();
		int numOfCoins = in.nextInt();
		int[] coins = new int[numOfCoins];
		
		for (int index = 0; index < numOfCoins; index++) {
			coins[index] = in.nextInt();
		}
		
		int sumOfChangeCombos = findChangeCombos(capitalAmount,0, coins, new HashMap<Integer, Integer>());
	}

	private static int findChangeCombos(int capitalAmount,int coinVal, int[] coins, Map<Integer, Integer> map) {
		if(capitalAmount==0){
			return coinVal;
		}else if(capitalAmount<0){
			return -1;
		}
		int sum = 0;
		for (int index = 0; index < coins.length; index++) {
			int sumDownTheLane = findChangeCombos(capitalAmount-coins[index],coins[index], coins, map);
			if(sumDownTheLane>0){
				sum = sum + sumDownTheLane;		
			}else if (sumDownTheLane==0){
				return sum;
			}else{
				return -1;
			}
		}
		return sum;
	}
}
	