package ch01.src5;

public class QuickFind_UF extends UF {

	public QuickFind_UF(int N) {
		super(N);
	}

	@Override
	public int find(int p) {
		return id[p];
	}

	@Override
	public void union(int p, int q) {
		// put p and q into the same component
		int pID = find(p);
		int qID = find(q);
		if (pID == qID)
			return;

		// Rename p’s component to q’s name.
		for (int i = 0; i < id.length; i++)
			if (id[i] == pID)
				id[i] = qID;
		count--;
	}

}
