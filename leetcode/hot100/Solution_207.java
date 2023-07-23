package leetcode.hot100;

import java.util.LinkedList;
import java.util.List;

public class Solution_207 {
	// 记录一次 traverse 递归经过的节点
	boolean[] onPath;
	// 记录遍历过的节点，防止走回头路
	boolean[] visited;
	// 记录图中是否有环
	boolean hasCycle = false;
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<Integer>[] graph = buildGraph(numCourses, prerequisites);
		onPath=new boolean[numCourses];
		visited=new boolean[numCourses];
		
		for (int i = 0; i < numCourses; i++) {
			traverse(graph, i);
		}
		
		return !hasCycle;
	}
	
	void traverse(List<Integer>[] graph, int s) {
		if (onPath[s]) hasCycle = true; // 出现环
		
		if (hasCycle) return; // 找到环了
		if (visited[s]) return; // 节点访问过了
		
		visited[s] = true;
		onPath[s] = true;
		for (Integer i : graph[s]) {
			traverse(graph, i);
		}
		onPath[s] = false;
	}
	
	private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
		List<Integer>[] graph = new LinkedList[numCourses];
		for (int i = 0; i < numCourses; i++) {
			graph[i] = new LinkedList<>();
		}
		for (int[] prerequisite : prerequisites) {
			int from = prerequisite[1];
			int to = prerequisite[0];
			graph[from].add(to);
		}
		return graph;
	}
	
	public static void main(String[] args) {
		int numCourses=2;
		int[][] prerequisites={{1,0}};
		System.out.println(new Solution_207().canFinish(numCourses, prerequisites));
		
	}
}
