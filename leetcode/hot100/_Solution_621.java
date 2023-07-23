package leetcode.hot100;

import java.util.Arrays;

public class _Solution_621 {
	// 1、将任务按类型分组，正好A-Z用一个int[26]保存任务类型个数
	// 2、对数组进行排序，优先排列个数（count）最大的任务，
	//      如题得到的时间至少为 retCount =（count-1）* (n+1) + 1 ==> A->X->X->A->X->X->A(X为其他任务或者待命)
	// 3、再排序下一个任务，如果下一个任务B个数和最大任务数一致，
	//      则retCount++ ==> A->B->X->A->B->X->A->B
	// 4、如果空位都插满之后还有任务，那就随便在这些间隔里面插入就可以，因为间隔长度肯定会大于n，在这种情况下就是任务的总数是最小所需时间
	
	// 例: AAAABBBBCCCDDEEE n=3.
	// 解释:将出现次数最多(即A)的优先排列,得到①, 此时的retCount =（count-1）* (n+1) + 1;
	// 如果有次数相同(即B)的, 邻接着前一个进行占位,得到②, 此时retCount+1;
	// 次数更小的任务进行占位, 得到③、④, retCount无需改变
	// 如果空位都插满之后还有任务(即E的最后两个任务)，那就随便在这些间隔里面插入就可以.得到⑤. 此时retCount=tasks.length
	// 		   ①		   ②		   ③		   ④		   	⑤
	// 		A X X X  ->	A B X X	 ->	A B C X  -> A B C D  ->	A B C D E
	// 		A X X X		A B X X		A B C X		A B C D		A B C D E
	// 		A X X X		A B X X		A B C X		A B C X		A B C E
	// 		A			A B			A B			A B			A B
	public int leastInterval(char[] tasks, int n) {
		if (tasks.length <= 1 || n < 1) return tasks.length;
		// 步骤1
		int[] counts = new int[26];
		for (int i = 0; i < tasks.length; i++) {
			counts[tasks[i] - 'A']++;
		}
		// 步骤2
		Arrays.sort(counts);
		int maxCount = counts[25];
		int retCount = (maxCount - 1) * (n + 1) + 1;
		int i = 24;
		// 步骤3
		while (i >= 0 && counts[i] == maxCount) {
			retCount++;
			i--;
		}
		// 步骤4
		return Math.max(retCount, tasks.length);
	}
	
	public static void main(String[] args) {
		char[] task={'A','A','A','A','A','A','B','C','D','E','F','G'};
		int n=2;
		System.out.println(new _Solution_621().leastInterval(task, n));
	}
}
