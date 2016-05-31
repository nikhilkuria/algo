package sort;

import java.util.Scanner;

public class AlmostSorted {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int length = in.nextInt();
		int input[] = new int[length+2];

		for (int index = 1; index <= length; index++) {
			input[index] = in.nextInt();
		}
		input[0] = -1;
		input[length+1]=1000001;
		
		boolean trendUp = true;
		int inversions = 0;
		int firstPoint = -1;
		int lastPoint = -1;
		int[] inversionPoints = new int[4];
		for (int index = 0; index < input.length-1; index++) {
			int currval = input[index];
			int nextval = input[index + 1];

			if(index == input.length-2){
				//the last element before boundary value
				if(!trendUp && inversions>1){
					System.out.println("no");
					return;
				}
			}
			
			if (((nextval < currval) && trendUp)
					|| ((nextval > currval) && !trendUp)) {
				
				if(inversions>2 && (index - lastPoint > 1)){
					System.out.println("no");
					return;
				}
				inversionPoints[inversions] = index;
				inversions++;
				trendUp = !trendUp;
				if (firstPoint == -1) {
					firstPoint = index;
				}
				lastPoint = index;
				
				if(inversions>4){
					System.out.println("no");
					return;
				}
			}

		}
		
		if(lastPoint != length){
			if(input[lastPoint+1]<input[firstPoint]){
				System.out.println("no");
				return;
			}
		}
		
		if(inversions==4){
			if((inversionPoints[1]-inversionPoints[0]!=1) || (inversionPoints[3]-inversionPoints[2]!=1)){
				System.out.println("no");
				return;
			}
		}
		
		if(inversions==2){
			if(firstPoint>1){
				if(input[lastPoint]<input[firstPoint-1]){
					System.out.println("no");
					return;
				}
			}
		}
		
		if(inversions==2 && (lastPoint-firstPoint < 3)){
			inversions = 4;
		}
		switch (inversions) {
		case 4:
			System.out.println("yes");
			System.out.println("swap " + firstPoint + " " + lastPoint);
			break;
		case 2:
			System.out.println("yes");
			System.out.println("reverse " + firstPoint + " " + lastPoint);
			break;
		case 0:
			System.out.println("yes");
			break;
		default:
			System.out.println("no");
			break;
		}
	}
}
