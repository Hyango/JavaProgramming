package acmexercise.saike;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong(); // 输入数字 n
		
		long sum = calculateSum(n); // 计算切法结果的和
		
		System.out.println(sum); // 输出结果
	}
	
	private static long calculateSum(long n) {
		List<Long> segments = getSegments(n); // 获取所有切割片段
		long sum = 0; // 切法结果的和
		
		for (long segment : segments) {
			sum += segment;
		}
		
		return sum;
	}
	
	private static List<Long> getSegments(long n) {
		List<Long> segments = new ArrayList<>();
		segments.add(n); // 将整个数字作为一个切割片段
		
		String numStr = String.valueOf(n);
		int length = numStr.length();
		
		for (int i = 1; i < length; i++) {
			for (int j = 0; j < length - i; j++) {
				String segmentStr = numStr.substring(j, j + i);
				long segment = Long.parseLong(segmentStr);
				segments.add(segment);
			}
		}
		
		return segments;
	}
}
// public class Main_3 {
// 	public static void main(String[] args) {
// 		Scanner scanner = new Scanner(System.in);
// 		long n = scanner.nextLong(); // 输入数字 n
// 		long sum = calculateSum(n); // 计算切法结果的和
//
// 		System.out.println(sum); // 输出结果
// 	}
//
// 	private static long calculateSum(long n) {
// 		String numStr = String.valueOf(n); // 将数字转换为字符串
// 		int length = numStr.length(); // 数字的位数
//
// 		long sum = 0; // 切法结果的和
//
// 		// 枚举每个切割点的位置
// 		for (int i = 1; i < length; i++) {
// 			String leftStr = numStr.substring(0, i); // 左侧部分字符串
// 			String rightStr = numStr.substring(i); // 右侧部分字符串
//
// 			long leftNum = Long.parseLong(leftStr); // 左侧部分的数字
// 			long rightNum = Long.parseLong(rightStr); // 右侧部分的数字
//
// 			sum += leftNum + rightNum; // 累加切法结果的和
//
// 			// 递归计算右侧部分的切法结果的和，并累加到总和中
// 			sum += calculateSum(leftNum) + calculateSum(rightNum);
// 		}
//
// 		return sum;
// 	}
// }


