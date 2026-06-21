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
    private ListNode merge(ListNode l1, ListNode l2){
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode nh = new ListNode(-1, null);
        ListNode temp=nh;
        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                nh.next=l1;
                l1=l1.next;
                nh=nh.next;

            }else{
                nh.next=l2;
                l2=l2.next;
                nh=nh.next;
            }
        }
        if(l1 != null){
            nh.next=l1;
        }else{
            nh.next=l2;
        }
        return temp.next;
    }
    private ListNode part(int s, int e, ListNode[] lists){
        if(s==e)return lists[s];

        int mid = s+(e-s)/2;
        
        ListNode l1=part(s, mid, lists);
        ListNode l2=part(mid+1, e, lists);

        return merge(l1, l2);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        return part(0, lists.length-1, lists);
    }
}
