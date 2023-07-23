package acmexercise.huawei;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _Main_41 {
	public static void main(String[] args) throws Exception {
		// 思路: 所有砝码放进一个list中. set集合存放所有可能得结果, 每次从list中取出一个,记录和set中的结果组合所能产生的新结果,放入set.
		Scanner in = new Scanner(System.in);
		// 注意 hasNext 和 hasNextLine 的区别
		while (in.hasNext()) { // 注意 while 处理多个 case
			int n = in.nextInt();// 砝码的种类数
			int[] weights = new int[n];// 每一种砝码的重量
			int[] numbers = new int[n];// 每一种砝码对应的数量
			in.nextLine();
			String[] s1 = in.nextLine().split(" ");
			String[] s2 = in.nextLine().split(" ");
			for (int i = 0; i < n; i++) {
				weights[i] = Integer.parseInt(s1[i]);
				numbers[i] = Integer.parseInt(s2[i]);
			}
			ArrayList<Integer> list = new ArrayList<>();// 保存所有的砝码
			Set<Integer> set = new HashSet<>();
			int k = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < numbers[i]; j++) {
					// arr[k++] = weights[i];
					list.add(weights[i]);
				}
			}
			// 现在得到了数组1 1 2，接下来我们遍历数组就可以得到最终想要的答案了
			for (int i = 0; i < list.size(); i++) { // 遍历砝码
				ArrayList<Integer> list1 = new ArrayList<>(set);
				if (!set.contains(list.get(i))) set.add(list.get(i));
				for (int j = 0; j < list1.size(); j++) { // 遍历list1集合
					int tmp = list.get(i) + list1.get(j);
					if (!set.contains(tmp)) {
						set.add(tmp);
					}
				}
			}
			System.out.println(set.size() + 1); // 加1是因为要把0的重量加上。
		}
	}
}
