package hackerrank.algo.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ValidString {

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
		String inputString = in.nextLine();
		
		char[] input = inputString.toCharArray();
		
		for (int index = 0; index < input.length; index++) {
			Character inputChar = Character.valueOf(input[index]);
			if(!charMap.containsKey(inputChar)){
				charMap.put(inputChar, 1);
			}else{
				charMap.put(inputChar, charMap.get(inputChar)+1);
			}
		}
		
		for (char c : charMap.keySet()) {
			int count = charMap.get(Character.valueOf(c));
			if(!frequencyMap.containsKey(count)){
				frequencyMap.put(count, 1);
			}else{
				frequencyMap.put(count, frequencyMap.get(count)+1);
			}
		}
		
		if(frequencyMap.keySet().size()>2){
			System.out.println("NO");
			return;
		}
		
		if(frequencyMap.keySet().size()==1){
			System.out.println("YES");
			return;
		}
		
		boolean freqOne = false;
		
		for (int occurence : frequencyMap.keySet()) {
			int frequency = frequencyMap.get(occurence);
			if(frequency==1){
				if(freqOne){
					System.out.println("NO");
					return;
				}
				freqOne=true;
			}
		}
		if(freqOne){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
		
	}
	
}
