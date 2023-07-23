package acmexercise.meituan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class XIaoMeiChocolate {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int t = 1;
        // int t = scanner.nextInt();
        
        while (t-- > 0) {
            int n = scanner.nextInt(), m = scanner.nextInt();
            
            List<Integer> a = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                a.add(scanner.nextInt());
            }
            
            List<Long> q = new ArrayList<>();
            for (int i = 0; i < m; ++i) {
                q.add(scanner.nextLong());
            }
            
            List<Integer> id = new ArrayList<>();
            for (int i = 0; i < m; ++i) {
                id.add(i);
            }
            
            Collections.sort(a);
            id.sort((x, y) -> q.get(x).compareTo(q.get(y)));
            
            int p = 0;
            long cur = 0;
            List<Integer> ans = new ArrayList<>(m);
            
            for (int i = 0; i < m; ++i) {
                long tot = q.get(id.get(i));
                while (p < n && cur + a.get(p) * a.get(p) <= tot) {
                    cur += a.get(p) * a.get(p);
                    p += 1;
                }
                ans.add(p);
            }
            
            for (int i = 0; i < m; ++i) {
                System.out.print(ans.get(i));
                System.out.print(i == m - 1 ? "\n" : " ");
            }
        }
    }

}
