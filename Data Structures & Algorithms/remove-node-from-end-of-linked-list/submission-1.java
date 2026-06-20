/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    private ListNode getRev(ListNode head){
        ListNode prev = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev=head;
            head=next;
        }
        return prev;

    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null || head.next == null)
        return null;

    head = getRev(head);

    if (n == 1) {
        return getRev(head.next);
    }

    ListNode curr = head;
    for (int i = 1; i < n - 1; i++) {
        curr = curr.next;
    }

    curr.next = curr.next.next;

    return getRev(head);
}
}
