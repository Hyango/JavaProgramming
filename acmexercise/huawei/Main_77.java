package acmexercise.huawei;

import java.util.*;

public class Main_77 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// 注意 hasNext 和 hasNextLine 的区别
		while (in.hasNext()) { // 注意 while 处理多个 case
			int n = in.nextInt();
			List<String> res = new ArrayList<>(); // 存放结果
			int[] trains = new int[n];
			Stack<Integer> station = new Stack<>();
			for (int i = 0; i < n; i++) { // 火车
				trains[i] = in.nextInt();
			}
			trainInOut(trains, station, "", res, 0, 0);
			Collections.sort(res);
			for (int i = 0; i < res.size(); i++) {
				System.out.println(res.get(i));
			}
			
		}
	}
	
	private static void trainInOut(int[] trains, Stack<Integer> station, String path, List<String> res, int in, int out) {
		// 全部出栈,记录结果并返回
		if (out == trains.length) {
			res.add(path);
			return;
		}
		// 出栈: 条件为 栈不为空
		if (!station.isEmpty()) {
			int train = station.pop();
			trainInOut(trains, station, path + train + " ", res, in, out + 1);
			station.push(train);
		}
		// 进栈: 条件为 有火车没进栈
		if (in < trains.length) {
			station.push(trains[in]); // 进栈
			trainInOut(trains, station, path, res, in + 1, out);
			station.pop();
		}
	}
}
