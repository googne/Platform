package com.striver.DSAExperience.Day5LinkedList;/*
 * @lc app=leetcode id=237 lang=java
 *
 * [237] Delete Node in a Linked List
 */

// @lc code=start

import com.common.Printer;
import com.striver.DSAExperience.Day5LinkedList.LinkedList;
import com.striver.DSAExperience.Day5LinkedList.ListNode;
import com.striver.DSAExperience.Day5LinkedList.RemoveNthNodeFromEndOfList_medium_19;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class DeleteNodeInALinkedList_easy_237 {
    static class Solution {
        // [Optimal] O(n), SC: O(1) - Replacement teh value of node and delete next node
        public static void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }

    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList(new int[]{1, 2, 3});
        ListNode toBeDeleted = new ListNode(3);
        list.addLast(toBeDeleted);
        list.appendElement(new int[]{5, 6, 7});
        Solution.deleteNode(toBeDeleted);
        Printer.print(list.head);

    }
}
// @lc code=end

