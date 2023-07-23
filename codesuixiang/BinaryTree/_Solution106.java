package codesuixiang.BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class _Solution106 {
    /*
     * 从中序遍历或后序遍历构造二叉搜索树
     * LeetCode-105: 从前序遍历或中序遍历构造二叉搜索树
     * 以上两种方式可以唯一确定一棵二叉树
     * 从前序和后序遍历构造二叉搜索树,无法唯一确定一棵
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        /*
         * 原理: 后序遍历的最后一个元素是root结点, 该元素在中序遍历中将数组分成两部分,分别代表了左右子树
         * */
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = findNode(map,
                inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
        return root;
    }
    
    private TreeNode findNode(Map<Integer, Integer> map,
                              int[] inorder, int inBegin, int inEnd,
                              int[] postorder, int postBegin, int postEnd) {
        //1. 递归结束条件: 数组中的元素都已加入tree中了
        if (inBegin > inEnd || postBegin > postEnd) return null;
        //2. 单层递归逻辑 (中序:左子树 root 右子树) (后序:左子树 右子树 root)
        //  2.1. root节点
        TreeNode root = new TreeNode(postorder[postEnd]);
        
        int rootIndex = map.get(postorder[postEnd]); //root结点在中序数组中的下标
        //  2.2. 左子树
        int leftLength = rootIndex - inBegin; // 左子树长度
        root.left = findNode(map,
                inorder, inBegin, rootIndex - 1,
                postorder, postBegin, postBegin + leftLength - 1);
        
        //  2.3. 右子树
        int rightLength = inEnd - rootIndex;//右子树长度
        root.right = findNode(map,
                inorder, rootIndex + 1, inEnd,
                postorder, postEnd - rightLength, postEnd-1);
        return root;
    }
    
    
    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7}, postorder = {9, 15, 7, 20, 3};
        TreeNode root = new _Solution106().buildTree(inorder, postorder);
        System.out.println(Solution_102.levelOrder(root));
    
    }
}
