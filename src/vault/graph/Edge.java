package vault.graph;

public class Edge implements Comparable<Edge> {
	private static final double DEFAULT_WEIGHT = 1.0;

	private int from;
	private int to;
	private double weight;

	private Edge(int from, int to) {
		this.from = from;
		this.to = to;
		this.weight = DEFAULT_WEIGHT;
	}

	private Edge(int from, int to, double weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	public static Edge newEdge(int from, int to) {
		return new Edge(from, to);
	}

	public static Edge newEdge(int from, int to, double weight) {
		return new Edge(from, to, weight);
	}

	public int other(int vertex) {
		return vertex == from ? to : from;
	}

	public int either(){
		return from;
	}
	
	public double getWeight() {
		return this.weight;
	}

	@Override
	public int compareTo(Edge that) {
		if (this.weight < that.weight) {
			return -1;
		} else if (this.weight > that.weight) {
			return 1;
		} else {
			return 0;
		}

	}
}
