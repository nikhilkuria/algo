package hackerrank.algo.bits;

import java.util.Scanner;

public class ChangingBits {

	private static int[] sumRepo;
	private static String firstInput;
	private static String secondInput;
	private static int inputLength;
	
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int numOfBits = in.nextInt();
		int numOfCommands = in.nextInt();
		in.nextLine();
		firstInput = in.nextLine().trim();
		secondInput = in.nextLine().trim();
		inputLength = numOfBits;
		initializeRepo(firstInput,secondInput);
		executeCommands(numOfCommands, in);
	}

	private static void initializeRepo(String firstInput, String secondInput) {
		sumRepo = new int[firstInput.length()];
		for (int index = 0; index < firstInput.length(); index++) {
			sumRepo[index] = Character.getNumericValue(firstInput.charAt(index)) + Character.getNumericValue(secondInput.charAt(index));
		}
	}

	private static void executeCommands(int numOfCommands, Scanner in) {
		for (int index = 0; index < numOfCommands; index++) {
			String commandString = in.nextLine();
			String params[] = commandString.split(" ");
			Commands command = Commands.valueOf(params[0]); 
			int indxToReplace = 0;
			int charToReplace = 0;
			Integer idx = Integer.valueOf(params[1]);
			switch (command) {
			case set_a :
				indxToReplace = inputLength - idx - 1;
				charToReplace = Integer.valueOf(params[2]);
				if(Character.getNumericValue(firstInput.charAt(indxToReplace))==charToReplace){
					return;
				}
				if(charToReplace==0){
					sumRepo[indxToReplace]--;
				}else{
					sumRepo[indxToReplace]++;
				}
				break;
			case set_b :
				indxToReplace = inputLength - idx - 1;
				charToReplace = Integer.valueOf(params[2]);
				if(Character.getNumericValue(secondInput.charAt(indxToReplace))==charToReplace){
					return;
				}
				if(charToReplace==0){
					sumRepo[indxToReplace]--;
				}else{
					sumRepo[indxToReplace]++;
				}
				break;
			case get_c :
				System.out.print(printSumBit(idx-1, idx-1));
				break;
			default:
				break;
			}
		}
	}
	
	private static int printSumBit(int indexToPrint, int currentIndex) {
		if((currentIndex<sumRepo.length)){
			if (sumRepo[currentIndex]!=0) {
				int carryBit = printSumBit(indexToPrint, currentIndex + 1);
				int sum = sumRepo[currentIndex] + carryBit;
				switch(sum){
				case 3:
					return 1;
				case 2:
					if(currentIndex==0){
						return 0;
					}else{
						return 1;
					}
				case 1:
					return 1;
				case 0:
					return 0;
				default:
					return 0;
				}

			}
		}
		return 0;
	}

	enum Commands{
		set_a,set_b,get_c; 
	}
}
