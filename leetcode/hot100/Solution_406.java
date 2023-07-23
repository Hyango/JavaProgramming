package leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_406 {
    public int[][] reconstructQueue(int[][] people) {
        // 首先身高降序排序,相同则按k升序:[[7,0], [7,1], [6,1], [5,0], [5,2]，[4,4]]
        // 从第一个元素开始放入如queue,k为其对应的索引. 因为身高大于等于自身的已全部入队,故k即为自身入队的位置
        Arrays.sort(people, (a, b) -> { //按照身高降序排
            if (a[0] == b[0]) return a[1] - b[1]; //身高h一样,按照k升序排序
            return b[0] - a[0];
        });
        List<int[]> list = new ArrayList<>();
        for (int[] person : people) {
            list.add(person[1],person);
        }
        return list.toArray(new int[people.length][]); // List<int[]> -> int[][]
    }
    
    
    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] result = new Solution_406().reconstructQueue(people);
        for (int[] person : result) {
            System.out.println(Arrays.toString(person));
        }
    }
}
