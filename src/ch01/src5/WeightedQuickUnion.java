package ch01.src5;

public class WeightedQuickUnion extends UF {
	private int[] sz; // size of component for roots (site indexed)

	public WeightedQuickUnion(int N) {
		super(N);
		sz = new int[N];
		for (int i = 0; i < N; i++)
			sz[i] = 1;
	}

	@Override
	public int find(int p) {
		// Follow links to find a root
		while (p != id[p])
			p = id[p];
		return p;
	}

	@Override
	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (i == j)
			return;
		// Make smaller root point to larger one.
		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
		count--;
	}

}
