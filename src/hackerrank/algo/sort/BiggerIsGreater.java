package hackerrank.algo.sort;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BiggerIsGreater {
	
	
    public static void main(String[] args) {
    	BiggerIsGreater bigger = new BiggerIsGreater();
    	Scanner in = new Scanner(System.in);
    	int numOfTests = in.nextInt();
    	in.nextLine();
    	for (int testIndex = 0; testIndex < numOfTests; testIndex++) {
			String word = in.nextLine();
			bigger.getNext(word);

		}
    }

	public void getNext(String word) {
		OutputStreamWriter writer = new OutputStreamWriter(System.out);
		try {
			if (word.length() == 1) {
				writer.append("no answer");
				writer.append("\n");
				writer.flush();
				return;
			}
			char[] chars = word.toCharArray();
			if (getHigherWord(chars)) {
				for (int index = 0; index < chars.length; index++) {
					writer.append(chars[index]);
				}
			}
			writer.append("\n");
			writer.flush();
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

	public boolean getHigherWord(char[] chars) {
		int indexToReplace = chars.length-1;
		
		while(indexToReplace>0 && chars[indexToReplace-1]>=chars[indexToReplace]){
			indexToReplace--;
		}
		
		if(indexToReplace<=0){
			System.out.print("no answer");
			return false;
		}
		
		int replacementIndex = indexToReplace-1;
		while((replacementIndex+1<=chars.length-1) && chars[replacementIndex+1]>chars[indexToReplace-1]){
			replacementIndex++;
		}
		swap(chars,indexToReplace-1, replacementIndex);
		
		int endPointer = chars.length-1;
		while(indexToReplace<endPointer){
			if(chars[indexToReplace]==chars[endPointer]){
				return true;
			}
			swap(chars, indexToReplace, endPointer);
			indexToReplace++;
			endPointer--;
		}
		return true;
	}
	
	private static void swap(char[] chars, int indexToReplace,
			int replacementIndex) {
		char tmp = chars[indexToReplace];
		chars[indexToReplace] = chars[replacementIndex];
		chars[replacementIndex] = tmp;
	}

    
}
