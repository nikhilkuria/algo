package hackerrank.algo.dynamic;

import java.util.Scanner;

public class StockMaximize {

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int numOfTests = in.nextInt();
		for (int testIndex = 0; testIndex < numOfTests; testIndex++) {
			int numOfDays = in.nextInt();
			int[] prices = new int[numOfDays];
			for (int priceIndex = 0; priceIndex < numOfDays; priceIndex++) {
				prices[priceIndex] = in.nextInt();
			}
			int[] actions = new int[numOfDays];
 			findMaximumProfit(prices, 0, actions);
 			int maxProfit = 0;
 			int holdings = 0;
 			for (int actionIndex = 0; actionIndex < actions.length; actionIndex++) {
 				if(((actions[actionIndex]>=0) && actionIndex!=actions.length-1) || (actions[actionIndex]==0 && holdings==0)){
					maxProfit = maxProfit - (prices[actionIndex]);
					holdings++;
				}else{
					if(holdings>0){
						maxProfit = maxProfit + prices[actionIndex]*holdings;
						holdings=0;
					}
				}
			}
 			System.out.println(maxProfit);
		}
	}

	private static int findMaximumProfit(int[] prices, int index, int[] actions) {
		if(index == prices.length-2){
			actions[index] = (prices[index+1]-prices[index]);
		}else{
			actions[index] = ((prices[index+1]-prices[index])*prices[index]) + findMaximumProfit(prices, index+1, actions);
		}
		return actions[index];
	}
	
}
