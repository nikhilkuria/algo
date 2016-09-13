package hackerrank.algo.implementation;

import java.util.Scanner;

public class FlatlandSpace {

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int stationSize = in.nextInt();
		
		boolean[] cities = new boolean[size];
		
		for (int index = 0; index < stationSize; index++) {
			cities[in.nextInt()] = true;
		}
		
		int maxLength = 0;
		int length = 0;
		boolean leading = true;
		for (int cityIndex = 0; cityIndex < cities.length; cityIndex++) {
			if(!cities[cityIndex]){
				length++;
				if(leading){
					length++;
				}
				if(cityIndex==cities.length-1){
					length = length*2;
				}
				if(length>maxLength){
					maxLength = length;
				}
			}else{
				leading = false;
				length = 0;
			}
		}
		System.out.println((maxLength+1)/2);
	}
	
}
