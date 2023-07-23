package leetcode.topinterviewquestions;

import java.util.ArrayList;
import java.util.List;

public class Solution_118 {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> curLevel = new ArrayList<>();
		
		curLevel.add(1);
		res.add(new ArrayList<>(curLevel));
		if (numRows == 1) return res;
		
		curLevel.add(1);
		res.add(new ArrayList<>(curLevel));
		if (numRows == 2) return res;
		
		for (int i = 2; i < numRows; i++) {
			curLevel.clear();
			List<Integer> preLevel = res.get(res.size() - 1);
			curLevel.add(1);
			for (int j = 0; j < preLevel.size() - 1; j++) {
				curLevel.add(preLevel.get(j) + preLevel.get(j + 1));
			}
			curLevel.add(1);
			res.add(new ArrayList<>(curLevel));
		}
		return res;
	}
	
	public static void main(String[] args) {
		int numRows = 3;
		System.out.println(new Solution_118().generate(numRows));
	}
}
