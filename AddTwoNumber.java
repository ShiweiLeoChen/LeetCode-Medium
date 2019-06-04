import __HELPER_CLASSES__.ListNode;

public class AddTwoNumber {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode res = ListNode.isLonger(l1, l2) ? l1: l2;
        ListNode res_ptr = res;
        ListNode res_ptr_previous = null;

        int carry = 0;
        while (t1 != null || t2 != null) {
            int v;
            if (t1 == null) {
                v = carry + t2.val;
                t2 = t2.next;
            }
            else if (t2 == null) {
                v = carry + t1.val;
                t1 = t1.next;
            }
            else {
                v = carry + t1.val + t2.val;
                t1 = t1.next;
                t2 = t2.next;
            }

            res_ptr.val = v % 10;
            res_ptr_previous = res_ptr;
            res_ptr = res_ptr.next;
            carry = v / 10;
        }

        if (carry > 0) {
            res_ptr_previous.next = new ListNode(carry);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(addTwoNumbers(ListNode.build(args[0]), ListNode.build(args[1])));
    }
}
