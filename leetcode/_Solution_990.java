package leetcode;

public class _Solution_990 {
	public boolean equationsPossible(String[] equations) {
		// 将恒等式加入并查集
		
		UF uf = new UF(26);
		for (String equation : equations) {
			if (equation.charAt(1) == '=') {
				uf.union((equation.charAt(0) - 'a'), (equation.charAt(3) - 'a'));
			}
		}
		
		for (String equation : equations) {
			if (equation.charAt(1) == '!')
				if (uf.connected((equation.charAt(0) - 'a'), (equation.charAt(3) - 'a')))
					return false;
			
		}
		return true;
	}
	
	/* 并查集 */
	class UF {
		private int count;
		private int[] parent;
		
		public UF(int n) {
			count = n;
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
			}
		}
		
		public int find(int x) {
			if (parent[x] != x)
				parent[x] = find(parent[x]);
			return parent[x];
		}
		
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
	
	public static void main(String[] args) {
		String[] equations = new String[]{"a==b", "b==c", "c==a"};
		System.out.println(new _Solution_990().equationsPossible(equations));
	}
}
