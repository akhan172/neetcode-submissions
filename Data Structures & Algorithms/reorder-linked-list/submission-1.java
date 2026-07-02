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
    public void reorderList(ListNode head) {
        ListNode mid = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            mid = mid.next;
            fast = fast.next.next;
        }

        ListNode prev = null, curr = mid.next;
        mid.next=null;

        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        //Merge
        ListNode l1= head, l2= prev;
        while(l2!=null){
            ListNode n1 = l1.next;
            ListNode n2 = l2.next;

            l1.next = l2;
            l2.next = n1;

            l1=n1;
            l2=n2;
        }
    }
}
