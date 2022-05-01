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
    public int getDecimalValue(ListNode head) {
        if (head == null){
            return 0;
        }
        int c= 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            c++;
        }
        int sum = 0;
        temp = head;
        while(temp != null){
            sum = sum + (int)Math.pow(2,c-1)*temp.val;
            c--;
            temp = temp.next;
        }
        return sum;
    }
}