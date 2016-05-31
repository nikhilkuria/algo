package hackerrank.algo.implementation;

import java.util.Scanner;

public class LarryArray {

    private static final String YES = "YES";
    private static final String NO = "NO";
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTestCases = in.nextInt();

        for (int testCaseIndex = 0; testCaseIndex < numTestCases; testCaseIndex++) {
            int testCaseLength = in.nextInt();
            int[] testCase = new int[testCaseLength];
            for (int testCaseLengthIndex = 0; testCaseLengthIndex < testCaseLength; testCaseLengthIndex++) {
                testCase[testCaseLengthIndex] = in.nextInt();
            }
            System.out.println(canBeSorted(testCase));
        }
    }

    private static String canBeSorted(int[] testCase) {       
        int count = 0;
        int index = 0;
        do{
            int secIndex = index+1;
            do{
                if(testCase[index]>testCase[secIndex]){
                    count++;
                }
                secIndex++;
            }while(secIndex<testCase.length);
            index++;
        }while(index<testCase.length-1);
        return count%2==0?YES:NO;
    }

    
    
}
