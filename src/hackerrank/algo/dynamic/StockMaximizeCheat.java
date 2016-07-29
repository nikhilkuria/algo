package hackerrank.algo.dynamic;

import java.util.Scanner;

public class StockMaximizeCheat {
	  public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int size = scanner.nextInt();

	        for (int i = 0; i < size; i++) {
	            int numOfDays = scanner.nextInt();
	            int[] prices = new int[numOfDays];
	            for (int j = 0; j < numOfDays; j++) {
	                prices[j] = scanner.nextInt();
	            }
	            System.out.println(getMaxProfit(prices));
	        }
	    }

	    public static long getMaxProfit(int[] prices) {
	    	long profitMade = 0;
	    	int localMax = 0;
	    	for (int index = prices.length-1; index >=0; index--) {
				if(prices[index]>=localMax){
					localMax = prices[index];
				}
				profitMade = profitMade + (localMax - prices[index]);
			}
	    	return profitMade;
	    }
}
