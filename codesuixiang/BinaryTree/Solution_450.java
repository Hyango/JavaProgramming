package codesuixiang.BinaryTree;

public class Solution_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        //分情况讨论
        // 1. root为空,直接返回
        if (root == null) return null;
        
        if (root.val == key) {// 2. root.val==key,需要删除root
            // 2.1. root的左子树为空, 返回右子树
            if (root.left == null)
                return root.right;
                // 2.2. root的右子树为空,返回左子树
            else if (root.right == null)
                return root.left;
                // 2.3. root的左右子树均不为空, 将root.left移至右子树的左下角./或者将root.right移至左子树的右下角
            else {
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                return root.right;
            }
        }
        // 3. root.val>key, key位于左子树
        if (root.val > key) root.left = deleteNode(root.left, key);
        // 4. root.val<key, key位于右子树
        if (root.val < key) root.right = deleteNode(root.right, key);
        return root;
    }
    
    
    public static void main(String[] args) {
        String input = "[5,3,6,2,4,null,7]";
        int key = 3;
        TreeNode root = TreeNode.stringToTreeNode(input);
        TreeNode newRoot = new Solution_450().deleteNode(root, key);
        System.out.println(Solution_102.levelOrder(newRoot));
    }
    
}
