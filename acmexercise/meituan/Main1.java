package acmexercise.meituan;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int time = in.nextInt();
        for (int tt = 0; tt < time; tt++) {
            int len = in.nextInt();
            ArrayList<Integer> vIn = new ArrayList<Integer>();
            ArrayList<Integer> vOut = new ArrayList<Integer>();
            for (int oo = 0; oo < len; oo++) {
                vIn.add(in.nextInt());
            }
            for (int oo = 0; oo < len; oo++) {
                vOut.add(in.nextInt());
            }
            
            int left = 0;
            int right = 0;
            Stack<Integer> myStack = new Stack<Integer>();
            while (right < len && left < len) {
                if (vIn.get(left).equals(vOut.get(right))) {
                    left++;
                    right++;
                } else if (!myStack.empty() && myStack.peek().equals(vOut.get(right))) {
                    right++;
                    myStack.pop();
                } else {
                    myStack.push(vIn.get(left));
                    left++;
                }
            }
            while (!myStack.empty() && right < len) {
                if (myStack.peek().equals(vOut.get(right))) {
                    right++;
                    myStack.pop();
                } else {
                    break;
                }
            }
            if (myStack.empty()) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        in.close();
    }
}
