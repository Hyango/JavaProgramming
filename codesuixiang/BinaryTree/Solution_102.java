package codesuixiang.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_102 {
    //层序遍历
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result; // 如果缺少此处的判断,会导致list.add(node.val)报错.
        Queue<TreeNode> queue = new LinkedList<>();
        //首先加入第一层节点.
        queue.add(root);
        while (!queue.isEmpty()) {
            //记录第n层节点数,弹出后记录在list中
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while (count > 0) {
                //每弹出一个就记录他的左右子节点.
                TreeNode node = queue.poll();
                list.add(node.val);
                count--;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(list);
        }
        return result;
    }
    
    public static void main(String[] args) {
        String input = "[9,6,-3,null,null,-6,2,null,null,2,null,-6,-6,-6]";//"[4,1,null,2,null,3]";
        TreeNode root = TreeNode.stringToTreeNode(input);
        System.out.println(levelOrder(root));
    }
}
