package hackerrank.algo.dynamic;

import java.util.Scanner;

public class StockMaximize {
		public static void main(String args[]){
			Scanner in = new Scanner(System.in);
			int numOfTests = in.nextInt();
			for (int testIndex = 0; testIndex < numOfTests; testIndex++) {
				int numOfDays = in.nextInt();
				long[] prices = new long[numOfDays+2];
				for (int priceIndex = 1; priceIndex < numOfDays+1; priceIndex++) {
					prices[priceIndex] = in.nextLong();
				}
				prices[0] = 0;
				prices[prices.length-1] = 0;
				long[] movementIndices = new long[numOfDays];
				for (int i = 0; i < numOfDays; i++) {
					movementIndices[i] = (prices[i+1] - prices[i])*(i);
				}
				
				int stocksInHand = 0;
				long highestSoFar = -1;
				long profitMade = 0L;
				for (int index = numOfDays-1; index >=0; index--) {

						if(prices[index+1]>highestSoFar){
							profitMade = profitMade + stocksInHand*highestSoFar;
							highestSoFar = prices[index+1];
							stocksInHand=0;
						}else{
							profitMade = profitMade - prices[index+1];
							stocksInHand++;
						}

				}
				profitMade = profitMade + stocksInHand*highestSoFar;
				
				System.out.println(profitMade);
			}
		}
}
