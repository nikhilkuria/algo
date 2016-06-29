package hackerrank.algo.bits;

import java.util.Arrays;

public class XORHelper {

	public static void main(String args[]){
		int[] xorArray = new int[1024];
		int[] outerArray = new int[1024];
		xorArray[0] = 0;
		for (int i = 1; i < xorArray.length; i++) {
			xorArray[i] = xorArray[i-1] ^ (i);
		}
		System.out.println(Arrays.toString(xorArray));
		int outerArrayIndex = 0;
		for (int i = 0; i < xorArray.length-1;) {
			int xor = 0;
			StringBuilder builder = new StringBuilder();
			for (int j = 0; j < 4; j++,i++) {
				builder.append(xorArray[i]);
				xor = xor ^ xorArray[i];
			}
			outerArray[outerArrayIndex] = xor;
			outerArrayIndex++;
			if(isPowerOfTwo(xorArray[i-1])){
				System.out.println(builder.toString() + " : " +xor);
			}
		}
		int outerXor = 0;
/*		for (int j = 0; j < outerArray.length; j++) {
			outerXor = outerXor ^ outerArray[j];
			System.out.print(outerXor);
			System.out.print(" ");
		}*/

	}

	private static boolean isPowerOfTwo(int n) {
		//return (n & (n - 1)) == 0;
		return true;
	}
	
}
