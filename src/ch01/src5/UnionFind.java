package ch01.src5;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class UnionFind {

	private int[] id; // id[i] = parent of i
	private byte[] rank; // rank[i] = rank of subtree rooted at i (cannot be
							// more than 31)
	private int count; // number of components

	public UnionFind(int N) {
		id = new int[N];
		rank = new byte[N];
		count = N;
		for (int i = 0; i < N; i++) {
			id[i] = i;
			rank[i] = 0;
		}
	}

	/**
	 * Returns the component identifier for the component containing site p
	 * 
	 * @param p
	 *            the integer representing one object
	 * @return the component identifier for the component containing site
	 *         <tt>p</tt>
	 */
	public int find(int p) {
		while (p != id[p]) {
			id[p] = id[id[p]]; // path compression by halving
			p = id[p];
		}
		return p;
	}

	/**
	 * Returns the number of components.
	 * 
	 * @return the number of components (between <tt>1</tt> and <tt>N</tt>)
	 */
	public int count() {
		return count;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public void union(int p, int q){
		int i = find(p);
		int j = find(q);
		if(i == j) return;

		// make root of smaller rank point to root of larger rank
		if(rank[i] < rank[j]) id[i] = j;
		else if(rank[i] > rank[j]) id[j] = i;
		else {
			id[j] = i;
			rank[i]++;
		}
		count--;
	}
	
	public static void main(String[] args) {
		int N = StdIn.readInt();
		UnionFind uf = new UnionFind(N);
		while(StdIn.isEmpty()){
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if(uf.connected(p, q)) continue;
			uf.union(p, q);
			StdOut.println(p + " " + q);
		}
        StdOut.println(uf.count() + " components");
	}
}
