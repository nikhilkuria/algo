package hackerrank.algo.bits;

import java.util.Scanner;

public class MaximizeXor {

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		
		int lower = in.nextInt();
		int upper = in.nextInt();
		
		int base = lower ^ upper;
		base = base | (base >> 2);
		base = base | (base >> 2);
		base = base | (base >> 2);
		base = base | (base >> 2);
		base = base | (base >> 2);
		base = base | (base >> 2);
		base = base | (base >> 2);
		base = base | (base >> 2);
		base = base | (base >> 2);
		base = base | (base >> 2);

		System.out.println(base);
	}
	
}
