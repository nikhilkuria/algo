package hackerrank.algo.gametheory;

import java.util.Scanner;

public class GameOfStonesO1 {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int count = in.nextInt();
		for (int i = 0; i < count; i++) {
			System.out.println(in.nextInt() % 7 < 2 ? "Second" : "First");
		}
	}

}
