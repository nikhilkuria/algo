package hackerrank.algo.implementation;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;


public class CutSticks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCaseCount = in.nextInt();
        List<Integer> sticks = new LinkedList<Integer>();
        int minLengthStick = Integer.MAX_VALUE;
        for(int index=0; index < testCaseCount; index++){
            int stick = in.nextInt();
            if(stick < minLengthStick){
                minLengthStick = stick;
            }
            sticks.add(stick);
        }
        do{
            System.out.println(sticks.size());
            ListIterator<Integer> iterator = sticks.listIterator();
            int newMinLengthStick = Integer.MAX_VALUE;
            while(iterator.hasNext()){
                int stick = iterator.next();
                iterator.remove();
                int newStick = stick-minLengthStick;
                if(newStick>0){
                    iterator.add(newStick);
                    if(newStick < newMinLengthStick){
                        newMinLengthStick = newStick;
                    }
                }
            }
            minLengthStick = newMinLengthStick;
        }while(sticks.size()>0);
    }
}