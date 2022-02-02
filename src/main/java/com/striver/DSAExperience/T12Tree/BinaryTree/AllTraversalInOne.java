package com.striver.DSAExperience.T12Tree.BinaryTree;

import com.common.Out;
import com.striver.DSAExperience.T12Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Pair {
    TreeNode node;
    int num;

    Pair(TreeNode _node, int _num) {
        num = _num;
        node = _node;
    }
}

public class AllTraversalInOne {
    static class Solution {
        // [Optimal Iterative] TC: O(n) - all traversal in single stack
        // we can use pattern that extreme left then right and then root is going for all traversal with
        // PreOrder, InOrder, PostOrder
        // SC: O(4n) - 3n is for result for all type of traversal and n for stack
        public void traverse(TreeNode root) {
            Stack<Pair> st = new Stack<Pair>();
            st.push(new Pair(root, 1));

            List<Integer> pre = new ArrayList<>();
            List<Integer> in = new ArrayList<>();
            List<Integer> post = new ArrayList<>();

            while (!st.isEmpty()) {
                Pair it = st.pop();
                if (it.num == 1) { //PRE ORDER
                    pre.add(it.node.val);
                    it.num++;
                    st.push(it);
                    if (it.node.left != null)
                        st.push(new Pair(it.node.left, 1));
                } else if (it.num == 2) { //IN ORDER
                    in.add(it.node.val);
                    it.num++;
                    st.push(it);
                    if (it.node.right != null)
                        st.push(new Pair(it.node.right, 1));
                } else
                    post.add(it.node.val);
            }

            Out.print("PreOrder", pre);
            Out.print("InOrder", in);
            Out.print("PostOrder", post);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        sol.traverse(root);
    }
}