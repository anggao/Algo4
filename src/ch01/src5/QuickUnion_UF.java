package ch01.src5;

public class QuickUnion_UF extends UF {

	public QuickUnion_UF(int N) {
		super(N);
	}

	@Override
	public int find(int p) {
		while (id[p] != p)
			p = id[p];
		return p;
	}

	@Override
	public void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot == qRoot)
			return;
		id[pRoot] = qRoot;
		count--;
	}
}
