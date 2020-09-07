package com.hjp.javaSource.nowcoder;

/**
 * @ClassName: ReverseList
 * @Description:输入一个链表，反转链表后，输出新链表的表头。
 * https://www.nowcoder.com/profile/1097990/codeBookDetail?submissionId=88374079
 * @Author: huangjp
 * @Date: 2020/9/7 15:47
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next = new ListNode(2);
        ListNode next2 = new ListNode(3);
        next.next = next2;
        head.next = next;
        Solution solution = new Solution();
        ListNode newHead = solution.reverseList(head);
        while (newHead != null){
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {

        if (head == null){
            return null;
        }

        ListNode newHead = new ListNode(head.val);
        ListNode newNext;

        ListNode next;
        while ((next = head.next) != null){
            newNext = newHead;
            newHead = new ListNode(next.val);
            newHead.next = newNext;
            head = next;
        }

        return newHead;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}