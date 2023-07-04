//https://leetcode.com/problems/swap-nodes-in-pairs/description/

public class SwapPair {
    
    public static ListNode swapPairs(ListNode head) {
        int size = size(head);

        if (size <= 1)
            return head;

        ListNode temp = head;
        ListNode prev = head;
        int counter = 0;

        while (temp != null) {
            ListNode succ = temp.next;

            if (succ == null) {
                break;
            }

            temp.next = succ.next;
            succ.next = temp;

            if (counter == 0) {
                head = succ;
                counter++;
            } else {
                prev.next = succ;
            }
            prev = temp;
            temp = temp.next;
        }

        return head;
    }

    private static int size(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        return size;
    }
}
