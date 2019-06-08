import __HELPER_CLASSES__.ListNode;

public class RemoveNodeFromEnd_19 {
    public static ListNode remove(ListNode head, int n) {
        if (head.next == null && n == 1) {
            return null;
        }

        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 1; i <= n; i++) {
            p2 = p2.next;
        }

        if (p2 == null) {
            head = head.next;
        }
        else {
            while (p2.next != null) {
                p1 = p1.next;
                p2 = p2.next;
            }
            p1.next = p1.next.next;
        }

        return head;
    }

    public static void main(String[] args){
        ListNode l = ListNode.build(args[0]);
        int n = Integer.parseInt(args[1]);
        System.out.println("Removed the "+n+" node from end: "+remove(l, n));
    }
}
