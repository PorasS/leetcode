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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    int length_l1 = 0;
    int length_l2 = 0;

    ListNode l1Node = l1;
    while (l1Node != null) {
      length_l1++;
      l1Node = l1Node.next;
    }

    ListNode l2Node = l2;
    while (l2Node != null) {
      length_l2++;
      l2Node = l2Node.next;
    }

    if (length_l1 > length_l2) {
      return listSum(l1, l2);
    } else {
      return listSum(l2, l1);
    }

  }

  public ListNode listSum(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode curr = l1;
    while (curr != null) {
      int l1Val = curr.val;
      int l2val = l2 == null ? 0 : l2.val;
      int sum = (l1Val + l2val + carry) % 10;
      carry = (l1Val + l2val + carry) / 10;
      curr.val = sum;

      if (curr.next == null && carry > 0) {
        ListNode node = new ListNode(carry);
        curr.next = node;
        break;
      }

      curr = curr.next;
      if (l2 != null) {
        l2 = l2.next;
      }

    }

    return l1;
  }
}
