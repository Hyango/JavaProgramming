package leetcode;

/* 并查集 */
public class UnionFind {
	private int count;
	private int[] parent;
	
	public UnionFind(int n) {
		count = n;
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}
	
	/* !!!要会写!!! */
	public int find(int x) {
		if (parent[x] != x)
			parent[x] = find(parent[x]);
		return parent[x];
	}
	
	/* !!!要会写!!! */
	public void union(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		if (rootP == rootQ)
			return;
		parent[rootQ] = rootP;
		count--;
	}
	
	public boolean connected(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		return rootP == rootQ;
	}
	
	public int count() {
		return count;
	}
}
