package hackerrank.algo.bits;

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
		long xor = 0 ;
		for (long i = lower; i <= upper; i++) {
			xor = xor ^ getXor(i);
		}
		System.out.println(xor);
	}

	private static long getXor(long i) {
		int modulus = (int)i%4;
		
		switch (modulus) {
		case 0:
			return i;
		case 1:
			return 1;
		case 2:
			return i + 1;
		case 3:
			return 0;
		default:
			break;
		}
		return 0;
	}
	
}
