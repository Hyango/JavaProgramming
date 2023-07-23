package acmexercise.huawei;

import java.util.*;

public class Main_102 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String input = in.nextLine();
            Map<Character, Integer> charCount = new HashMap<>();
            for (char c : input.toCharArray()) {
                if (Character.isLetterOrDigit(c)) {
                    charCount.put(c, charCount.getOrDefault(c, 0) + 1);
                }
            }
            List<Map.Entry<Character, Integer>> sortedEntries = new ArrayList<>(charCount.entrySet());
            Collections.sort(sortedEntries, (o1,  o2) -> {
                    int countComparison = o2.getValue().compareTo(o1.getValue());
                    if (countComparison != 0) {
                        return countComparison;
                    } else {
                        return o1.getKey().compareTo(o2.getKey());
                    }
                }
            );
            for (Map.Entry<Character, Integer> entry : sortedEntries) {
                System.out.print(entry.getKey());
            }
        }
    }
}
