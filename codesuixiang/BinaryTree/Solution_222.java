package codesuixiang.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_222 {
    public int countNodes(TreeNode root) {
        if(root==null)  return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int count=0;
    
        while (!queue.isEmpty()){
            int size = queue.size();
            count+=size;
            while (size != 0) {
                TreeNode node = queue.poll();
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                size--;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        String input = "[3,9,20,null,null,15,7]";
        TreeNode root = TreeNode.stringToTreeNode(input);
        System.out.println(new Solution_222().countNodes(root));
    }
}
