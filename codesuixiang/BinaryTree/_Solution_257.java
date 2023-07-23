package codesuixiang.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class _Solution_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        List<TreeNode> path = new ArrayList<>();
        backtracking(root, path, result);
        return result;
    }
    
    private void backtracking(TreeNode root, List<TreeNode> path, List<String> result) {
        path.add(root);
        if (root.left == null && root.right == null) {
            //path中的路径加入result
            StringBuilder sb=new StringBuilder();
            for (int i = 0; i < path.size()-1; i++) {
                sb.append(String.valueOf(path.get(i).val)).append("->");
            }
            sb.append(String.valueOf(path.get(path.size()-1).val));
            result.add(sb.toString());
            return;
        }
        if (root.left != null) {
            backtracking(root.left, path, result);
            path.remove(path.size()-1);
        }
        if (root.right != null) {
            backtracking(root.right, path, result);
            path.remove(path.size()-1);
        }
    }
    
    public static void main(String[] args) {
        String input = "[1,2,3,null,5]";
        TreeNode root = TreeNode.stringToTreeNode(input);
        System.out.println(new _Solution_257().binaryTreePaths(root));
    }
}
