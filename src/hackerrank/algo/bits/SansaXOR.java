package hackerrank.algo.bits;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SansaXOR {

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		
		int numOfTests = in.nextInt();
		
		for (int testIndex = 0; testIndex < numOfTests; testIndex++) {
			int length = in.nextInt();
			int[] test = new int[length];
			for (int i = 0; i < length; i++) {
				test[i] = in.nextInt();
			}
			sansaXOR(test);
		}
	}

	private static void sansaXOR(int[] test) {
		Map<Integer, Integer> counterMap = new HashMap<Integer, Integer>();
		counterMap.put(test[0], test.length);
		for (int i = 1; i < test.length; i++) {
			int count = (test.length-i)*(i+1); 
					//+ (counterMap.get(test[i-1])-i);
			if(counterMap.containsKey(test[i])){
				count = count + counterMap.get(test[i]);
			}
			counterMap.put(test[i], count);
		}
		long xorVal = 0;
		for (Integer uniqueNum : counterMap.keySet()) {
			if(counterMap.get(uniqueNum)%2!=0){
				xorVal = xorVal ^ uniqueNum;
			}
		}
		System.out.println(xorVal);
	}
	
}
