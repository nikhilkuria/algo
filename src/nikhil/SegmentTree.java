package nikhil;

public class SegmentTree {

	int arrayLength;
	int[] segmentTree;
	
	public void construct(int[] interval){
		initializeSegmentTree(interval.length);
		buildTree(0,interval,0,interval.length-1);
	}

	private void buildTree(int currentIndex, int[] intervalArray, int startIndex, int endIndex) {
		if(startIndex==endIndex){
			segmentTree[currentIndex] = intervalArray[startIndex];
			return;
		}
		int mid = (startIndex+endIndex)/2;
		buildTree(2*currentIndex+1, intervalArray, startIndex, mid);
		buildTree(2*currentIndex+2, intervalArray, mid+1, endIndex);
		segmentTree[currentIndex] = Math.min(segmentTree[2*currentIndex+1], segmentTree[2*currentIndex+2]);
	}

	public int searchMinimum(int startIndex, int endIndex){
		if(this.segmentTree == null){
			return Integer.MAX_VALUE;
		}
		return searchMinimum(startIndex, endIndex, 0, this.arrayLength-1, 0);
	}
	
	private int searchMinimum(int startIndex, int endIndex, int low,
			int high, int pos) {
		if((startIndex<=low)&&(endIndex>=high)){
			return segmentTree[pos];
		}
		if((startIndex>high) || (endIndex<low)){
			return Integer.MAX_VALUE;
		}
		int mid = (low+high)/2;
		return Math.min(searchMinimum(startIndex, endIndex, low, mid, 2*pos+1), searchMinimum(startIndex, endIndex, mid+1, high, 2*pos+2));
	}

	private void initializeSegmentTree(int length) {
		this.arrayLength = length;
		int treeSize = (int)((2*(Math.pow(Math.ceil(Math.sqrt(length)), 2)))-1);
		this.segmentTree = new int[treeSize];
	}
	
	public static void main(String args[]){
		SegmentTree segmentTree = new SegmentTree();
		segmentTree.construct(new int[]{-1,0,3,6,4,2,1});
		for (int i = 0; i < 10; i++) {
			int lowIndex = ((int)(Math.random()*10))%7;
			int upperIndex = ((int)(Math.random()*10))%7;
			if(lowIndex>upperIndex){
				upperIndex = upperIndex+lowIndex;
				lowIndex = upperIndex - lowIndex;
				upperIndex = upperIndex - lowIndex;
			}
			System.out.println("between "+lowIndex+" and "+upperIndex+" is "+segmentTree.searchMinimum(lowIndex, upperIndex));
		}
	}
	
}
