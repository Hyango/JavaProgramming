package leetcode.topinterviewquestions;

import java.util.*;

public class _Solution_210 {
	// 拓扑排序:dfs得到后序遍历的结果,对其进行倒序即为拓扑排序结果
	List<Integer> postorder = new ArrayList<>(); // 记录后序遍历结果
	boolean hasCycle = false; // 记录是否存在环
	boolean[] visited, onPath;
	
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<Integer>[] graph = buildGraph(numCourses, prerequisites);
		visited = new boolean[numCourses];
		onPath = new boolean[numCourses];
		
		for (int i = 0; i < numCourses; i++) { // 遍历图
			traverse(graph, i);
		}
		
		// -----------------↓相较环检测，新增的代码--------------------
		// 主要是增加了后序遍历（traverse函数的postorder.add(s);）,以及对后序遍历的翻转
		if (hasCycle) { // 有环图无法进行拓扑排序
			return new int[]{};
		}
		// 逆后序遍历结果即为拓扑排序结果
		Collections.reverse(postorder);
		int[] res = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			res[i] = postorder.get(i);
		}
		// -----------------↑相较环检测，新增的代码--------------------
		return res;
	}
	
	// 图遍历函数,dfs
	void traverse(List<Integer>[] graph, int s) {
		if (onPath[s]) { // 发现环
			hasCycle = true;
		}
		if (visited[s] || hasCycle) {
			return;
		}
		// 前序遍历位置
		onPath[s] = true;
		visited[s] = true;
		for (int t : graph[s]) {
			traverse(graph, t);
		}
		// 后序遍历位置
		postorder.add(s);
		onPath[s] = false;
	}
	
	public List<Integer>[] buildGraph(int num, int[][] edges) {
		// 图中共有 num 个节点
		List<Integer>[] graph = new LinkedList[num];
		for (int i = 0; i < num; i++) {
			graph[i] = new LinkedList<>();
		}
		for (int[] edge : edges) {
			int from = edge[1], to = edge[0];
			graph[from].add(to);
		}
		return graph;
	}
	
	
	/* BFS解法 */
	List<List<Integer>> edges; // 存储有向图
	int[] indeg; // 存储每个节点的入度
	int[] result; // 存储答案
	int index; // 答案下标
	public int[] findOrder1(int numCourses, int[][] prerequisites) {

		edges = new ArrayList<List<Integer>>();
		for (int i = 0; i < numCourses; ++i) {
			edges.add(new ArrayList<Integer>());
		}
		indeg = new int[numCourses];
		result = new int[numCourses];
		index = 0;
		for (int[] info : prerequisites) {
			edges.get(info[1]).add(info[0]);
			++indeg[info[0]];
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		// 将所有入度为 0 的节点放入队列中
		for (int i = 0; i < numCourses; ++i) {
			if (indeg[i] == 0) {
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			// 从队首取出一个节点
			int u = queue.poll();
			// 放入答案中
			result[index++] = u;
			for (int v: edges.get(u)) {
				--indeg[v];
				// 如果相邻节点 v 的入度为 0，就可以选 v 对应的课程了
				if (indeg[v] == 0) {
					queue.offer(v);
				}
			}
		}

		if (index != numCourses) {
			return new int[0];
		}
		return result;
	}
	
	
	public static void main(String[] args) {
	
	
	}
}
