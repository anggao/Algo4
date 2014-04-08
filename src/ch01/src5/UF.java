package ch01.src5;

public abstract class UF {

	protected int[] id; // access to component id (site indexed)
	protected int count; // number of components

	public UF(int N) {
		// Initialize component id array
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
	}

	public int count() {
		return count;
	}

	public abstract int find(int p);
	public abstract void union(int p, int q);

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
}
