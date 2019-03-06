/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        Set<TreeNode> visited = new HashSet<>();
        List<String> results = new ArrayList<>();
        if(root == null){
            return results;
        }
        DFS(root, visited, results, "");
        return results;
    }
    
    private void DFS(TreeNode u, Set<TreeNode> visited, List<String> results,
                    String localPath){
        visited.add(u);
        
        if(u.left == null && u.right == null){
            results.add(localPath+u.val);
            return;
        }
        
        if(u.left != null){
            DFS(u.left, visited, results, localPath+u.val+"->");
        }
        
        if(u.right != null){
            DFS(u.right, visited, results, localPath+u.val+"->");
        }
        
        visited.remove(u);
    }

}