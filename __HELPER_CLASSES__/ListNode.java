package __HELPER_CLASSES__;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) { val = x; }

    public String toString() {
        String s = "";
        ListNode temp = this;
        while (true) {
            s += temp.val;
            if (temp.next == null) {
                break;
            }
            s += " -> ";
            temp = temp.next;
        }

        return s;
    }

    /**
     *
     * @param s Integer String
     * @return ListNode built from s
     */
    public static ListNode build(String s) {
        if (s.equals("")) {
            return null;
        }
        else {
            ListNode l = new ListNode(Integer.parseInt(Character.toString(s.charAt(0))));
            l.next = build(s.substring(1));
            return l;
        }
    }

    /**
     *
     * @param l1 ListNode l1
     * @param l2 ListNode l2
     * @return true if l1 is longer than l2 else false
     */
    public static boolean isLonger(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;
        while(true) {
            if (t1 == null) {
                return false;
            }
            else if (t2 == null){
                return true;
            }
            else {
                t1 = t1.next;
                t2 = t2.next;
            }
        }
    }
}
