package hackerrank.algo.implementation;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class EmaSuperComputer {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		EmaSuperComputer computer = new EmaSuperComputer();
		int height = in.nextInt();
		int width = in.nextInt();
		in.nextLine();
		char[][] grid = new char[height][width];
		Span[][] spanArray = new Span[height][width];

		for (int heightIndex = 0; heightIndex < height; heightIndex++) {
			char[] line = in.nextLine().toCharArray();
			for (int widthIndex = 0; widthIndex < width; widthIndex++) {
				grid[heightIndex][widthIndex] = line[widthIndex];
				spanArray[heightIndex][widthIndex] = computer.new Span();
			}
		}

		computer.populateSpanArray(spanArray, grid);
		System.out.println();
	}

	private void populateSpanArray(Span[][] spanArray, char[][] grid) {
		for (int heightIndex = 0; heightIndex < grid.length; heightIndex++) {
			for (int widthIndex = 0; widthIndex < grid[0].length; widthIndex++) {
				for (Direction direction : Direction.values()) {
					int spanVal = getSpanValue(direction, heightIndex,
							widthIndex, grid, spanArray);
					spanArray[heightIndex][widthIndex].setSpan(direction,
							spanVal);
				}
			}
		}
	}

	private int getSpanValue(Direction direction, int heightIndex,
			int widthIndex, char[][] grid, Span[][] spanArray) {
		switch (direction) {
		case NORTH:
			if (heightIndex - 1 >= 0) {
				return spanArray[heightIndex - 1][widthIndex].getSpan(direction);
			} else {
				return 0;
			}
		case SOUTH:
			if (heightIndex + 1 >= 0) {
				return spanArray[heightIndex + 1][widthIndex].getSpan(direction);
			} else {
				return 0;
			}
		case EAST:
			if (widthIndex - 1 >= 0) {
				return spanArray[heightIndex][widthIndex - 1].getSpan(direction);
			} else {
				return 0;
			}
		case WEST:
			if (widthIndex + 1 >= 0) {
				return spanArray[heightIndex][widthIndex + 1].getSpan(direction);
			} else {
				return 0;
			}
		default:
			return 0;
		}
	}

	private class Span {
		private Map<Direction, Integer> spans;

		public Span() {
			Map<Direction, Integer> spans = new HashMap<Direction, Integer>();
			for (Direction direction : Direction.values()) {
				this.spans.put(direction, 1);
			}
			this.spans = spans;
		}

		public Integer getSpan(Direction direction) {
			return spans.get(direction);
		}

		public void setSpan(Direction direction, Integer spanVal) {
			spans.put(direction, spanVal);
		}

		public void setSpans(Map<Direction, Integer> spans) {
			this.spans = spans;
		}
	}

	public enum Direction {
		NORTH, SOUTH, EAST, WEST;
	}

}
