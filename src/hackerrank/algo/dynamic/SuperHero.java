package hackerrank.algo.dynamic;

import java.util.Scanner;

public class SuperHero {

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		
		int numOfTests = in.nextInt();
		in.nextLine();
		for (int testIndex = 0; testIndex < numOfTests; testIndex++) {
			int numOfLevels = in.nextInt();
			int numOfMonsters = in.nextInt();
			in.nextLine();
			int[][] monsterHealthIndex = new int[numOfLevels][numOfMonsters];
			int[][] monsterBulletIndex = new int[numOfLevels][numOfMonsters];
			
			for (int levelIndex = 0; levelIndex < numOfLevels; levelIndex++) {
				for (int monsterIndex = 0; monsterIndex < numOfMonsters; monsterIndex++) {
					monsterHealthIndex[levelIndex][monsterIndex] = in.nextInt();
				}
			}
			
			for (int levelIndex = 0; levelIndex < numOfLevels; levelIndex++) {
				for (int monsterIndex = 0; monsterIndex < numOfMonsters; monsterIndex++) {
					monsterBulletIndex[levelIndex][monsterIndex] = in.nextInt();
				}
			}
			
			System.out.println();
		}
	}
	
}
