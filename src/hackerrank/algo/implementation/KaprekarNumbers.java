package hackerrank.algo.implementation;

import java.util.Scanner;

public class KaprekarNumbers {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int firstIndex = in.nextInt();
        int secondIndex = in.nextInt();
        StringBuilder builder = new StringBuilder();
        for (int index = firstIndex; index <= secondIndex; index++) {
            if(isKaprekar(index)){
                builder.append(index);
                builder.append(" ");
            }
        }
        if(builder.toString().length()==0){
            System.out.println("INVALID RANGE");
        }else{
            System.out.println(builder.toString());
        }
    }
    
    private static boolean isKaprekar(int num){
        long numSquare = (long)num*num;
        String numSquareString = String.valueOf(numSquare);
        int length = numSquareString.length();
        int firstHalf = 0;
        String substringFirstHalf = numSquareString.substring(0, (length/2));
        if(substringFirstHalf.length()>0){
            firstHalf = Integer.valueOf(substringFirstHalf);
        }
        int secondHalf = Integer.valueOf(numSquareString.substring(length/2, length));
        if(firstHalf+secondHalf==num){
            return true;
        }
        return false;
    }
    
}
