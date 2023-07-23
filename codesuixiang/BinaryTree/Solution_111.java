package codesuixiang.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_111 {
    public static int minDepth(TreeNode root) {
        //注意:最小深度是从 根节点 到最近 叶子节点 的最短路径上的节点数量. 叶子结点:度为0,即没有子节点的节点
        //不能将最大深度(Solution_104)递归法的代码搬.
        //举例:根节点 无左子树但有右子树 时,其最小深度为到最近的叶子节点的深度.
        // ↑ 参考代码随想录对应章节
        
        // ↓ 使用迭代法实现
        int depth=0;
        if(root==null) return depth;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //层序遍历
        while (!queue.isEmpty()){
            //记录第n层节点数
            int count=queue.size();
            depth++;
            while(count>0){
                TreeNode node = queue.poll();
                //找到第一个叶子结点
                if(node.left==null&&node.right==null) return depth;
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                count--;
            }
        }
        return depth;
    }
    
    public static void main(String[] args) {
        String input = "[3,9,20,null,null,15,7,8]";
        TreeNode root = TreeNode.stringToTreeNode(input);
        System.out.println(minDepth(root));
    }
}
