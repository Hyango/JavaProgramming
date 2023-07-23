package codesuixiang.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    
    public TreeNode() {
    }
    
    public TreeNode(int val) {
        this.val = val;
    }
    
    
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    
    /**
     *
     * 传入此格式的字符串: "[3,9,20,null,null,15,7]"
     *
     */
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }
        
        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        
        int index = 1; //保存建到第几个节点了
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
            
            //建左节点
            if (index == parts.length) { //树已建完
                break;
            }
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }
            
            //建右节点
            if (index == parts.length) { //树已建完
                break;
            }
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
}
