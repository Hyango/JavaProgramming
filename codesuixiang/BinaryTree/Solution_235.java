package codesuixiang.BinaryTree;

public class Solution_235 {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //可以直接复用Solution_236的代码
        //此处根据二叉搜索树的特点来解
        //当min(p.val,q.val) < root.val < max(p.val,q.val)时,root即为公共祖先,即else部分
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }
    
    
    public static void main(String[] args) {
        String input = "[20,6,25,5,15,23,28,null,null,13,16]";
        TreeNode root = TreeNode.stringToTreeNode(input);
        TreeNode p = root.left.left;
        TreeNode q = root.left.right.right;
        System.out.println(new Solution_235().lowestCommonAncestor(root, p, q).val);
    }
}
