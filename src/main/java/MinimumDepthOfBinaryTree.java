/*
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
Note: A leaf is a node with no children.
Example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
*/


import sun.reflect.generics.tree.Tree;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class MinimumDepthOfBinaryTree {
    public Set<Integer> resultDepthSet;

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public int minDepth(TreeNode root) {
        resultDepthSet = new HashSet<>();
        int depthCnt = 0;
        searchFromRoot(root, depthCnt);

        depthCnt = Collections.min(resultDepthSet);

        return depthCnt;
    }

    private void searchFromRoot(TreeNode root,  int depthCnt){
        depthCnt++;
        if(root == null){
            resultDepthSet.add(0);
            return;
        }
        if(root.left == null && root.right == null) {
            resultDepthSet.add(depthCnt);
            return;
        }

        if(root.left != null)
            searchFromRoot(root.left, depthCnt);
        if(root.right != null)
            searchFromRoot(root.right, depthCnt);
    }

    static TreeNode initTestTree(){
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        return root;
    }

    public static void main(String ... args){
        MinimumDepthOfBinaryTree minimumDepthOfBinaryTree = new MinimumDepthOfBinaryTree();
        TreeNode root = initTestTree();
        minimumDepthOfBinaryTree.minDepth(root);
    }
}
























