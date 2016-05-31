package hackerrank.algo.sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BiggerIsGreaterTest {

	public static void main(String args[]){
		try {
			BiggerIsGreater bigger = new BiggerIsGreater();
			Scanner inputScanner = new Scanner(new File("C:/Temp/input.txt"));
			Scanner outputScanner = new Scanner(new File("C:/Temp/output.txt"));
			while(inputScanner.hasNext()){
				String input = inputScanner.nextLine();
				char[] inputChars = input.toCharArray();
				String output =  null;
				if(bigger.getHigherWord(inputChars)){
					output = new String(inputChars);
				}else{
					output = "no answer";	
				}
				String expectedOutput = outputScanner.nextLine();
				if(output==expectedOutput){
					//System.out.println("Looks good");
				}else{
					System.out.println("Expected : "+expectedOutput+" for Input : "+input+". But got : "+output);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("done");

	}
	
}
