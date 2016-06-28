package hackerrank.algo.bits;

public class XORHelper {

	public static void main(String args[]){
		int[] xorArray = new int[1024];
		xorArray[0] = 1;
		for (int i = 1; i < xorArray.length; i++) {
			xorArray[i] = xorArray[i-1] ^ (i+1);
		}
		
	}
	
}
