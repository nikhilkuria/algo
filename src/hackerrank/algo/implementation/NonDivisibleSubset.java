package hackerrank.algo.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NonDivisibleSubset {

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		
		Map<Integer, Integer> remainderMap = new HashMap<Integer, Integer>();
		
		int count = in.nextInt();
		int divisor = in.nextInt();
		int[] input = new int[count];
		for (int i = 0; i < count; i++) {
			input[i] = in.nextInt();
		}
		
		for (int index = 0; index < input.length; index++) {
			int remainder = input[index]%divisor;
			if(remainderMap.containsKey(remainder)){
				remainderMap.put(remainder, remainderMap.get(remainder)+1);
			}else{
				remainderMap.put(remainder, 1);
				if(remainder!=0){
					remainderMap.put(divisor-remainder, 0);
				}
			}
		}
		
		int maxCount = 0;
		
		for (Integer remainder : remainderMap.keySet()) {
			if(remainder==0){
				maxCount = maxCount+2;
			}else if((divisor%2==0)&&(remainder==divisor/2)){
				maxCount = maxCount+2;
			}else{
				maxCount = maxCount + Math.max(remainderMap.get(remainder), remainderMap.get(divisor-remainder));
			}
		}
		System.out.println(maxCount/2);
	}
	
}
