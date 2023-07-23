package classicalalgorithm;

import java.util.Random;

public class SortArray {
	public static void main(String[] args) {
		int[] nums = {5, 1, 1, 2, 0, 0};
		// new MergeSort().sortArray(nums);
		// System.out.println(Arrays.toString(nums));
	}
}

class QuickSort {
	/* 	快速排序(重点)
	 *	1.从数列中挑出一个元素，一般都是左边的第一个数字，称为基准数；
	 *  2.创建两个指针，一个从前往后走，一个从后往前走；
	 *  3.先执行后面的指针，找出第一个比基准数小的数字；
	 *  4.在执行后面的指针，找出第一个比基准数大的数字；
	 *  5.交换两个指针指向的数字；
	 *  6.直到两个指针相遇；
	 *  7.将基准数跟指针指向的位置的数字交换位置，称之为：基准数归位；
	 *  8.第一轮结束后，基准数左边的数字都是比基准数小的，基准数右边的数字都是比基准数大的；
	 *  9.把基准数左边的看作是一个序列，把基准数右边的看作一个序列，按照刚刚的规则进行递归排序
	 */
	private final static Random random = new Random(System.currentTimeMillis());
	
	public int[] sortArray(int[] nums) {
		quickSort(nums, 0, nums.length - 1);
		return nums;
	}
	
	// 两次优化:
	// 1.在partition中,使用随机化选取分割元素. 作用:当传入数组高度有序时可以有效降低递归树高度
	// 2.在quickSort中,排除掉与分割点pivot元素值相同的元素
	private void quickSort(int[] nums, int left, int right) {
		// 递归出口
		if (left >= right) return;
		
		int pivot = partition(nums, left, right); // 得到支点(分割点)坐标, 在求数组第K大的元素时可以用上
		int leftPivot = pivot - 1;
		int rightPivot = pivot + 1;
		// 用于存在大量重复元素时的优化, 排除掉重复元素.  如果不需要可以不加此判断
		while (left < leftPivot && nums[leftPivot] == nums[pivot])
			leftPivot--;
		while (rightPivot < right && nums[rightPivot] == nums[pivot])
			rightPivot++;
		
		quickSort(nums, left, leftPivot);
		quickSort(nums, rightPivot, right);
	}
	
	/**
	 * @return 对 nums[left, right] 进行分割, 同时返回分割点坐标.
	 * 分割时满足:分割点左边元素 <= 分割点 <= 分割点右边元素
	 */
	private int partition(int[] nums, int left, int right) {
		// 随机化选取分割元素.当传入数组高度有序时可以有效降低递归树高度
		int randomIndex = left + random.nextInt(right - left + 1);
		swap(nums, left, randomIndex);
		
		int startIndex = left;
		int endIndex = right;
		int baseNumber = nums[left];
		// 两指针相遇说明左右两边的数据已经按基准数的大小排列好，跳出循环
		while (startIndex != endIndex) {
			// 利用endIndex,从后向前找 比基准数小 的数据
			while (nums[endIndex] >= baseNumber && endIndex > startIndex) {
				endIndex--;
			}
			// 利用startIndex,从前向后找 比基准数大 的数据
			while (nums[startIndex] <= baseNumber && startIndex < endIndex) {
				startIndex++;
			}
			swap(nums, startIndex, endIndex);
		}
		swap(nums, left, startIndex);
		return startIndex;
	}
	
	private void swap(int[] nums, int index1, int index2) {
		int temp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = temp;
	}
}

class MergeSort {
	/* 归并排序(重点) */
	int[] tmp;
	
	public int[] sortArray(int[] nums) {
		tmp = new int[nums.length];
		mergeSort(nums, 0, nums.length - 1);
		return nums;
	}
	
	public void mergeSort(int[] nums, int l, int r) {
		if (l >= r) {
			return;
		}
		int mid = l + (r - l) / 2;
		// int mid = l + ((r - l) >> 1); // !!!注意: 若使用移位操作,需要加上括号.  即'+'运算符优先级大于'>>'
		// 中序位置:将左右两部分进行归并排序,即分治处理
		mergeSort(nums, l, mid);
		mergeSort(nums, mid + 1, r);
		
		// 后序位置: 将 已经完成归并排序的左右两部分 归并排序为一个部分
		int i = l, j = mid + 1;
		int cnt = 0;
		while (i <= mid && j <= r) {
			if (nums[i] <= nums[j])
				tmp[cnt++] = nums[i++];
			else
				tmp[cnt++] = nums[j++];
		}
		// 根据上一个while的条件可知,循环结束时其中一个条件被打破,故下两个循环只会执行其中一个
		while (i <= mid) {
			tmp[cnt++] = nums[i++];
		}
		while (j <= r) {
			tmp[cnt++] = nums[j++];
		}
		System.arraycopy(tmp, 0, nums, l, r - l + 1);
		// for (int k = 0; k < r - l + 1; ++k) nums[l + k] = tmp[k]; //同上
	}
}

class HeapSort {
	public int[] sortArray(int[] nums) {
		int len = nums.length;
		// 将数组整理成堆
		heapify(nums);
		// 循环不变量：区间 [0, i] 堆有序
		for (int i = len - 1; i >= 1; ) {
			// 把堆顶元素（当前最大）交换到数组末尾
			swap(nums, 0, i);
			// 逐步减少堆有序的部分
			i--;
			// 下标 0 位置下沉操作，使得区间 [0, i] 堆有序
			siftDown(nums, 0, i);
		}
		return nums;
	}
	
	private void heapify(int[] nums) {
		int len = nums.length;
		// 只需要从 i = (len - 1) / 2 这个位置开始逐层下移
		for (int i = (len - 1) / 2; i >= 0; i--) {
			siftDown(nums, i, len - 1);
		}
	}
	
	private void siftDown(int[] nums, int k, int end) {
		while (2 * k + 1 <= end) {
			int j = 2 * k + 1;
			if (j + 1 <= end && nums[j + 1] > nums[j]) {
				j++;
			}
			if (nums[j] > nums[k]) {
				swap(nums, j, k);
			} else {
				break;
			}
			k = j;
		}
	}
	
	private void swap(int[] nums, int index1, int index2) {
		int temp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = temp;
	}
}

class InsertSort {
	// 插入排序：每次将当前元素插入到前面已经排好序的元素中.
	// 对于高度有序的数组,算法性能最优
	
	public int[] sortArray(int[] nums) {
		int len = nums.length;
		for (int i = 1; i < len; i++) {
			int temp = nums[i];
			int j = i;
			while (j > 0 && nums[j - 1] > temp) { // 注意边界 j > 0
				nums[j] = nums[j - 1];
				j--;
			}
			nums[j] = temp;
		}
		return nums;
	}
}

class SelectSort {
	// 选择排序：每一轮选择最小元素交换到未排队部分的开头
	public int[] sortArray(int[] nums) {
		int len = nums.length;
		for (int i = 0; i < len - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < len; j++) {
				if (nums[j] < nums[minIndex]) {
					minIndex = j;
				}
			}
			swap(nums, i, minIndex);
		}
		return nums;
	}
	
	private void swap(int[] nums, int index1, int index2) {
		int temp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = temp;
	}
}

