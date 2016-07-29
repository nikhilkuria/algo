package hackerrank.algo.bits;

import java.math.BigInteger;
import java.util.Scanner;

public class XORSequence {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        for(int a0 = 0; a0 < Q; a0++){
            long L = in.nextLong();
            long R = in.nextLong();
            findXORDiff(L,R);
        }
    }

	private static void findXORDiff(long lower, long upper) {
		BigInteger xor = BigInteger.ZERO;
		long lowerFourOffset = (4-((lower)%4))%4;
		long upperFourOffset = (upper)%4;

		long lowerFour = lower + lowerFourOffset;
		long upperFour = upper - upperFourOffset;
		
		for (long i = 0; i < lowerFourOffset; i++) {
			//xor = xor ^ findXor(lower+i);
			xor = xor.xor(findXor(BigInteger.valueOf(lower+i)));
		}
		for (long i = 0; i < upperFourOffset+1; i++) {
			//xor = xor ^ findXor(upper-i);
			xor = xor.xor(findXor(BigInteger.valueOf(upper-i)));
		}
		
		if(!(((upperFour-lowerFour)/2)%4==0)){
			xor = xor.xor(BigInteger.valueOf(2L));
		}
		
		System.out.println(xor);
	}

	private static BigInteger findXor(BigInteger index) {
		switch (Integer.valueOf(index.mod(BigInteger.valueOf(4)).toString())) {
		case 1:
			return BigInteger.ONE;
		case 2:
			return index.divide(BigInteger.valueOf(4)).add(BigInteger.ONE).multiply(BigInteger.valueOf(4)).subtract(BigInteger.ONE);
		case 3: 
			return BigInteger.ZERO;
		default:
			return index;
		}
	}

	
}
