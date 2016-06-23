package hackerrank.algo.dynamic;

import java.util.HashMap;
import java.util.Scanner;

public class Coins {

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		
		int capitalAmount = in.nextInt();
		
		int numOfCoins = in.nextInt();
		
		int[] coins = new int[numOfCoins];
 		
		for (int index = 0; index < numOfCoins; index++) {
			coins[index] = in.nextInt();
		}
		
		System.out.println(findSum(capitalAmount, coins, new HashMap<Integer, Integer>()));
	}

	private static int findSum(int capitalAmount, int[] coins,
			HashMap<Integer, Integer> map) {
		if(capitalAmount<0){
			return 0;
		}else if(capitalAmount==0){
			return 1;
		}else{
			if(map.containsKey(capitalAmount)){
				return map.get(capitalAmount);
			}
			int sum = 0;
			for (int index = 0; index < coins.length; index++) {
				int partialSum = findSum(capitalAmount-coins[index], coins, map);
				sum = sum + partialSum;
			}
			map.put(capitalAmount, sum);
			return sum;
		}
	}
	
}
