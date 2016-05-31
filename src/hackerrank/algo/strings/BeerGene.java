package hackerrank.algo.strings;

import java.util.Arrays;
import java.util.Scanner;

public class BeerGene {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        String[] strand = new String[length];
        strand = in.next().split("(?!^)");
        System.out.println(getMinimalSection(strand));
        in.close();
    }

    private static int getMinimalSection(String[] strand) {
        int[] linkFreq = new int[4];
        int count = 0;
        boolean shouldReplace = false;
        for (int index = 0; index < strand.length; index++) {
            Link link = Link.valueOf(strand[index]);
            linkFreq[link.getIndex()]++;
        }
        for (int index = 0; index < linkFreq.length; index++) {
            linkFreq[index]-=strand.length/4;
            if(linkFreq[index]<0){
            	shouldReplace = true;
            }
        }
        if(shouldReplace){
            count = getMinimalStringLenth(linkFreq, strand);
        }
        return count;
    }

    

	private static int getMinimalStringLenth(int[] linkFreq, String[] strand) {
		int strandLength = strand.length;
		int leadingPointer=0,trailingPointer = 0;
		do{
			
			Link link = Link.valueOf(strand[leadingPointer]);
			linkFreq[link.getIndex()]--;
			if(allLinksFound(linkFreq)){
				do{
					Link trailinglink = Link.valueOf(strand[trailingPointer]);
					if(linkFreq[trailinglink.getIndex()]==0){
						int length = leadingPointer - trailingPointer + 1;
						if(length<strandLength){
							strandLength = length;
						}
						break;
					}
					linkFreq[trailinglink.getIndex()]++;
					trailingPointer++;
				}while(trailingPointer<leadingPointer);
			}
			leadingPointer++;
		}while(leadingPointer<strand.length);
		return strandLength;
	}

	private static boolean allLinksFound(int[] links) {
		for (int index = 0; index < links.length; index++) {
			if(links[index]>0){
				return false;
			}
		}
		return true;
	}

	private enum Link{
        A("A",0),
        G("G",1),
        T("T",2),
        C("C",3);
        
        private String code;
        private int index;
        
        private Link(String code, int index){
            this.code = code;
            this.index = index;
        }
        
        public int getIndex(){
            return index;
        }
        
        public String getCode(){
            return code;
        }
        
        public Link getLink(String code){
            for (Link link : values()) {
                if(link.getCode().equals(code)){
                    return link;
                }
            }
            return null;
        }
    }
    
}
