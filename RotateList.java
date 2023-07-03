//https://leetcode.com/problems/rotate-list/description/

public class RotateList {

    public static ListNode rotateRight(ListNode head, int k) {

        int size = size(head);

        if (size <= 1) {
            return head;
        }

        int indexOfFirstElement = k % size;
        int elementsAfterFirst = size - (indexOfFirstElement+1);

        if (elementsAfterFirst == (size-1)) {
            return head;
        }

        ListNode newHead = getNewHead(head, elementsAfterFirst);

        ListNode temp = head;
        for(int i = 0; i < elementsAfterFirst; i++) {
            temp = temp.next;
        }
        temp.next = null;
        ListNode temp2 = newHead;
        while (temp2.next != null) {
            temp2 = temp2.next;
        }
        temp2.next = head;
        head = newHead;

        //print(head);
        return head;
    }

    private static ListNode getNewHead(ListNode head, int index) {
        for(int i = 0; i < index+1; i++) {
            head = head.next;
        }
        return head;
    }

    private static int size(ListNode head) {
        int counter = 0;
        while (head != null) {
            counter++;
            head = head.next;
        }
        return counter;
    }

    private static void print(ListNode head) {
        System.out.print("[");
        while (head != null) {
            System.out.print("" + head.val + " ");
            head = head.next;
        }
        System.out.println("]");;
    }
}