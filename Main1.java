import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String source = in.nextLine();
			String target = in.nextLine();
			char[] sources = source.toCharArray();
			char[] targets = target.toCharArray();
			
			int count = 0;
			
			Map<Character, Integer> map = new HashMap<>();
			for (int i = 0; i < sources.length; i++) {
				map.put(sources[i], i);
			}
			
			int pre = 0;
			for (int i = 0; i < targets.length; i++) {
				if (!map.containsKey(targets[i])) {
					count = -1;
					break;
				}
				if (map.get(targets[i]) < pre) {
					count++;
				}
				pre = map.get(targets[i]);
			}
			System.out.println(count == -1 ? -1 : ++count);
		}
	}
}